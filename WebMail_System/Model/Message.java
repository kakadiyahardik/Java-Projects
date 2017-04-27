package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Message implements Serializable
{
	private ArrayList<String> to=new ArrayList<String>();
	private ArrayList<String> toCC=new ArrayList<String>();
	private ArrayList<String> toBCC=new ArrayList<String>();
	private ArrayList<String> attach=new ArrayList<String>();
	private String sender;
	private String body="";
	private long msg_id;
	private static long next_msg_id=10000;
	
	public Message(String sender)
	{
		this.msg_id=next_msg_id;
		this.next_msg_id++;
		this.sender=sender;
	}
	
	public void addRecipeint(String to)
	{
		this.to.add(to);
	}
	
	public void addCC(String tocc)
	{
		toCC.add(tocc);
	}
	
	public void addBCC(String tobcc)
	{
		toBCC.add(tobcc);
	}
	
	public void addAttach(String mime)
	{
		attach.add(mime);
	}
	
	public void appendBody(String str)
	{
		this.body+=str;
	}
	
	/*public boolean equals(Message m)
	{
		
	}*/
	
	public long getId()
	{
		return this.msg_id;
	}
	
	public String getSender()
	{
		return this.sender;
	}
	public String getBody()
	{
		return this.body;
	}
  
}
