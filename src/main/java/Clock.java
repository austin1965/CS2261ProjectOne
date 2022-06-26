import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Clock {
    private int hours;
    private int minutes;

    public Clock(int hours, int minutes) throws Exception {

        if (hours < 0 || hours > 23) {
            throw new Exception("Invalid value for hours. Must be greater than or equal to 0 and less than 24.");
        }
        if (minutes < 0 || minutes > 59) {
            throw new Exception("Invalid value for minutes. Must be greater than or equal to 0 and less than 60.");
        }

        this.setHours(hours);
        this.setMinutes(minutes);
    }

    public void decrementFortyFive() {
        int hoursDifference = this.getHours();
        int minuteDifference = this.getMinutes() - 45;

        if (minuteDifference < 0) {
            hoursDifference -= 1;
            minuteDifference = 60 - Math.abs(minuteDifference);
        }
        if (hoursDifference < 0) {
            hoursDifference = 24 - Math.abs(hoursDifference);
        }

        this.setMinutes(minuteDifference);
        this.setHours(hoursDifference);
    }

    public String formattedTime() {
        return String.format("%2d %2d", this.getHours(), this.getMinutes());
    }

}
