package views;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class ReminderAppView {
    protected IOSDriver<MobileElement> driver;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Reminders\"]")
    public MobileElement reminderApp;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Allow Once\"]")
    public MobileElement allowOnceLocationButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continue\"]")
    public MobileElement continueButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Back\"]")
    public MobileElement backButton;;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"New Reminder\"]")
    public MobileElement newReminderButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Quick Entry Title Field\"]")
    public MobileElement newReminderTitleField;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Reminders\"]")
    public MobileElement remindersList;

    public ReminderAppView(IOSDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public boolean locationNotificationLoaded(){
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(allowOnceLocationButton)).isDisplayed();
    }
    public void allowOnceLocation(){
        allowOnceLocationButton.click();}

    public boolean reminderAppOnboarding() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(continueButton)).isDisplayed();
    }
    public void continueInReminderApp(){continueButton.click();}
    public void goToMainView(){backButton.click();}
    public boolean reminderAppViewLoaded(){
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(reminderApp)).isDisplayed();
    }
    public void addNewReminder(){newReminderButton.click();}
    public void checkRemaindersList(){remindersList.click();}

}
