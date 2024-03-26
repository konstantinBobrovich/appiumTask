package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    private static AppiumDriver driver = null;

    public static AppiumDriver getDriver() {
        if (driver == null) {
            driver = new AndroidDriver(getUrl(), getOptions());
        }
        return driver;
    }

    private static URL getUrl(){
        URL appiumServerURL = null;
        try {
            appiumServerURL = new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException exception){
            throw new WebDriverException("url exception");
        }
        return appiumServerURL;
    }

    private static DesiredCapabilities getOptions(){
        DesiredCapabilities options = new DesiredCapabilities();
        options.setCapability("platformName", "android");
        options.setCapability("platformVersion", "12.0");
        options.setCapability("automationName", "uiautomator2");
        options.setCapability("udid", "AJJJUT3828003267");
        options.setCapability("autoLaunch", "false");
        options.setCapability("noReset", true);
        options.setCapability("enforceXPath1", true);
        options.setCapability("allowInvisibleElements", true);
        options.setCapability("ensureWebviewsHavePages", true);
        options.setCapability("nativeWebScreenshot", true);
        options.setCapability("app", "C:\\work\\apps\\mastodon-githubRelease.apk");

        return options;
    }

    public static void quitDriver(){
        if (driver != null) {
            driver.quit();
        }
    }
}
