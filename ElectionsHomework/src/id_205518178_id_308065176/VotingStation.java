package id_205518178_id_308065176;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Vector;

public class VotingStation {

	protected static int counter;
	protected int stationId;
	protected Vector<Citizen> citizens;
	protected String address;
	protected int[] results;
	protected int numOfVotes;
	protected final static String DEFAULT_ADDRESS = "Tel Aviv 15";
	protected boolean corona;
	protected boolean military;

	
	//---------------------C'tors---------------------
	public VotingStation() {
		this(DEFAULT_ADDRESS,false,false);

	}
	public VotingStation(String address) {
		this(address,false,false);
	}
	public VotingStation(String address,boolean corStat) {
		this(address,corStat,false);
	}
	public VotingStation(String address,boolean corStat, boolean milStat) {
		setAddress(address);
		corona = corStat;
		military = milStat;
		citizens = new Vector<Citizen>();
		stationId=++counter;
	}

	
	//--------------------Getters/Setters--------------
	

	public int getStationId() {
		return this.stationId;
	}
	
	public void setNumOfParties(int numOfPartiesAdded) {
		this.results = new int [numOfPartiesAdded];
	}

	public void addCitizen(Citizen citizen) {
		citizens.add(citizen);
	}
	
	public int [] getVotingStationResults() {
		return results;
	}
	private void setAddress(String address) {//Consider using exception
			this.address = address;
	}
	//--------------------------------------------------

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("\n----------------------");
		str.append("\nVoting Station ID: " + stationId + "\nAddress: " + address);

		for (int i = 0; i < citizens.size(); i++) {
			str.append("\n" + citizens.get(i));

		}
		return "" + str+"\n";
	}

	

	public void castVote(int vote) {
		results[vote]++;
		numOfVotes++;
	}

	public String getStatistics() {
		String s;
		double percentage = 0;
		if(citizens.size()>0) {
		percentage = (double)numOfVotes/citizens.size()*100;
		s ="Vote percentage : "+(int)percentage+"%\n";
		return s;
		}
		else return "Vote percentage : 0%\n";
	}

	public void resetRound() {
		for (int i = 0; i < results.length; i++) {
			results[i]=0;
			numOfVotes = 0;
		}
		
	}

	public boolean setCorona() {
		corona = true;
		return true;
	}

	public boolean setMilitary() {
		military = true;
		return true;
	}

	public void addVoter(Citizen c) {
		citizens.add(c);
	}
	public void updateNumOfParties(int num) {
		results = new int [num];
	}

	

		
		
		
		

}
