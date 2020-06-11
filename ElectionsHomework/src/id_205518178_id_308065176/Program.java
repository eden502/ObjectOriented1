package id_205518178_id_308065176;

//Eden Harel ID:205518178

//Dorel Saig ID:308065176

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Vector;

import com.sun.javafx.application.LauncherImpl;

import id_205518178_id_308065176.Party.Wing;
import javafx.application.Application;
import javafx.stage.Stage;
import view_id_205518178_id_308065176.MainView;

public class Program extends Application{


	public static void main(String[] args) throws Exception {
        launch(args);


		// -----------HARD CODED OBJECTS------------------
		RoundManager round1 = new RoundManager(1, 2, 2017);
		Vector <VotingStation> allVotingStations= new Vector<VotingStation>();
		//VotingStation[] allVotingStations = new VotingStation[3];
		VotingStation v1 = new VotingStation("Tel Aviv 15", true, false);
		VotingStation v2 = new VotingStation("Rosh Pina 46", false, false);
		VotingStation v3 = new VotingStation("Rasfana 14", false, true);
		allVotingStations.add(v1);
		allVotingStations.add(v2);
		allVotingStations.add(v3);
		
		//Party[] allParties = new Party[3];
		LocalDate likud = LocalDate.of(1988, 4, 25);
		LocalDate meretz = LocalDate.of(2002, 6, 14);
		LocalDate KL = LocalDate.of(2017, 5, 12);
		Vector <Party> allParties = new Vector<Party>();
		Party allParties1 = new Party("Likud", likud, Wing.Right);
		Party allParties2 = new Party("Meretz", meretz, Wing.Left);
		Party allParties3 = new Party("Kahol Lavan", KL, Wing.Center);
		allParties.add(allParties1);
		allParties.add(allParties2);
		allParties.add(allParties3);

		//Citizen[] allCitizens = new Citizen[10];
		Vector <Citizen> allCitizens = new Vector<Citizen>();
		Soldier allCitizens1 = new Soldier(555555555, 1989, "Hob", false);
		Citizen allCitizens2 = new Citizen(111111111, 1990, "Bob");
		Citizen allCitizens3 = new Citizen(222222222, 1991, "Rob");
		Citizen allCitizens4 = new Citizen(333333333, 1992, "Kob");
		Citizen allCitizens5 = new Citizen(444444444, 1993, "Sob");
		Citizen allCitizens6 = new Citizen(666666666, 1989, "erob");
		Citizen allCitizens7 = new Citizen(777777777, 1990, "Bwer");
		Citizen allCitizens8 = new Citizen(888888888, 1991, "Rhf");
		Citizen allCitizens9 = new Citizen(999999999, 1992, "Kvbs");
		SickCitizen allCitizens10 = new SickCitizen(123456789, 1992, "sick", 11);
		
		allCitizens.add(allCitizens1);
		allCitizens.add(allCitizens2);
		allCitizens.add(allCitizens3);
		allCitizens.add(allCitizens4);
		allCitizens.add(allCitizens5);
		allCitizens.add(allCitizens6);
		allCitizens.add(allCitizens7);
		allCitizens.add(allCitizens8);
		allCitizens.add(allCitizens9);
		allCitizens.add(allCitizens10);
		
		
		for (int i = 0; i < allVotingStations.size(); i++) {
			round1.addVotingStation(allVotingStations.get(i));

		}
		for (int i = 0; i < allCitizens.size(); i++) {
			round1.addCitizen(allCitizens.get(i));
		}
		for (int i = 0; i < allParties.size(); i++) {
			round1.addParty(allParties.get(i));
		}
		PartyMember p1 = new PartyMember(123456789, 1990, "Member");

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
		int choice;
		do {

			choice = scan.nextInt();
			switch (choice) {
			case 1:
				round1.addVotingStation("Beer Sheva", false, true);
				break;
			case 2:
				Citizen c1 = new Citizen(123456789, 1990, "NEWC");
				round1.addCitizen(c1);
				break;
			case 3:
				LocalDate d = LocalDate.of(1950, 11, 26);
				Party par1 = new Party("Avoda", d, Wing.Left);
				round1.addParty(par1);
				break;
			case 4:
				round1.addNewCandidate(p1);
				break;
			case 5:

				System.out.println(round1.getVotingStations());
				break;
			case 6:

				System.out.println(round1.getAllCitizens());
				break;
			case 7:

				System.out.println(round1.getAllParties());
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
		} while (choice != 10);
		scan.close();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		MainView theView = new MainView(primaryStage,2,2017);		
	}

}
