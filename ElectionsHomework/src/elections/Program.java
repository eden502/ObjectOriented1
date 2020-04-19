package elections;

import java.util.Scanner;

public class Program {
	
	public static void main(String[] args) {
		
		
		//-----------HARD CODED OBJECTS------------------
		int numOfCitizens = 50;
		RoundManager round1 = new RoundManager(numOfCitizens, 2, 2, 1,30,"April");
		
		VotingStation [] allVotingStations = new VotingStation [2];
		allVotingStations[0] = new VotingStation("Tel Aviv 15",50);
		allVotingStations[1] = new VotingStation("Rosh Pina 46",50);	
		
		Citizen [] allCitizens = new Citizen [5];
		allCitizens[4] = new Citizen(555555555, 1989, "Hob", false);
		allCitizens[1] = new Citizen(111111111, 1990, "Bob", false);
		allCitizens[2] = new Citizen(222222222, 1991, "Rob", false);
		allCitizens[3] = new Citizen(333333333, 1992, "Kob", false);
		allCitizens[0] = new Citizen(444444444, 1993, "Sob", false);
		
		round1.addCitizensList(allCitizens);
		round1.addVotingStationList(allVotingStations);
		round1.setCitizenVotingStation();
			
		
			
		
		//
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println(round1.toString());
		
		int choice = scan.nextInt();
		
		do {
			switch(choice) {
			case 1:
				System.out.println("Add voting station");
			//	round1.addNewVotingStation();
				break;
			case 2:
				System.out.println("Add citizen");
			//	round1.addNewCitizen();
				break;
			case 3:
				System.out.println("Add party");
				//round1.addNewParty();
				break;
			case 4:
				System.out.println("Add party candidate");
				//round1.addNewCandidate();
				break;
			case 5:
				System.out.println("Show all voting stations");
			//	System.out.println(round1.getVotingStations());
				break;
			case 6:
				System.out.println("Show all citizens");
				//System.out.println(round1.getAllCitizens());
				break;
			case 7:
				System.out.println("Show all parties");
				//System.out.println(round1.getAllParties());
				break;
			case 8:
				System.out.println("Check if wants to vote");
				break;
			case 9:
				System.out.println("Show results");
				break;
			case 10:
				System.out.println("Exit");
				break;
			}
		}while(choice!=10);
	}
}

