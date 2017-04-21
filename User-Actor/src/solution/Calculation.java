package solution;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Calculation {
	
	private final int limit=50;
	private BufferedReader br;
	
	/*artist hashmap store artist name as key and UserArtist class as value UserArtist class
	 * contains artist name and detail of user who like Artist set as key 
	 * */
	private HashMap<String,UserArtist> artist;
	
	/* gretterThanLimit  ArrayList store detail of Artist who at least favorite of 50 user  */
	private ArrayList<UserArtist> gretterThanLimit;
	
	private String file;
	
	public Calculation(String file){
		artist=new HashMap<>();
		gretterThanLimit=new ArrayList<>();
		this.file=file;
	}
	
	/* this method read detail from file and store in to hashmap*/
	public void storeData(){
		
		
		try {
			br=new BufferedReader(new FileReader(file));
				
			String line=new String();
			int userId=0;
			
			/* read line from file until end of file
			 * take N*M time where n= number of line and M can not exceed 50 (each line up to 50 artists)
			 * */
			while((line=br.readLine())!=null){
				
				/* separate line by comma and store in to array*/
				String temp[]=line.split(",");
				
				/* read one by one artist from array*/
				for(int i=0;i<temp.length;i++){
					
					/* if artist already contains in hashmap then add user(line number)*/
					if(artist.containsKey(temp[i])){
						
						UserArtist user=artist.get(temp[i]);
						
						user.userNo.add(userId);
						
						/* if artist is favorite of at lest 50 user then he/she add in to array list*/
						if(user.userNo.size()==limit){
							gretterThanLimit.add(user);
						}
					}
					else{
						
						artist.put(temp[i], new UserArtist(temp[i], userId));
					}
				}
				
				userId++;
			}
			
		}catch (IOException  |NullPointerException e) {
					System.out.println(e+" at collect data");
		}
	}
	
	/* this method display two pair of artist that together favorite of at least  50 user*/
	public void result(){
		
		int size=gretterThanLimit.size();
		
		for(int i=0;i<size-1;i++){ /* 1 -> this loop take time O(A) A=number of artist who favorite of at least 50 user*/
			for(int j=i+1;j<size;j++){/* 2 ->  this loop take time O(A) A=number of artist who favorite of at least 50 user*/
				
				int cnt=0,ini=0,inj=0;
				
				int sizei=gretterThanLimit.get(i).userNo.size();
				int sizej=gretterThanLimit.get(j).userNo.size();
				
				/* check how many user like pair of two artist ,
				 * this loop not exceed 50 && max(size of list of user of iTH artist,size of list of user of jTH artist)
				 * (cnt+sizei-ini > limit) && (cnt+sizej-inj > limit) -> this is for optimization 
				 *  
				 *  3 -> this loop take time O(m)  where m=max(size of list of user of iTH artist , size of list of user of jTH artist) or  50(Limit)
				 */
				while(cnt<limit && ini<sizei && inj<sizej  && (cnt+sizei-ini > limit) && (cnt+sizej-inj > limit)){
					
					int valuei=gretterThanLimit.get(i).userNo.get(ini);
					int valuej=gretterThanLimit.get(i).userNo.get(inj);
					
					if(valuei>valuej){
						valuej++;
					}
					else if(valuei<valuej){
						valuei++;
					}
					else{
						valuei++;
						valuej++;
						cnt++;
					}
				}
				
				/* display pair of artist who fond in at least 50 user favorite list*/
				if(cnt>=limit){
					System.out.println(gretterThanLimit.get(i).artistName+","+gretterThanLimit.get(j).artistName);
				}
			}
			
			/*
			 * so final time complexity is  O(A*A*M)  from above 1,2,3
			 * 
			 */
		}
	}
}
