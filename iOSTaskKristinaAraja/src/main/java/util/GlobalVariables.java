package util;

import java.util.HashMap;

public class GlobalVariables {

    public static final int globalTimeout = 10; // in seconds

    //Driver setup global variables
    public static final String localAppiumServerUrl = "http://localhost:4723/wd/hub";
    public static final String newReminderTitle = "Buy milk";
    public static int[] coordinates = new int[]{370, 540};
    public static String[] dateInputData = new String[]{"2023","April"};
    public static String[] timeInputData = new String[]{"2","05","AM"};
    public static String reminderDate = "4/26/23, 2:05 AM";
}
