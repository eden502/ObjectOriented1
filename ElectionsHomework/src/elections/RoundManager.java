package elections;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

import elections.Party.Wing;

public class RoundManager {

	protected Citizen[] allCitizens;
	protected Party[] allParties;
	protected VotingStation[] allVotingStations;
	//protected CoronaVotingStation[] allCoronaVotingStations;
//	protected MilitaryVotingStation[] allMilitaryVotingStation;
	private int numOfCitizensAdded, numOfPartiesAdded, numOfVotingStationsAdded;
	private int numOfCoronaStations,numOfMilitaryStations;
	private String month;
	private int day, year;

	// ------------------RoundManager C'tor-------------------
	public RoundManager(int totalCitizens, int totalVotingStat, int totalParties, int roundNumber, int day,
			String month, int year) {
		allCitizens = new Citizen[totalCitizens];
		allParties = new Party[totalParties];
		allVotingStations = new VotingStation[totalVotingStat];
		//allCoronaVotingStations = new CoronaVotingStation[1];
	//	allMilitaryVotingStation = new MilitaryVotingStation[1];
		numOfCitizensAdded = 0;
		numOfPartiesAdded = 0;
		this.day = day;
		this.month = month;
		this.year = year;
	}
	// ------------------CITIZEN RELATED-------------------

	// ----------------------------------------------------

	// -------------------Getters/Setters--------------------

	public int getNumOfParties() {
		return allParties.length;
	}

	public int getYear() {
		return this.year;
	}

	public void setCitizenVotingStation(Citizen c1) {
		c1.setVotingStation(numOfVotingStationsAdded);
		// addCitizensList(c1);
		this.allVotingStations[c1.voteStation - 1].addCitizen(c1);
//		for (int i = 0; i < numOfCitizensAdded; i++) {
//			allCitizens[i].setVotingStation(numOfVotingStationsAdded);
//			addCitizenToVotingStation(allCitizens[i]);

		// }
	}

	public String getVotingStations() {
		StringBuffer str = new StringBuffer();
		str.append("Showing all voting stations: \n");
		for (int i = 0; i < numOfVotingStationsAdded; i++) {
			str.append(allVotingStations[i].toString());
		}
		return "" + str;
	}

	public StringBuffer getAllCitizens() {
		StringBuffer ctzn = new StringBuffer();
		ctzn.append("List of all citizens: \n");
		for (int i = 0; i < numOfCitizensAdded; i++) {
			ctzn.append("------------------------\n");
			ctzn.append(allCitizens[i].toString());
		}
		return ctzn;
	}

	public StringBuffer showAllParties() {
		StringBuffer pty = new StringBuffer();
		pty.append("Registered Parties:\n");
		for (int i = 0; i < numOfPartiesAdded; i++) {
			pty.append("-----------------------------\n");
			pty.append(allParties[i].toString());
			pty.append("-----------------------------\n");
		}

		return pty;
	}

	public boolean setParties(Party[] allParties) {
		this.allParties = allParties;
		numOfPartiesAdded = allParties.length;
		for (int i = 0; i < allVotingStations.length; i++) {
			allVotingStations[i].setNumOfParties(numOfPartiesAdded);
		}
		return true;
	}
//
//	public boolean createCitizens(Citizen citizen_new) {
//		allCitizens[numOfCitizenAdded++] = citizen_new;
//			
//		}
//		
//		for (int i = 0; i < allCitizens.length; i++) {
//			allCitizens[i].id = id++;
//			allCitizens[i].birthYear=2002;
//			allCitizens[i].name = names[i]; 
//			allCitizens[i].isInIsolation = false;
//		}
//	}
//	
//	public boolean createVotingStations() {
//		return false;
//	}

	public void addCitizensList(Citizen c1) {
		// this.allCitizens = allCitizens2;
		// numOfCitizensAdded = allCitizens2.length;
		this.allCitizens[numOfCitizensAdded] = c1;
		numOfCitizensAdded++;
	}

//----------------------Old set voting station-------------------------
//	public void setCitizenVotingStation() {
//		for (int i = 0; i < numOfCitizenAdded; i++) {
//			allCitizens[i].setVotingStation(numOfVotingStationsAdded, allVotingStations);
//			
//		}
//	}
//---------------------------------------------------------------------

	private void addCitizenToVotingStation(Citizen c1) {
		if(!c1.isInIsolation&&!c1.isSoldier) {
		allVotingStations[c1.getVotingStation() - 1].addCitizen(c1);
		}
		if(c1.isInIsolation) {
			for (int i = 0; i <numOfVotingStationsAdded; i++) {
				if(allVotingStations[i].corona) {
					allVotingStations[i].addCitizen(c1);
					break;
				}
			}
		}
		if(c1.isSoldier) {
			for (int i = 0; i <numOfVotingStationsAdded; i++) {
				if(allVotingStations[i].military) {
					allVotingStations[i].addCitizen(c1);
					break;
				}
			}
		}
	}

	public void addVotingStationList(VotingStation[] allVotingStations) {
		this.allVotingStations = allVotingStations;
		numOfVotingStationsAdded = allVotingStations.length;
	}

//-------------------Add Voting Stations------------------------------
	public void addNewVotingStation(String address, int listSize, int type) {
		if (numOfVotingStationsAdded < allVotingStations.length) {
			switch (type) {
			case 1:// regular voting station
				allVotingStations[numOfVotingStationsAdded] = new VotingStation(address, listSize);
				allVotingStations[numOfVotingStationsAdded].setNumOfParties(numOfPartiesAdded);
				numOfVotingStationsAdded++;
				updateStationLists();
				break;
			case 2:// corona voting station
				allVotingStations[numOfVotingStationsAdded] = new CoronaVotingStation(address, listSize);
				allVotingStations[numOfVotingStationsAdded].setNumOfParties(numOfPartiesAdded);
				allVotingStations[numOfVotingStationsAdded].setCorona();
				numOfVotingStationsAdded++;
				numOfCoronaStations++;
				updateStationLists();
				break;

			case 3:// military voting station
				allVotingStations[numOfVotingStationsAdded] = new MilitaryVotingStation(address, listSize);
				allVotingStations[numOfVotingStationsAdded].setNumOfParties(numOfPartiesAdded);
				allVotingStations[numOfVotingStationsAdded].setMilitary();
				numOfVotingStationsAdded++;
				numOfMilitaryStations++;
				updateStationLists();
				break;
			}
		}

		else {
			int newLength = this.allVotingStations.length * 2;
			Object t = new Object[newLength];
			t = fullArray(this.allVotingStations);
			this.allVotingStations = new VotingStation[newLength];
			System.arraycopy(t, 0, this.allVotingStations, 0, newLength);
			addNewVotingStation(address, listSize, type);
		}

	}

	private void updateStationLists() {
		for (int i = 0; i < numOfCitizensAdded; i++) {

		}
	}

	private Object[] fullArray(Object[] obj) {
		Object[] temp = new Object[obj.length * 2];
		System.arraycopy(obj, 0, temp, 0, obj.length);
		// this.allVotingStations = new VotingStation[temp.length];
		// System.arraycopy(temp, 0, this.allVotingStations, 0, temp.length);
		return temp;
	}

	// --------------------------Add Citizen---------------------------
	public void addNewCitizen(int id, int birthYear, String name, boolean isInIsolation, int stationType) {

		if (numOfCitizensAdded < allCitizens.length) {
			allCitizens[numOfCitizensAdded] = new Citizen(id, birthYear, name, numOfVotingStationsAdded,
					isInIsolation);
			addCitizenToVotingStation(allCitizens[numOfCitizensAdded]);
			numOfCitizensAdded++;
//			switch (stationType) {
//			case 1:// regular voting station
//				allCitizens[numOfCitizensAdded] = new Citizen(id, birthYear, name, numOfVotingStationsAdded,
//						isInIsolation);
//				addCitizenToVotingStation(allCitizens[numOfCitizensAdded]);
//				numOfCitizensAdded++;
//				break;
//			case 2:// corona voting station
//				allCitizens[numOfCitizensAdded] = new Citizen(id, birthYear, name, numOfVotingStationsAdded,
//						isInIsolation);
//				addCitizenToVotingStation(allCitizens[numOfCitizensAdded]);
//				numOfCitizensAdded++;
//				break;
//			case 3:// military voting station
//				allCitizens[numOfCitizensAdded] = new Citizen(id, birthYear, name, numOfVotingStationsAdded,
//						isInIsolation);
//				addCitizenToVotingStation(allCitizens[numOfCitizensAdded]);
//				numOfCitizensAdded++;
//				break;
//
//			case 4: // military corona voting station
//
//				break;
//			}
		} else {
			int newLength = this.allCitizens.length * 2;
			Object t = new Object[newLength];
			t = fullArray(this.allCitizens);
			this.allCitizens = new Citizen[newLength];
			System.arraycopy(t, 0, this.allCitizens, 0, newLength);
			addNewCitizen(id, birthYear, name, isInIsolation, stationType);
		}

	}

	public void addNewCandidate(int id, int birthYear, String name, boolean isInIsolation, Party memberOf,
			int stationType) {
		if (numOfCitizensAdded < allCitizens.length) {
			switch (stationType) {
			case 1:// regular voting station
				allCitizens[numOfCitizensAdded] = new PartyMember(id, birthYear, name, numOfVotingStationsAdded,
						isInIsolation, memberOf);
				addCitizenToVotingStation(allCitizens[numOfCitizensAdded]);
				memberOf.addMemberToParty((PartyMember) allCitizens[numOfCitizensAdded]);
				numOfCitizensAdded++;
				break;
			case 2:// corona voting station

				break;
			}
		} else {
			int newLength = this.allCitizens.length * 2;
			Object t = new Object[newLength];
			t = fullArray(this.allCitizens);
			this.allCitizens = new Citizen[newLength];
			System.arraycopy(t, 0, this.allCitizens, 0, newLength);
			addNewCitizen(id, birthYear, name, isInIsolation, stationType);
		}

	}

	// ----------------------------------------------------------------
	// --------------------------Add Party---------------------------
	public void addNewParty(String partyName, LocalDate dateCreated, Wing wing) {
		if (numOfPartiesAdded < allParties.length) {
			allParties[numOfPartiesAdded] = new Party(partyName, dateCreated, wing);
			numOfPartiesAdded++;
			for (int i = 0; i < numOfVotingStationsAdded; i++) {
				allVotingStations[i].setNumOfParties(numOfPartiesAdded);
			}
		} else {
			int newLength = this.allParties.length * 2;
			Object t = new Object[newLength];
			t = fullArray(this.allParties);
			this.allParties = new Party[newLength];
			System.arraycopy(t, 0, this.allParties, 0, newLength);
			addNewParty(partyName, dateCreated, wing);
		}

	}

	// ----------------------------------------------------------------

//---------------------------------------------------------------------	
	public void startVote() {
		resetRound();
		for (int i = 0; i < numOfCitizensAdded; i++) {
			if (allCitizens[i].vote()) {
				Random randomGen = new Random();
				int rand = randomGen.nextInt(numOfPartiesAdded);
				allVotingStations[allCitizens[i].getVotingStation() - 1].castVote(rand);
				// allVotingStations[allCitizens[i].voteStation].castVote(rand);
			}
		}
	}

	public String results() {

		StringBuffer str = new StringBuffer();
		str.append("Final results are:\n");
		for (int i = 0; i < numOfVotingStationsAdded; i++) {
			str.append("--------------------------------\n");
			// allVotingStations[i].getVotingStationResults();
			str.append("Voting Station " + allVotingStations[i].getStationId() + ":\n");
			str.append(allVotingStations[i].getStatistics());
			for (int j = 0; j < numOfPartiesAdded; j++) {
				str.append(allParties[j].getPartyName() + ":" + allVotingStations[i].results[j] + " votes\n");
			}
		}
		str.append("--------------------------------\n");
		return str + "" + showFinalResults();
	}

	private void resetRound() {
		for (int i = 0; i < numOfVotingStationsAdded; i++) {
			for (int j = 0; j < numOfPartiesAdded; j++) {
				allVotingStations[i].resetRound();// add interface
				allParties[j].resetRound();
			}
		}
	}

	private StringBuffer showFinalResults() {
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < numOfVotingStationsAdded; i++) {
			for (int j = 0; j < numOfPartiesAdded; j++) {
				allParties[j].setTotalVotes(allVotingStations[i].results[j]);
			}
		}
		for (int i = 0; i < numOfPartiesAdded; i++) {
			str.append(allParties[i].getPartyName() + " total votes are: " + allParties[i].getTotalVotes() + "\n");
		}
		return str;
	}

	@Override
	public String toString() {
		return "RoundManager [allCitizens=" + Arrays.toString(allCitizens) + ", allParties="
				+ Arrays.toString(allParties) + ", allVotingStations=" + Arrays.toString(allVotingStations)
				+ ", numOfCitizenAdded=" + numOfCitizensAdded + ", numOfPartiesAdded=" + numOfPartiesAdded
				+ ", numOfVotingStationsAdded=" + numOfVotingStationsAdded + "]";
	}

}
