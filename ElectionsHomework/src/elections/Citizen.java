package elections;

import java.util.Random;

public class Citizen {

	protected static final int CURRENT_YEAR = 2020;
	protected static final int DEFAULT_YEAR = 1990;
	protected static final int DEFAULT_ID = 123456789;
	protected static final boolean DEFAULT_ISOLATION_STATUS = false;
	// protected static final VotingStation = -------------------- set default
	// voting station

	protected int id, birthYear, voteStation;
	protected String name;
	protected VotingStation votesWhere;
	protected boolean isInIsolation;

	
	
	//-------------------C'tors---------------------------
	public Citizen(int id) {

	}

	public Citizen(int id, int birthYear) {

	}

	public Citizen(int id, int birthYear, String name, boolean isInIsolation) {
		this(id, birthYear, name, 1, isInIsolation);
	}

	public Citizen(int id, int birthYear, String name, int voteStation, boolean isInIsolation) {
		setId(id);
		setBirthYear(birthYear);
		setName(name);
		setVotingStation(voteStation);
		this.isInIsolation = isInIsolation;
	}
	//----------------------------------------------------
	
	//--------------------Getters/Setters-----------------
	private void setName(String name) {
		this.name = name;
	}
	public void setVotingStation(int numOfStations) {
		/*
		 * generates random number between 1 and total number of stations sets Citizen
		 * voting station
		 */
		Random randomGen = new Random();
		int rand = randomGen.nextInt(numOfStations) + 1;

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
	
	// ----------------------------------------------------- CHECK IF WE CAN USE ID
	// INSTEAD-----------------------------------
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
