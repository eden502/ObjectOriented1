package elections;


public class VotingStation {

	protected int numOfVotersAdded;
	protected static int counter;
	protected int stationId;
	protected Citizen[] voteList;
	protected String address;
	protected int[] results;
	protected int numOfVotes;
	protected final static String DEFAULT_ADDRESS = "Tel Aviv 15";
	protected boolean corona;
	protected boolean military;

	
	//---------------------C'tors---------------------
	public VotingStation() {
		this(DEFAULT_ADDRESS,50);

	}

	public VotingStation(String address, int listSize) {
		this.address = address;
		this.voteList = new Citizen[listSize];
		stationId=++counter;

	}
	//--------------------Getters/Setters--------------

	public int getStationId() {
		return this.stationId;
	}
	
	public void setNumOfParties(int numOfPartiesAdded) {
		this.results = new int [numOfPartiesAdded];
	}

	public void addCitizen(Citizen citizen) {
		this.voteList[numOfVotersAdded++] = citizen;
		citizen.setVotingStation(stationId);

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
		numOfVotes++;
	}

	public String getStatistics() {
		String s;
		double percentage = 0;
		if(numOfVotersAdded>0) {
		percentage = (double)numOfVotes/numOfVotersAdded*100;
		s ="Vote percentage : "+(int)percentage+"%\n";
		return s;
		}
		else return "Vote percentage : 0%\n";
	}

	public void resetRound() {
		for (int i = 0; i < results.length; i++) {
			results[i]=0;
			numOfVotes = 0;
		}
		
	}

	public boolean setCorona() {
		corona = true;
		return true;
	}

	public boolean setMilitary() {
		military = true;
		return true;
	}

	

		
		
		
		

}
