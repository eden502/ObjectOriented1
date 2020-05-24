package id_205518178_id_308065176;

import java.util.Random;

public class Citizen {

	protected static final int CURRENT_YEAR = 2020;
	protected static final int DEFAULT_YEAR = 1990;
	protected static final int DEFAULT_ID = 123456789;
	protected static final int DEFAULT_NUM_OF_VOTING_STATIONS = 1;
	protected static final String DEFAULT_NAME = "CTZN";
	
	protected int id, birthYear, voteStation;
	protected String name;
	protected boolean isSoldier;
	protected boolean didVote;
	// -------------------C'tors---------------------------
	public Citizen(int id) throws Exception {
		this(id, DEFAULT_YEAR, DEFAULT_NAME);
	}

	public Citizen(int id, int birthYear) throws Exception {
		this(id, birthYear,DEFAULT_NAME);
	}

//	public Citizen(int id, int birthYear, String name) throws Exception {
//		this(id, birthYear, name);
//	}

	public Citizen(int id, int birthYear, String name) throws Exception {
		try {
			setId(id);
		} catch (Exception e) {
			System.out.println(e.toString());
			setId(123456789);
		}
		setBirthYear(birthYear);
		setName(name);
		setStatus();
		

	}
	// ----------------------------------------------------

	// --------------------Getters/Setters-----------------
	private void setName(String name) {
		this.name = name;
	}

	public void setVotingStation(int stationId) {
			this.voteStation = stationId;
	}

	public int getVotingStation() {
		return voteStation;
	}

	private boolean setBirthYear(int birthYear) {
		if (birthYear > 1920 && birthYear < CURRENT_YEAR - 18) {
			this.birthYear = birthYear;
			return true;
		} else {
			return false;
		}
	}

	private boolean setId(int id)  throws Exception{
			if (id>100000000) {//more than 9 digits
				this.id = id;
				return true;
			}
			throw new Exception("Invalid citizen ID");
	}

	// sets if citizen is soldier------------------>>>>>>>>>>>>>>>>>add exception for soldiers
	private void setStatus() {
		if (CURRENT_YEAR - birthYear >= 18 && CURRENT_YEAR - birthYear <= 21) {
			this.isSoldier = true;
		}
	}

	// -----------------------------------------------------------------
	public boolean vote() {
		/*
		 * randomise boolean value to determine if citizen is voting
		 */
		Random isVoting = new Random();
		return didVote=isVoting.nextBoolean();
		
	}

	@Override
	public String toString() {
		return "Name: " + name + "\nID: " + id + "\nBirth year: " + birthYear
				+ "\nDid vote: "+didVote+"\n";
	}

}
