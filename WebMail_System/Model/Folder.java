package Model;

import java.io.Serializable;
import java.util.HashMap;

public class Folder implements Serializable
{
	HashMap<Long,Message> message=new HashMap<>();
	
	public void add(Message m)
	{
		message.put(m.getId(), m);
	}
	
	public void remove(long id)
	{
		message.remove(id);
	}
	
}
