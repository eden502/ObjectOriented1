package elections;

import java.time.LocalDate;

public abstract class Party {
	
	enum Wing {Left, Center, Right}
	protected String partyName;
	protected PartyMember [] members;
	protected LocalDate dateCreated;
	protected Wing wing;
	
	
	public Party(String partyName, LocalDate dateCreated, Wing wing) {
		this.partyName = partyName;
		members = new PartyMember[10];
		this.dateCreated = dateCreated;
		this.wing = wing;
	}
	
	
	

}
