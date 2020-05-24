package id_205518178_id_308065176;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Vector;

import id_205518178_id_308065176.Party.Wing;

public class RoundManager {

//	protected Citizen[] allCitizens;
//	protected Party[] allParties;
//	protected VotingStation[] allVotingStations;
//	private int numOfCitizensAdded, numOfPartiesAdded, numOfVotingStationsAdded;
//	private int numOfCoronaStations, numOfMilitaryStations;
	private int month, year;

	// ---------------------------USING VECTORS-------------------------------

	private Vector<Citizen> allCitizens;
	private Vector<VotingStation<Citizen>> healthyCitizens;
	private Vector<VotingStation<SickCitizen>> sickCitizens;
	private Vector<VotingStation<Soldier>> soldiers;
	private Vector<VotingStation<SickSoldier>> sickSoldiers;
	private Vector<Party> allParties;

	public RoundManager(int roundNumber, int month, int year) {
		allCitizens = new Vector<Citizen>();
		healthyCitizens = new Vector<VotingStation<Citizen>>();
		sickCitizens = new Vector<VotingStation<SickCitizen>>();
		soldiers = new Vector<VotingStation<Soldier>>();
		sickSoldiers = new Vector<VotingStation<SickSoldier>>();
		allParties = new Vector<Party>();
		setMonth(month); // add methods
		setYear(year); // add methods

	}

	private void setYear(int year) {
		final int DEFAULT_YEAR = 2020;
		try {
			if (year > 1990 && year < 2030) {
				this.year = year;
				return;
			}
			this.year = DEFAULT_YEAR;
			return;
		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
			this.year = DEFAULT_YEAR;
		} catch (Exception e) {
			System.out.println("General error: " + e.getMessage());
			this.year = DEFAULT_YEAR;
		}
	}

	private void setMonth(int month) {
		final int DEFAULT_MONTH = 1;
		try {
			if (month < 13 && month > 0) {
				this.month = month;
				return;
			}
			this.month = DEFAULT_MONTH;
			return;

		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
			this.month = DEFAULT_MONTH;
		} catch (Exception e) {
			System.out.println("General error: " + e.getMessage());
			this.month = DEFAULT_MONTH;
		}
	}

	public void addParty(Party p) throws Exception {
		if(allParties.contains(p)) {
			throw new Exception("party already exists");
		}
		this.allParties.add(p);
		setNumOfParties(healthyCitizens, allParties.size());
		setNumOfParties(soldiers, allParties.size());
		setNumOfParties(sickSoldiers, allParties.size());
		setNumOfParties(sickCitizens, allParties.size());
	}

	// updates the number of parties at results array in votingstation
	private <T extends Citizen> void setNumOfParties(Vector<VotingStation<T>> stationType, int num) {
		for (int i = 0; i < stationType.size(); i++) {
			stationType.get(i).updateNumOfParties(num);
		}
	}

	public <T extends Citizen> void addCitizen(T c) { // check if voting station of each type will be created on first
														// run
		try {
			allCitizens.add(c);
			// System.out.println(c.getClass());

			Random rand = new Random();
			int r;
			if (c.getClass() == Soldier.class) {
				soldiers.get(r = rand.nextInt(soldiers.size())).addVoter((Soldier) c);
				((Soldier) c).setVotingStation(soldiers.get(r).stationId);
			} else if (c.getClass() == SickSoldier.class) {
				sickSoldiers.get(r = rand.nextInt(sickSoldiers.size())).addVoter((SickSoldier) c);
				((SickSoldier) c).setVotingStation(sickSoldiers.get(r).stationId);
			} else if (c.getClass() == Citizen.class) {
				healthyCitizens.get(r = rand.nextInt(healthyCitizens.size())).addVoter(c);
				((Citizen) c).setVotingStation(healthyCitizens.get(r).stationId);
			} else if (c.getClass() == SickCitizen.class) {
				sickCitizens.get(r = rand.nextInt(sickCitizens.size())).addVoter((SickCitizen) c);
				// sickCitizens.get(0).addVoter(c);
				((SickCitizen) c).setVotingStation(sickCitizens.get(0).stationId);
			}
		} catch (IllegalArgumentException e) {
			System.out.println("voting station for type" + c.getClass() + "was not created yet");
		}

	}

	public void addVotingStation(String adr, boolean corStat, boolean milStat) { // method receives votingStation
																					// details and creates it
		VotingStation station = new VotingStation(adr, corStat, milStat);
		addVotingStation(station);
	}

	@SuppressWarnings("unchecked")
	public <T extends Citizen> void addVotingStation(VotingStation<T> station) {// method adds an already existing
																				// voting station

		if (station.military && !station.corona) {
			soldiers.add((VotingStation<Soldier>) station);
			return;
		}
		if (station.corona && !station.military) {
			sickCitizens.add((VotingStation<SickCitizen>) station);
			return;
		}
		if (station.corona && station.military) {
			sickSoldiers.add((VotingStation<SickSoldier>) station);
			return;
		}
		if (!station.corona && !station.military) {
			healthyCitizens.add((VotingStation<Citizen>) station);
			return;
		}

	}

	public int getNumOfParties() {
		return allParties.size();
	}

	public int getYear() {
		return this.year;
	}

	public String getVotingStations() {
		return healthyCitizens.toString() + sickCitizens.toString() + soldiers.toString() + sickSoldiers.toString();
	}

	public String getAllCitizens() {
		return allCitizens.toString();
	}

	public String getAllParties() {
		return allParties.toString();
	}

//	public void setCitizenVotingStation(Citizen c1) {
//		if (c1.isInIsolation) {
//			if (c1.isSoldier) {
//				c1.setVotingStation(sickSoldiers.size());
//				return;
//			}
//			c1.setVotingStation(sickCitizens.size());
//			return;
//		}
//		if (c1.isSoldier) {
//			c1.setVotingStation(soldiers.size());
//			return;
//		}
//		c1.setVotingStation(healthyCitizens.size());
////		c1.setVotingStation(numOfVotingStationsAdded);
//		// addCitizensList(c1);
//		this.allVotingStations[c1.voteStation - 1].addCitizen(c1);
////		for (int i = 0; i < numOfCitizensAdded; i++) {
////			allCitizens[i].setVotingStation(numOfVotingStationsAdded);
////			addCitizenToVotingStation(allCitizens[i]);
//
//		// }
//	}

	// ------------------------------------------------------------------------
	// ------------------RoundManager C'tor-------------------
//	public RoundManager(int totalCitizens, int totalVotingStat, int totalParties, int roundNumber, int day,
//			String month, int year) {
//		allCitizens = new Citizen[totalCitizens];
//		allParties = new Party[totalParties];
//		allVotingStations = new VotingStation[totalVotingStat];
//		numOfCitizensAdded = 0;
//		numOfPartiesAdded = 0;
//		this.day = day;
//		this.month = month;
//		this.year = year;
//	}

	// -------------------Getters/Setters--------------------

//	public String getVotingStations() {
//		StringBuffer str = new StringBuffer();
//		str.append("Showing all voting stations: \n");
//		for (int i = 0; i < numOfVotingStationsAdded; i++) {
//			str.append(allVotingStations[i].toString());
//		}
//		return "" + str;
//	}

//	public StringBuffer getAllCitizens() {
//		StringBuffer ctzn = new StringBuffer();
//		ctzn.append("List of all citizens: \n");
//		for (int i = 0; i < numOfCitizensAdded; i++) {
//			ctzn.append("------------------------\n");
//			ctzn.append(allCitizens[i].toString());
//		}
//		return ctzn;
//	}

//	public StringBuffer showAllParties() {
//		StringBuffer pty = new StringBuffer();
//		pty.append("Registered Parties:\n");
//		for (int i = 0; i < numOfPartiesAdded; i++) {
//			pty.append("-----------------------------\n");
//			pty.append(allParties[i].toString());
//			pty.append("-----------------------------\n");
//		}
//
//		return pty;
//	}
//
//	public boolean setParties(Party[] allParties) {
//		this.allParties = allParties;
//		numOfPartiesAdded = allParties.length;
//		for (int i = 0; i < allVotingStations.length; i++) {
//			allVotingStations[i].setNumOfParties(numOfPartiesAdded);
//		}
//		return true;
//	}

//	public boolean addCitizensList(Citizen c1) {
//		this.allCitizens[numOfCitizensAdded] = c1;
//		numOfCitizensAdded++;
//		return true;
//	}

//	private void addCitizenToVotingStation(Citizen c1) {
//		if (!c1.isInIsolation && !c1.isSoldier) {
//			c1.getVotingStation()
//		}
//		if (c1.isInIsolation) {
//			for (int i = 0; i < numOfVotingStationsAdded; i++) {
//				if (allVotingStations[i].corona) {
//					allVotingStations[i].addCitizen(c1);
//					break;
//				}
//			}
//		}
//		if (c1.isSoldier) {
//			for (int i = 0; i < numOfVotingStationsAdded; i++) {
//				if (allVotingStations[i].military) {
//					allVotingStations[i].addCitizen(c1);
//					break;
//				}
//			}
//		}
//	}
//
//	public boolean addVotingStationList(VotingStation[] allVotingStations) {
//		this.allVotingStations = allVotingStations;
//		numOfVotingStationsAdded = allVotingStations.length;
//		return true;
//	}

////-------------------Add Voting Stations------------------------------
//	public void addNewVotingStation(String address, int listSize, int type) {
//		if (numOfVotingStationsAdded < allVotingStations.length) {
//			switch (type) {
//			case 1:// regular voting station
//				allVotingStations[numOfVotingStationsAdded] = new VotingStation(address, listSize);
//				allVotingStations[numOfVotingStationsAdded].setNumOfParties(numOfPartiesAdded);
//				numOfVotingStationsAdded++;
//				break;
//			case 2:// corona voting station
//				allVotingStations[numOfVotingStationsAdded] = new CoronaVotingStation(address, listSize);
//				allVotingStations[numOfVotingStationsAdded].setNumOfParties(numOfPartiesAdded);
//				allVotingStations[numOfVotingStationsAdded].setCorona();
//				numOfVotingStationsAdded++;
//				numOfCoronaStations++;
//				break;
//
//			case 3:// military voting station
//				allVotingStations[numOfVotingStationsAdded] = new MilitaryVotingStation(address, listSize);
//				allVotingStations[numOfVotingStationsAdded].setNumOfParties(numOfPartiesAdded);
//				allVotingStations[numOfVotingStationsAdded].setMilitary();
//				numOfVotingStationsAdded++;
//				numOfMilitaryStations++;
//				break;
//			}
//		}
//
//		else {
//			int newLength = this.allVotingStations.length * 2;
//			Object t = new Object[newLength];
//			t = fullArray(this.allVotingStations);
//			this.allVotingStations = new VotingStation[newLength];
//			System.arraycopy(t, 0, this.allVotingStations, 0, newLength);
//			addNewVotingStation(address, listSize, type);
//		}
//
//	}
//
//	private Object[] fullArray(Object[] obj) {
//		Object[] temp = new Object[obj.length * 2];
//		System.arraycopy(obj, 0, temp, 0, obj.length);
//		return temp;
//	}

	// --------------------------Add Citizen---------------------------
//	public void addNewCitizen(int id, int birthYear, String name, boolean isInIsolation, int stationType) {
//
//		if (numOfCitizensAdded < allCitizens.length) {
//			allCitizens[numOfCitizensAdded] = new Citizen(id, birthYear, name, numOfVotingStationsAdded, isInIsolation);
//			addCitizenToVotingStation(allCitizens[numOfCitizensAdded]);
//			numOfCitizensAdded++;
//		} else {
//			int newLength = this.allCitizens.length * 2;
//			Object t = new Object[newLength];
//			t = fullArray(this.allCitizens);
//			this.allCitizens = new Citizen[newLength];
//			System.arraycopy(t, 0, this.allCitizens, 0, newLength);
//			addNewCitizen(id, birthYear, name, isInIsolation, stationType);
//		}
//
//	}

//	public void addNewCandidate(int id, int birthYear, String name, boolean isInIsolation, Party memberOf,
//			int stationType) {
//		if (numOfCitizensAdded < allCitizens.length) {
//			switch (stationType) {
//			case 1:// regular voting station
//				allCitizens[numOfCitizensAdded] = new PartyMember(id, birthYear, name, numOfVotingStationsAdded,
//						isInIsolation, memberOf);
//				addCitizenToVotingStation(allCitizens[numOfCitizensAdded]);
//				memberOf.addMemberToParty((PartyMember) allCitizens[numOfCitizensAdded]);
//				numOfCitizensAdded++;
//				break;
//			case 2:// corona voting station
//
//				break;
//			}
//		} else {
//			int newLength = this.allCitizens.length * 2;
//			Object t = new Object[newLength];
//			t = fullArray(this.allCitizens);
//			this.allCitizens = new Citizen[newLength];
//			System.arraycopy(t, 0, this.allCitizens, 0, newLength);
//			addNewCitizen(id, birthYear, name, isInIsolation, stationType);
//		}
//
//	}

	// ----------------------------------------------------------------
	// --------------------------Add Party---------------------------
//	public void addNewParty(String partyName, LocalDate dateCreated, Wing wing) {
//		if (numOfPartiesAdded < allParties.length) {
//			allParties[numOfPartiesAdded] = new Party(partyName, dateCreated, wing);
//			numOfPartiesAdded++;
//			for (int i = 0; i < numOfVotingStationsAdded; i++) {
//				allVotingStations[i].setNumOfParties(numOfPartiesAdded);
//			}
//		} else {
//			int newLength = this.allParties.length * 2;
//			Object t = new Object[newLength];
//			t = fullArray(this.allParties);
//			this.allParties = new Party[newLength];
//			System.arraycopy(t, 0, this.allParties, 0, newLength);
//			addNewParty(partyName, dateCreated, wing);
//		}
//
//	}

	// ----------------------------------------------------------------

//---------------------------------------------------------------------	
	public void startVote() {// check for generic method!
		for (int i = 0; i < allCitizens.size(); i++) {
			if (allCitizens.get(i).vote()) {
				Random randomGen = new Random();
				int rand = randomGen.nextInt(allParties.size());
				if (allCitizens.get(i).getClass() == SickSoldier.class) {
					for (int j = 0; j < sickSoldiers.size(); j++) {
						if (sickSoldiers.get(j).stationId == allCitizens.get(i).getVotingStation()) {
							sickSoldiers.get(j).castVote(rand);
							break;
						}
					}
				}
				if (allCitizens.get(i).getClass() == SickCitizen.class) {
					for (int j = 0; j < sickCitizens.size(); j++) {
						if (sickCitizens.get(j).stationId == allCitizens.get(i).getVotingStation()) {
							sickCitizens.get(j).castVote(rand);
							break;
						}
					}

				}
				if (allCitizens.get(i).getClass() == Soldier.class) {
					for (int j = 0; j < soldiers.size(); j++) {
						if (soldiers.get(j).stationId == allCitizens.get(i).getVotingStation()) {
							soldiers.get(j).castVote(rand);
							break;
						}
					}
				}
				if (allCitizens.get(i).getClass() == Citizen.class) {
					for (int j = 0; j < healthyCitizens.size(); j++) {
						if (healthyCitizens.get(j).stationId == allCitizens.get(i).getVotingStation()) {
							healthyCitizens.get(j).castVote(rand);
							break;
						}
					}

				}

//				if (allCitizens.get(i).isInIsolation && allCitizens.get(i).isSoldier) {
//					for (int j = 0; j < sickSoldiers.size(); j++) {
//						if (sickSoldiers.get(j).stationId == allCitizens.get(i).getVotingStation()) {
//							sickSoldiers.get(j).castVote(rand);
//							break;
//						}
//					}
//				}
//				if (allCitizens.get(i).isInIsolation && !allCitizens.get(i).isSoldier) {
//					for (int j = 0; j < sickCitizens.size(); j++) {
//						if (sickCitizens.get(j).stationId == allCitizens.get(i).getVotingStation()) {
//							sickCitizens.get(j).castVote(rand);
//							break;
//						}
//					}
//				}
//				if (allCitizens.get(i).isSoldier && !allCitizens.get(i).isInIsolation) {
//					for (int j = 0; j < soldiers.size(); j++) {
//						if (soldiers.get(j).stationId == allCitizens.get(i).getVotingStation()) {
//							soldiers.get(j).castVote(rand);
//							break;
//						}
//					}
//
//				}
//				if (!allCitizens.get(i).isSoldier && !allCitizens.get(i).isInIsolation) {
//					for (int j = 0; j < healthyCitizens.size(); j++) {
//						if (healthyCitizens.get(j).stationId == allCitizens.get(i).getVotingStation()) {
//							healthyCitizens.get(j).castVote(rand);
//							break;
//						}
//					}
//
//				}

				// allVotingStations[allCitizens[i].getVotingStation() - 1].castVote(rand);
				// allVotingStations[allCitizens[i].voteStation].castVote(rand);
			}
		}
	}

	private <T extends Citizen> String generateStationResults(Vector<VotingStation<T>> stationType) {
		StringBuffer str = new StringBuffer();
		// str.append("Final results are:\n");
		for (int i = 0; i < stationType.size(); i++) {
			str.append("--------------------------------\n");
			// allVotingStations[i].getVotingStationResults();
			str.append("Voting Station " + stationType.get(i) + ":\n");
			str.append((stationType.get(i)).getStatistics());
			for (int j = 0; j < allParties.size(); j++) {
				str.append(allParties.get(j).getPartyName() + ":" + stationType.get(i).results[j] + " votes\n");
			}
		}

		return str + "";
	}

	public String results() {
		StringBuffer str = new StringBuffer();

		str.append(generateStationResults(healthyCitizens));
		str.append(generateStationResults(sickCitizens));
		str.append(generateStationResults(soldiers));
		str.append(generateStationResults(sickSoldiers));
		str.append("-----------------------------\n");
		calculateFinalResults(healthyCitizens);
		calculateFinalResults(sickCitizens);
		calculateFinalResults(sickSoldiers);
		calculateFinalResults(soldiers);

		return "" + str + showFinalResults();

	}



	private StringBuffer showFinalResults() {
		StringBuffer str = new StringBuffer();

		for (int i = 0; i < allParties.size(); i++) {
			str.append(allParties.get(i).getPartyName() + " total votes are: " + allParties.get(i).getResults() + "\n");
		}
		return str;
	}

	private <T extends Citizen> void calculateFinalResults(Vector<VotingStation<T>> stationType) {
		for (int i = 0; i < stationType.size(); i++) {
			for (int j = 0; j < allParties.size(); j++) {
				allParties.get(j).setResults(stationType.get(i).results[j]);
			}
		}

	}

	public void addNewCandidate(PartyMember p1) throws Exception { 
		if(p1.getMemberStatus()) {
			throw new Exception("Already a member of a party"); 
		}
		int rand;
		Random randNum = new Random();
		rand = randNum.nextInt(allParties.size());
		allParties.get(rand).addMemberToParty(p1);
		p1.setParty(rand);
		
	}

//	@Override
//	public String toString() {
//		return "RoundManager [allCitizens=" + Arrays.toString(allCitizens) + ", allParties="
//				+ Arrays.toString(allParties) + ", allVotingStations=" + Arrays.toString(allVotingStations)
//				+ ", numOfCitizenAdded=" + numOfCitizensAdded + ", numOfPartiesAdded=" + numOfPartiesAdded
//				+ ", numOfVotingStationsAdded=" + numOfVotingStationsAdded + "]";
//	}

}
