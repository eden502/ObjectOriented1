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
	
	
	public Citizen() {
		this(DEFAULT_ID, DEFAULT_YEAR,)
	}
	
	public Citizen (int id) {
		
	}
	public Citizen (int id, int birthYear) {
		
	}
	public Citizen (int id, int birthYear, String name) {
		
	}
	public Citizen (int id, int birthYear, String name, VotingStation votesWhere) {
		
	}
	public Citizen (int id, int birthYear,String name, VotingStation votesWhere, boolean isInIsolation) {
		setId(id);
		setBirthYear(birthYear);
		setVotingStation(votesWhere);
		this.isInIsolation = isInIsolation;
	}

	private boolean setVotingStation(VotingStation votesWhere) {
		this.votesWhere = votesWhere;
		return true;
		
	}

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

}
