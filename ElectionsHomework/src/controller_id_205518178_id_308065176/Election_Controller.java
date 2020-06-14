package controller_id_205518178_id_308065176;

import java.time.LocalDate;

import id_205518178_id_308065176.Citizen;
import id_205518178_id_308065176.Party;
import id_205518178_id_308065176.PartyMember;
import id_205518178_id_308065176.RoundManager;
import id_205518178_id_308065176.Party.Wing;
import view_id_205518178_id_308065176.AbstractView;

public class Election_Controller {

	private RoundManager electionRound;
	private AbstractView electionView;
	
	public Election_Controller(RoundManager model, AbstractView view ) {
		electionRound = model;
		electionView = view;
	}
	
	public void addVotingStationToModel(String adr, boolean corStat, boolean milStat) {
		electionRound.addVotingStation(adr, corStat, milStat);
	}
	
	public void addCitizenToModel(int id, int birthYear, String name) throws Exception{
		Citizen c_temp = new Citizen(id, birthYear, name);
		electionRound.addCitizen(c_temp);
	}
	
	public void addPartyToModel(String partyName, LocalDate dateCreated, Wing wing) throws Exception {
		Party p_temp = new Party(partyName, dateCreated, wing);
		electionRound.addParty(p_temp);
	}
	
	public void addCandidateToModel(int id, int birthYear, String name) throws Exception {
		PartyMember pMember_temp = new PartyMember(id, birthYear, name);
		electionRound.addNewCandidate(pMember_temp);
	}
	
	public String viewAskShowVotingStaions() {
		return electionRound.getVotingStations();
		
	}
	
	public String viewAskShowAllCitizens() {
		return electionRound.getAllCitizens();
		
	}
	
	public String viewAskShowAllParties() {
		return electionRound.getAllParties();
		
	}
	
	public void viewSayVote() {
		electionRound.startVote();
	}
}
