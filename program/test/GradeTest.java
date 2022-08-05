import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests the Grade class
 *
 * @author Jack Pham
 * @author Sebastian Echeverry
 * @author Michael Ruhmel
 * @author Will Gunter
 */
public class GradeTest {
    /** new grade to test */
    private Grade alex;

    /** new grade to test */
    private Grade jack;

    /** new grade to test */
    private Grade jake;

    /** new grade to test */
    private Grade alan;

    /**
     * Declare grade object
     */
    @BeforeEach
    public void setUp() {
        alex = new Grade(10, 90, "T1");
        alan = new Grade(10, 90, "T1");
        jack = new Grade(10, 80, "T1");
        jake = new Grade(10, 80, "T1");
    }
    
    /**
     * The following tests test that constants are defined as specified
     */
    @Test
    public void testAlexGrade() {
        assertEquals(90, alex.getScore(), "testing get grade method for alex");
    }

    /**
     * The following tests test that constants are defined as specified
     */
    @Test
    public void testJackGrade() {
        assertEquals(80, jack.getScore(), "testing get grade method for alex");
    }

    /**
     * The following tests test that constants are defined as specified
     */
    @Test
    public void testJackWeight() {
        assertEquals(10, jack.getWeight(), "testing get weight method for alex");
    }

    /**
     * The following tests test that constants are defined as specified
     */
    @Test
    public void testAlexWeight() {
        assertEquals(10, jack.getWeight(), "testing get weight method for alex");
    }

    /**
     * The following tests test that constants are defined as specified
     */
    @Test
    public void testAlexGradeName() {
        assertEquals("T1", alan.getGradeName(), "testing get grade name method for alan");
    }

    /**
     * Tests equals with two of hearts
     */
    @Test
    public void testEqualsAlex() {
        Grade alen = new Grade(10, 90, "T1");

        assertTrue(alex.equals(alex), "test with same grade alex");
        assertTrue(jack.equals(jack), "test with same grade jack");
        assertFalse(alex.equals(jack), "test with different grade");
        assertFalse(alex.equals(new Grade(9, 90, "T1")), "test with different weight");
        assertFalse(alex.equals(new Grade(10, 80, "T1")),"test with different score");
        assertFalse(alex.equals(null), "test compare to null object");
        assertFalse(alex.equals("alex"), "test compare to String");
        assertTrue(jack.equals(jake),"same grade with different instance jack vs jake");
        assertTrue(alex.equals(alen),"same grade with different instance alex vs alan");
    }
}
