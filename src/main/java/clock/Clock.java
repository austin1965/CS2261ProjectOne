package clock;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Clock {
    /* Implements functionality of clock */

    // Member Variables

    public static final int USER_DECREMENT = 45;

    static final int MINIMUM_MINUTES = 0;
    static final int MAXIMUM_MINUTES = 59;
    static final int MINIMUM_HOURS = 0;
    static final int MAXIMUM_HOURS = 23;

    private int hours;
    private int minutes;


    // Member methods

    Clock(int hours, int minutes){
        this.setHours(hours);
        this.setMinutes(minutes);
    }

    public void decrementTime() {
        int hoursDifference = this.getHours();
        int minuteDifference = this.getMinutes() - Clock.USER_DECREMENT;

        if (minuteDifference < Clock.MINIMUM_MINUTES) {
            hoursDifference -= 1;
            minuteDifference = Clock.MAXIMUM_MINUTES + 1 - Math.abs(minuteDifference);
        }
        if (hoursDifference < Clock.MINIMUM_HOURS) {
            hoursDifference = Clock.MAXIMUM_HOURS + 1 - Math.abs(hoursDifference);
        }

        this.setMinutes(minuteDifference);
        this.setHours(hoursDifference);
    }

    public String formattedTime() {
        return String.format("%2d %2d", this.getHours(), this.getMinutes());
    }


}
