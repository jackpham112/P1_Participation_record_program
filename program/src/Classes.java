import java.io.*;
import java.util.*;

/**
 * Gives us the ability to assign and use data about a class
 *
 * @author Michael Ruhmel
 * @author Sebastian Echeverry
 * @author Jack Pham
 * @author Will Gunter
 */
public class Classes {
    /** name of class */
    private String className;

    /** total times the class meets */
    private int term;

    /** the class size */
    private int classSize;

    /** name of the class */
    private String nameClass;

    /**
     * Constructor
     *
     * @param className name of the class
     * @param term is how many times the class meets in semester
     */
    public Classes(String className, int term) {
        setClassName(className);
        setTerm(term);
    }

    /**
     * set the name of the class
     *
     * @param className is the name of the class
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * set the amount of times the class meets
     *
     * @param term amount of times the class meets
     */
    public void setTerm(int term) {
        this.term = term;
    }

    /**
     * sets the class size
     *
     * @param classSize is the class size
     */
    public void setClassSize(int classSize) {
        this.classSize = classSize;
    }

    /**
     * gets the name
     *
     * @return className is the name of the class
     */
    public String getClassName() {
        return className;
    }

    /**
     * get the amount of times the class meets
     *
     * @return term amount of times the class meets
     */
    public int getTerm() {
        return term;
    }

    /**
     * gets the class size
     *
     * @return classSize is the class size
     */
    public int getClassSize() {
        return classSize;
    }


}
