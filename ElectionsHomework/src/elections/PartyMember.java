package elections;

public class PartyMember extends Citizen {

	private int position;
	private Party memberOf;
	private boolean isMember;

	public PartyMember(int id, int birthYear, String name, int voteStation, boolean isInIsolation, int position,
			Party memberOf) {
		super(id, birthYear, name, voteStation, isInIsolation);
		this.position = position;
		this.memberOf = memberOf;
		isMember=false;

	}

	public String toString() {
		return super.toString() + "Position #" + position + " In the party of the " + memberOf;
	}

}
