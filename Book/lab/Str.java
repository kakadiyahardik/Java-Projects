package lab;
import java.util.Scanner;

public class Str
{
    public static void main(String... ar)
    {
        Scanner sc=new Scanner(System.in);
        
        Stack<String> st=new Stack<String>();
        
        
        st.push("hardik");
        st.push("sdj");
        
        System.out.println(st.peek());
        System.out.println(st.pop());
        
        st.push("last");
        
        System.out.println(st.peek());
    }
}
