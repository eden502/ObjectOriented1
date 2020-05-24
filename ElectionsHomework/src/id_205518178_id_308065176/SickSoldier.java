package id_205518178_id_308065176;

import java.util.InputMismatchException;

public class SickSoldier extends Soldier implements Sickable {
	
	private int sickDays;
	
	public SickSoldier(int id,int birthYear,String name,boolean weaponStatus,int daysSick) throws Exception {
		super(id, birthYear, name,weaponStatus);
		updateSickDays(daysSick);
		
	}

	@Override
	public int getDaysSick() {
		
		return sickDays;
	}


	@Override
	public void updateSickDays(int num) {
		try {
			sickDays = num;

		} catch (InputMismatchException e) {
			System.out.println("Input error");
			
		} catch (Exception e) {
			System.out.println(e.toString());
			
		}
	}

}
