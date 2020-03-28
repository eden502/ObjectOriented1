package elections;

import java.util.Scanner;

public class Program {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int choice = scan.nextInt();
		
		do {
			switch(choice) {
			case 1:
				System.out.println("Add voting station");
				break;
			case 2:
				System.out.println("Add citizen");
				break;
			case 3:
				System.out.println("Add party");
				break;
			case 4:
				System.out.println("Add party candidate");
				break;
			case 5:
				System.out.println("Show all voting stations");
				break;
			case 6:
				System.out.println("Show all citizens");
				break;
			case 7:
				System.out.println("Show all parties");
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
