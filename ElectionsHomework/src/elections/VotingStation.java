package elections;

import java.util.Arrays;

public class VotingStation{
	
	protected static int numOfVotersAdded;
	protected static int stationIdCounter = 1;
	protected int stationId;
	protected Citizen [] voteList;
	protected String address;
	protected int [] results;
	protected final String  DEFAULT_ADDRESS = "Tel Aviv 15";
	
	
	
	public VotingStation() {
		
	}
		
	
	public VotingStation(String address,int listSize) {
		this.address = address;
		this.voteList = new Citizen[listSize];
		this.stationId = stationIdCounter++;
	}	

	public int getStationId() {
		return this.stationId;
	}


	public void addCitizen(Citizen citizen) {
		voteList[numOfVotersAdded++] = citizen;
		
	}


	@Override
	public String toString() {
		return "\nVotingStation [voteList=" + Arrays.toString(voteList) + ", address=" + address + "]";
	}
	
	
	

}
