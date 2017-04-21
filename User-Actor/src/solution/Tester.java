package solution;

public class Tester {
	
	

	public static void main(String[] args) {
		
		/* in this class pass file name and read data from that and display result*/
		Calculation cal=new Calculation("Artist_lists_small.txt");
		
		/*store data */
		cal.storeData();
		
		/*display artist pair*/
		cal.result();
	}

}
