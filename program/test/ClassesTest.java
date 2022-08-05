import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.io.*;

/**
 * Testing Classes class
 *
 * @author Michael Ruhmel
 * @author Sebastian Echeverry
 * @author Jack Pham
 * @author Will Gunter
 */
public class ClassesTest {

    /** create class object */
    private Classes exampleClass;

    /** create student object */
    private Student exStudent;

    /** example size of a class */
    public static final int CLASS_SIZE = 20;

    /**
     * Create a class for testing
     */
    @BeforeEach
    public void setUp() {
        exampleClass = new Classes("CSC116", 24);
    }

    /**
     * Example testing all method
     */
    @Test
    public void testExample() {
        // test the class name methods and term methods
        assertEquals("CSC116", exampleClass.getClassName(), "getClassName");
        assertEquals(24, exampleClass.getTerm(), "getTerm");

        // test get and set the class size
        exampleClass.setClassSize(CLASS_SIZE);
        assertEquals(20, exampleClass.getClassSize(), "getClassSize");

        // test final grade
        exStudent = new Student("John Smith", "MA241");
        assertEquals(18, exampleClass.finalGrade("test-files/MA241.txt", exStudent), "finalGrade");

        // test total attendance
        assertEquals("2/2", exampleClass.totalAtt("test-files/MA241.txt", exStudent), "totalAtt");

        // run add student method
        exampleClass.addStudent("test-files/MA241TEST.txt", exStudent);

        // declare and initialize variables
        String studentName = "";
        FileInputStream inFS;
        String nameFinding = "";
        String nameTarget = exStudent.getStudent();
        boolean valid = false;

        // try opening a file and testing whether the name was copied over
        try {
            inFS = new FileInputStream("test-files/MA241TEST.txt");
            Scanner in = new Scanner(inFS);
            while(in.hasNextLine()) {
                String s = in.nextLine();
                String[] s1 = s.split(",");
                if(s1[0].equals(nameTarget)) {
                    studentName = nameTarget;
                    break;
                }
                else {
                    studentName = "";
                    break;
                }
            }
        }
        catch (FileNotFoundException e) {
            valid = false;
        }
        // testing whether add student worked
        assertEquals("John Smith", studentName, "addStudent");
    }
}
