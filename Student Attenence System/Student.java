import java.util.*;

/**
 * Class to model a student.
 * Contains student Name, Date of Birth, Date of Admission, Gender.
 *
 * @author Pranav Gade
 * @version 0.1
 */
public class Student
{
   String name;
   String dateOfBirth;
   String dateOfAdmission;
   String password;
   
   boolean isBoy;
   boolean isPresent = false;
   
   public Student(String n, String DOB, String DOA, boolean boyOrNot, String passwd){
      name = n;
      dateOfBirth = DOB;
      dateOfAdmission = DOA;
      isBoy = boyOrNot;
      password = passwd;
   }
   
   public boolean login(){
      Scanner s = new Scanner(System.in);
      System.out.println("Enter your password:");
      String pass = s.next();

      if(password.equals(pass)){
         isPresent = true;
         System.out.println("Welcome, " + name);
         
         return true;
      }else{
          System.out.println("Sorry, that is NOT the correct password.");
          System.out.println("Please try again.");

          return false;
      }
   }
}