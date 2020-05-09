package id_205518178_id_308065176;

import java.util.Random;

public class Citizen {

	protected static final int CURRENT_YEAR = 2020;
	protected static final int DEFAULT_YEAR = 1990;
	protected static final int DEFAULT_ID = 123456789;
	protected static final int DEFAULT_NUM_OF_VOTING_STATIONS = 1;
	protected static final boolean DEFAULT_ISOLATION_STATUS = false;
	protected static final String DEFAULT_NAME = "CTZN";
	
	protected int id, birthYear, voteStation;
	protected String name;
	protected boolean isInIsolation;
	protected boolean isSoldier;

	// -------------------C'tors---------------------------
	public Citizen(int id) {
		this(id, DEFAULT_YEAR, DEFAULT_NAME, DEFAULT_NUM_OF_VOTING_STATIONS, DEFAULT_ISOLATION_STATUS);
	}

	public Citizen(int id, int birthYear) {
		this(id, birthYear, DEFAULT_NAME, DEFAULT_NUM_OF_VOTING_STATIONS, DEFAULT_ISOLATION_STATUS);
	}

	public Citizen(int id, int birthYear, String name, boolean isInIsolation) {
		this(id, birthYear, name, DEFAULT_NUM_OF_VOTING_STATIONS, isInIsolation);
	}

	public Citizen(int id, int birthYear, String name, int voteStation, boolean isInIsolation) {
		setId(id);
		setBirthYear(birthYear);
		setName(name);
		setStatus();
		this.isInIsolation = isInIsolation;
		setVotingStation(voteStation);

	}
	// ----------------------------------------------------

	// --------------------Getters/Setters-----------------
	private void setName(String name) {
		this.name = name;
	}

	public void setVotingStation(int numOfStations) {
		/*
		 * generates random number between 1 and total number of stations sets Citizen
		 * voting station
		 */
			Random randomGen = new Random();
			int rand = randomGen.nextInt(numOfStations);
			this.voteStation = rand;
	
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

	private boolean setId(int id) {
		// in the future ID will be tested for 9 digits
		this.id = id;
		return true;
	}

	// sets if citizen is soldier
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
		return isVoting.nextBoolean();
	}

	@Override
	public String toString() {
		return "Name: " + name + "\nID: " + id + "\nBirth year: " + birthYear + "\nIsolation status: " + isInIsolation
				+ "\n";
	}

}
