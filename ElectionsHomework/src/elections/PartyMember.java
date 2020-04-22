package elections;

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


	public void setPosition(int position) {
		this.position = position;

	}

	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}


	public String toString() {
		return super.toString() + "Position #" + position + " In the party of the " + memberOf;
	}

}
