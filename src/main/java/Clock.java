public class Clock {
    private int hours;
    private int minutes;

    public Clock(int hours, int minutes) throws Exception {

        if (hours < 0 || hours > 24) {
            throw new Exception("Invalid value for hours. Must be greater than 0 and less than 24.");
        }
        if (minutes < 0 || minutes > 60) {
            throw new Exception("Invalid value for minutes. Must be greater than 0 and less than 60.");
        }

        this.hours = hours;
        this.minutes = minutes;

    }

    public void decrementFortyFive() {
        int hoursDifference = this.hours;
        int minuteDifference = this.minutes - 45;

        if (minuteDifference < 0) {
            hoursDifference -= 1;
            minuteDifference = 60 - Math.abs(minuteDifference);
        }
        if (hoursDifference < 0) {
            hoursDifference = 24 - Math.abs(hoursDifference);
        }

        this.minutes = minuteDifference;
        this.hours = hoursDifference;
    }

    public String formattedTime() {
        return String.format("%2d %2d", this.hours, this.minutes);
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

}
