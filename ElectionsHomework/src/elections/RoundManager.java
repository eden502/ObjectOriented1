package elections;

import java.util.Arrays;

public class RoundManager {

	protected Citizen[] allCitizens;
	protected Party[] allParties;
	protected VotingStation[] allVotingStations;
	private int numOfCitizenAdded, numOfPartiesAdded, numOfVotingStationsAdded;

	// ------------------RoundManager C'tor-------------------
	public RoundManager(int totalCitizens, int totalVotingStat, int totalParties, int roundNumber) {
		allCitizens = new Citizen[totalCitizens];
		allParties = new Party[totalParties];
		allVotingStations = new VotingStation[totalVotingStat];
		numOfCitizenAdded = 0;
		numOfPartiesAdded = 0;
	}
	// ------------------CITIZEN RELATED-------------------

	// ----------------------------------------------------

	// -------------------PARTY RELATED--------------------

	public int getNumOfParties() {
		return allParties.length;
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
	public void setCitizenVotingStation() {
		for (int i = 0; i < numOfCitizenAdded; i++) {
			allCitizens[i].setVotingStation(numOfVotingStationsAdded);
			addCitizenToVotingStation(allCitizens[i]);

		}
	}

	private void addCitizenToVotingStation(Citizen c1) {
		allVotingStations[c1.getVotingStation()-1].addCitizen(c1);
	}

	public void addVotingStationList(VotingStation[] allVotingStations) {
		this.allVotingStations = allVotingStations;
		numOfVotingStationsAdded = allVotingStations.length;
	}

	@Override
	public String toString() {
		return "RoundManager [allCitizens=" + Arrays.toString(allCitizens) + ", allParties="
				+ Arrays.toString(allParties) + ", allVotingStations=" + Arrays.toString(allVotingStations)
				+ ", numOfCitizenAdded=" + numOfCitizenAdded + ", numOfPartiesAdded=" + numOfPartiesAdded
				+ ", numOfVotingStationsAdded=" + numOfVotingStationsAdded + "]";
	}

}
