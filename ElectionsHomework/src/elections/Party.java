package elections;

import java.time.LocalDate;

public class Party {

	enum Wing {
		Left, Center, Right
	}

	protected String partyName;
	protected PartyMember[] members;
	protected LocalDate dateCreated;
	protected Wing wing;
	private int numOfPartyMembers;
	private int totalVotes;

	public Party(String partyName, LocalDate dateCreated, Wing wing) {
		this.partyName = partyName;
		members = new PartyMember[10];
		this.dateCreated = dateCreated;
		this.wing = wing;
		numOfPartyMembers = 0;
	}
	
	public String getPartyName() {
		return this.partyName;
	}
	public void setTotalVotes(int votes) {
		this.totalVotes += votes;
	}
	public int getTotalVotes() {
		return totalVotes;
	}
	@Override
	public String toString() {

		return "Party Name: " + partyName + "\nDate created: " + dateCreated + "\nWing: " + wing.toString()
				+ "\nNumber of members: " + numOfPartyMembers + "\n";
	}

	public void resetRound() {
		this.totalVotes=0;
	}

}
