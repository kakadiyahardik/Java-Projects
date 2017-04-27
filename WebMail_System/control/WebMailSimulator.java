package control;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import Model.MailBox;
import Model.Message;
import Model.User;
import Model.WebMail;

public class WebMailSimulator implements Serializable
{
	public static void main(String...strings) throws LoginFail, IOException, ClassNotFoundException
	{
		WebMail web=new WebMail();
		web.addUser("hardik", "root");
		User user=web.login("hardik","root");
		
		try
		{
			if(user==null)
				throw new LoginFail("usaer name or password is wrong");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		MailBox  mbox=user.getMailBox();
		Message m=new Message("Hardik");
		m.addRecipeint("kaushik");
		m.addCC("nikul");
		m.addBCC("blank");
		m.addAttach("file 1");
		m.appendBody("hi am there ");
		
		mbox.addToInbox(m);
		
		m=new Message("Hardik");
		m.addRecipeint("kaushik@gmail.com");
		m.appendBody("hi am there mail 2");
		
		mbox.send(m);
		mbox.addToDraft(m);
		
		web.save();
		HashMap<String, User> h=web.read();
		
		mbox=h.get("hardik").getMailBox();
		
		//mbox=user.getMailBox();
		ArrayList<Message> am=mbox.getDraft();
		
		Iterator i=am.listIterator();
		while(i.hasNext())
		{
			Message ms=(Message) i.next();
			System.out.println(ms.getId());
			System.out.println(ms.getBody());
			System.out.println(ms.getSender());
		}
		
	}
}
