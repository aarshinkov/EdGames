package main;

import obj.EDay;

public class Main {
    public static void main(String[] args) {

    }

    private static EDay getDayOfWeek(int num) throws IllegalArgumentException {
        if (num < 1 || num > 7) {
            throw new IllegalArgumentException("The input parameter should be between 1 and 7 incl. but found " + num);
        }

        switch (num) {
            case 1:
                return EDay.Monday;
            case 2:
                return EDay.Tuesday;
            case 3:
                return EDay.Wednesday;
            case 4:
                return EDay.Thursday;
            case 5:
                return EDay.Friday;
            case 6:
                return EDay.Saturday;
            default:
                return EDay.Sunday;
        }
    }
}
