package pages;

import elements.Button;
import elements.TextField;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.DriverUtils;

import java.util.List;
import java.util.stream.Collectors;


public class MainPage {
    private final Button mastodonSocialButton = new Button(
            By.xpath("//android.widget.TextView[@text='mastodon.social']"));
    private final Button nextButton = new Button(By.xpath("//android.widget.Button[@text='Next']"));
    private final Button iAgreeButton = new Button(By.xpath("//android.widget.Button[@text='I Agree']"));
    private final TextField textField = new TextField(By.id("org.joinmastodon.android:id/search_edit"));
    private static final String SEARCH_RESULT_XPATH =
            "//android.widget.TextView[@resource-id='org.joinmastodon.android:id/title']";
    private static final int pickAnotherServerXCoord = 550;
    private static final int pickAnotherServerYCoord = 2080;

    public void searchForServer(String serverName){
        textField.click();
        textField.sendKeys(serverName);
    }

    public void clickMastodonSocialButton() {
        mastodonSocialButton.click();
    }

    public void clickNextButton(){
        nextButton.click();
    }

    public void clickIAgreeButton(){
        iAgreeButton.click();
    }

    public void clickPickAnotherServer() {
        Point point = new Point(pickAnotherServerXCoord, pickAnotherServerYCoord);
        DriverUtils.tapByCoordinates(point);
    }

    public List<String> getAllSearchResults(){
        return getAllSearchResultsElements().stream().map(WebElement::getText).collect(Collectors.toList());
    }

    private List<WebElement> getAllSearchResultsElements(){
        return DriverUtils.getWait().until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(By.xpath(SEARCH_RESULT_XPATH)));
    }
}
