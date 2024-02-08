package utils;

import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

public class DriverUtils {

    public static void tapByCoordinates(Point point){
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "name");
        Sequence tap = new Sequence(input, 1);
        tap.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), point.getX(), point.getY()));
        tap.addAction(input.createPointerDown(0));
        tap.addAction(input.createPointerUp(0));
        Driver.getDriver().perform(Collections.singletonList(tap));
    }

    public static WebDriverWait getWait(){
        return new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    }
}
