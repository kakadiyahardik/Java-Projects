package Model;

import java.io.Serializable;

public class User implements Serializable
{
	private String name;
	private String pwd;
	
	MailBox mailBox;
	
	public User(String uName,String pwd)
	{
		this.name=uName;
		this.pwd=pwd;
		mailBox=new MailBox();
	}
	
	public MailBox getMailBox()
	{
		return this.mailBox;
	}
	
	public String getPass()
	{
		return this.pwd;
	}
}
