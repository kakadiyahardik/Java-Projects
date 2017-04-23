package Lab05;

public class PollDB
{
	private String []candidate;
	private int[] vote;
	
	PollDB(String []cand)
	{
		this.candidate=cand;
		vote=new int[candidate.length];
	}

	public int getNumberOfCandidates()
	{
		return this.candidate.length;
	}
	
	public void voteTo(int c)
	{
		vote[c]+=1;
	}
	
	public String getCandidateName(int c)
	{
		return candidate[c];
	}
	
	public int votesCount(int c)
	{
		return vote[c];
	}
	
	public String getWinner()
	{
		int max=0;
		for(int i=0;i<getNumberOfCandidates();i++)
		{
			if(vote[i]>vote[max])
			{
				max=i;
			}
		}
		return candidate[max];
	}
}
