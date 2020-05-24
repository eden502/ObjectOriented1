package id_205518178_id_308065176;

public class PartyMember extends Citizen {

	private static int positionCounter;
	private int memberOf;
	private boolean isMember;
	private int position;

	public PartyMember(int id, int birthYear, String name) throws Exception {
		super(id, birthYear, name);
		this.position = ++positionCounter;
		this.memberOf = memberOf;
		isMember = false;

	}

	public int getPosition() {
		return position;
	}

	public boolean setPosition(int position) {
		this.position = position;
		return true;
	}
	public boolean getMemberStatus() {
		return isMember;
	}

	private void setMember() {

		isMember = true;
	}
	public void setParty(int num) {
		memberOf = num;
		setMember();
	}

	public String toString() {
		return super.toString() + "Position #" + position;
	}

}
