import java.util.*;

/**
 * Class to model a division. 
 * Contains an array of Students, Size of division(no. of boys & girls), Teacher name
 *
 * @author Pranav Gade
 * @version 0.
 */
public class Division
{
    public int divSize = 1;
    public Student[] students = new Student[divSize];
    
    public String teacherName;
    
    /**
     * Constructor for objects of class Division
     */
    public Division(Student new_student, String class_teacher_name)
    {
        students[0] = new_student;
        
        teacherName = class_teacher_name;
    }

    /**
     * A method to add a student to the division
     *
     * @param  void         nothing
     * @return              nothing for now
     */
    public void addStudent()
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
        
        // a temporary array to store students' details while
        // the orignal array is reallocated
        Student[] temp;// declaration
        temp = new Student[divSize];// initialisation
        
        //assign temp
        for (int i = 0;i < divSize;i++) {
            temp[i] = students[i];
        }
        divSize++;// Add 1 to the division size
        students = new Student[divSize]; //new array with one more student
        
        for (int i = 0;i < divSize-1;i++) {// loop to reassign students
            students[i] = temp[i];
        }
        students[divSize-1] = new_student;// the last student is the new one
    }
}