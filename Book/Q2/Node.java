
package Q2;

public class Node 
{
    public Comparable id;
    public Book b;
    Node left,right;
    
    Node(Comparable id,Book b)
    {
        this.id=id;
        this.b=b;
        left=right=null;
    }
}
