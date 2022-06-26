package clock;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class ClockBuilder {
    /* Implements validation details for construction of a clock. */

    // Member variables
    public static final String EXPECTED_USER_FORMAT = "HH MM";

    private static final int MAXIMUM_INPUT_LENGTH = 5;
    private static final int EXPECTED_SEPARATOR_INDEX = 2;
    private static final int[] EXPECTED_HOURS_INDEXES = {0, 1};
    private static final int[] EXPECTED_MINUTES_INDEXES = {3, 4};

    // Member methods
    public static Clock clockBuilder() throws Exception{
        Scanner scanner = new Scanner(System.in);
        String userHours;
        String userMinutes;
        String userString;
        String[] tempList;

        userString = scanner.nextLine();
        ClockBuilder.inputLengthChecker(userString);
        ClockBuilder.charTypeChecker(userString);
        tempList = ClockBuilder.charsToStrings(userString);
        userHours = tempList[0];
        userMinutes = tempList[1];
        ClockBuilder.checkValueRange(parseInt(userHours), parseInt(userMinutes));

        return new Clock(parseInt(userHours), parseInt(userMinutes));
    }

    private static void inputLengthChecker(String stringToCheck) throws Exception{
        if (stringToCheck.length() != ClockBuilder.MAXIMUM_INPUT_LENGTH) {
            throw new Exception("Invalid input length. Input should be exactly " + ClockBuilder.MAXIMUM_INPUT_LENGTH
                    + " characters.");
        }
    }

    private static void charTypeChecker(String stringToCheck) throws Exception{
        for (int i = 0; i < stringToCheck.length(); ++i) {
            if (i != ClockBuilder.EXPECTED_SEPARATOR_INDEX && (!Character.isDigit(stringToCheck.charAt(i))))  {
                throw new Exception("Non-numeric value detected in field expecting numeric value. Expected '"
                        + ClockBuilder.EXPECTED_USER_FORMAT
                        + "' format where positions occupied by H and M should be numeric.");
            }
        }

        if (stringToCheck.charAt(ClockBuilder.EXPECTED_SEPARATOR_INDEX) != ' ') {
            throw new Exception("Expected space not provided. Expected format '" + ClockBuilder.EXPECTED_USER_FORMAT
                    + "' where the third character is a space key.");
        }
    }

    private static String[] charsToStrings(String userString) {
        String[] tempList = {"", ""};

        for (int i = 0; i < userString.length(); ++i) {
            if (checkIfHourIndex(i)) {
                tempList[0] += userString.charAt(i);
            }
            if (checkIfMinuteIndex(i)) {
                tempList[1] += userString.charAt(i);
            }
        }

        return tempList;
    }

    private static boolean checkIfHourIndex(int index) {
        for (int expectedHoursIndex : ClockBuilder.EXPECTED_HOURS_INDEXES) {
            if (index == expectedHoursIndex) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkIfMinuteIndex(int index) {
        for (int expectedMinutesIndex : ClockBuilder.EXPECTED_MINUTES_INDEXES) {
            if (index == expectedMinutesIndex) {
                return true;
            }
        }

        return false;
    }

    private static void checkValueRange(int hours, int minutes) throws Exception {
        if (hours < Clock.MINIMUM_HOURS || hours > Clock.MAXIMUM_HOURS) {
            throw new Exception("Invalid value for hours. Must be greater than or equal to "+ Clock.MINIMUM_HOURS
                    + " and less than " + (Clock.MAXIMUM_HOURS + 1) + ".");
        }
        if (minutes < Clock.MINIMUM_MINUTES || minutes > Clock.MAXIMUM_MINUTES) {
            throw new Exception("Invalid value for minutes. Must be greater than or equal to " + Clock.MINIMUM_MINUTES
                    + " and less than " + (Clock.MAXIMUM_MINUTES + 1) + ".");
        }
    }
}
