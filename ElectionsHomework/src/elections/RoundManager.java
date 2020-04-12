package elections;


public class RoundManager {
	
	protected Citizen[] allCitizens;
	protected Party [] allParties;
	protected VotingStation [] allVotingStations;
	private int numOfCitizenAdded, numOfPartiesAdded;
	
	//------------------RoundManager C'tor-------------------
	public RoundManager(int totalCitizens, int totalVotingStat, int totalParties, int roundNumber) {
		allCitizens = new Citizen[totalCitizens];
		allParties = new Party[totalParties];
		allVotingStations = new VotingStation[totalVotingStat];
		numOfCitizenAdded = 0;
		numOfPartiesAdded = 0;
	}
	//------------------CITIZEN RELATED-------------------
	
	Citizen [] allCitizens = new Citizen [20];
	String [] names = new String [20];
	
	//----------------------------------------------------
	
	//-------------------PARTY RELATED--------------------
	
	Party [] allParties = new Party [4];
	
	public int getNumOfParties() {
		return allParties.length;
	}
	


	public boolean createCitizens(Citizen citizen_new) {
		allCitizens[numOfCitizenAdded++] = citizen_new;
			
		}
		
		for (int i = 0; i < allCitizens.length; i++) {
			allCitizens[i].id = id++;
			allCitizens[i].birthYear=2002;
			allCitizens[i].name = names[i]; 
			allCitizens[i].isInIsolation = false;
		}
	}
	
	public boolean createVotingStations() {
		return false;
	}

}
