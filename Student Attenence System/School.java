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

   public int schoolSize = 1;
   public Standard[] standards = new Standard[schoolSize];
   public int students_present = 0;

    /**
     * Constructor for class School
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

       System.out.print("Enter the new student's name: ");
       String new_student_name = s.next();
       System.out.print("Enter the new student's Date of Birth: ");
       String new_student_DOB = s.next();
       System.out.print("Enter the new student's Date of Admission: ");
       String new_student_DOA = s.next();
       System.out.print("Is the student a Boy?(y/n): ");
       boolean new_student_isBoy = getYesOrNo();
       
       System.out.print("Enter the new student Password: ");
       String new_student_passwd = s.next();
       System.out.println("");

       new_student = new Student(new_student_name, new_student_DOB, new_student_DOA,
        new_student_isBoy, new_student_passwd);

       return new_student;
    }

    /**
     * Method to add a student in the school.
     *
     * @param     void
     * @return    void
     */
    public int addStudent()
    {
       Scanner s = new Scanner(System.in);
       Student new_student = createStudent();

       System.out.print("Enter the GRADE or STANDARD(1-10) of the student: ");
       int grade = s.nextInt();
       grade--;// to get the index in the array

       int id = standards[grade].addStudent(new_student);
       schoolSize++;
       return (id*100)+grade;
    }

    /**
     * A method to add a standard to the school
     *
     * @param   void
     * @return  void   nothing for now
     */
    public void addStandard()
    {
       Standard new_standard;
       Division new_division;
       Scanner s = new Scanner(System.in);

       System.out.println("Please enter the details of the first student:");
       Student new_student = createStudent();
       schoolSize++;

       System.out.println("Please enter the details of the first division:");
       System.out.print("Enter the new division's ID: ");
       String new_div_ID = s.next();
       System.out.print("Enter the new division's teacher's name: ");
       String new_div_teacher = s.next();

       new_division = new Division(new_div_ID, new_div_teacher, new_student);
       new_standard = new Standard(new_division);

        // a temporary array to store students' details while
        // the orignal array is reallocated
        Standard[] temp;// declaration
        temp = new Standard[schoolSize];// initialisation
        
        //assign temp
        for (int i = 0;i < schoolSize;i++) {
         temp[i] = standards[i];
      }
        schoolSize++;// Add 1 to the division size
        standards = new Standard[schoolSize]; // new array with one more student
        
        for (int i = 0;i < schoolSize-1;i++) {// loop to reassign students
         standards[i] = temp[i];
      }
        standards[schoolSize-1] = new_standard;// the last student is the new one
     }

   /**
      * Method to accept yes/no and return true/false
      * display the prompt asking for (y/n) before calling this function
      *
      * @param     void
      * @return    boolean
      *
      */
   public boolean getYesOrNo(){
      Scanner s = new Scanner(System.in);
      String yes_or_no = s.next();
      yes_or_no = yes_or_no.toLowerCase();
      char y_or_n = yes_or_no.charAt(0);
       
      switch (y_or_n) {
         case 'y':
            return true;
         case 'n':
            return false;
      }
      return false;
   }

   /**
     * Method to display all stats like present n absent students
     *
     * @param     void
     * @return    void
     *
     * Current Functions-
     * 1. No. of Students present
     * 2. No. of Students absent
     */
   public void dispStats(){
      System.out.println("Today, "+students_present+" students are present.");
      System.out.print("and "+(schoolSize-students_present)+" are absent, ");
      System.out.println("out of "+schoolSize+" students.");
   }

   /**
      * Method to ask for confirmation and start a new day
      * i.e., clear all present marks and set no of students present to 0
      *
      * @param     void
      * @return    boolean
      *
      */
   public boolean startANewDay(){
      System.out.print("Are you sure you want to start a new day?(y/n): ");
      if(getYesOrNo() == false) return false;

      //if false is not returned:
      students_present = 0;
      for (int x=0;x<schoolSize ;x++) { // set all the student's isPresent to false
         for (int y=0;y<standards[x].stdSize ;y++) {
            for (int z=0;z<standards[x].divisions[y].divSize ;z++) {
               standards[x].divisions[y].students[z].isPresent = false;
            }
         }
      }
      return true;
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
      System.out.print("Enter your chioce: ");

      int opt = s.nextInt();
      opt--; // Decrement to start from 0
      System.out.println("");

      if(opt == 1) {// Check if the user wanting to perform administrative function is authorised
         System.out.print("Please enter the master password: ");
         String st = s.next();

         if(st.equals(masterPass)){
            return 1;
         } else {
            System.out.println("Wrong password, please try again.");
            return 6;// somr arbitary number so that the loop in main continues
         }
      } else {
         return opt;
      }
   }

   public void main(){
        Scanner s = new Scanner(System.in);

        //first Student in the school
        System.out.println("Please enter the first student's details:");
      Student first_student = createStudent();//fill in the details

      //first standard
      System.out.println("Creating the first standard...\n");

      //first division
      System.out.print("Please enter the first division's ID: ");
      String div_id = s.next();
      System.out.print("Please enter the teacher's name: ");
      String teacher_name = s.next();

      //actual creation
      Division new_div = new Division(div_id, teacher_name, first_student);
      standards[0] = new Standard(new_div);
        
        
      //The actual program which iterates starts here
      for (; ; ) {
         int opt = getOperation();

         if (opt == 0) { // Student login
            System.out.print("Enter your 6-digit ID: ");
            int id = s.nextInt();

            int std = id%100; // Get the last two digits(standard ID)
            id -= std; // Remove the last 2 digits from the id
            id /= 100; // divide id by 100(to continue the same process in standards[std]

            boolean success = standards[std].login(id); // pass new ID

            if (success) {
               students_present++;
            }
         }

         if (opt == 1) { // Carry out administrative functions
            System.out.println("Please select an option:");
            System.out.println("0. Exit");
            System.out.println("1. Add a NEW Student to the school.");
            System.out.println("2. Add a NEW Division to the school.");
            System.out.println("3. Add a NEW Standard to the school.");
            System.out.println("4. Display Stats.");
            System.out.println("5. Start a new day.");
            System.out.print("Enter your choice: ");

            int funcToDo = s.nextInt();
            System.out.println("");

            switch (funcToDo) {
               case 1: // add a new student
                  int ID = addStudent();
                  System.out.println("The 6-digit ID of the new student is: "+ID);
               break;

               case 2: // add a new division
                  System.out.print("Enter the GRADE or STANDARD(1-10) to add the new division: ");
                  int grade = s.nextInt();
                  grade--;

                  // create the first student in the div
                  Student new_student = createStudent();

                  //add the division and new student
                  standards[grade].addDivision(new_student);

               break;

               case 3:
                  addStandard();
               break;

               case 4:
                  dispStats();
               break;

               case 5:
                  System.out.print("Please re-enter the password: ");
                  String pass = s.next();
                  if(Objects.equals(masterPass, pass)) {
                     startANewDay();
                  } else {
                     System.out.println("Abort.");
                }
               break;

               default:
                  System.out.println("Please enter the correct option.");
               break;
            }
         }
         for (int sp = 0; sp < 10; sp++) {
            System.out.println("\n\n");
         }
      }
   }
}