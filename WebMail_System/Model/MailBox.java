package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class MailBox implements Serializable
{
	private ArrayList<Message> inbox=new ArrayList<>();
	private ArrayList<Message> draft=new ArrayList<>();
	private ArrayList<Message> sent=new ArrayList<>();
	private ArrayList<Message> folder=new ArrayList<>();
	
	public void send(Message m)
	{
		sent.add(m);
	}
	
	public void addToInbox(Message m)
	{
		inbox.add(m);
	}
	
	public void addToDraft(Message m)
	{
		draft.add(m);
	}
	
	public Message clone() throws CloneNotSupportedException
	{
		return (Message) super.clone();
	}
	
	public ArrayList<Message> getInbox()
	{
		return this.inbox;
	}
	
	public ArrayList<Message> getDraft()
	{
		return this.draft;
	}
	
	public ArrayList<Message> getSend()
	{
		return this.sent;
	}

}
