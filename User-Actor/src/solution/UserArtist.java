package solution;

import java.util.ArrayList;

public class UserArtist {
	
	//ArtistName is used to store artist name
	String artistName;
	
	//this array list store user which like this artist 
	ArrayList<Integer> userNo;
	
	public UserArtist(String artistName,int userId) {
		userNo=new ArrayList<>();
		
		this.artistName=artistName;
		this.userNo.add(userId);
	}
}
