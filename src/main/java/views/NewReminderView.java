package views;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;
import util.Helpers;

public class NewReminderView extends Helpers {
    protected IOSDriver<MobileElement> driver;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Allow\"]")
    public MobileElement allowNotificationsButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"New Reminder\"]")
    public MobileElement newReminderNavBar;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Quick Entry Title Field\"]")
    public MobileElement newReminderTitleField;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Date & time\"]")
    public MobileElement calendarIcon;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Enable Notifications\"]")
    public MobileElement notificationButton;

    public NewReminderView(IOSDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean newReminderViewLoaded(){
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(newReminderNavBar)).isDisplayed();
    }
    public void setAllowNotifications(){allowNotificationsButton.click();}
    public void addNewReminderTitle(String newReminderTitle){newReminderTitleField.sendKeys(newReminderTitle);}
    public void selectCalendar(){calendarIcon.click();}
    public void selectDateTime(int[] coordinates){
        clickByCoordinates(driver, coordinates[0], coordinates[1]);
    };
    public void enableNotifications(){notificationButton.click();}
}
