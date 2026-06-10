package RubixCube;

public class Time {
    private int minutes;
    private int seconds;

    public Time(int minutes, int seconds) {
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public boolean shorter(Time other){
        return this.seconds + this.minutes * 60 > other.seconds + other.minutes * 60;
    }

    public Time copy(){
        return new Time(this.minutes, this.seconds);
    }



    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}
