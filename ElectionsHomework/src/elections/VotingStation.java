package elections;

public class VotingStation extends RoundManager{
	
	protected static int stationId;
	protected Citizen [] voteList;
	protected String address;
	protected int [] results;
	protected final String  DEFAULT_ADDRESS = "Tel Aviv 15";
	
	
	
	public VotingStation() {
		
	}
		
	public VotingStation(String address) {
		
	}
	
	public VotingStation(String address, Citizen [] list) {
		stationId++;
		this.address = address;
		voteList = list;
		
		createStation();
		
	}	

	private void createStation() {
	results = new int [getNumOfParties()];
	}
	

}
