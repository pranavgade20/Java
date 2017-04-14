/**
 * The class tree.This includes addElement.
 *
 * @author Pranav Gade
 * @version 0.1
 */
public class Tree
{
    public Node base;
    
    public int size = 1;//size of the tree.No use at present.:-(
    public Tree(int v)//construct a tree with a base value of v
    {
        base = new Node(v);
    }
    
    /**
     * A method to add an element to the tree.
     * Rereferences to addElement form Node.java
     * also adds one to the size of the tree
     *
     * @param  n  the value to be added to the tree
     * @return    Nothing, yet.(as, of course you can see ;-p)
     */
    public void addElement(int n)
    {
        base.addElement(n);
        size++;
    }
    
    /**
     * A method to search an element in the tree.
     * If exists, return true, else return false.
     *
     * @param  x  an element to search
     * @return    true or false - x exists or not
     */
    public boolean search(int x)
    {
        boolean result = base.search(x);
        
        return result;
    }
    
    /**
     * A method to print the binary tree.
     *
     * @param  null
     * @return null
     */
    public void show()
    {
        System.out.println("The tree has " + size + " element(s).");
        base.show();
    }
}
