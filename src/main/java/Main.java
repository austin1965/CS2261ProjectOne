import java.util.Scanner;

public class Main {

    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int userHours;
        int userMinutes;

        System.out.print("Input current time (format HH MM): ");
        userHours = scanner.nextInt();
        userMinutes = scanner.nextInt();

        Clock userClock = new Clock(userHours, userMinutes);
        userClock.incrementFortyFive();

        System.out.println(userClock.getHours() + " " + userClock.getMinutes());

    }
}
