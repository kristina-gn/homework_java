package org.example.clock;

public class Clock implements Readable {
    int hour;
    int min;
    int sec;

    public Clock (int hour, int min, int sec) {
        this.hour = hour;
        this.min = min;
        this.sec = sec;
    }
    public void setHour(int hour) {
        this.hour = hour;
    }
    public int getHour() {
        return hour;
    }
    public void setMin (int min) {
        this.min = min;
    }
    public int getMin() {
        return min;
    }
    public void setSec(int sec) {
        this.sec = sec;
    }
    public int getSec(){
        return sec;
    }

    public void tick () {
        sec++;
        if (sec == 60) {
            sec = 0;
            min++;
            if (min == 60) {
                min = 0;
                hour++;
                if (hour == 24) {
                    hour = 0;
                }
            }
        }
    }
    @Override
    public void readTime() {
        System.out.printf("Сейчас на часах: %02d:%02d:%02d\n", hour, min, sec);
    }

}
