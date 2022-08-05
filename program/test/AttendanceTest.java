import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing Attendance class
 *
 * @author Michael Ruhmel
 * @author Sebastian Echeverry
 * @author Jack Pham
 * @author Will Gunter
 */
public class AttendanceTest {

    /**
    * the name of the attendance variable
    *
    */
    private Attendance attend;

    /**
     * Declare attendance object
     */
    @BeforeEach
    public void setUp() {
        attend = new Attendance();
    }

    /**
     * Example testing all method
     */
    @Test
    public void testExample() {
        // test set and get day
        attend.setDay("4");
        assertEquals("4", attend.getDay(), "getDay");

        // test set and get month
        attend.setMonth("7");
        assertEquals("7", attend.getMonth(), "getMonth");

        // test set and get year
        attend.setYear("2022");
        assertEquals("2022", attend.getYear(), "getYear");

        // test set and get date
        attend.setDate(attend.getDay(), attend.getMonth(), attend.getYear());
        assertEquals("04072022", attend.getDate(), "getDate");

        // test set and get status
        attend.setStatus("p");
        assertEquals("p", attend.getStatus(), "getStatus");
    }
}
