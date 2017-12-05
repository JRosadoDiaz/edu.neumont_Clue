package rosado.jose.csc110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class RoomLogic {
	
	/*
	 * this class needs to store what a player can do and see inside a room
	 * track when players enter a room
	 * hold a players options while in a room
	 */
	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public Random generator = new Random();
	
	public ArrayList<Weapons> fullWeaponList = new ArrayList<>();
	
	public ArrayList<Suspects> StudyRoom = new ArrayList<>();
	public ArrayList<Weapons> StudyRoomWeapon = new ArrayList<>();
	
	public ArrayList<Suspects> HallRoom = new ArrayList<>();
	public ArrayList<Weapons> HallRoomWeapon = new ArrayList<>();
	
	public ArrayList<Suspects> LoungeRoom = new ArrayList<>();
	public ArrayList<Weapons> LoungeRoomWeapon = new ArrayList<>();
	
	public ArrayList<Suspects> LibraryRoom = new ArrayList<>();
	public ArrayList<Weapons> LibraryRoomWeapon = new ArrayList<>();
	
	public ArrayList<Suspects> DiningRoom = new ArrayList<>();
	public ArrayList<Weapons> DiningRoomWeapon = new ArrayList<>();
	
	public ArrayList<Suspects> BilliardRoomList = new ArrayList<>();
	public ArrayList<Weapons> BilliardRoomWeapon = new ArrayList<>();
	
	public ArrayList<Suspects> ConservatoryRoom = new ArrayList<>();
	public ArrayList<Weapons> ConservatoryWeapon = new ArrayList<>();
	
	public ArrayList<Suspects> BallRoom = new ArrayList<>();
	public ArrayList<Weapons> BallRoomWeapon = new ArrayList<>();
	
	public ArrayList<Suspects> KitchenRoom = new ArrayList<>();
	public ArrayList<Weapons> KitchenRoomWeapon = new ArrayList<>();
	

	public void placeWeapons() {
		createWeaponList();
		setWeaponsToRooms();
	}

	public void createWeaponList() {
		fullWeaponList.add(Weapons.CandleStick);
		fullWeaponList.add(Weapons.Knife);
		fullWeaponList.add(Weapons.LeadPipe);
		fullWeaponList.add(Weapons.Pistol);
		fullWeaponList.add(Weapons.Rope);
		fullWeaponList.add(Weapons.Wrench);
	}
	
	private void setWeaponsToRooms() {
		int totalWeapons = 6;
		int roomGen;
		int weaponGen;
		int numberOfRooms = 9;
		
		for(int i=0; i<totalWeapons; i++) {
			boolean isRoomEmpty = false;
			while(!isRoomEmpty) {
				roomGen = generator.nextInt(numberOfRooms);
				weaponGen = generator.nextInt(fullWeaponList.size());
				isRoomEmpty = pickRoomToPlaceWeapon(roomGen, weaponGen);
			}
		}
	}
	
	private boolean pickRoomToPlaceWeapon(int roomGen, int weaponGen) {
		switch(roomGen) {
		case 0:
			if(StudyRoomWeapon.size() == 0) {
				StudyRoomWeapon.add(fullWeaponList.get(weaponGen));
				fullWeaponList.remove(weaponGen);
				return true;
			}
			return false;
		case 1:
			if(HallRoomWeapon.size() == 0) {
				HallRoomWeapon.add(fullWeaponList.get(weaponGen));
				fullWeaponList.remove(weaponGen);
				return true;
			}
			return false;
		case 2:
			if(LoungeRoomWeapon.size() == 0) {
				LoungeRoomWeapon.add(fullWeaponList.get(weaponGen));
				fullWeaponList.remove(weaponGen);
				return true;
			}
			return false;
		case 3:
			if(LibraryRoomWeapon.size() == 0) {
				LibraryRoomWeapon.add(fullWeaponList.get(weaponGen));
				fullWeaponList.remove(weaponGen);
				return true;
			}
			return false;
		case 4:
			if(DiningRoomWeapon.size() == 0) {
				DiningRoomWeapon.add(fullWeaponList.get(weaponGen));
				fullWeaponList.remove(weaponGen);
				return true;
			}
			return false;
		case 5:
			if(BilliardRoomWeapon.size() == 0) {
				BilliardRoomWeapon.add(fullWeaponList.get(weaponGen));
				fullWeaponList.remove(weaponGen);
				return true;
			}
			return false;
		case 6:
			if(ConservatoryWeapon.size() == 0) {
				ConservatoryWeapon.add(fullWeaponList.get(weaponGen));
				fullWeaponList.remove(weaponGen);
				return true;
			}
			return false;
		case 7:
			if(BallRoomWeapon.size() == 0) {
				BallRoomWeapon.add(fullWeaponList.get(weaponGen));
				fullWeaponList.remove(weaponGen);
				return true;
			}
			return false;
		case 8:
			if(KitchenRoomWeapon.size() == 0) {
				KitchenRoomWeapon.add(fullWeaponList.get(weaponGen));
				fullWeaponList.remove(weaponGen);
				return true;
			}
			return false;
		default:
			return false;
		}
	}
	
	public void movePlayersToRoom(Player currentPlayer, Board b, Deck d) throws IOException {
		if(b.roomLocation[currentPlayer.getyCoordinate()][currentPlayer.getxCoordinate()] == Rooms.Study) {
			StudyRoom.add(currentPlayer.getName());
			playerOptions(currentPlayer, currentPlayer.getName(), StudyRoom, b, d);
			adjustPlayerPositionAndState(currentPlayer, b);
			
		}
		if(b.roomLocation[currentPlayer.getyCoordinate()][currentPlayer.getxCoordinate()] == Rooms.Lounge) {
			LoungeRoom.add(currentPlayer.getName());
			playerOptions(currentPlayer, currentPlayer.getName(), LoungeRoom, b, d);
			adjustPlayerPositionAndState(currentPlayer, b);
		}
		if(b.roomLocation[currentPlayer.getyCoordinate()][currentPlayer.getxCoordinate()] == Rooms.BallRoom) {
			BallRoom.add(currentPlayer.getName());
			playerOptions(currentPlayer, currentPlayer.getName(), BallRoom, b, d);
			adjustPlayerPositionAndState(currentPlayer, b);
		}
		if(b.roomLocation[currentPlayer.getyCoordinate()][currentPlayer.getxCoordinate()] == Rooms.BilliardRoom) {
			BilliardRoomList.add(currentPlayer.getName());
			playerOptions(currentPlayer, currentPlayer.getName(), BilliardRoomList, b, d);
			adjustPlayerPositionAndState(currentPlayer, b);
		}
		if(b.roomLocation[currentPlayer.getyCoordinate()][currentPlayer.getxCoordinate()] == Rooms.Conservatory) {
			ConservatoryRoom.add(currentPlayer.getName());
			playerOptions(currentPlayer, currentPlayer.getName(), ConservatoryRoom, b, d);
			adjustPlayerPositionAndState(currentPlayer, b);
		}
		if(b.roomLocation[currentPlayer.getyCoordinate()][currentPlayer.getxCoordinate()] == Rooms.DiningRoom) {
			DiningRoom.add(currentPlayer.getName());
			playerOptions(currentPlayer, currentPlayer.getName(), DiningRoom, b, d);
			adjustPlayerPositionAndState(currentPlayer, b);
		}
		if(b.roomLocation[currentPlayer.getyCoordinate()][currentPlayer.getxCoordinate()] == Rooms.Hall) {
			HallRoom.add(currentPlayer.getName());
			playerOptions(currentPlayer, currentPlayer.getName(), HallRoom, b, d);
			adjustPlayerPositionAndState(currentPlayer, b);
		}
		if(b.roomLocation[currentPlayer.getyCoordinate()][currentPlayer.getxCoordinate()] == Rooms.Kitchen) {
			KitchenRoom.add(currentPlayer.getName());
			playerOptions(currentPlayer, currentPlayer.getName(), KitchenRoom, b, d);
			adjustPlayerPositionAndState(currentPlayer, b);
		}
		if(b.roomLocation[currentPlayer.getyCoordinate()][currentPlayer.getxCoordinate()] == Rooms.Library) {
			LoungeRoom.add(currentPlayer.getName());
			playerOptions(currentPlayer, currentPlayer.getName(), LoungeRoom, b, d);
			adjustPlayerPositionAndState(currentPlayer, b);
		}
	}

	private void adjustPlayerPositionAndState(Player currentPlayer, Board b) {
		currentPlayer.setInsideRoom(true);
		b.removePreviousSpot(currentPlayer.getyCoordinate(), currentPlayer.getxCoordinate());
		b.removePlayerFromSpot(currentPlayer);
	}

	/*
	 * This method is for external calls
	 */
	public boolean playerOptions(Player currentPlayer, Board b, Deck d) throws IOException {
		System.out.println("You are still in a room");
		
		if(LoungeRoom.contains(currentPlayer.getName()) || StudyRoom.contains(currentPlayer.getName()) || ConservatoryRoom.contains(currentPlayer.getName()) || KitchenRoom.contains(currentPlayer.getName())) {
			System.out.println("Woah a Secert Passage!");
			System.out.println("What are you going to do?"
					+ "\n 0 - Leave Room"
					+ "\n 1 - Make a Suggestion"
					+ "\n 2 - Make an Accusation!"
					+ "\n 3 - Go through the secret passage");
		}
		else {
			System.out.println("What are you going to do?" 
					+ "\n 0 - Leave Room"
					+ "\n 1 - Make a Suggestion"
					+ "\n 2 - Make an Accusation");
		}
		
		try {
			String rawInput = in.readLine();
			int input = Integer.parseInt(rawInput);
			return playerChoice(currentPlayer, input, currentPlayer.getName(), b, d);
		}
		catch(NumberFormatException ex) {
			System.out.println("We need a number, try again.");
			return false;
		}
	}
	
	/*
	 * This method is for internal calls
	 */
	public void playerOptions(Player currentPlayer, Suspects suspectsPlayerArrayList, ArrayList<Suspects> suspectNames, Board b, Deck d) throws IOException {
		if(suspectNames.size() == 1) {
			System.out.println("There is nobody here...");
		}
		else {
			System.out.println("Inside there is " + suspectNames + " wandering around inside.");
		}
		
		boolean isValidInput = false;
		while (!isValidInput) {
			if(LoungeRoom.contains(suspectsPlayerArrayList) || StudyRoom.contains(suspectsPlayerArrayList) || ConservatoryRoom.contains(suspectsPlayerArrayList) || KitchenRoom.contains(suspectsPlayerArrayList)) {
				System.out.println("Woah a Secert Passage!");
				System.out.println("What are you going to do?" 
						+ "\n 1 - Make a Suggestion"
						+ "\n 2 - Make an Accusation!"
						+ "\n 3 - Go through the secret passage");
			}
			else {
				System.out.println("What are you going to do?" 
						+ "\n 1 - Make a Suggestion"
						+ "\n 2 - Make an Accusation");
			}
			
			try {
				String rawInput = in.readLine();
				int input = Integer.parseInt(rawInput);
				isValidInput = true;
				playerChoice(currentPlayer, input, suspectsPlayerArrayList, b , d);
			}
			catch(NumberFormatException ex) {
				System.out.println("We need a number,");
			}
			
		}
	}

	private boolean playerChoice(Player currentPlayer, int input, Suspects suspectsPlayerArrayList, Board b, Deck d) throws IOException {
		switch(input) {
		case 0: // Leave Room
			boolean isValidInput = false;
			while(!isValidInput) {
				isValidInput = leaveRoom(currentPlayer, b);
				if(!isValidInput) {
					currentPlayer.setInsideRoom(true);
					break;
				}
					
			}
			return true;
		case 1:
			makeSuggestion(currentPlayer, d);
			return false ;
		case 2:
			makeAccusation(currentPlayer, d);
			return false;
		case 3:
				goThroughSecretPassage(currentPlayer, b);
			return false;
		default:
			System.out.println("That's not a valid option");
			return false;
		}
	}

	private boolean leaveRoom(Player currentPlayer, Board b) throws IOException {
		currentPlayer.setInsideRoom(false);
		
		// Single Door Rooms
		if(StudyRoom.contains(currentPlayer.getName())) {
			if(b.board[5][7] == null) {
				currentPlayer.setyCoordinate(7);
				currentPlayer.setxCoordinate(18);
				return true;
			}
			else {
				System.out.println("Someone is blocking the door!");
				return true;
			}
		}
		
		if(LoungeRoom.contains(currentPlayer.getName())) {
			if(b.board[7][18] == null) {
				currentPlayer.setyCoordinate(7);
				currentPlayer.setxCoordinate(18);
				return true;
			}
			else {
				System.out.println("Someone is blocking the door!");
				return true;
			}
		}
		
		if(KitchenRoom.contains(currentPlayer.getName())) {
			if(b.board[18][20] == null) {
				currentPlayer.setyCoordinate(18);
				currentPlayer.setxCoordinate(20);
				return true;
			}
			else {
				System.out.println("Someone is blocking the door!");
				return true;
			}
		}
		
		if(ConservatoryRoom.contains(currentPlayer.getName())) {
			if(b.board[20][6] == null) {
				currentPlayer.setyCoordinate(20);
				currentPlayer.setxCoordinate(6);
				return true;
			}
			else {
				System.out.println("Someone is blocking the door!");
				return true;
			}
		}
		
		// Two door rooms
		if(LibraryRoom.contains(currentPlayer.getName())) {
			System.out.println("Which door?" 
					+ "\n 1 - Right Side Door"
					+ "\n 2 - Bottom Side Door");
			String input = in.readLine();
			
			switch(input) {
			case "1": // Right Side
				if(b.board[9][8] != null) {
					System.out.println("Someone is blocking the door!");
					return true;
				}
				currentPlayer.setyCoordinate(9);
				currentPlayer.setxCoordinate(8);
				return true;
			case "2": // Bottom Side
				if(b.board[11][4] != null) {
					System.out.println("Someone is blocking the door!");
					return true;
				}
				currentPlayer.setyCoordinate(11);
				currentPlayer.setxCoordinate(4);
				return true;
			default:
				System.out.println("Not a valid input");
				break;
			}
			
		}
		
		if(BilliardRoomList.contains(currentPlayer.getName())) {
			System.out.println("Which door?" 
					+ "\n 1 - Top Side Door"
					+ "\n 2 - Right Side Door");
			String input = in.readLine();
			
			switch(input) {
			case "1": // Top Side
				if(b.board[12][2] != null) {
					System.out.println("Someone is blocking the door!");
					return true;
				}
				currentPlayer.setyCoordinate(12);
				currentPlayer.setxCoordinate(2);
				return true;
			case "2": // Bottom Side
				if(b.board[16][7] != null) {
					System.out.println("Someone is blocking the door!");
					return true;
				}
				currentPlayer.setyCoordinate(16);
				currentPlayer.setxCoordinate(7);
				return true;
			default:
				System.out.println("Not a valid input");
				break;
			}
		}
		
		if(DiningRoom.contains(currentPlayer.getName())) {
			System.out.println("Which door?" 
					+ "\n 1 - Left Side Door"
					+ "\n 2 - Top Side Door");
			String input = in.readLine();
			
			switch(input) {
			case "1": // Left Side
				if(b.board[13][16] != null) {
					System.out.println("Someone is blocking the door!");
					return true;
				}
				currentPlayer.setyCoordinate(13);
				currentPlayer.setxCoordinate(16);
				return true;
			case "2": // Top Side
				if(b.board[9][18] != null) {
					System.out.println("Someone is blocking the door!");
					return true;
				}
				currentPlayer.setyCoordinate(9);
				currentPlayer.setxCoordinate(18);
				return true;
			default:
				System.out.println("Not a valid input");
				break;
			}
		}
		
		// Three door rooms
		if(HallRoom.contains(currentPlayer.getName())) {
			System.out.println("Which door?" 
					+ "\n 1 - Left Side Door"
					+ "\n 2 - Bottom Left Side Door"
					+ "\n 3 - Bottom Right Side Door");
			String input = in.readLine();
			
			switch(input) {
			case "1": // Left Side
				if(b.board[5][9] != null) {
					System.out.println("Someone is blocking the door!");
					return true;
				}
				currentPlayer.setyCoordinate(5);
				currentPlayer.setxCoordinate(9);
				return true;
			case "2": // Bottom Left Side Door
				if(b.board[8][12] != null) {
					System.out.println("Someone is blocking the door!");
					return true;
				}
				currentPlayer.setyCoordinate(8);
				currentPlayer.setxCoordinate(12);
				return true;
			case "3": // Bottom Right Side Door
				if(b.board[8][13] != null) {
					System.out.println("Someone is blocking the door!");
					return true;
				}
				currentPlayer.setyCoordinate(8);
				currentPlayer.setxCoordinate(13);
				return true;
			default:
				System.out.println("Not a valid input");
				break;
			}
		}
		
		// Four door room
		if(BallRoom.contains(currentPlayer.getName())) {
			System.out.println("Which door?" 
					+ "\n 1 - Left Side Door"
					+ "\n 2 - Top Left Side Door"
					+ "\n 3 - Top Right Side Door"
					+ "\n 4 - Right Side Door");
			String input = in.readLine();
			
			switch(input) {
			case "1": // Left Side
				if(b.board[20][9] != null) {
					System.out.println("Someone is blocking the door!");
					return true;
				}
				currentPlayer.setyCoordinate(20);
				currentPlayer.setxCoordinate(9);
				return true;
			case "2": // Top Left Side Door
				if(b.board[17][10] != null) {
					System.out.println("Someone is blocking the door!");
					return true;
				}
				currentPlayer.setyCoordinate(17);
				currentPlayer.setxCoordinate(10);
				return true;
			case "3": // Top Right Side Door
				if(b.board[17][15] != null) {
					System.out.println("Someone is blocking the door!");
					return true;
				}
				currentPlayer.setyCoordinate(17);
				currentPlayer.setxCoordinate(15);
				return true;
			case "4": // Top Right Side Door
				if(b.board[20][17] != null) {
					System.out.println("Someone is blocking the door!");
					return true;
				}
				currentPlayer.setyCoordinate(20);
				currentPlayer.setxCoordinate(17);
				return true;
			default:
				System.out.println("Not a valid input");
				break;
			}
		}
		return false;
	}

	private void goThroughSecretPassage(Player currentPlayer, Board b) throws IOException {
		for(int i=0; i<1; i++) {
			if(LoungeRoom.contains(currentPlayer.getName())) {
				ConservatoryRoom.add(currentPlayer.getName());
				LoungeRoom.remove(currentPlayer.getName());
				break;
			}
			if(ConservatoryRoom.contains(currentPlayer.getName())) {
				LoungeRoom.add(currentPlayer.getName());
				ConservatoryRoom.remove(currentPlayer.getName());
				break;
			}
			
			if(StudyRoom.contains(currentPlayer.getName())) {
				KitchenRoom.add(currentPlayer.getName());
				StudyRoom.remove(currentPlayer.getName());
				break;
			}
			
			if(KitchenRoom.add(currentPlayer.getName())) {
				StudyRoom.add(currentPlayer.getName());
				KitchenRoom.remove(currentPlayer.getName());
				break;
			}
		}
		
		
		
	}

	private void makeAccusation(Player currentPlayer, Deck d) throws IOException {
		String roomSuggestion = roomSuggestionChoiceAccusation(currentPlayer);
		String weaponSuggestion = weaponSuggestionChoice();
		String suspectSuggestion = suspectSuggestionChoice(roomSuggestion, weaponSuggestion);
		
		if(checkSuggestion(roomSuggestion, weaponSuggestion, suspectSuggestion, d)) {
			System.exit(0);
		}
		else {
			System.out.println("Your lack of evidence costed you greatly! \n" 
					+ "You're off the case!");
			currentPlayer.setCanPlayAgain(false);
		}
	}

	private void makeSuggestion(Player currentPlayer, Deck d) throws IOException {
		String roomSuggestion = roomSuggestionChoice(currentPlayer);
		String weaponSuggestion = weaponSuggestionChoice();
		String suspectSuggestion = suspectSuggestionChoice(roomSuggestion, weaponSuggestion);
		
		if(checkSuggestion(roomSuggestion, weaponSuggestion, suspectSuggestion, d)) {
			System.exit(0);
		}
	}

	private String roomSuggestionChoiceAccusation(Player currentPlayer) throws IOException {
		boolean isValidInput = false;
		while(!isValidInput) {
			System.out.println("The murder happened in the..."
					+ "\n 1 - Study"
					+ "\n 2 - Hall"
					+ "\n 3 - Lounge"
					+ "\n 4 - Dining Room"
					+ "\n 5 - Billiard Room"
					+ "\n 6 - Conservatory"
					+ "\n 7 - Ballroom"
					+ "\n 8 - Kitchen");
			String weaponSuggestionRawInput = in.readLine();
			switch(weaponSuggestionRawInput) {
			case "1":
				isValidInput = true;
				return "Study";
			case "2":
				isValidInput = true;
				return "Hall";
			case "3":
				isValidInput = true;
				return "Lounge";
			case "4":
				isValidInput = true;
				return "DiningRoom";
			case "5":
				isValidInput = true;
				return "BilliardRoom";
			case "6":
				isValidInput = true;
				return "Conservatory";
			case "7":
				isValidInput = true;
				return "BallRoom";
			case "8":
				isValidInput = true;
				return "Kitchen";
			default:
				System.out.println("Thats not a valid option");
			}
		}
		return null;
	}
	
	private String roomSuggestionChoice(Player currentPlayer) {
		System.out.print("The murder was done in the ");
		if(LoungeRoom.contains(currentPlayer.getName())) {
			System.out.println("Lounge,");
			return "Lounge";
		}
		if(StudyRoom.contains(currentPlayer.getName())) {
			System.out.println("Study,");
			return "Study";
		}
		if(HallRoom.contains(currentPlayer.getName())) {
			System.out.println("Hall,");
			return "Hall";
		}
		if(DiningRoom.contains(currentPlayer.getName())) {
			System.out.println("Dining Room,");
			return "DiningRoom";
		}
		if(BilliardRoomList.contains(currentPlayer.getName())) {
			System.out.println("Billiard Room,");
			return "BilliardRoom";
		}
		if(KitchenRoom.contains(currentPlayer.getName())) {
			System.out.println("Kitchen,");
			return "Kitchen";
		}
		if(ConservatoryRoom.contains(currentPlayer.getName())) {
			System.out.println("Conservatory,");
			return "Conservatory";
		}
		if(BallRoom.contains(currentPlayer.getName())) {
			System.out.println("Ballroom,");
			return "BallRoom";
		}
		return null;
	}

	private String weaponSuggestionChoice() throws IOException {
		boolean isValidInput = false;
		while(!isValidInput) {
			System.out.println("With a..." 
					+ "\n 1 - Rope"
					+ "\n 2 - Lead Pipe"
					+ "\n 3 - Knife"
					+ "\n 4 - Wrench"
					+ "\n 5 - CandleStick"
					+ "\n 6 - Pistol");
			String weaponSuggestionRawInput = in.readLine();
			switch(weaponSuggestionRawInput) {
			case "1":
				return "Rope";
			case "2":
				return "LeadPipe";
			case "3":
				return "Knife";
			case "4":
				return "Wrench";
			case "5":
				return "CandleStick";
			case "6":
				return "Pistol";
			default:
				System.out.println("Thats not a valid option");
			}
		}
		return null;
		
	}

	private String suspectSuggestionChoice(String roomSuggestion, String weaponSuggestion) throws IOException {
		System.out.println("The murder was done in the " + roomSuggestion + " With a " + weaponSuggestion + "?"
				+ "\nBut by who?"
				+ "\n 1 - Miss Scarlet"
				+ "\n 2 - Mrs White"
				+ "\n 3 - Mrs Peacock"
				+ "\n 4 - Colonel Mustard"
				+ "\n 5 - Professor Plum"
				+ "\n 6 - Mr Green");
		String suspectSuggestionRawInput = in.readLine();
		switch(suspectSuggestionRawInput) {
		case "1":
			return "Miss_Scarlet";
		case "2":
			return "Mrs_White";
		case "3":
			return "Mrs_Peacock";
		case "4":
			return "Colonel_Mustard";
		case "5":
			return "Professor_Plum";
		case "6":
			return "Mr_Green";
		default:
			System.out.println("Thats not a valid option");
		}
		return null;
	}

	
	private boolean checkSuggestion(String roomSuggestion, String weaponSuggestion, String suspectSuggestion, Deck d) {
		if(d.confidential.contains(roomSuggestion) && d.confidential.contains(weaponSuggestion) && d.confidential.contains(suspectSuggestion)) {
			System.out.println("The murder has been solved! Case closed!");
			return true;
		}
		else {
			System.out.println("Wrong, you don't have enough evidence to support that");
			return false;
		}
	}
}
