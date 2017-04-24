package lab;

import java.util.LinkedList;

public class Stack<T>
{
    private LinkedList<T> s;
    
    public Stack()
    {
        s=new LinkedList<T>();
    }
    
    public Object peek()
    {
        return s.get(s.size()-1);
    }
    
    public Object pop()
    {
        return s.remove(s.size()-1);
    }
    
    public void push(T i)
    {
        s.addLast(i);
    }

}
