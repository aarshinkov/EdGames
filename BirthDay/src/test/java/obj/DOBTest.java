package obj;

import org.junit.Assert;
import org.junit.Test;

public class DOBTest {

    private DOB dob = new DOB("12/02/1978");
    private DOB dob1 = new DOB("12/05/1997");
    private DOB dob2 = new DOB("29/02/1992");

    @Test
//    @Ignore
    public void decodeDOBTest() {
        Assert.assertEquals(1978, dob.getYEAR());
        Assert.assertEquals(2, dob.getMONTH());
        Assert.assertEquals(12, dob.getDAY());

        Assert.assertEquals(1997, dob1.getYEAR());
        Assert.assertEquals(5, dob1.getMONTH());
        Assert.assertEquals(12, dob1.getDAY());

        Assert.assertEquals(1992, dob2.getYEAR());
        Assert.assertEquals(2, dob2.getMONTH());
        Assert.assertEquals(29, dob2.getDAY());
    }

    @Test
    public void isDateValid() {
        Assert.assertTrue(dob.isDateValid());
        Assert.assertTrue(dob1.isDateValid());
        Assert.assertTrue(dob2.isDateValid());
    }

    @Test
    public void isLeapYear() {
        Assert.assertFalse(dob.isLeapYear());
        Assert.assertFalse(dob1.isLeapYear());
        Assert.assertTrue(dob2.isLeapYear());
    }

    @Test
    public void roundLower() {
        Assert.assertEquals(1970, dob.roundLower());
        Assert.assertEquals(1990, dob1.roundLower());
        Assert.assertEquals(1990, dob2.roundLower());
    }

    @Test
    public void findDayOfBirth() {
        Assert.assertEquals("Sunday", dob.findDayOfBirth());
        Assert.assertEquals("Monday", dob1.findDayOfBirth());
//        Assert.assertEquals("Saturday", dob2.findDayOfBirth());
    }

    @Test
    public void getMonthString() {
        Assert.assertEquals("February", dob.getMonthString());
        Assert.assertEquals("May", dob1.getMonthString());
        Assert.assertEquals("February", dob2.getMonthString());
    }
}
