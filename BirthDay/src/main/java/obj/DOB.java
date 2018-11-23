package obj;

import java.util.HashMap;

public class DOB {
    private AuxDate auxDate;

    private int DAY;
    private int MONTH;
    private int YEAR;

    private HashMap<Integer, Integer> monthsHashMap = new HashMap<Integer, Integer>();
    private HashMap<Integer, String> daysOfWeekHashMap = new HashMap<Integer, String>();

    /**
     * Creates and DOB (date of birth) instance by getting the
     * dateOfBirth parameter.
     * <br/><br/>
     * <b>dateOfBirth</b> should have the following mask
     * <br/><br/>
     * DD/MM/YYYY
     *
     * @param dateOfBirth String representation of date of birth in format <b>DD/MM/YYYY</b>
     */
    public DOB(String dateOfBirth) {
        decodeDOB(dateOfBirth);
    }

    private void decodeDOB(String dateOfBirth) {

        buildAuxDate(dateOfBirth);

        if (!isDateValid()) {
//            throw new IllegalArgumentException("The provided input is invalid. Make sure your input have mask DD/MM/YYYY");
            return;
        }

        this.DAY = auxDate.getDay();
        this.MONTH = auxDate.getMonth();
        this.YEAR = auxDate.getYear();
    }

    private void buildAuxDate(String dateOfBirth) {
        String[] dateArray = dateOfBirth.split("/");

        auxDate = new AuxDate();

        auxDate = populateSubYears(dateArray[2], auxDate);

        try {
            auxDate.setDay(Integer.parseInt(dateArray[0]));
            auxDate.setMonth(Integer.parseInt(dateArray[1]));
            auxDate.setYear(Integer.parseInt(dateArray[2]));
        } catch (NumberFormatException nfe) {
//            throw new NumberFormatException("Some of the provided data is invalid. Make sure your values for date, month and year in required range.");
        }
    }

    private AuxDate populateSubYears(String year, AuxDate auxDate) {

        auxDate.setSubYearOne(Integer.parseInt(year.substring(0, 2)));
        auxDate.setSubYearTwo(Integer.parseInt(year.substring(2, 4)));

        return auxDate;
    }


    public boolean isDateValid() {
        if (auxDate.getMonth() < 1 || auxDate.getMonth() > 12) {
            return false;
        }
        if (isLeapYear()) {
            if (auxDate.getMonth() == 2) {
                if (auxDate.getDay() < 1 || auxDate.getDay() > 29) {
                    return false;
                }
            }
        } else {
            if (auxDate.getMonth() == 2) {
                if (auxDate.getDay() < 1 || auxDate.getDay() > 28) {
                    return false;
                }
            }
        }
        switch (auxDate.getMonth()) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (auxDate.getDay() < 1 || auxDate.getDay() > 31) {
                    return false;
                }
            case 4:
            case 6:
            case 9:
            case 11:
                if (auxDate.getDay() < 1 || auxDate.getDay() > 30) {
                    return false;
                }
        }
        return true;
    }

    public boolean isLeapYear() {
        return ((auxDate.getYear() % 4 == 0) && (auxDate.getYear() % 100 != 0)) || (auxDate.getYear() % 400 == 0);
    }

    public int roundLower() {
        return Math.round(YEAR / 10) * 10;
    }

    public String findDayOfBirth() {
        monthsHashMap = populateMonthsHashMap(monthsHashMap);
        daysOfWeekHashMap = populateDaysOfWeekHashMap(daysOfWeekHashMap);

        int div = auxDate.getSubYearTwo() / 4;
        int step3 = auxDate.getSubYearTwo() + div;
        int step4 = step3 + DAY;
        int step5 = step4 + monthsHashMap.get(MONTH);
        int step6 = step5 % 7;

        return daysOfWeekHashMap.get(step6);
    }

    private HashMap<Integer, Integer> populateMonthsHashMap(HashMap<Integer, Integer> monthsHashMap) {
        monthsHashMap.put(1, 0);
        monthsHashMap.put(2, 3);
        monthsHashMap.put(3, 3);
        monthsHashMap.put(4, 6);
        monthsHashMap.put(5, 1);
        monthsHashMap.put(6, 4);
        monthsHashMap.put(7, 6);
        monthsHashMap.put(8, 2);
        monthsHashMap.put(9, 5);
        monthsHashMap.put(10, 0);
        monthsHashMap.put(11, 3);
        monthsHashMap.put(12, 5);
        return monthsHashMap;
    }

    private HashMap<Integer, String> populateDaysOfWeekHashMap(HashMap<Integer, String> daysOfWeekHashMap) {
        daysOfWeekHashMap.put(0, "Sunday");
        daysOfWeekHashMap.put(1, "Monday");
        daysOfWeekHashMap.put(2, "Tuesday");
        daysOfWeekHashMap.put(3, "Wednesday");
        daysOfWeekHashMap.put(4, "Thursday");
        daysOfWeekHashMap.put(5, "Friday");
        daysOfWeekHashMap.put(6, "Saturday");
        return daysOfWeekHashMap;
    }

    public int getDAY() {
        return DAY;
    }

    public int getMONTH() {
        return MONTH;
    }

    public String getMonthString() {
        switch (MONTH) {
            default:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
        }
    }

    public int getYEAR() {
        return YEAR;
    }
}
