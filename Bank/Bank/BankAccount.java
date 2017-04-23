package Q2;

import java.util.ArrayList;

public class BankAccount
{
	private final long accno;
	private double balance;
	private static long next_accno=10000;
	private ArrayList<Transaction> trnsaction=new ArrayList<>();
	private double min;
	
   public BankAccount()
   {
       accno = next_accno++;
       balance = 0;
       min=0;
   }

   public long getAccno()
   {
       return accno;
   }
   
   public BankAccount(double initialBalance) 
   {
       accno = next_accno++;
       balance = initialBalance;
       min=initialBalance;
       
   }
   
   public void deposit(double amount)
   {
       double newBalance = balance + amount;
       balance = newBalance;
       Transaction t=new Transaction("Credited", "Ahmedabad", amount, balance);
       trnsaction.add(t);
   }
   
   public void withdraw(double amount)
           throws DailyLimitException, InsuffBalanceException 
   {
       double newBalance = balance - amount;
       if ( amount > 25000 )
       {
           throw new DailyLimitException();
       }
       else if ( amount > balance )
       {
           throw new InsuffBalanceException();
       }
       else
       {
    	   balance = newBalance;
    	   Transaction t=new Transaction("Debiteded", "Ahmedabad", amount, balance);
    	   trnsaction.add(t);
    	   
    	   if(min>balance)
    	   {
    		   min=balance;
    	   }
       }
   }
   
   public double getBalance()
   {
       return balance;
   }
   
   public double payInterest(double rate)
   {
	   double intrest=this.min*rate/100;
	   
	   return intrest;
   }

}

class InsuffBalanceException extends Exception {}

class DailyLimitException extends Exception {}