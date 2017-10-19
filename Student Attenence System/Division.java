import java.util.*;

/**
 * Class to model a division. 
 * Contains an array of Students, Size of division(no. of boys & girls), Teacher name
 *
 * @author Pranav Gade
 * @version 0.x
 */
public class Division
{
    public int divSize = 1;
    public Student[] students = new Student[divSize];
    
    public String divID;
    public String teacherName;
    
    /**
     * Constructor for objects of class Division
     */
    public Division(String div_id, String class_teacher_name, Student new_student)
    {
        divID = div_id;
        teacherName = class_teacher_name;
        students[0] = new_student;
    }

    /**
     * A method to add a student to the division
     *
     * @param   new_student  The Student to be added
     * @return               nothing for now
     */
    public int addStudent(Student new_student)
    {      
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
        return (divSize-1);// returning the roll number
    }

    public boolean login(int id){
        //we should be left with a 2 digit id by this stage.

        boolean success = students[id].login();

        return success;
    }
}