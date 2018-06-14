package org.fundacionjala.pivotal.steps.ui.project;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.fundacionjala.core.util.PropertiesInput;
import org.fundacionjala.core.util.PropertiesManager;
import org.fundacionjala.pivotal.util.Helper;
import org.fundacionjala.pivotal.pages.project.PageLogin;
import org.testng.asserts.Assertion;

/**
 * Class of Login Steps.
 */
public class LoginSteps {

    private final Assertion assertion;

    /**
     * Constructor for LoginSteps class.
     *
     * @param pageLogin object.
     * @param helper    object.
     */
    public LoginSteps(final PageLogin pageLogin, final Helper helper) {
        this.pageLogin = pageLogin;
        this.assertion = helper.getAssertion();
    }

    private PageLogin pageLogin;

    /**
     * Given a valid user and password.
     */
    @Given("I put a valid user and Password")
    public void iPutAValidAnd() {
        pageLogin.setUrl(PropertiesManager.getInstance().getProperties(PropertiesInput.URL_LOGIN));
        pageLogin.signIn(PropertiesManager.getInstance()
                .getProperties(PropertiesInput.USER), PropertiesManager
                .getInstance().getProperties(PropertiesInput.PASSWORD));
    }

    /**
     * Then can see login page.
     */
    @Then("^I can see the Login Page$")
    public void iCanSeeTheLoginPage() {
        assertion.assertTrue(pageLogin.checkPageLogin());
    }
}
