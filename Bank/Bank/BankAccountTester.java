package Q2;

public class BankAccountTester {

    public static void main(String[] args) 
    {
    	
        Bank bank = new Bank(2.2,"SBI");
        long ac=bank.openNewAccount(5000);
        bank.deposite(ac, 5000);
        try {
        	
            bank.withdraw(ac,500);
        }
        catch( InsuffBalanceException e ) {
            System.out.println( "Insufficient balance");
            System.out.println( e.getMessage() );
       }
        catch( DailyLimitException e ) {
            System.out.println( "Daily Limits Exceeded: " + e.getMessage() );
       }
        catch( Exception e ) {
            System.out.println( "Something else went wrong: " + e.getMessage() );
       }
        finally {
            System.out.println( "This is always executed");
        }

        System.out.println(bank.getBalance(ac));

    }

}
