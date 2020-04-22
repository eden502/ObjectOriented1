package id_205518178_id_308065176;

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
	
	public int getSizeOfParty() {
		return members.length;
	}
	@Override
	public String toString() {

		return "Party Name: " + partyName + "\nDate created: " + dateCreated + "\nWing: " + wing.toString()
				+ "\nNumber of members: " + numOfPartyMembers + "\n";
	}

	public void resetRound() {
		this.totalVotes=0;
	}

	
	// -------- Adding Member to Party By his Position - 
	//check if position set in PartyMember been restricted -------- 
	public void addMemberToParty(PartyMember Candidate) {
		if (numOfPartyMembers<members.length) {
		members[Candidate.getPosition()-1] = Candidate;
		numOfPartyMembers++;
		Candidate.setMember(true);
		}
		else {
			int newLength = this.members.length * 2;
			Object t = new Object[newLength];
			t = fullArray(this.members);
			this.members = new PartyMember[newLength];
			System.arraycopy(t, 0, this.members, 0, newLength);
			addMemberToParty(Candidate);
		}
		
	}
	
	private Object[] fullArray(Object[] obj) {
		Object[] temp = new Object[obj.length * 2];
		System.arraycopy(obj, 0, temp, 0, obj.length);
		// this.allVotingStations = new VotingStation[temp.length];
		// System.arraycopy(temp, 0, this.allVotingStations, 0, temp.length);
		return temp;
	}

}
