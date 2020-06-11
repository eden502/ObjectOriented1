package id_205518178_id_308065176;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Vector;

import id_205518178_id_308065176.Party.Wing;

public class RoundManager {


	private int month, year;

	// ---------------------------USING VECTORS-------------------------------

	private Set<Citizen> allCitizens;
	private Vector<VotingStation<Citizen>> healthyCitizens;
	private Vector<VotingStation<SickCitizen>> sickCitizens;
	private Vector<VotingStation<Soldier>> soldiers;
	private Vector<VotingStation<SickSoldier>> sickSoldiers;
	private Vector<Party> allParties;

	public RoundManager(int roundNumber, int month, int year) {
		allCitizens = new Set<Citizen>();
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
		if (allParties.contains(p)) {
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

//---------------------------------------------------------------------	
	public void startVote() {
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
		if (p1.getMemberStatus()) {
			throw new Exception("Already a member of a party");
		}
		int rand;
		Random randNum = new Random();
		rand = randNum.nextInt(allParties.size());
		allParties.get(rand).addMemberToParty(p1);
		p1.setParty(rand);

	}



}
