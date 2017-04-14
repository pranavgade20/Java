/**
 * The class for every node of the tree.
 *
 * @author Pranav Gade
 * @version 0.2
 */
public class Node
{
    public int value;
    
    public Node parent;//the parent node
    public Node left;//the left child node, if existing
    public Node right;//the right child node, if existing
    
    public Node(int v)//constructor for the base node of the tree
    {
        this(v, null);
    }
    public Node(int v ,Node n)//constructor for all other nodes. Adds the parent too
    {
        value = v;
        parent = n;
    }
    
    /**
     * A method to add an element to the tree.
     * Self-refrencing if the appropriate node is not null.
     *
     * @param  n  the value to be added to the tree
     * @return    Nothing, yet.(as, of course you can see ;-p)
     */
    public void addElement(int n)
    {
        if(value > n){
            if(left != null){
                left.addElement(n);
            }else{
                left = new Node(n, this);
            }
        }else if(value < n){
            if(right != null){
                right.addElement(n);
            }else{
                right = new Node(n, this);
            }
        }else{
            System.out.println("Value already exists in the tree.");
        }
    }
    
    /**
     * A method to search the given element in the left and right nodes, and call itself again.
     * 
     * @param  x  the number to search
     * @return    true or false, the element exists or not
     */
    public boolean search(int x)
    {
        boolean result = false;
        if(value == x){
            result = true;
        }else{
            if(right != null && value < x){
                result = right.search(x);
            }
            if(left != null && value > x){
                result = left.search(x);
            }
        }
        return result;
    }
    
    /**
     * A method to print the binary tree. 
     * Can be used to return arrays or numbers in a order.
     *
     * @param  null
     * @return null
     */
    public void show()
    {
        if(left != null){
            left.show();
        }
        System.out.println(value);
        if(right != null){
            right.show();
        }
    }
}
