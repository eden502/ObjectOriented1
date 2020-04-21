package elections;


public class VotingStation {

	protected int numOfVotersAdded;
	protected static int stationId;
	protected Citizen[] voteList;
	protected String address;
	protected int[] results;
	protected final static String DEFAULT_ADDRESS = "Tel Aviv 15";

	
	//---------------------C'tors---------------------
	public VotingStation() {
		this(DEFAULT_ADDRESS,50);

	}

	public VotingStation(String address, int listSize) {
		this.address = address;
		this.voteList = new Citizen[listSize];
		stationId++;

	}
	//--------------------Getters/Setters--------------

	public int getStationId() {
		return this.stationId;
	}
	
	public void setNumOfParties(int numOfPartiesAdded) {
		this.results = new int [numOfPartiesAdded];
	}

	public void addCitizen(Citizen citizen) {
		voteList[numOfVotersAdded++] = citizen;

	}
	
	public int [] getVotingStationResults() {
		return results;
	}
	//--------------------------------------------------

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("\n----------------------");
		str.append("\nVoting Station ID: " + stationId + "\nAddress: " + address);

		for (int i = 0; i < numOfVotersAdded; i++) {
			str.append("\n" + voteList[i]);

		}
		return "" + str;
	}

	

	public void castVote(int vote) {
		results[vote]++;
	}

	

		
		
		
		

}
