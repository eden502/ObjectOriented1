package elections;

import java.util.Arrays;

public class VotingStation{
	
	protected static int numOfVotersAdded;
	protected int stationId = 1;
	protected Citizen [] voteList;
	protected String address;
	protected int [] results;
	protected final String  DEFAULT_ADDRESS = "Tel Aviv 15";
	
	
	
	public VotingStation() {
		
	}
		
	
	public VotingStation(String address,int listSize) {
		this.address = address;
		this.voteList = new Citizen[listSize];
		
	}	

	public int getStationId() {
		return this.stationId;
	}


	public void addCitizen(Citizen citizen) {
		voteList[numOfVotersAdded++] = citizen;
		
	}


	@Override
	public String toString() {
		return "VotingStation [voteList=" + Arrays.toString(voteList) + ", address=" + address + "]";
	}
	
	
	

}
