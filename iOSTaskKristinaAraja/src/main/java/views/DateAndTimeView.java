package views;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class DateAndTimeView {

    protected IOSDriver<MobileElement> driver;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Date & Time\"]")
    public MobileElement dateTimeNavBar;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Show year picker\"]")
    public MobileElement showYearPickerSelector;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Apply\"]")
    public MobileElement applyButton;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Time\"]")
    public MobileElement timeSwitch;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel[2]")
    public MobileElement yearPickerWheelSelector;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel[1]")
    public MobileElement monthPickerWheelSelector;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Hide year picker\"]")
    public MobileElement hideYearPickerSelector;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"26\"]")
    public MobileElement selectDate;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel[1]")
    public MobileElement hourPickerWheelSelector;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel[2]")
    public MobileElement minutePickerWheelSelector;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel[3]")
    public MobileElement periodPickerWheel;
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Add\"]")
    public MobileElement addReminderButton;


    public boolean DateTimeViewLoaded(){
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(dateTimeNavBar)).isDisplayed();
    }
    public DateAndTimeView(IOSDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public void showYearPicker(){showYearPickerSelector.click();}
    public void hideYearPicker(){hideYearPickerSelector.click();}

    public void setDatePickerWheel(String[] dateInputData) {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(yearPickerWheelSelector));
        yearPickerWheelSelector.sendKeys(dateInputData[0]);
        monthPickerWheelSelector.sendKeys(dateInputData[1]);
    }
    public void selectDate(){selectDate.click();}
    public void enableTimeSwitch(){timeSwitch.click();}
    public void setHourMinutePickerWheel(String[] timeInputData) {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(hourPickerWheelSelector));
        hourPickerWheelSelector.sendKeys(timeInputData[0]);
        minutePickerWheelSelector.sendKeys(timeInputData[1]);
        periodPickerWheel.sendKeys(timeInputData[2]);
    }
    public void applySelectedDate(){applyButton.click();}
    public void addNewReminder(){addReminderButton.click();}


}
