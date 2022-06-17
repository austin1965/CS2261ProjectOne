import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {

    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String userHours;
        String userMinutes;

        System.out.println("Hello Steve. Let's set your alarm 45 minutes early.");
        System.out.print("Input intended wake-up time (format 'HH MM'): ");

        try {
            userHours = scanner.next();
            userMinutes = scanner.next();

            for (int i = 0; i < userHours.length(); ++i) {
                if (!Character.isDigit(userHours.charAt(i))) {
                    throw new Exception("Input value is not a digit.");
                }
            }

            for (int i = 0; i < userMinutes.length(); ++i) {
                if (!Character.isDigit(userMinutes.charAt(i))) {
                    throw new Exception("Input value is not a digit.");
                }
            }

            Clock userClock = new Clock(parseInt(userHours), parseInt(userMinutes));
            userClock.decrementFortyFive();

            System.out.println(userClock.formattedTime());
        }
        catch(Exception exception) {
            System.out.println(exception.getMessage());
        }






    }
}
