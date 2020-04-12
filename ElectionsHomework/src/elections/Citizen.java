package elections;

public class Citizen {
	
	protected static final int CURRENT_YEAR = 2020;
	protected static final int DEFAULT_YEAR = 1990;
	protected static final int DEFAULT_ID = 123456789;
	protected static final boolean DEFAULT_ISOLATION_STATUS = false;
	//protected static final VotingStation = -------------------- set default voting station
	
	
	protected int id, birthYear;
	protected String name;
	protected VotingStation votesWhere;
	protected boolean isInIsolation;
	
	
	
	public Citizen (int id) {
		
	}
	public Citizen (int id, int birthYear) {
		
	}
	public Citizen (int id, int birthYear, String name) {
		
	}
	public Citizen (int id, int birthYear,String name, boolean isInIsolation) {
		setId(id);
		setBirthYear(birthYear);
		setName(name);
		this.isInIsolation = isInIsolation;
	}

	
	//----------------------------------------------------- CHECK IF WE CAN USE ID INSTEAD-----------------------------------
	
	private void setName(String name) {
		this.name = name;
	}
	public boolean setVotingStation(int numOfVotingStationsAdded, VotingStation[] allVotingStations) {
		
		int rand = 1;//(int)Math.random()*numOfVotingStationsAdded;
		for (int i = 0; i < numOfVotingStationsAdded; i++) {
			if(rand == allVotingStations[i].getStationId()) {
				this.votesWhere = allVotingStations[i];
				allVotingStations[i].addCitizen(this);
				break;
			}
		}
		return true;
		
	}
	//-----------------------------------------------------------------------------------------------------------------------
	private boolean setBirthYear(int birthYear) {
		if (birthYear>1920&&birthYear<CURRENT_YEAR-18) {
			this.birthYear=birthYear;
			return true;
		}
			else {
				return false;
			}
	}

	private boolean setId(int id) {
		//in the future ID will be tested for 9 digits		
		this.id=id;
		return true;
	}
	@Override
	public String toString() {
		return "Citizen [id=" + id + ", birthYear=" + birthYear + ", name=" + name + ", votesWhere=" + votesWhere
				+ ", isInIsolation=" + isInIsolation + "]";
	}

}
