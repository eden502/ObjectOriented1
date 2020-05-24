package id_205518178_id_308065176;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Vector;

public class VotingStation<T extends Citizen> {

	protected static int counter;
	protected int stationId;
	protected Vector<T> voters;
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
		voters = new Vector<T>();
		stationId=++counter;
	}

	
	//--------------------Getters/Setters--------------
	

	public int getStationId() {
		return this.stationId;
	}
	
	public void setNumOfParties(int numOfPartiesAdded) {
		this.results = new int [numOfPartiesAdded];
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

		for (int i = 0; i < voters.size(); i++) {
			str.append("\n" + voters.get(i));

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
		if(voters.size()>0) {
		percentage = (double)numOfVotes/voters.size()*100;
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

	public void addVoter(T c) {
		voters.add(c);
	}
	public void updateNumOfParties(int num) {
		results = new int [num];
	}

	

		
		
		
		

}
