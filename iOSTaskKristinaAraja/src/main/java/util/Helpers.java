package util;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

import java.time.Duration;

import static util.DriverSetup.driver;

public class Helpers {

    public enum DIRECTION {
        DOWN, UP, LEFT, RIGHT;
    }

    public void scrollToElementWithText(IOSDriver<MobileElement> driver, String text) {
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" +
                ".scrollIntoView(new UiSelector().text(\"" + text + "\").instance(0));"));
    }

    public void clickByCoordinates(IOSDriver<MobileElement> driver, int x, int y) {
        try {
            new TouchAction(driver).tap(PointOption.point(x, y)).perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void swipe(AndroidDriver<MobileElement> driver, DIRECTION direction, long duration) {
        Dimension size = driver.manage().window().getSize();

        int startX;
        int endX = 0;
        int startY;
        int endY = 0;


        switch (direction) {
            case RIGHT:
                startY = size.height / 2;
                startX = (int) (size.width * 0.90);
                endX = (int) (size.width * 0.05);
                new TouchAction(driver)
                        .press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                        .moveTo(PointOption.point(endX, endY))
                        .release()
                        .perform();
                break;

            case LEFT:
                startY = size.height / 2;
                startX = (int) (size.width * 0.05);
                endX = (int) (size.width * 0.90);
                new TouchAction(driver)
                        .press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                        .moveTo(PointOption.point(endX, endY))
                        .release()
                        .perform();
                break;

            case UP:
                startY = (int) (size.height * 0.30);
                endY = (int) (size.height * 0.70);
                startX = size.width / 2;
                new TouchAction(driver)
                        .press(PointOption.point(startX, startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                        .moveTo(PointOption.point(endX, endY))
                        .release()
                        .perform();
                break;

            case DOWN:
            startY = (int) (size.height * 0.70);
            endY = (int) (size.height * 0.30);
            startX = size.width / 2;
            new TouchAction(driver)
                    .press(PointOption.point(startX, startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(duration)))
                    .moveTo(PointOption.point(endX, endY))
                    .release()
                    .perform();
            break;
        }
    }

    public void swipeAction(AndroidDriver<MobileElement> driver, int Xcoordinate, int Ycoordinate, String direction) {
        Dimension dimension = driver.manage().window().getSize();
        int deviceWidth = dimension.getWidth();

        switch (direction) {
            case "Left":
                int startX = deviceWidth - Xcoordinate;
                int startY = Ycoordinate;
                int endX = Xcoordinate;
                int endY = Ycoordinate;
                new TouchAction(driver).longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY)).release().perform();
                break;

            case "Right":
                startX=Xcoordinate;
                startY=Ycoordinate;
                endX=deviceWidth - Xcoordinate;
                endY=Ycoordinate;
                new TouchAction(driver).longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY)).release().perform();
                break;
        }
    }
}
