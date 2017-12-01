package rosado.jose.csc110;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	
//	Cards suspects = new Cards();
//	
//	Cards weapons = new Cards();
//	
//	Cards rooms = new Cards();
//	
//	ArrayList<Cards> cards = new ArrayList<>();

	/*
	 * These three lists will be made as cards for their respective type
	 * Within the Game class is where the first sorting starts
	 * First Rooms need to be allocated
	 * Weapons will be randomly assigned to one room
	 * A card from each list will be chosen as classified
	 * Those chosen cards will be removed and the remaining cards...
	 * ...will be shuffled to the players into a new list called hand
	 */
	
	private Random gen = new Random();
	
	private ArrayList<Enum> list = new ArrayList<>();
	
	public ArrayList<Enum> confidential = new ArrayList<>();	
	
	private ArrayList<Suspects> suspectCards = new ArrayList<>();
	private void setSuspectCards() {
		suspectCards.add(Suspects.Miss_Scarlet);
		suspectCards.add(Suspects.Mrs_White);
		suspectCards.add(Suspects.Mrs_Peacock);
		suspectCards.add(Suspects.Colonel_Mustard);
		suspectCards.add(Suspects.Professor_Plum);
		suspectCards.add(Suspects.Mr_Green);
	}
	
	private ArrayList<Weapons> weaponCards = new ArrayList<>();
	private void setWeaponCards() {
		weaponCards.add(Weapons.Rope);
		weaponCards.add(Weapons.LeadPipe);
		weaponCards.add(Weapons.Knife);
		weaponCards.add(Weapons.Wrench);
		weaponCards.add(Weapons.CandleStick);
		weaponCards.add(Weapons.Pistol);
	}
	
	private ArrayList<Rooms> roomCards = new ArrayList<>();
	private void setRoomCards() {
		roomCards.add(Rooms.Study);
		roomCards.add(Rooms.Hall);
		roomCards.add(Rooms.Lounge);
		roomCards.add(Rooms.Library);
		roomCards.add(Rooms.DiningRoom);
		roomCards.add(Rooms.BilliardRoom);
		roomCards.add(Rooms.Conservatory);
		roomCards.add(Rooms.BallRoom);
		roomCards.add(Rooms.Kitchen);
	}
	
	
	public void choseConfidential() {
		setSuspectCards();
		setWeaponCards();
		setRoomCards();
		setConfidentialCards(generateNumber(suspectCards), suspectCards);
		setConfidentialCards(generateNumber(weaponCards), weaponCards);
		setConfidentialCards(generateNumber(roomCards), roomCards);
	}
	
	private int generateNumber(ArrayList separateList) {
		return gen.nextInt(separateList.size());
	}
	
	private void setConfidentialCards(int pew, ArrayList cool) {
		confidential.add((Enum)cool.get(pew));
	}
	
	public void setFullList() {
		list.addAll(suspectCards);
		list.addAll(weaponCards);
		list.addAll(roomCards);
	}
}
