package id_205518178_id_308065176;

public class PartyMember extends Citizen {

	private static int positionCounter;
	private Party memberOf;
	private boolean isMember;
	private int position;

	public PartyMember(int id, int birthYear, String name, int voteStation, boolean isInIsolation,
			Party memberOf) {
		super(id, birthYear, name, voteStation, isInIsolation);
		this.position = ++positionCounter;
		this.memberOf = memberOf;
		isMember=false; 

	}
	

	public int getPosition() {
		return position;
	}


	public boolean setPosition(int position) {
		this.position = position;
		return true;
	}

	public boolean setMember(boolean isMember) {
		this.isMember = isMember;
		return true;
	}


	public String toString() {
		return super.toString() + "Position #" + position + " In the party of the " + memberOf;
	}

}
