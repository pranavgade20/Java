import java.util.*;

/**
 * Class to model a Standard.
 * Contains an array of Divisions, Number of divisions, Supervisor name
 *
 * @author Pranav Gade
 * @version 0.2
 */
public class Standard
{
    public int stdSize = 1;
    public Division[] divisions = new Division[stdSize];
    
    //public String supervisorName; //not bothering, for now
    
    /**
     * Constructor for objects of class Standard
     */
    public Standard(Division new_division) //, String supervisor_name)
    {
        divisions[0] = new_division;
        
        //supervisorName = supervisor_name;
    }

    /**
     * A method to add a division to the standard
     *
     * @param   new_student The first student in the Division
     * @return              nothing for now
     */
    public void addDivision(Student new_student)
    {
        Division new_division;
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter the new division's ID:");
        String new_div_ID = s.next();
        System.out.println("Enter the new division's teacher's name:");
        String new_div_teacher = s.next();
        System.out.println("Enter the new division's Password:");
        String new_div_passwd = s.next();
        
        new_division = new Division(new_div_ID, new_div_teacher, new_student);
        
        // a temporary array to store students' details while
        // the orignal array is reallocated
        Division[] temp;// declaration
        temp = new Division[stdSize];// initialisation
        
        //assign temp
        for (int i = 0;i < stdSize;i++) {
            temp[i] = divisions[i];
        }
        stdSize++;// Add 1 to the division size
        divisions = new Division[stdSize]; // new array with one more student
        
        for (int i = 0;i < stdSize-1;i++) {// loop to reassign students
            divisions[i] = temp[i];
        }
        divisions[stdSize-1] = new_division;// the last student is the new one
    }
    
    /**
     * A method to add a student to this standard.
     *
     * @param   new_student a sample parameter for a method
     * @return              nothing for now
     */
    public int addStudent(Student new_student)
    {
        Scanner s = new Scanner(System.in);
        
        System.out.println("Please select a division to add the student.");
        for (int i = 0;i < stdSize;i++) {
            System.out.print((i+1) + ".");//adding 1 to i to start list from 1
            System.out.println(divisions[i].divID);
        }
        int divID;// user's choice/option
        divID = s.nextInt();
        divID--;// decrease by one to get the index in array
        
        int studID = divisions[divID].addStudent(new_student);
        return (studID*100)+divID;// returning the roll number
    }

    public boolean login(int id){
        int div = id%100; // Get the last two digits(div ID)
        id -= div; // Remove the last 2 digits from the id
        id /= 100; // divide id by 100(to continue the same process in divisions[div]

        boolean success = divisions[div].login(id);

        return success;
    }
}