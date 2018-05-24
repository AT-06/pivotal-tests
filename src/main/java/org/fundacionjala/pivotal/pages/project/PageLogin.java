package org.fundacionjala.pivotal.pages.project;

import org.fundacionjala.pivotal.pages.common.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class for PageLogin.
 */
public class PageLogin extends Base {

    @FindBy(name = "credentials[username]")
    private WebElement txtUsername;

    @FindBy(name = "credentials[password]")
    private WebElement txtPassword;

    @FindBy(name = "action")
    private WebElement txtButton;

    @FindBy(id = "projects-search-bar")
    private WebElement txtSearch;

    /**
     * Method for set txt User Name.
     *
     * @param username String.
     */
    private void setTxtUsername(final String username) {
        driverWait.until(ExpectedConditions.visibilityOf(txtUsername));
        txtUsername.sendKeys(username);
    }

    /**
     * Method for set txt Password.
     *
     * @param password String.
     */
    private void setTxtPassword(final String password) {
        driverWait.until(ExpectedConditions.visibilityOf(txtPassword));
        txtPassword.sendKeys(password);
    }

    /**
     * Method for set txt Button.
     */
    private void setTxtButton() {
        driverWait.until(ExpectedConditions.visibilityOf(txtButton));
        txtButton.submit();
    }

    /**
     * Method for check Page Login.
     *
     * @return txtSearch is Displayed.
     */
    public boolean checkPageLogin() {
        driverWait.until(ExpectedConditions.visibilityOf(txtSearch));
        return txtSearch.isDisplayed();
    }

    /**
     * Method for use User Name and Password.
     *
     * @param username String.
     * @param password String.
     */
    public void asLogin(final String username, final String password) {
        setTxtUsername(username);
        setTxtButton();
        setTxtPassword(password);
        setTxtButton();
    }
}
