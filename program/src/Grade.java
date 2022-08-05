import java.io.*;
import java.util.*;

/**
 * The program is to make grade objects
 *
 * @author Michael Ruhmel
 * @author Jack Pham
 * @author Sebastian Echeverry
 * @author Will Gunter
 */
public class Grade {

    /** Weight of assignment*/
    private String weight;

    /** Score that student got on the assignment*/
    private String score;

    /** Name of assignment */
    private String gradeName;


    /**
     * Grade constructor method
     *
     * @param gradeName name of assignment
     * @param score score of assignment
     * @param weight weight of assignment
     */
    public Grade(String weight, String score, String gradeName) {
        this.weight = weight;
        this.score = score;
        this.gradeName = gradeName;
        int score1 = Integer.parseInt(this.score);
        int weight1 = Integer.parseInt(this.weight);

        if(weight1 < 0) {
            throw new IllegalArgumentException ("Invalid weight");
        } else if(score1 < 0) {
            throw new IllegalArgumentException ("Invalid score");
        }
        if (gradeName == null) {
            throw new IllegalArgumentException ("null grade name");
        }
    }

    /**
     * Sets name of grade
     *
     * @param gradeName name of assignment
     * @throws IllegalArgumentException if null grade name
     */
    public void setGradeName(String gradeName) {
        if (gradeName == null) {
            throw new IllegalArgumentException ("null grade name");
        }
        this.gradeName = gradeName;
    }

    /**
     * Sets score of grade
     *
     * @param score score of assignment
     */
    public void setScore(String score) {
        this.score = score;
        int score1 = Integer.parseInt(this.score);
        if(score1 < 0) {
            throw new IllegalArgumentException ("Invalid score");
        }

    }

    /**
     * Sets weight of assignment
     *
     * @param weight weight of assignment
     */
    public void setWeight(String weight) {
        this.weight = weight;
        int weight1 = Integer.parseInt(this.weight);
        if(weight1 < 0) {
            throw new IllegalArgumentException ("Invalid score");
        }
    }

    /**
     * Gets weight of assignment
     *
     * @return String string of weight
     */
    public String getWeight() {
        return weight;
    }

    /**
     * Gets score of assignment
     *
     * @return String score of assignment
     */
    public String getScore() {
        return score;
    }

    /**
     * method that return the name of the grade
     *
     * @return the name of the grade
     */
    public String getGradeName() {
        return gradeName;
    }

    /**
     * method that compare 2 Grade together for testing
     *
     * @param o input grade
     * @return true if they equal and vice versa
     */
    public boolean equals(Object o) {
        if (o instanceof Grade) {
            Grade that = (Grade) o;
            int score1 = Integer.parseInt(score);
            int weight1 = Integer.parseInt(weight);
            int scorethat = Integer.parseInt(that.getScore());
            int weightthat = Integer.parseInt(that.getWeight());
            return score1 == scorethat && weight1 == weightthat
                                && gradeName.equals(that.getGradeName());
        } else {
            return false;
        }
    }

}
