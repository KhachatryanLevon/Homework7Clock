package com.company;

public class Clock {

    private int hours = 0;
    private int minutes = 0;
    private int seconds = 0;

    public int getHours() {
        return hours;
    }

    public void setHours(int hour) {
        if (hours >= 24) {
            while (hours >= 24) {
                hours = hours - 24;
            }
        }
        if (hour >= 0 && hour < 24) {
            this.hours = hours + hour;
        } else {
            while (hour >= 24) {
                hour = hour - 24;
            }
            hours = hour;
        }
    }

    public void setSeconds(int second) {
        if (second >= 0 && second < 60) {
            this.seconds = second;
        } else {
            while (second >= 60) {
                second = second - 60;
                setMinutes(getMinutes() + 1);
            }
            seconds = second;
        }
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minute) {
        if (minutes >= 60) {
            while (minutes >= 60) {
                hours++;
                minutes = minutes - 60;
            }
        }
        if (minute >= 0 && minute < 60) {
            minutes = minutes + minute;
        } else {
            while (minute >= 60) {
                minute = minute - 60;
                setHours(getHours() + 1);
            }
            minutes = minute;
        }
    }

    public int getSeconds() {
        return seconds;
    }

    public void tick() {
        int timeSecond = getSeconds() + 1;
        setSeconds(timeSecond);
    }

    public void tickDown() {
        setSeconds(getSeconds() - 1);
        if (seconds < 0) {
            setMinutes(getMinutes() - 1);
            if (minutes < 0) {
                setHours(getHours() - 1);
                minutes = 59;
                if (hours < 0) {
                    hours = 23;
                }
            }
            seconds = 59;
        }
        setSeconds(seconds);
    }

    public void setClock(int second) {
        if (second >= 0 && second < 60) {
            this.seconds = second;
        } else {
            while (second >= 60) {
                second = second - 60;
                minutes++;
            }
            seconds = second;
        }
        if (minutes >= 60) {
            while (minutes >= 60) {
                hours++;
                minutes = minutes - 60;
            }
        }
        if (hours >= 24) {
            while (hours >= 24) {
                hours = hours - 24;
            }
        }
    }

    public void addClock(Clock clock) {
        hours = hours + clock.getHours();
        minutes = minutes + clock.getMinutes();
        seconds = seconds + clock.getSeconds();
        if (seconds >= 60) {
            while (seconds >= 60) {
                minutes++;
                seconds = seconds - 60;
            }
        }
        if (minutes >= 60) {
            while (minutes >= 60) {
                hours++;
                minutes = minutes - 60;
            }
        }
        if (hours >= 24) {
            while (hours >= 24) {
                hours = hours - 24;
            }
        }
    }

    public void subtractClock(Clock clock) {
        hours = hours - clock.getHours();
        minutes = minutes - clock.getMinutes();
        seconds = seconds - clock.getSeconds();
        if (seconds < 0) {
            while (seconds <= 0) {
                minutes--;
                seconds = seconds + 60;
            }
        }
        if (minutes < 0) {
            while (minutes <= 0) {
                hours--;
                minutes = minutes + 60;
            }
        }
        if (hours < 0) {
            while (hours <= 0) {
                hours = hours + 24;
            }
        }
    }


    public Clock(int hour, int minute, int second) {
        setSeconds(second);
        setMinutes(minute);
        setHours(hour);
    }

    public Clock() {
        setSeconds(0);
        setMinutes(0);
        setHours(12);
    }

    public Clock(int second) {
        setClock(second);
    }

    public void time() {

        System.out.print(getHours() + " hours ");
        System.out.print(getMinutes() + " minutes ");
        System.out.print(getSeconds() + " seconds");
    }
}



