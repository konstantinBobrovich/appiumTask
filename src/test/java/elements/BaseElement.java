package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.DriverUtils;

public class BaseElement {

    private final By locator;

    public BaseElement(final By locator) {
        this.locator = locator;
    }

    public WebElement getElement() {
        return DriverUtils.getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click() {
        DriverUtils.getWait().until(ExpectedConditions.elementToBeClickable(getElement())).click();
    }

    public void sendKeys(CharSequence... keys){
        DriverUtils.getWait().until(ExpectedConditions.elementToBeClickable(getElement())).sendKeys(keys);
    }

    public boolean isEnabled(){
        return getElement().isEnabled();
    }
}
