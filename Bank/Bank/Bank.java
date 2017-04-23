package Q2;

import java.util.HashMap;

public class Bank
{
	private String bName;
	private double rate;
	private HashMap<Long,BankAccount> bank;
	private BankAccount acc;
	
	Bank(double rate,String name)
	{
		bank=new HashMap<>();
		this.rate=rate;
		this.bName=name;
	}
	
	public long openNewAccount(double initial_balance)
	{
		acc=new BankAccount(initial_balance);
		bank.put(acc.getAccno(), acc);
		
		return acc.getAccno();
	}
	
	public BankAccount find(long acc_no)
	{
		if(bank.containsKey(acc_no))
		{
			return bank.get(acc_no);
		}
		else
		{
			return null;
		}
		
	}
	
	public BankAccount close(int acc_no)
	{
		return bank.remove(acc_no);
	}
	
	public void deposite(long ac,double amt)
	{
		BankAccount ba=find(ac);
		ba.deposit(amt);
	}
	
	public void withdraw(long ac,double amt) throws DailyLimitException, InsuffBalanceException
	{
		BankAccount ba=find(ac);
		ba.withdraw(amt);
	}
	
	public double getBalance(long ac)
	{
		BankAccount ba=find(ac);
		return ba.getBalance();
	}

}
