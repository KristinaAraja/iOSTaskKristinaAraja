package views;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class RemindersListView {
    protected IOSDriver<MobileElement> driver;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Reminders\"]")
    public MobileElement remindersListNavBar;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name=\"Title\"]")
    public MobileElement reminderTitle;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextView")
    public MobileElement reminderDate;
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"CompleteOff\"])")
    public MobileElement checklistButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable[@name=\"Empty list\"]")
    public MobileElement emptyRemindersListSelector;


    public RemindersListView(IOSDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public boolean remindersListViewLoaded(){
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(remindersListNavBar)).isDisplayed();
    }
    public String getReminderTitle(){return reminderTitle.getAttribute("value");}
    public String getReminderDate(){return reminderDate.getAttribute("value");}
    public void completeReminder(){checklistButton.click();}
    public boolean checkEmptyRemindersList(){
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(emptyRemindersListSelector)).isDisplayed();
    }
}
