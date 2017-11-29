package rosado.jose.csc110;

import java.util.ArrayList;

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
	ArrayList<Suspects> suspectCards = new ArrayList<>();
	ArrayList<Weapons> weaponCards = new ArrayList<>();
	ArrayList<Rooms> roomCards = new ArrayList<>();
}
