package Model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class WebMail implements Serializable
{
	private HashMap<String,User> user=new HashMap<String,User>();
	private User u;
	public void  addUser(String user_name,String pwd)
	{
		u=new User(user_name,pwd);
		user.put(user_name,u);
	}
	
	public User login(String un,String pwd)
	{
		if(user.containsKey(un))
		{
			User tm=user.get(un);
			if(pwd.equals(tm.getPass()))
			{
				return tm;
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}
	
	public void deleteUser(User du)
	{
		user.remove(du);
	}
	
	public void save() throws IOException
	{
		FileOutputStream f=new FileOutputStream("message.txt");
		ObjectOutputStream obj=new ObjectOutputStream(f);
		
		obj.writeObject(user);
	}
	
	public HashMap<String,User> read() throws IOException, ClassNotFoundException
	{
		FileInputStream f=new FileInputStream("message.txt");
		ObjectInputStream obj=new ObjectInputStream(f);
		
		return (HashMap<String, User>) obj.readObject();
	}
	
}
