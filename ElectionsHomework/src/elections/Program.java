package elections;

import java.util.Scanner;

public class Program {
	
	public static void main(String[] args) {
		
		
		//-----------HARD CODED OBJECTS------------------
		int numOfCitizens = 50;
		RoundManager round1 = new RoundManager(numOfCitizens, 2, 2, 1);
		
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
//		
//		int choice = scan.nextInt();
//		
//		do {
//			switch(choice) {
//			case 1:
//				System.out.println("Add voting station");
//				break;
//			case 2:
//				System.out.println("Add citizen");
//				break;
//			case 3:
//				System.out.println("Add party");
//				break;
//			case 4:
//				System.out.println("Add party candidate");
//				break;
//			case 5:
//				System.out.println("Show all voting stations");
//				break;
//			case 6:
//				System.out.println("Show all citizens");
//				break;
//			case 7:
//				System.out.println("Show all parties");
//				break;
//			case 8:
//				System.out.println("Check if wants to vote");
//				break;
//			case 9:
//				System.out.println("Show results");
//				break;
//			case 10:
//				System.out.println("Exit");
//				break;
//			}
//		}while(choice!=10);
	}
}

