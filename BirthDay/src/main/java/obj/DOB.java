package obj;

import java.util.Date;

public class DOB {
    private Date date;
    private EDay eDay;

    /**
     * Creates and DOB (date of birth) instance by getting the
     * dateOfBirth parameter.
     * <br/><br/>
     * <b>dateOfBirth</b> should have the following mask
     * <br/><br/>
     * DD.MM.YYYY
     *
     * @param dateOfBirth
     */
    public DOB(String dateOfBirth) {
        decodeDOB(dateOfBirth);
    }

    private void decodeDOB(String dateOfBirth) {
        String[] split = dateOfBirth.split("/");

        this.date = null;
    }

    private void setDayOfWeek(int num) throws IllegalArgumentException {
        if (num < 1 || num > 7) {
            throw new IllegalArgumentException("The input parameter should be between 1 and 7 incl. but found " + num);
        }

        switch (num) {
            case 1:
                eDay = EDay.Monday;
            case 2:
                eDay = EDay.Tuesday;
            case 3:
                eDay = EDay.Wednesday;
            case 4:
                eDay = EDay.Thursday;
            case 5:
                eDay = EDay.Friday;
            case 6:
                eDay = EDay.Saturday;
            default:
                eDay = EDay.Sunday;
        }
    }
}
