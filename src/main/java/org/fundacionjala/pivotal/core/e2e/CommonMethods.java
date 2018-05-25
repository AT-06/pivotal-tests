package org.fundacionjala.pivotal.core.e2e;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Class CommonMethods.
 */
public final class CommonMethods {

    /**
     * Constructor Private.
     */
    private CommonMethods() {
    }

    /**
     * Method for set WebElement.
     *
     * @param webElement WebElement.
     * @param text       String.
     */
    public static void setWebElement(final WebElement webElement, final String text) {
        waitWebElement(webElement);
        webElement.sendKeys(text);
    }

    /**
     * Method for ClickElement.
     *
     * @param webElement WebElement.
     */
    public static void clickWebElement(final WebElement webElement) {
        waitWebElement(webElement).click();
    }

    /**
     * Method for wait Web element.
     *
     * @param webElement WebElement.
     * @return the element received in param.
     */
    public static WebElement waitWebElement(final WebElement webElement) {
        return DriverManager.getInstance().getDriverWait().until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * Method for clickWebElementWithJavascriptExecutor.
     *
     * @param webElement WebElement.
     */
    public static void clickWebElementWithJavascriptExecutor(final WebElement webElement) {
        ((JavascriptExecutor) DriverManager.getInstance().getDriver())
                .executeScript("arguments[0].click();", webElement);
    }

    /**
     * This method press enter key to web element.
     *
     * @param webElement is the WebElement.
     */
    public static void pressEnter(final WebElement webElement) {
        webElement.sendKeys(Keys.ENTER);
    }

}