package obj;

public class DOB {
    private AuxDate auxDate;

    private int DAY;
    private int MONTH;
    private int YEAR;

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

        try {
            auxDate.setDay(Integer.parseInt(dateArray[0]));
            auxDate.setMonth(Integer.parseInt(dateArray[1]));
            auxDate.setYear(Integer.parseInt(dateArray[2]));
        } catch (NumberFormatException nfe) {
//            throw new NumberFormatException("Some of the provided data is invalid. Make sure your values for date, month and year in required range.");
        }
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
