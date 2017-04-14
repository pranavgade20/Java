import java.util.Scanner;

/**
 * Class to actually work on the tree
 *
 * @author Pranav Gade
 * @version 0.0
 */
public class BinaryTree
{
    static Tree t;
    
    static Scanner s = new Scanner(System.in);
    public static void  main(){
        System.out.println("Enter the first value:");
        t = new Tree(s.nextInt());
        
        for(;;){
            System.out.println("Enter 0 to search the tree.");
            System.out.println("Enter 1 to add element to the tree.");
            System.out.println("Enter 2 to show the elements of the tree.");
            
            int mode = s.nextInt();
            
            if(mode == 0){//to search a value in the tree
                System.out.println("Enter the value to search:");
                int searchInt = s.nextInt();
                
                boolean searchResult;
                searchResult = t.search(searchInt);
                
                if(searchResult){
                    System.out.print("The search was successful.");
                    System.out.println("Found " + searchInt + " in the tree.");
                }else{
                    System.out.print("The search was unsuccessful.");
                    System.out.println("Could not find " + searchInt + " in the tree");
                }
            }else if(mode == 1){//to add an element to the tree
                System.out.println("Enter the value to add:");
                int newValue = s.nextInt();
                
                t.addElement(newValue);
            }else if(mode == 2){
                t.show();
            }else{
                System.out.println("Please enter the correct choice");
            }
        }
    }
}
