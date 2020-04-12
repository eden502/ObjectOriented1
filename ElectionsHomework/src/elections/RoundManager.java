package elections;


public class RoundManager {
	
	protected Citizen[] allCitizens;
	protected Party [] allParties;
	protected VotingStation [] allVotingStations;
	protected String [] cities;
	
	
	//------------------CITIZEN RELATED-------------------
	
	Citizen [] allCitizens = new Citizen [20];
	String [] names = new String [20];
	
	//----------------------------------------------------
	
	//-------------------PARTY RELATED--------------------
	
	Party [] allParties = new Party [4];
	
	public int getNumOfParties() {
		return allParties.length;
	}
	


	public boolean createCitizens() {
		int id, birthYear;
		String name = "A";
		for (int i = 0; i < names.length; i++) {
			names[i] = name;
			name+="A";
			
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
