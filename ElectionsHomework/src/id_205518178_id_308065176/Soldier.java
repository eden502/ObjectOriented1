package id_205518178_id_308065176;

public class Soldier extends Citizen {
	
	private boolean carryWeapon;

	public Soldier(int id) throws Exception {
		super(id);
	}
	public Soldier(int id, int birthYear, String name, boolean isInIsolation,boolean weaponStatus) throws Exception {
		super(id,birthYear,name,isInIsolation);
		setWeaponStatus(weaponStatus);
		
	}
	private void setWeaponStatus(boolean weaponStatus) {
		carryWeapon = weaponStatus;
	}
	public boolean getWeaponStatus() {
		return carryWeapon;
	}

}
