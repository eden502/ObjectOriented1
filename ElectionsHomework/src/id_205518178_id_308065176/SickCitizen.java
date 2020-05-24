package id_205518178_id_308065176;

import java.util.InputMismatchException;

public class SickCitizen extends Citizen implements Sickable {

	private int daysSick;

	public SickCitizen(int id, int birthYear, String name, int daysSick) throws Exception {
		super(id, birthYear, name);
		updateSickDays(daysSick);
	}

	public void updateSickDays(int num) {
		try {
			daysSick = num;

		} catch (InputMismatchException e) {
			System.out.println("Input error");
			
		} catch (Exception e) {
			System.out.println(e.toString());
			
		}
	}



	@Override
	public int getDaysSick() {
		
		return daysSick;
	}

}
