import java.io.*;
import java.util.*;

/**
 * gets and sets attendance for a student
 *
 * @author Michael Ruhmel
 * @author Sebastian Echeverry
 * @author Jack Pham
 * @author Will Gunter
 */

public class Attendance {

    /** selected date to modify */
    private String date;

    /** char for attendance status */
    private String status;

    /** day for chosen date */
    private String day;

    /** month for chosen date */
    private String month;

    /** year for chosen date */
    private String year;

    /**
     * Constructor
     *
     * @param day selected by user
     * @param month selected by user
     * @param year selected by user
     * @param attendance status
     */
    public Attendance(String day, String month, String year, String attendance) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.status = attendance;
    }

    /**
     * sets status
     *
     * @param status is whether or not they are present
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * sets day
     *
     * @param day is the selected day by user
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * sets month
     *
     * @param month is the selected month by user
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * sets year
     *
     * @param year is the selected year by user
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * sets the date
     *
     * @param day is the chosen day
     * @param month is the chosen month
     * @param year is the chosen year
     */
    public void setDate(String day, String month, String year) {
        // declare variable
        String format;

        // fixes incorrectly formatted variables
        if (day.length() == 1) {
            day = "0" + day;
        }
        if (month.length() == 1) {
            month = "0" + month;
        }

        // puts variables together
        format = day + month + year;
        this.date = format;
    }

    /**
     * gets status
     *
     * @return status is whether or not they are present
     */
    public String getStatus() {
        return status;
    }

    /**
     * gets the date
     *
     * @return date is the chosen date
     */
    public String getDate() {
        return this.date;
    }

    /**
     * gets the day
     *
     * @return day is the chosen day
     */
    public String getDay() {
        return this.day;
    }

    /**
     * gets the month
     *
     * @return month is the chosen month
     */
    public String getMonth() {
        return this.month;
    }

    /**
     * gets the year
     *
     * @return year is the chosen year
     */
    public String getYear() {
        return this.year;
    }
}
