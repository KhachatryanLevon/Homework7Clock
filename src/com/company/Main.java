package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        int secondsAfterMidnight = 0;

        System.out.println("Enter the number of seconds after midnight");
        secondsAfterMidnight = scanner.nextInt();
        Clock firstClock = new Clock(secondsAfterMidnight);
        System.out.print("The time is ");
        firstClock.time();
        System.out.println();

        System.out.println("Let's tick 10 times:");
        for (int i = 0; i < 10; i++) {
            firstClock.tick();
            firstClock.time();
            System.out.println();
        }

        System.out.println("Enter the hours");
        hours = scanner.nextInt();
        System.out.println("Enter the minutes");
        minutes = scanner.nextInt();
        System.out.println("Enter the seconds");
        seconds = scanner.nextInt();
        Clock secondClock = new Clock(hours, minutes, seconds);
        System.out.print("The time is ");
        secondClock.time();
        System.out.println();

        System.out.println("Let's tick 10 times:");
        for (int i = 0; i < 10; i++) {
            secondClock.tick();
            secondClock.time();
            System.out.println();
        }

        Clock thirdClock = new Clock(secondsAfterMidnight); // Clock for difference
        Clock fourthClock = new Clock(secondsAfterMidnight); // Clock for sum
        secondClock = new Clock(hours, minutes, seconds);

        fourthClock.addClock(secondClock);
        System.out.println("The sum of first and second clocks is ");
        fourthClock.time();
        System.out.println();

        thirdClock.subtractClock(secondClock);
        System.out.println("The difference between first and second clocks is ");
        thirdClock.time();
    }
}
