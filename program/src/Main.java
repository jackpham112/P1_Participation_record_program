import java.io.*;
import java.util.*;

/**
 * This is the main class that runs all our classes and prompts the user
 *
 * @author Michael Ruhmel
 * @author Will Gunter
 * @author Sebastian Echeverry
 * @author Jack Pham
 */


public class Main {

    /** Grade object */
    private Grade grade;

    /** Attendence object */
    private Attendance attend;

    /** Student object */
    private Student temp;

    /** magic number I think */
    private static final int HALF_DOZEN = 6;

    /** weeks in a month */
    private static final int WHEELS_CAR = 4;

    /** days in a week */
    private static final int DAYS_WEEK = 7;

    /**
     * This method main runs the entire code
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {


        int r1;
        String option1 = "";
        String option2 = "";
        String option3 = "";
        String option4 = "";
        String option5 = "";
        String option6 = "";
        String ignore = "";
        String className = "";
        String studentName = "";
        int meetsPerWeek = 0;
        int weeksPerSemester = 0;
        int classesMet = 0;
        int classSize = 0;
        Student[] studentNamesArr;
        Student temp;
        Attendance attend;
        Classes one;
        String studentOption = "";
        Grade grade;

        // create scanner
        Scanner in = new Scanner(System.in);

        // prompts user to enter option
        System.out.println("Welcome\nSelect an option (1 or 2)");
        System.out.print("1. Add Class\n2. Review Class\n3. Quit\nEnter: ");
        option1 = in.nextLine();

        // validates user input for the option selected
        if (!option1.equals("1") && !option1.equals("2") && !option1.equals("3")) {
            System.out.println("Error: Invalid Option");
            System.exit(1);
        }

        // runs code for option one
        if (option1.equals("1")) {
            // prompts for file name
            System.out.print("Enter class name without space: ");
            className = in.nextLine();
            String s = "test-files/" + className + ".txt";
            try {
                FileWriter bugera = new FileWriter("test-files/totalClass.txt", true);

                BufferedWriter outL = new BufferedWriter(bugera);
                outL.write(className + "\n");
                outL.close();
            } catch (IOException e) {
                System.out.println("exception occurred" + e);
            }


            try {
                System.out.println("");
                System.out.println("Creating class file...");
                FileOutputStream fileStream = new FileOutputStream(s);
                PrintWriter outFS = new PrintWriter(fileStream);
                outFS.close();
            } catch (FileNotFoundException e) {
                throw new IllegalArgumentException("Unable to access input file: ");
            }

            // prompts for meetings per week
            System.out.println("");
            System.out.println("How many times will the class meet per week");
            System.out.print("Enter: ");
            meetsPerWeek = in.nextInt();
            if(meetsPerWeek < 0) {
                throw new IllegalArgumentException ("invalid input");
            }

            // prompts for weeks per semester
            System.out.println("");
            System.out.println("How many weeks will the class meet in the semester?");
            System.out.print("Enter: ");
            weeksPerSemester = in.nextInt();
            if(weeksPerSemester < 0) {
                throw new IllegalArgumentException ("invalid input");
            }

            // calculates the classes met
            classesMet = meetsPerWeek * weeksPerSemester;

            // create the class object
            one = new Classes(className,classesMet);

            // prompts for class class size
            System.out.println("");
            System.out.println("What is the class size?");
            System.out.print("Enter: ");
            classSize = in.nextInt();
            if(classSize < 0) {
                throw new IllegalArgumentException ("invalid input");
            }

            ignore = in.nextLine();

            // sets the class size
            one.setClassSize(classSize);

            // sets size of array of students
            studentNamesArr = new Student[classSize];

            // gets the student names
            for (int i = 0; i < classSize; i++) {
                int j = i + 1;
                System.out.println("");
                System.out.print("Enter the name of student number " + j +
                    " (First and Last name): ");
                studentName = in.nextLine();
                studentNamesArr[i] = new Student(studentName,className);
                addStudent(s,studentNamesArr[i]);
            }

            // prompts for option selection
            System.out.println("Select Option (1, 2, or 3)");
            System.out.println("1. Add Attendance\n2. Add Grades\n3. Quit");
            System.out.print("Pick one number: ");
            option2 = in.nextLine();
            if(!option2.equals("1") && !option2.equals("2") && !option2.equals("3")) {
                throw new IllegalArgumentException ("invalid input");
            }
            if(option2.equals("1")) {
                while (option2.equals("1")) {
                    System.out.print("Enter the student name you want to add attendance: ");
                    studentOption = in.nextLine();

                    if (option2.equals("1")) {
                        System.out.println("");
                        System.out.print("Enter day (EX: 04 for fourth day of " +
                            "month or 11 for eleventh day of month): ");
                        option2 = in.next();
                        r1 = Integer.parseInt(option2);
                        if(r1 < 0) {
                            throw new IllegalArgumentException ("invalid input");
                        }


                        System.out.print("Enter month (EX 03 for March or 12 for December): ");
                        option3 = in.next();
                        r1 = Integer.parseInt(option3);
                        if(r1 < 0) {
                            throw new IllegalArgumentException ("invalid input");
                        }


                        System.out.print("Enter year in 2 digit (EX 22 for 2022): ");
                        option4 = in.next();
                        r1 = Integer.parseInt(option4);
                        if(r1 < 0) {
                            throw new IllegalArgumentException ("invalid input");
                        }


                        System.out.print("Status of attendance (p for present and a for absent)");
                        option5 = in.next();
                        if(!option5.equals("p") && !option5.equals("a")) {
                            throw new IllegalArgumentException ("invalid input");
                        }

                        attend = new Attendance(option2,option3,option4,option5);

                        String attDate = option2 + option3 + option4;

                        addStudentAtt(studentOption,s,attDate,option5);
                    }
                }
            }
            if(option2.equals("2")) {
                while (option2.equals("2")) {
                    System.out.println("");
                    System.out.print("Enter the student name you want to add grade: ");
                    studentOption = in.nextLine();

                    if (option2.equals("1")) {

                        System.out.println("Enter the name of the grade in 2 digit");
                        System.out.print("(EX T1 for Test 1 or FT for Final Test): ");
                        option2 = in.next();
                        if(option2.length() > 2) {
                            throw new IllegalArgumentException ("input too long");
                        }


                        System.out.println("Enter the weight for the grade in 2 digit");
                        System.out.print("EX 05 for 5 or 20 for 20% or XX for 100%: ");
                        option3 = in.next();
                        r1 = Integer.parseInt(option3);
                        if(r1 < 0) {
                            throw new IllegalArgumentException ("invalid input");
                        }



                        System.out.println("Enter the grade in 2 digit");
                        System.out.print("EX 05 for 5 or 20 for 20% or XX for 100%: ");
                        option4 = in.next();
                        r1 = Integer.parseInt(option4);
                        if(r1 < 0) {
                            throw new IllegalArgumentException ("invalid input");
                        }

                        grade = new Grade(option2,option3,option4);


                        addStudentGrade(studentOption,s,option2,option3,option4);
                    }
                }
            }
            if(option2.equals("3")) {
                System.exit(0);
            }

        }

        //Prompt for option 2 Review Class
        if(option1.equals("2")) {
            System.out.println("");
            System.out.println("Which class do you want to access ?");
            FileInputStream fileinput1;
            FileInputStream fileinput2;
            try {

                //Prompt the classes that already exist
                fileinput1 = new FileInputStream("test-files/totalClass.txt");
                Scanner scan = new Scanner(fileinput1);
                while(scan.hasNextLine()) {
                    String s = scan.nextLine();
                    System.out.println(s);
                }

                System.out.print("Pick one: ");

                //user option on which class they want to access
                option2 = in.nextLine();

                String s = "test-files/" + option2 + ".txt";
                fileinput2 = new FileInputStream(s);
                Scanner in2 = new Scanner(fileinput2);

                String inputFile = "test-files/" + option2 + ".txt";
                System.out.println("");
                System.out.println("What do you want to do with this class ?");
                System.out.println("1. See Attendance/Grade\n2. Add Attendance/Grade");
                System.out.print("Pick one: ");
                option6 = in.nextLine();
                if(!option6.equals("1") && !option6.equals("2") && !option6.equals("3")) {
                    throw new IllegalArgumentException ("invalid input");
                }

                if(option6.equals("1")) {
                    System.out.println("1. View Attendance\n2. View Grade\n3. Quit");
                    System.out.print("Pick one: ");

                    //user option on what they want to do with the class
                    option3 = in.nextLine();

                    if(!option3.equals("1") && !option3.equals("2") && !option3.equals("3")) {
                        throw new IllegalArgumentException ("invalid input");
                    }

                    if(option3.equals("1")) {
                        System.out.println("");
                        System.out.print("Enter the name of student you want to see: ");

                        //user option on which student they want to choose
                        option3 = in.nextLine();
                        temp = new Student(option3,option2);

                        String r2 = totalAtt(inputFile,temp);
                        System.out.println("Attendance of " + option3 + " : " + r2);
                    }
                    if(option3.equals("2")) {
                        System.out.println("");
                        System.out.print("Enter the name of student you want to see: ");
                        option3 = in.nextLine();

                        temp = new Student(option3,option2);
                        double r2 = finalGrade(inputFile,temp);
                        System.out.printf("Final Grade of selected student: %.2f",r2);
                    }
                    if(option3.equals("3")) {
                        System.exit(0);
                    }
                } else if(option6.equals("2")) {
                    System.out.println("1. Add Attendance\n2. Add Grade\n3. Quit");
                    System.out.print("Pick one: ");

                    //user option on what they want to do with the class
                    option3 = in.nextLine();
                    if(!option3.equals("1") && !option3.equals("2") && !option3.equals("3")) {
                        throw new IllegalArgumentException ("invalid input");
                    }

                    if(option3.equals("1")) {
                        System.out.print("Enter the student name you want to add attendance: ");
                        studentOption = in.nextLine();

                        System.out.println("");
                        System.out.print("Enter day (EX: 04 for fourth day of month"
                            + " or 11 for eleventh day of month): ");
                        option2 = in.next();
                        r1 = Integer.parseInt(option2);
                        if(r1 < 0) {
                            throw new IllegalArgumentException ("invalid input");
                        }


                        System.out.print("Enter month (EX 03 for March or 12 for December): ");
                        option3 = in.next();
                        r1 = Integer.parseInt(option3);
                        if(r1 < 0) {
                            throw new IllegalArgumentException ("invalid input");
                        }


                        System.out.print("Enter year in 2 digit (EX 22 for 2022): ");
                        option4 = in.next();
                        r1 = Integer.parseInt(option4);
                        if(r1 < 0) {
                            throw new IllegalArgumentException ("invalid input");
                        }


                        System.out.print("Status of attendance (p for present and a for absent)");
                        option5 = in.next();

                        attend = new Attendance(option2,option3,option4,option5);

                        String attDate = option2 + option3 + option4;

                        addStudentAtt(studentOption,s,attDate,option5);
                    }
                    if(option3.equals("2")) {
                        System.out.print("Enter the student name you want to add grade: ");
                        studentOption = in.nextLine();

                        System.out.println("");
                        System.out.print("Enter Test Name in 2 digits (EX: T1 for Test 1): ");
                        option2 = in.next();


                        System.out.print("Enter weight in 2 digit (EX 20 for 20%): ");
                        option3 = in.next();
                        r1 = Integer.parseInt(option3);
                        if(r1 < 0) {
                            throw new IllegalArgumentException ("invalid input");
                        }


                        System.out.println("Enter score in 2 digit (EX 03 for 3% or 30"
                            + " for 30% or XX for 100%)");
                        System.out.println("EX 03 for 3% or 30 for 30% or XX for 100%");
                        System.out.print("Enter: ");
                        option4 = in.next();
                        r1 = Integer.parseInt(option4);
                        if(r1 < 0 && !option4.equals("XX")) {
                            throw new IllegalArgumentException("invalid input");
                        }

                        grade = new Grade(option3,option4,option2);

                        String attDate = option2 + option3 + option4;

                        addStudentGrade(studentOption,s,option2,option3,option4);
                    }
                    if(option3.equals("3")) {
                        System.exit(0);
                    }
                }


            } catch (FileNotFoundException e) {
                throw new IllegalArgumentException("Unable to access input file: ");
            }
        }

    }

    /**
     * adds a student to the classes roster
     *
     * @param outputFile the file to be output towards
     * @param student the student to add
     * @throws IOException e if file cannot be found
     */
    public static void addStudent(String outputFile, Student student) {

        try {

            BufferedWriter out = new BufferedWriter(new FileWriter(outputFile, true));


            out.write(student.getStudent() + "," + "\n");
            out.close();
        } catch (IOException e) {
            System.out.println("exception occurred" + e);
        }
    }

    /**
     * calculates final grade for a student
     *
     * @param inputFile the file to input
     * @param student student class file for the student to calculate
     * @return result the final grade
     * @throws IllegalArgumentException "Unable to access output file" if cannot access file
     *
     */
    public static double finalGrade(String inputFile, Student student) {
        FileInputStream inFS;
        String nameFinding = "";
        String nameTarget = student.getStudent();
        boolean found = false;
        double result = 0.0;

        try {
            inFS = new FileInputStream(inputFile);
            Scanner in = new Scanner(inFS);
            while(in.hasNextLine()) {
                String s = in.nextLine();
                String[] s1 = s.split(",");
                if(s1[0].equals(nameTarget)) {
                    found = true;
                    for(int i = 1; i < s1.length; i++) {
                        if(s1[i].length() == HALF_DOZEN) {
                            result = result + ((Double.parseDouble(s1[i].substring(2,WHEELS_CAR))
                                / 100) *
                                Double.parseDouble(s1[i].substring(WHEELS_CAR,HALF_DOZEN)));
                        }
                    }
                }
            }
            if(found) {
                return result;
            } else {
                return -1;
            }

        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Unable to access output file: " + inputFile);
        }

    }

    /**
     * calculates total attendance for a student
     *
     * @param inputFile the file to input
     * @param student object of the student
     * @return result the students total attendance
     * @throws IllegalArgumentException if cannot open file
     */
    public static String totalAtt(String inputFile, Student student) {
        FileInputStream inFS;
        String nameFinding = "";
        String nameTarget = student.getStudent();
        boolean found = false;
        String result = "";
        int present = 0;
        int dayCount = 0;

        try {
            inFS = new FileInputStream(inputFile);
            Scanner in = new Scanner(inFS);
            while(in.hasNextLine()) {
                String s = in.nextLine();
                String[] s1 = s.split(",");
                if(s1[0].equals(nameTarget)) {
                    found = true;
                    for(int i = 1; i < s1.length; i++) {
                        if(s1[i].length() == DAYS_WEEK) {
                            dayCount++;
                            String f = s1[i].substring(HALF_DOZEN,DAYS_WEEK);
                            if(f.equals("p")) {
                                present++;
                            }
                        }
                    }
                }
            }
            result = result + present + "/" + dayCount;
            if(found) {
                return result;
            } else {
                return "Student not found";
            }

        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Unable to access output file: " + inputFile);
        }
    }

    /**
     * adds a student attendance record
     *
     * @param student the student to add
     * @param inputFile the file to input to
     * @param date the date to add attendance for
     * @param att the attendance status
     * @throws IOException if file not found
     */
    public static void addStudentAtt(String student,String inputFile, String date, String att) {

        try {
            //oldString
            String oldS = "";

            //newString
            String newS = "";

            //array that store chang
            String[] changeArr;

            //String to be changed
            String change = "";

            //line number
            int lineCount = 0;

            //totalLine
            int totalLine = 0;

            //Scan input file
            FileInputStream inFS;
            inFS = new FileInputStream(inputFile);
            Scanner in = new Scanner(inFS);
            File tempe = new File("test-files/temp.txt");

            //outputFile
            BufferedWriter out = new BufferedWriter(new FileWriter(tempe, true));
            File replace = new File(inputFile);


            //Copy old String to oldString
            while(in.hasNextLine()) {
                String s = in.nextLine();
                oldS += s + "\n";
                totalLine++;
            }

            //Scan to find student and find line number
            Scanner in2 = new Scanner(oldS);
            String studenName = student;
            boolean keep = true;
            while(in2.hasNextLine()) {
                String f = in2.nextLine();
                String[] f2 = f.split(",");
                if(keep) {
                    lineCount++;
                }
                if(f2[0].equals(student)) {
                    keep = false;
                    changeArr = f2;
                    change = f;
                }
            }

            //Add Attendance
            int z = change.length();
            String change2 = change.substring(0,z);
            change2 += "," + date + att;

            //ReForm new String
            Scanner in3 = new Scanner(oldS);
            int zz = 0;
            String y;
            while(zz < totalLine) {
                zz++;
                if(zz != lineCount) {
                    out.write(in3.nextLine() + "\n");
                } else if (zz == lineCount) {
                    y = in3.nextLine();
                    out.write(change2 + "\n");
                }
            }

            inFS.close();
            out.close();

            boolean successful = tempe.renameTo(replace);


        } catch (IOException e) {
            System.out.println("exception occurred" + e);
        }



    }

    /**
     * ads a students grade
     *
     * @param student the student to add
     * @param inputFile the file to input
     * @param testName1 the name of the test
     * @param weight the weight of the test
     * @param score the score the student received
     */
    public static void addStudentGrade(String student,String inputFile,
        String testName1,String weight,String score) {

        try {
            //oldString
            String oldS = "";

            //newString
            String newS = "";

            //array that store chang
            String[] changeArr;

            //String to be changed
            String change = "";

            //line number
            int lineCount = 0;

            //totalLine
            int totalLine = 0;

            //Scan input file
            FileInputStream inFS;
            inFS = new FileInputStream(inputFile);
            Scanner in = new Scanner(inFS);
            File tempe = new File("test-files/temp.txt");

            //outputFile
            BufferedWriter out = new BufferedWriter(new FileWriter(tempe, true));
            File replace = new File(inputFile);


            //Copy old String to oldString
            while(in.hasNextLine()) {
                String s = in.nextLine();
                oldS += s + "\n";
                totalLine++;
            }

            //Scan to find student and find line number
            Scanner in2 = new Scanner(oldS);
            String studenName = student;
            boolean keep = true;
            while(in2.hasNextLine()) {
                String f = in2.nextLine();
                String[] f2 = f.split(",");
                if(keep) {
                    lineCount++;
                }
                if(f2[0].equals(student)) {
                    keep = false;
                    changeArr = f2;
                    change = f;
                }
            }

            //Add Attendance
            int z = change.length();
            String change2 = change.substring(0,z);
            change2 += "," + testName1 + weight + score;

            //ReForm new String
            Scanner in3 = new Scanner(oldS);
            int zz = 0;
            String y;
            while(zz < totalLine) {
                zz++;
                if(zz != lineCount) {
                    out.write(in3.nextLine() + "\n");
                } else if (zz == lineCount) {
                    y = in3.nextLine();
                    out.write(change2 + "\n");
                }
            }

            inFS.close();
            out.close();

            boolean successful = tempe.renameTo(replace);


        } catch (IOException e) {
            System.out.println("exception occurred" + e);
        }



    }
}
