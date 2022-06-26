import clock.Clock;
import clock.ClockBuilder;

import java.util.Scanner;

public class Main {
    /* Main program loop for user interaction with clock object. */

    // Member variables

    static Scanner scanner = new Scanner(System.in);

    // Member methods

    public static void main(String[] args) {
        boolean settingClock = true;


        while (settingClock) {
            String userInput = "";

            System.out.println("Hello Steve. Let's set your alarm " + Clock.USER_DECREMENT + " minutes early.");
            System.out.print("Input intended wake-up time (format '" + ClockBuilder.EXPECTED_USER_FORMAT + "'): ");

            try {
                Clock userClock = ClockBuilder.clockBuilder();
                userClock.decrementTime();
                System.out.println(userClock.formattedTime());
            }
            catch (Exception exception) {
                System.out.println(exception.getMessage());
            }

            System.out.println("Continue? If you would like to quit, press 'Q'. Press anything else to continue");
            userInput = scanner.nextLine();

            if (userInput.equals("Q") || userInput.equals("q")) {
                settingClock = false;
            }
        }
        System.out.println("Exiting program.");

    }
}
