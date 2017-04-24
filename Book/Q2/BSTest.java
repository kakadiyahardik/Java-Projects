package Q2;

import java.util.Scanner;

public class BSTest
{
    
    public static void main(String []ar)
    {
        BST btree = new BST();
         
        Book b1 = new Book(121, "ABC", 250);
        btree.put( new Integer(121), b1);
        btree.put(new Integer(133),new Book(121,"XYZ", 330));
        Book x = (Book) btree.get(new Integer(133));
       
        if(x==null)
            System.out.println("null");
        else
            System.out.println(x.getTitle());
        
        btree.remove(new Integer(121));
        btree.preOrderOutput();
        
        Book y = (Book) btree.get(new Integer(121));
       
        if(y==null)
            System.out.println("null");
        else
            System.out.println(y.getTitle());
       // btree.inOrderOutput();
       // btree.postOrderOutput();
    }
}
