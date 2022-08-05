import java.io.*;
import java.util.*;

/**
 * Code for Classes class
 *
 * @author Michael Ruhmel
 * @author Sebastian Echeverry
 * @author Jack Pham
 * @author Will Gunter
 *
 */
public class Student {

    /** students name */
    private String studentName;

    /** class of student */
    private String classOfStudent;

    /**
     * Constructor, probably good
     *
     * @param classOfStudent class that student is in
     * @param studentName name of student in class
     */
    public Student(String studentName, String classOfStudent) {
        this.studentName = studentName;
        this.classOfStudent = classOfStudent;
    }


    /**
     * gets class of student
     *
     * @return String class of student
     */
    public String getClassOfStudent() {
        return classOfStudent;
    }

    /**
     * gets name of student
     *
     * @return String name of student
     */
    public String getStudent() {
        return studentName;
    }
}
