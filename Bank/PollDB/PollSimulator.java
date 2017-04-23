package Lab05;

import java.util.Random;
import java.util.Scanner;

public class PollSimulator
{
	public static void main(String[] args) 
	{
		
		Scanner sc=new Scanner(System.in);
		 String[] candNames = new String[5];
		 candNames[0] = "Deep Goyal";
		 candNames[1] = "Sneha Mohan";
		 candNames[2] = "Praveen Shah";
		 candNames[3] = "Akshay Singh";
		 candNames[4] = "Somin Majumdar";
		 PollDB poll_db = new PollDB( candNames );
		 int nc = poll_db.getNumberOfCandidates();
		 System.out.println("How many vote you want to enter");
		 int n=sc.nextInt();
		 int str=1;
		 
		 while(str<=n)
		 {
			 System.out.println("Give vote............."
			 		+ "\n[1] Deep Goyal"
			 		+ "\n[2] Sneha Mohan"
			 		+ "\n[3] Praveen Shah"
			 		+ "\n[4] Akshay Singh"
			 		+ "\n[5] Somin Majumdar");
			 
			 int vote=sc.nextInt();
			 poll_db.voteTo( vote-1 ); 
			 str++;
		 }
		
		
		 
		 for(int i = 0; i < poll_db.getNumberOfCandidates(); i++ )
		 {
			 System.out.println(poll_db.getCandidateName(i)
					 + ": " + poll_db.votesCount(i));
		 }
		 
		 int cnt=0;
		 sc.nextLine();
		 while(cnt<3)
		 {
			 System.out.println("Enter Password..");
			 String pass=sc.nextLine().trim();
			 
			 if(pass.equals("Hardik"))
			 {
				 System.out.println("Winner: " + poll_db.getWinner());
				 break;
			 }
			 cnt++;
			 
			 if(cnt==3)
			 {
				 System.out.println("You enter password wrong 3 times");
				 break;
			 }
		 }
		 
	}

}
