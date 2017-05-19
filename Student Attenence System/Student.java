
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
   
   public void logIn(String pass){
      if(pass == password){
         isPresent = true;
         System.out.println("Welcome, " + name + "!");
      }else{
          System.out.println("Sorry, that is NOT the correct password.");
          System.out.println("Please try again.");
      }
   }
}
