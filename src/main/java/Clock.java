public class Clock {
    private int hours;
    private int minutes;

    public Clock(int hours, int minutes){
        try {
            if (hours < 0 || hours > 24) {
                throw new Exception("Invalid value for hours. Must be greater than 0 and less than 24.");
            }
            if (minutes < 0 || minutes > 60) {
                throw new Exception("Invalid value for minutes. Must be greater than 0 and less than 60.");
            }

            this.hours = hours;
            this.minutes = minutes;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void incrementFortyFive() {

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
