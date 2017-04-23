package Q2;
import java.util.Calendar;

public class Transaction 
{
	//private 
	private Calendar calobj;
	private String date;
	private String type;
	private String location;
	private double amount;
	private double remain=0;
    
	public Transaction(String type,String location,double ammount,double remain)
	{
		calobj=  Calendar.getInstance();
		date=calobj.getTime().toString();
		this.location=location;
		this.type=type;
		this.amount=ammount;
		this.remain=remain;
	}
	
	public void printTransaction()
	{
		System.out.println(this.type
				+ " "+this.amount +" from "+this.location +" at "+this.date 
				+"\n clear balance is"+this.remain);
	}
}
