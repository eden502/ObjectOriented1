package id_205518178_id_308065176;

//Eden Harel ID:205518178
//Dorel Saig ID:308065176


import java.time.LocalDate;
import java.util.Scanner;

import id_205518178_id_308065176.Party.Wing;

public class Program {

	public static void main(String[] args) {

		// -----------HARD CODED OBJECTS------------------
		RoundManager round1 = new RoundManager(1, 2, 2017);

		VotingStation[] allVotingStations = new VotingStation[2];
		allVotingStations[0] = new VotingStation("Tel Aviv 15");
		allVotingStations[1] = new VotingStation("Rosh Pina 46");

		Party[] allParties = new Party[3];
		LocalDate likud = LocalDate.of(1988, 4, 25);
		LocalDate meretz = LocalDate.of(2002, 6, 14); 
		LocalDate KL = LocalDate.of(2017, 5, 12);
		allParties[0] = new Party("Likud", likud, Wing.Right);
		allParties[1] = new Party("Meretz", meretz, Wing.Left);
		allParties[2] = new Party("Kahol Lavan", KL, Wing.Center);

		Citizen[] allCitizens = new Citizen[10];
		allCitizens[4] = new Citizen(555555555, 1989, "Hob", false);
		allCitizens[1] = new Citizen(111111111, 1990, "Bob", false);
		allCitizens[2] = new Citizen(222222222, 1991, "Rob", false);
		allCitizens[3] = new Citizen(333333333, 1992, "Kob", false);
		allCitizens[0] = new Citizen(444444444, 1993, "Sob", false);
		allCitizens[5] = new Citizen(666666666, 1989, "erob", false);
		allCitizens[6] = new Citizen(777777777, 1990, "Bwer", false);
		allCitizens[7] = new Citizen(888888888, 1991, "Rhf", false);
		allCitizens[8] = new Citizen(999999999, 1992, "Kvbs", false);
		allCitizens[9] = allCitizens[8];
		
		
		
		round1.addVotingStationList(allVotingStations);
		for (int i = 0; i < allCitizens.length; i++) {
			round1.addCitizen(allCitizens[i]);
			round1.setCitizenVotingStation(allCitizens[i]);
		}
		for (int i = 0; i < allParties.length; i++) {
			round1.addParty(allParties[i]);
		}
		

		// -----------------Menu------------------------
		System.out.println(round1.getYear() + " Election system:");
		System.out.println("1.Add voting station");
		System.out.println("2.Add citizen");
		System.out.println("3.Add party");
		System.out.println("4.Add party candidate");
		System.out.println("5.Show all voting stations");
		System.out.println("6.Show all citizens");
		System.out.println("7.Show all parties");
		System.out.println("8.Vote");
		System.out.println("9.Show results");
		System.out.println("10.Exit");

		// ---------------------------------------------

		Scanner scan = new Scanner(System.in);
		 int choice ;
		 do {
			
			 choice = scan.nextInt();
		switch (choice) {
		case 1:
			round1.addVotingStation("Beer Sheva",false,true);
			break;
		case 2:
			 round1.addNewCitizen(55511114,2001,"Kobi",false,1);
			break;
		case 3:
			LocalDate d = LocalDate.of(1950, 11, 26);
			 round1.addNewParty("Avoda",d,Wing.Left);
			break;
		case 4:

			 round1.addNewCandidate(14796741, 1990, "Shiko", false, allParties[1],1);
			break;
		case 5:

			System.out.println(round1.getVotingStations());
			break;
		case 6:

			System.out.println(round1.getAllCitizens());
			break;
		case 7:

			System.out.println(round1.showAllParties());
			break;
		case 8:
			round1.startVote();
			break;
		case 9:
			System.out.println(round1.results());
			break;
		case 10:

			break;
		}
		 }while(choice!=10);
		 scan.close();
	}
}
