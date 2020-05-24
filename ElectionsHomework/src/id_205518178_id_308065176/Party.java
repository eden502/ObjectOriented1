package id_205518178_id_308065176;

import java.time.LocalDate;
import java.util.Vector;

public class Party {

	enum Wing {
		Left, Center, Right
	}

	protected String partyName;
	protected Vector<PartyMember> members;
	protected LocalDate dateCreated;
	protected Wing wing;
	private int numOfPartyMembers;
	private int totalVotes;
	private int myResults;

	public Party(String partyName, LocalDate dateCreated, Wing wing) {
		this.partyName = partyName;
		this.dateCreated = dateCreated;
		this.wing = wing;
		numOfPartyMembers = 0;
		members = new Vector<PartyMember>();
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
		return members.size();
	}
	@Override
	public String toString() {

		return "Party Name: " + partyName + "\nDate created: " + dateCreated + "\nWing: " + wing.toString()
				+ "\nNumber of members: " + numOfPartyMembers + "\n"+"Candidates: "+members.toString()+"\n--------------------\n";
	}

	public void resetRound() {
		this.totalVotes=0;
	}

	
	// -------- Adding Member to Party By his Position - 
	//check if position set in PartyMember been restricted -------- 
//	public void addMemberToParty(PartyMember Candidate) {
//		if (numOfPartyMembers<members.length) {
//		members[Candidate.getPosition()-1] = Candidate;
//		numOfPartyMembers++;
//		Candidate.setMember(true);
//		}
//		else {
//			int newLength = this.members.length * 2;
//			Object t = new Object[newLength];
//			t = fullArray(this.members);
//			this.members = new PartyMember[newLength];
//			System.arraycopy(t, 0, this.members, 0, newLength);
//			addMemberToParty(Candidate);
//		}
//		
//	}
	
	public void addMemberToParty(PartyMember p1) {
		members.add(p1);
		numOfPartyMembers++;
	}
	public void setResults(int r) {
		myResults += r;
	}
	public int getResults() {
		return myResults;
	}
	


}
