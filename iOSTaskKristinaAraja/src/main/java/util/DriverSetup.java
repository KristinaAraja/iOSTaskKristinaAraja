package util;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import views.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@Listeners({ ITestListenerUtility.class })
public class DriverSetup {
    public static IOSDriver<MobileElement> driver;
    public DesiredCapabilities capabilities = new DesiredCapabilities();
    protected ReminderAppView reminderAppView;
    protected NewReminderView newReminderView;
    protected Helpers helpers;
    protected DateAndTimeView dateAndTimeView;
    protected RemindersListView remindersListView;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 14 Pro Max");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability(MobileCapabilityType.APP, "com.apple.reminders");
        capabilities.setCapability(MobileCapabilityType.LANGUAGE, "en");

        driver = new IOSDriver<>(new URL(GlobalVariables.localAppiumServerUrl), capabilities);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        reminderAppView = new ReminderAppView(driver);
        newReminderView = new NewReminderView(driver);
        helpers = new Helpers();
        dateAndTimeView = new DateAndTimeView(driver);
        remindersListView = new RemindersListView(driver);
    }
}
