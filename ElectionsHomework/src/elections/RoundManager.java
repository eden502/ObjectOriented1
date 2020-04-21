package elections;

import java.util.Arrays;
import java.util.Random;

public class RoundManager {

	protected Citizen[] allCitizens;
	protected Party[] allParties;
	protected VotingStation[] allVotingStations;
	private int numOfCitizenAdded, numOfPartiesAdded, numOfVotingStationsAdded;
	private String month;
	private int day, year;

	// ------------------RoundManager C'tor-------------------
	public RoundManager(int totalCitizens, int totalVotingStat, int totalParties, int roundNumber, int day,
			String month, int year) {
		allCitizens = new Citizen[totalCitizens];
		allParties = new Party[totalParties];
		allVotingStations = new VotingStation[totalVotingStat];
		numOfCitizenAdded = 0;
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
	public void setCitizenVotingStation() {
		for (int i = 0; i < numOfCitizenAdded; i++) {
			allCitizens[i].setVotingStation(numOfVotingStationsAdded);
			addCitizenToVotingStation(allCitizens[i]);

		}
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
		for (int i = 0; i < numOfCitizenAdded; i++) {
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

	public void addCitizensList(Citizen[] allCitizens2) {
		this.allCitizens = allCitizens2;
		numOfCitizenAdded = allCitizens2.length;
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
		allVotingStations[c1.getVotingStation() - 1].addCitizen(c1);
	}

	public void addVotingStationList(VotingStation[] allVotingStations) {
		this.allVotingStations = allVotingStations;
		numOfVotingStationsAdded = allVotingStations.length;
	}



	public void addNewVotingStation(String address, int listSize) {
		if (numOfVotingStationsAdded < allVotingStations.length) {
			allVotingStations[numOfVotingStationsAdded] = new VotingStation(address, listSize);
			numOfVotingStationsAdded++;
		}

	}


	public void startVote() {
		for (int i = 0; i < allCitizens.length; i++) {
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
		for (int i = 0; i < allVotingStations.length; i++) {
			allVotingStations[i].getVotingStationResults();
			str.append("Voting Station " + allVotingStations[i].getStationId() + ":\n");
			for (int j = 0; j < allParties.length; j++) {
				str.append(allParties[j].getPartyName() + ":" + allVotingStations[i].results[j] + " votes\n");
			}
		}

		return str + "" + showFinalResults();
	}

	private StringBuffer showFinalResults() {
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < allVotingStations.length; i++) {
			for (int j = 0; j < allParties.length; j++) {
				allParties[j].setTotalVotes(allVotingStations[i].results[j]);
			}
		}
		for (int i = 0; i < allParties.length; i++) {
			str.append(allParties[i].getPartyName() + " total votes are: " + allParties[i].getTotalVotes() + "\n");
		}
		return str;
	}
	
	@Override
	public String toString() {
		return "RoundManager [allCitizens=" + Arrays.toString(allCitizens) + ", allParties="
				+ Arrays.toString(allParties) + ", allVotingStations=" + Arrays.toString(allVotingStations)
				+ ", numOfCitizenAdded=" + numOfCitizenAdded + ", numOfPartiesAdded=" + numOfPartiesAdded
				+ ", numOfVotingStationsAdded=" + numOfVotingStationsAdded + "]";
	}



}
