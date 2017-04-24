/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lab;


public class TriDemo {
    public static void main(String... arg)
    {
        Triangle t1=new Triangle();
        Stack<Triangle> st =new Stack<Triangle>();
        
        t1.setXYZ(10,20,30);
        st.push(t1);
        
        Triangle t2=new Triangle();
        t2.setXYZ(40,50,60);
        st.push(t2);
        
        Triangle t3=(Triangle)st.pop();
        
        System.out.println(t3.getX());
        System.out.println(t3.gety());
        System.out.println(t3.getz());
    }
}
