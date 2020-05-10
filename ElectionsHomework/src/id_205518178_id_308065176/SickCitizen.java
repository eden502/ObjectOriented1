package id_205518178_id_308065176;

import java.util.InputMismatchException;

public class SickCitizen extends Citizen {

	private int daysSick;

	public SickCitizen(int id, int birthYear, String name, boolean isInIsolation, int daysSick) throws Exception {
		super(id, birthYear, name, isInIsolation);
		updateSickDays(daysSick);
	}

	public void updateSickDays(int num) {
		try {
			daysSick = num;

		} catch (InputMismatchException e) {
			System.out.println("Input error");
			daysSick = 0;
		} catch (Exception e) {
			System.out.println(e.toString());
			daysSick = 0;
		}
	}

}
