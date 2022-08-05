import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing Student class
 *
 * @author Jessica Young Schmidt
 * @author Pham The Duy
 * @author Sebastian Echeverry
 */
public class StudentTest {

    /** student object named jack */
    private Student jack;

    /** student object named alex */
    private Student alex;



    /**
     * Sets up things for Student test
     *
     */
    @BeforeEach
    public void setUp() {
        jack = new Student("jack", "CSC116");
        alex = new Student("alex", "CSC1160");

    }

    /**
     * Tests getName function
     *
     */
    @Test
    public void testgetName() {
        assertEquals("jack", jack.getStudent(), "jack name");
        assertEquals("alex", alex.getStudent(), "alex name");

    }

    /**
    * Tests getClassOfStudent for jack and alex
    *
    */
    @Test
    public void testgetClassOfStudent() {
        assertEquals("CSC116", jack.getClassOfStudent(), "class of jack");
        assertEquals("CSC1160", alex.getClassOfStudent(), "class of alex");

    }
}
