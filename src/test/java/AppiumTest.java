import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.CreateAccountForm;
import pages.MainPage;
import utils.Driver;

import java.util.List;


public class AppiumTest {
    MainPage mainPage = new MainPage();
    CreateAccountForm createAccountForm = new CreateAccountForm();

    @Test
    public void appiumTest() {

        mainPage.clickPickAnotherServer();
        mainPage.searchForServer("mastodon.social");
        List<String> allSearchResults = mainPage.getAllSearchResults();
        assertTrue(allSearchResults.contains("mastodon.social"),
                "mastodon.social server should be in list");
        mainPage.clickMastodonSocialButton();
        mainPage.clickNextButton();
        mainPage.clickIAgreeButton();
        mainPage.clickIAgreeButton();
        createAccountForm.fillNameField("Konstantin");
        createAccountForm.fillUsernameField("username");
        createAccountForm.fillEmailField("useremail@gmail.com");
        createAccountForm.fillPasswordField("password");
        createAccountForm.fillConfirmPasswordField("password");
        assertTrue(createAccountForm.isNextButtonEnabled(), "next button should be enabled");
        createAccountForm.clickNextButton();
    }

    @AfterTest
    public void tearDown() {
        Driver.quitDriver();
    }
}