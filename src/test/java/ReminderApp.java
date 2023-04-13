import org.testng.Assert;
import org.testng.annotations.Test;
import util.DriverSetup;
import util.GlobalVariables;
import views.*;

public class ReminderApp extends DriverSetup {
    public ReminderApp(){

    }
    @Test(testName = "ReminderApp")

    public void reminderApp(){
        Assert.assertTrue(this.reminderAppView.locationNotificationLoaded(), "Allow location notification isn't loaded ");
        this.reminderAppView.allowOnceLocation();
        Assert.assertTrue(this.reminderAppView.reminderAppOnboarding(), "Reminder app onboarding view isn't loaded ");
        this.reminderAppView.continueInReminderApp();
        this.reminderAppView.goToMainView();
        Assert.assertTrue(this.reminderAppView.reminderAppViewLoaded(), "Reminder app view isn't loaded");
        this.reminderAppView.addNewReminder();

        Assert.assertTrue(this.newReminderView.newReminderViewLoaded(), "New reminder view isn't loaded");
        this.newReminderView.addNewReminderTitle(GlobalVariables.newReminderTitle);
        this.newReminderView.selectCalendar();
        this.newReminderView.selectDateTime(GlobalVariables.coordinates);
        this.newReminderView.enableNotifications();
        this.newReminderView.setAllowNotifications();

        Assert.assertTrue(this.dateAndTimeView.DateTimeViewLoaded(), "Date & Time view isn't loaded");
        this.dateAndTimeView.showYearPicker();
        this.dateAndTimeView.setDatePickerWheel(GlobalVariables.dateInputData);
        this.dateAndTimeView.hideYearPicker();
        this.dateAndTimeView.selectDate();
        this.dateAndTimeView.enableTimeSwitch();
        this.dateAndTimeView.setHourMinutePickerWheel(GlobalVariables.timeInputData);
        this.dateAndTimeView.applySelectedDate();
        this.dateAndTimeView.addNewReminder();

        Assert.assertTrue(this.reminderAppView.reminderAppViewLoaded(), "Reminder app main view isn't loaded");
        this.reminderAppView.checkRemaindersList();

        Assert.assertTrue(this.remindersListView.remindersListViewLoaded(), "Reminders list view isn't loaded");
        Assert.assertEquals(this.remindersListView.getReminderTitle(),GlobalVariables.newReminderTitle);
        Assert.assertEquals(this.remindersListView.getReminderDate(),GlobalVariables.reminderDate);
        this.remindersListView.completeReminder();
        Assert.assertTrue(this.remindersListView.checkEmptyRemindersList(), "Reminder" + GlobalVariables.newReminderTitle + "isn't complete");


    }

}
