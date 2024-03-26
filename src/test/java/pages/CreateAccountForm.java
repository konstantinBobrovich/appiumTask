package pages;

import elements.Button;
import elements.TextField;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.DriverUtils;

public class CreateAccountForm {
    private final TextField nameField = new TextField(By.id("org.joinmastodon.android:id/display_name"));
    private final TextField usernameField = new TextField(By.id("org.joinmastodon.android:id/username"));
    private final TextField emailField = new TextField(By.id("org.joinmastodon.android:id/email"));
    private final TextField passwordField = new TextField(By.id("org.joinmastodon.android:id/password"));
    private final TextField confirmPasswordField = new TextField(By.id("org.joinmastodon.android:id/password_confirm"));
    private final Button nextButton = new Button(By.id("org.joinmastodon.android:id/btn_next"));

    public void fillNameField(String name) {
        nameField.sendKeys(name);
    }

    public void fillUsernameField(String username) {
        usernameField.sendKeys(username);
    }

    public void fillEmailField(String email) {
        emailField.sendKeys(email);
    }

    public void fillPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public void fillConfirmPasswordField(String password) {
        confirmPasswordField.sendKeys(password);
    }

    public void clickNextButton() {
        nextButton.click();
    }

    public boolean isNextButtonEnabled(){
        return DriverUtils.getWait().until(ExpectedConditions.elementToBeClickable(nextButton.getElement())).isEnabled();
    }
}
