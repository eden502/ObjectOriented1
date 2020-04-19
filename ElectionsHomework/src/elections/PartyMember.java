package elections;

public class PartyMember extends Citizen {
	
	private static int position;
	private Party memberOf;
	
	
	public PartyMember(int id, int birthYear, String name, int voteStation, 
			boolean isInIsolation, int position, Party memberOf) {
		super(id, birthYear, name, voteStation, isInIsolation);
		this.position = position;
		this.memberOf = memberOf;
		
	}


}
