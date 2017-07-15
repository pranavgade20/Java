import java.util.*;

/**
 * The main class to model the school.
 *
 * @author Pranav Gade
 * @version 0.3
 */
public class School
{
    public String schoolName = "Ryan International School, Kharghar";
    public String principalName = "Principal Mam";
    public String masterPass = "stupid";
    
    public int stdSize = 1;
    public Standard[] standards = new Standard[stdSize];
    
    /**
     * Constructor for class School
     */
    public School(String schoolName, String principal_name, String password)
    {
        schoolName = schoolName;
        principalName = principal_name;
        masterPass = password;
    }
    /**
     * Constructor for class School, without name
     */
    public School()
    {
        //this constructor in to be used if you want default details
    }

    /**
     * A method to create a new student.
     * Using this to avoid creating a new student in other classes.
     *
     * @param     void
     * @return    Student object
     */
    public Student createStudent()
    {
        Student new_student;
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter the new student's name:");
        String new_student_name = s.next();
        System.out.println("Enter the new student's Date of Birth:");
        String new_student_DOB = s.next();
        System.out.println("Enter the new student's Date of Admission:");
        String new_student_DOA = s.next();
        System.out.println("Is the student a Boy?");
        boolean new_student_isBoy = s.nextBoolean();
        System.out.println("Enter the new student Password:");
        String new_student_passwd = s.next();
        
        new_student = new Student(new_student_name, new_student_DOB, new_student_DOA,
                                  new_student_isBoy, new_student_passwd);
        
        return new_student;
    }

    /**
     * Method to set the users' choice in the main program
     *
     * @param     void
     * @return    int
     *
     * The current return codes are:
     * 0 - student present marking
     * 1 - Admin Functions
     */
    public int getOperation(){
      Scanner s = new Scanner(System.in);

      System.out.println("Select the operation you want to perform:");
      System.out.println("1. Login");
      System.out.println("2. Administrative function");

      int opt = s.nextInt();
      opt--; // Decrement to start from 0

      return opt;
    }
    
    /**
     * Method to add a student in the school.
     *
     * @param     void
     * @return    void
     */
    public void addStudent()
    {
        Scanner s = new Scanner(System.in);
        Student new_student = createStudent();
        
        System.out.println("Enter the GRADE or STANDARD(1-10) of the student:");
        int grade;
        grade = s.nextInt();
        grade--;
        
        standards[grade].addStudent(new_student);
    }
    
    public void main(){
        Scanner s = new Scanner(System.in);
        
        //first Student in the school
        System.out.println("Please enter the first student's details:");
        Student first_student = createStudent();//fill in the details

        //first standard
        System.out.println("Creating the first standard...");

        //first division
        System.out.println("Please enter the first division's ID:");
        String div_id = s.next();
        System.out.println("Please enter the teacher's name:");
        String teacher_name = s.next();

        //actual creation
        Division new_div = new Division(div_id, teacher_name, first_student);
        standards[0] = new Standard(new_div);
        
        
        //The actual program which iterates starts here
        for (; ; ) {
            int opt = getOperation();

            if (opt == 0) { // Student login
                System.out.println("Enter your 6-digit ID:");
                int id = s.nextInt();

                int std = id%100; // Get the last two digits(standard ID)
                id -= std; // Remove the last 2 digits from the id
                id /= 100; // divide id by 100(to continue the same process in standards[std]

                boolean success = standards[std].login(id); // pass new ID

                if (success) {
                    System.out.println(", std " + (std+1) + "!");
                }

                if (opt == 1) { // Carry out administrative functions
                    System.out.println("Please select an option:");
                    System.out.println("0. Exit");
                    System.out.println("1. Add a NEW Student to the school.");
                    System.out.println("2. Add a NEW Division to the school.");
                    System.out.println("3. Add a NEW Standard to the school.");

                    int funcToDo = s.nextInt();

                    switch (funcToDo) {
                        case 1: // add a new student
                            addStudent();
                            break;

                        case 2: // add a new division
                            System.out.println("Enter the GRADE or STANDARD(1-10) to add the new division.");
                            int grade;
                            grade = s.nextInt();
                            grade--;

                            // create the first student in the div
                            Student new_student = createStudent();

                            //add the division and new student
                            standards[grade].addDivision(new_student);

                            break;

                        case 3:
                            System.out.println("Work under Progress, feature coming soon.");
                            break;
                    }
                }
            }
        }
    }
}