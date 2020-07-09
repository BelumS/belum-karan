package org.example.numbers;

import java.time.ZonedDateTime;

public class Time implements Timer {
    private int hours;
    private int minutes;

    public Time() {
        this.hours = ZonedDateTime.now().getHour();
        this.minutes = ZonedDateTime.now().getMinute();
    }

    public Time(int hours, int minutes) {
        setHours(hours);
        setMinutes(minutes);
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        if (hours >= 0 && hours < 24)
            this.hours = hours;
        else
            throw new AssertionError(hours + " is an invalid hour unit!");
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        if (minutes >= 0 && minutes < 60)
            this.minutes = minutes;
        else
            throw new AssertionError(minutes + " is an invalid minute unit!");
    }

    @Override
    public String incrementHours() {
        if (hours > 0 && hours < 23) {
            this.hours++;
            if (this.hours == 23) {
                this.hours = 0;
            }
        }
        return hours + ":" + minutes;
    }

    @Override
    public String incrementMinutes() {
        if (minutes > 0 && minutes < 60) {
            this.minutes++;
            if (this.minutes == 59) {
                this.minutes = 0;
                this.hours++;
            }
        }
        return hours + ":" + minutes;
    }

    public void showCurrentTime() {
        System.out.println("The Current Time is [" + new Time(ZonedDateTime.now().getHour(), ZonedDateTime.now().getMinute()) + "]");
    }

    @Override
    public String toString() {
        String hourStr = String.valueOf(this.hours);
        String minStr = String.valueOf(this.minutes);
        if(hours < 10) hourStr = ("0" + this.hours);
        if ( minutes < 10) minStr = ("0" + this.minutes);

        return hourStr + ":" + minStr;
    }
}
