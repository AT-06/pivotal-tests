package org.fundacionjala.pivotal.core.e2e;

import org.fundacionjala.pivotal.utils.NoConfigPropertiesFound;
import org.fundacionjala.pivotal.utils.PropertiesConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Class Connection.
 */
public abstract class Connection implements  Browser {

    private static final PropertiesConfig PROPERTIES = PropertiesConfig.getInstance();
    static final String SAUCE_USERNAME = PROPERTIES.getSauceUserName();
    static final String SAUCE_KEY = PROPERTIES.getSauceKey();

    private final String url;

    /**
     * Set Capabilities.
     * @return capabilities of sauceLabs.
     */
    abstract DesiredCapabilities setCapabilities();

    /**
     * @param url .
     */
    Connection(final String url) {
        this.url = url;
    }

    /**
     * @return .
     */
    @Override
    public WebDriver getBrowser() {
        WebDriver driver;
        try {
            driver = new RemoteWebDriver(new URL(url), setCapabilities());
        } catch (MalformedURLException e) {
            String message = "URL not valid";
            throw new NoConfigPropertiesFound(message, e);
        }
        return driver;
    }
}