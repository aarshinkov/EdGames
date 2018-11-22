package obj;

import org.junit.Assert;
import org.junit.Test;

public class DOBTest {

    private DOB dob = new DOB("29/02/2016");

    @Test
//    @Ignore
    public void decodeDOBTest() {
        Assert.assertEquals(2016, dob.getYEAR());
        Assert.assertEquals(2, dob.getMONTH());
        Assert.assertEquals(29, dob.getDAY());
    }

    @Test
    public void getMonthStringTest() {
        Assert.assertEquals("February", dob.getMonthString());
    }

    @Test
    public void isLeapYearTest() {
        Assert.assertTrue(dob.isLeapYear());
    }

    @Test
    public void isDateValidTest() {
        Assert.assertTrue(dob.isDateValid());
    }
}
