
package Q2;


public class BST 
{
    Node root;
    
    BST()
    {
        root=null;
    }
    
    public Node add(Node root,Comparable key,Book b)
    {
        if(root==null)
            return new Node(key,b);
                 
        if(root.id.compareTo(key)>0)
        {
            root.left=add(root.left,key,b);
        }
        else
        {
            root.right=add(root.right,key,b);
        }
        
        return root;
    }
    
    public void put(Comparable key,Book b)
    {
        root=add(root,key,b);
    }
    
    public Object getBook(Node root,Comparable key)
    {
        if(root==null)
            return null;
        
        if(root.id.compareTo(key)==0)
            return root.b;
        
        if(root.id.compareTo(key)>0)
        {
            return getBook(root.left,key);
        }
        else
        {
            return getBook(root.right,key);
        }
    }
    public Object get(Comparable key)
    {
        return getBook(root,key);
    }
    
    public boolean isEmpty()
    {
        if(root==null)
            return true;
        else
            return false;
    }
    
    public void preOrderOutput()
    {
        preOrder(root);
    }
    public void preOrder(Node root)
    {
        if(root==null)
            return;
        
        System.out.println(root.b.getTitle());
        preOrder(root.left);
        preOrder(root.right);
    }
    
    public void inOrderOutput()
    {
        inorder(root);
    }
    public void inorder(Node root)
    {
        if(root==null)
            return;
        
        preOrder(root.left);
        System.out.println(root.b.getTitle());
        preOrder(root.right);
    }
    
    public void postOrderOutput()
    {
        postOrder(root);
    }
    public void postOrder(Node root)
    {
        if(root==null)
            return;
        
        preOrder(root.left);
        preOrder(root.right);
        System.out.println(root.b.getTitle());
        
    }
    
    public Node delete(Node root,Comparable key)
    {
        if(root==null)
            return root;
        
        if(root.id.compareTo(key)>0)
        {
            root.left=delete(root.left,key);
        }
        else if(root.id.compareTo(key)<0)
        {
            root.right=delete(root.right,key);
        }
        else
        {
            if(root.right==null)
                return root.left;
            else if(root.left==null)
                return root.right;
            
            root=minValue(root.right);
            
            root.right=delete(root.right,root.id);
        }
       return root;     
    }
    public void remove(Comparable key)
    {
        root=delete(root,key);
    }
    
    Node minValue(Node root)
    {
        Node tm=root;
        while(tm.left!=null)
        {
            tm=tm.left;
        }
        
        return tm;
    }
    /*
    public java.lang.Object get(java.lang.Comparable theKey);
    public java.lang.Object remove(java.lang.Comparable theKey);
    public boolean isEmpty();
    public void preOrderOutput(java.io.PrintStream out);
    public void inOrderOutput(java.io.PrintStream out);
    public void postOrderOutput(java.io.PrintStream out);*/

}
