package elections;
import java.util.Random;

public class Citizen {
	
	protected static final int CURRENT_YEAR = 2020;
	protected static final int DEFAULT_YEAR = 1990;
	protected static final int DEFAULT_ID = 123456789;
	protected static final boolean DEFAULT_ISOLATION_STATUS = false;
	//protected static final VotingStation = -------------------- set default voting station
	
	
	protected int id, birthYear,voteStation;
	protected String name;
	protected VotingStation votesWhere;
	protected boolean isInIsolation;
	
	
	
	public Citizen (int id) {
		
	}
	public Citizen (int id, int birthYear) {
		
	}
	public Citizen (int id, int birthYear, String name,boolean isInIsolation) {
		this(id,birthYear,name,1,isInIsolation);
	}
	public Citizen (int id, int birthYear,String name,int voteStation, boolean isInIsolation) {
		setId(id);
		setBirthYear(birthYear);
		setName(name);
		setVotingStation(voteStation);
		this.isInIsolation = isInIsolation;
	}

	

	
	
	private void setName(String name) {
		this.name = name;
	}
	//----------------------------------------------------- CHECK IF WE CAN USE ID INSTEAD-----------------------------------
//	public boolean setVotingStation(int numOfVotingStationsAdded, VotingStation[] allVotingStations) {
//		
//		int rand = 1;//(int)Math.random()*numOfVotingStationsAdded;
//		for (int i = 0; i < numOfVotingStationsAdded; i++) {
//			if(rand == allVotingStations[i].getStationId()) {
//				this.votesWhere = allVotingStations[i];
//				allVotingStations[i].addCitizen(this);
//				break;
//			}
//		}
//		return true;
//		
//	}
	//-----------------------------------------------------------------------------------------------------------------------
	
	
	//------------------------------------------------------SET VOTING STATION WITH ID---------------------------------------
	public void setVotingStation(int numOfStations) {
		
		Random randomGen = new Random();
		int rand = randomGen.nextInt(numOfStations)+1;
		
		this.voteStation = rand;
	}
	/*
	 * generates random number between 1 and total number of stations
	 * sets Citizen voting station
	 */
		public int getVotingStation() {
		return voteStation;
	}
	
	public void setVotesWhere(VotingStation votesWhere) {
		this.votesWhere = votesWhere;
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
