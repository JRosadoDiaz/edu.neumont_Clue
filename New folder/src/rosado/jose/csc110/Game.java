package rosado.jose.csc110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Game {
	private BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	private int numberOfPlayers = 0;

	private Random generator = new Random();
	
	private int dice = 0;
	
	public Player player1;
	
	public Player player2;
	
	public Player player3;
	
	public Player player4;
	
	public Player player5;
	
	public Player player6;

	/*
	 * This will create all the setup required
	 * First by setting up the base board design
	 * Then the deck is sorted out
	 * The Rooms are given the weapons to 6 random rooms
	 * Now the players are created by asking for how many players
	 * Lastly before the game starts we ask players for their names
	 */
	public void play() throws IOException {
		Board b = new Board();
		b.setupBoard();
		
		Deck d = new Deck();
		d.choseConfidential();
		
		RoomLogic r = new RoomLogic();
		r.placeWeapons();
		
		howManyPlayers();

		createPlayerList();
		askPlayersForNames();
		
		// This will determine how the cards are sent to each player
		switch(numberOfPlayers) {
			case 2:
				shuffleCards(player1, d);
				shuffleCards(player2, d);
				break;
			case 3:
				shuffleCards(player1, d);
				shuffleCards(player2, d);
				shuffleCards(player3, d);
				break;
			case 4:
				shuffleCards(player1, d);
				shuffleCards(player2, d);
				shuffleCards(player3, d);
				shuffleCards(player4, d);
				checkForCardRemainders(d);
				break;
			case 5:
				shuffleCards(player1, d);
				shuffleCards(player2, d);
				shuffleCards(player3, d);
				shuffleCards(player4, d);
				shuffleCards(player5, d);
				checkForCardRemainders(d);
				break;
			case 6:
				shuffleCards(player1, d);
				shuffleCards(player2, d);
				shuffleCards(player3, d);
				shuffleCards(player4, d);
				shuffleCards(player5, d);
				shuffleCards(player6, d);
				break;
			default:
				System.out.println("should never happen");
		}
			
		// boardTranslations are used as a safety measure to reprint the board after a players last move
		// This will determine turn order depending on number of players
		while(true) {
			if(numberOfPlayers >= 2) {
				playerTurn(player1, b, r, DiceRoll(), d);
				b.boardTranslations();
				
				playerTurn(player2, b, r, DiceRoll(), d);
				b.boardTranslations();
				
				if(numberOfPlayers >= 3) {
					playerTurn(player3, b, r, DiceRoll(), d);
					b.boardTranslations();
					
					if(numberOfPlayers >= 4) {
						playerTurn(player4, b, r, DiceRoll(), d);
						b.boardTranslations();
						
						if(numberOfPlayers >= 5) {
							playerTurn(player5, b, r, DiceRoll(), d);
							b.boardTranslations();
							
							if(numberOfPlayers == 6) {
								playerTurn(player6, b, r, DiceRoll(), d);
								b.boardTranslations();
							} // End of 6 players
						} // End of 5 players
					} // End of 4 players
				} // End of 3 players
			} // End of 2 players
		} // End of WHILE loop
	} // End of method
	
	/*
	 * This creates the cast of characters and their starting positions
	 * there will be a method after player 1 is made to ask how many players there will be
	 * Clue must have a minimum of 2 players
	 * and a maximum of 6 players total
	 */
	public void createPlayerList() throws IOException {
		player1 = new Player();
		player1.setName(Suspects.Miss_Scarlet);
		player1.setxCoordinate(17);
		player1.setyCoordinate(1);
				
		player2 = new Player();
		player2.setxCoordinate(23);
		player2.setyCoordinate(8);
		
		player3 = new Player();
		player3.setxCoordinate(15);
		player3.setyCoordinate(25);
		
		player4 = new Player();
		player4.setxCoordinate(10);
		player4.setyCoordinate(25);
		
		player5 = new Player();
		player5.setxCoordinate(1);
		player5.setyCoordinate(19);
		
		player6 = new Player();
		player6.setxCoordinate(1);
		player6.setyCoordinate(6);
	}
	
	/*
	 * When the game starts the players will be asked to set their name
	 * depending on the numberOfPlayers int will determine how many people will choose
	 * with each choice their name is removed from the list of available people
	 * when all players have chosen, if there are any remainders they will be randomized among the cpu
	 */
	private void askPlayersForNames() throws IOException {
		ArrayList<Suspects> suspectNames = new ArrayList<>();
		suspectNames.add(Suspects.Colonel_Mustard);
		suspectNames.add(Suspects.Mr_Green);
		suspectNames.add(Suspects.Mrs_Peacock);
		suspectNames.add(Suspects.Mrs_White);
		suspectNames.add(Suspects.Professor_Plum);
		
		System.out.println("Player 1, you will be Miss Scarlet \n");
		
		if(numberOfPlayers == 2) {
			System.out.print("Player 2");
			playersChooseTheirName(player2, suspectNames);
			randomizeRemainingNames(suspectNames);
		}
			
		if(numberOfPlayers == 3) {
			System.out.print("Player 2");
			playersChooseTheirName(player2, suspectNames);
			System.out.print("Player 3");
			playersChooseTheirName(player3, suspectNames);
			randomizeRemainingNames(suspectNames);
		}
		
		if(numberOfPlayers == 4) {
			System.out.print("Player 2");
			playersChooseTheirName(player2, suspectNames);
			System.out.println();
			
			System.out.print("Player 3");
			playersChooseTheirName(player3, suspectNames);
			System.out.println();
			
			System.out.print("Player 4");
			playersChooseTheirName(player4, suspectNames);
			randomizeRemainingNames(suspectNames);
		}
		
		if(numberOfPlayers == 5) {
			System.out.print("Player 2");
			playersChooseTheirName(player2, suspectNames);
			System.out.println();
			
			System.out.print("Player 3");
			playersChooseTheirName(player3, suspectNames);
			System.out.println();
			
			System.out.print("Player 4");
			playersChooseTheirName(player4, suspectNames);
			System.out.println();
			
			System.out.print("Player 5");
			playersChooseTheirName(player5, suspectNames);
			randomizeRemainingNames(suspectNames);
		}
		
		if(numberOfPlayers == 6) {
			System.out.print("Player 2");
			playersChooseTheirName(player2, suspectNames);
			System.out.println();
			
			System.out.print("Player 3");
			playersChooseTheirName(player3, suspectNames);
			System.out.println();
			
			System.out.print("Player 4");
			playersChooseTheirName(player4, suspectNames);
			System.out.println();
			
			System.out.print("Player 5");
			playersChooseTheirName(player5, suspectNames);
			System.out.println();
			
			System.out.println("Player 6, Your name will be " + suspectNames.get(0) + "\n");
			player6.setName(suspectNames.get(0));
		}
	}

	/*
	 * This method is tied to askPlayersForNames()
	 * It will randomize the remaining list of names depending on the number of players
	 */
	private void randomizeRemainingNames(ArrayList<Suspects> suspectNames) {
		if(numberOfPlayers <= 5) {
			int gen = generator.nextInt(suspectNames.size());
			player6.setName(suspectNames.get(gen));
			suspectNames.remove(gen);
			
			if(numberOfPlayers <= 4) {
				gen = generator.nextInt(suspectNames.size());
				player5.setName(suspectNames.get(gen));
				suspectNames.remove(gen);
			
				if(numberOfPlayers <= 3) {
					gen = generator.nextInt(suspectNames.size());
					player4.setName(suspectNames.get(gen));
					suspectNames.remove(gen);
			
					if(numberOfPlayers == 2) {
						gen = generator.nextInt(suspectNames.size());
						player3.setName(suspectNames.get(gen));
						suspectNames.remove(gen);
					}
				}
			}
		}
	}

	private void playersChooseTheirName(Player currentPlayer, ArrayList<Suspects> suspectNames) throws IOException {
		boolean isValidInput = false;
		while(!isValidInput) {
			try {
				System.out.println(", what will your name be? Here are your options:");
				
				for(int i=0; i<suspectNames.size(); i++) {
					System.out.println((i+1) + " = " + suspectNames.get(i));
				}
				
				String rawInput = in.readLine();
				int input = Integer.parseInt(rawInput) - 1;
				
				currentPlayer.setName(suspectNames.get(input));
				suspectNames.remove(input);
				
				isValidInput = true;
			}
			catch (NumberFormatException ex) {
				System.out.println("That is not a valid option, try again");
			}
		}
		
	}

	/*
	 * This method will shuffle cards
	 * It is done by calling the Deck class' fullList of strings
	 * First by getting a random index number from fullList
	 * Adding that random index to the currentPlayer's hand ArrayList
	 * and then removing that random index number from fullList
	 * The amount of cards that is given to each player is separated by numberOfPlayers
	 */
	private void shuffleCards(Player currentPlayer, Deck d) {
		if(numberOfPlayers == 2) {
			// This will add a random card from the full list onto the players hand
			for(int i=0; i<9; i++) {
				int randomCard = d.generateNumberForCards(d.fullCardList);
				currentPlayer.hand.add(d.fullCardList.get(randomCard));
				d.fullCardList.remove(randomCard);
			}
		}
		else if(numberOfPlayers == 3) {
			for(int i=0; i<6; i++) {
				int randomCard = d.generateNumberForCards(d.fullCardList);
				currentPlayer.hand.add(d.fullCardList.get(randomCard));
				d.fullCardList.remove(randomCard);
			}
		}
		else if(numberOfPlayers == 4) {
			for(int i=0; i<4; i++) {
				int randomCard = d.generateNumberForCards(d.fullCardList);
				currentPlayer.hand.add(d.fullCardList.get(randomCard));
				d.fullCardList.remove(randomCard);
			}
		}
		else if(numberOfPlayers == 5) {
			for(int i=0; i<3; i++) {
				int randomCard = d.generateNumberForCards(d.fullCardList);
				currentPlayer.hand.add(d.fullCardList.get(randomCard));
				d.fullCardList.remove(randomCard);
			}
		}
		else if(numberOfPlayers == 6) {
			for(int i=0; i<3; i++) {
				int randomCard = d.generateNumberForCards(d.fullCardList);
				currentPlayer.hand.add(d.fullCardList.get(randomCard));
				d.fullCardList.remove(randomCard);
			}
		}
	}
	
	/*
	 * This method deals with how the game deals cards to players that don't divide evenly
	 * Each player is given one card at a time
	 * Until the all the cards are dealt
	 */
	private void checkForCardRemainders(Deck d) {
		if(numberOfPlayers >= 4) {
			int randomCard = d.generateNumberForCards(d.fullCardList);
			player1.hand.add(d.fullCardList.get(randomCard));
			d.fullCardList.remove(randomCard);
			
			randomCard = d.generateNumberForCards(d.fullCardList);
			player2.hand.add(d.fullCardList.get(randomCard));
			d.fullCardList.remove(randomCard);
			
			if(numberOfPlayers == 5) {
				randomCard = d.generateNumberForCards(d.fullCardList);
				player3.hand.add(d.fullCardList.get(randomCard));
				d.fullCardList.remove(randomCard);
			}
		}
	}
	
	/*
	 * This method will ask the user at the start how many players will there be
	 * There will also be another method inside asking who the players (except player 1) would like to be
	 * player 1 is always Miss Scarlet
	 */
	private void howManyPlayers() throws IOException {
		boolean isValidInput = false;
		while(!isValidInput) {
			System.out.println("How many players are playing?" 
					+ "\n 2 players"
					+ "\n 3 players"
					+ "\n 4 players"
					+ "\n 5 players"
					+ "\n 6 players");
			try {
				String rawInput = in.readLine();
				numberOfPlayers = Integer.parseInt(rawInput);
			}
			catch(NumberFormatException ex) {
				System.out.println("We need a number,");
			}
			if(numberOfPlayers < 2 || numberOfPlayers > 6) {
				System.out.println("This game is up to a minimum of 2 and a maximum of 6 players, pick again");
			}
			else {
				isValidInput = true;
			}
		}
	}

	/*
	 * This method will contain all the code and methods that constitute a player turn
	 *  - A dice roll with two die to determine how many spaces a player can move
	 *  - Display the amount of available spaces remaining
	 *  - Player movement and checking collision
	 *  - Refreshing the board after a move has been made
	 *  - Checking for and entering a room
	 *  - room logic (which includes accusations and shortcuts)
	 */
	private void playerTurn(Player currentPlayer, Board b, RoomLogic r, int diceRoll, Deck d) throws IOException {
		if(currentPlayer.isCanPlayAgain()) {
			// This is to save the dice roll in case a player wants to retry moving their piece
			dice = diceRoll;
			// First the dice is rolled and the players available moves be according to the players roll
			if(!currentPlayer.isInsideRoom()) {
				saveCurrentSpot(currentPlayer, b);
				
				//This loop contains the number a times a player can move according to their dice roll
				for(int i=diceRoll; i>0; i--) {
					placePlayers(b);
					System.out.println("\n" + "Hello " + currentPlayer.getName() + ",");
					System.out.println();
					System.out.println("Your Hand: " + currentPlayer.hand + "\n \n"
							+ "You rolled a " + diceRoll + "\n"
							+ "You have " + i + " more spaces to move");
					
					// This WHILE loop is for the sake of re-prompting the player for a valid answer
					boolean isValidInput = false;
					while(!isValidInput) {
						try {
							playerMovement(currentPlayer, b, r, i, d);
							isValidInput = true;
							if(currentPlayer.isInsideRoom()) {
								i = 0;
							}
						}
						catch(NumberFormatException ex) {
							System.out.println("That's not an option. Try again");
						}
					}
				}
				if(!currentPlayer.isInsideRoom()) {
					// A player cannot move again once they've entered a room
					askForResetMovement(currentPlayer, b, r, d);
				}
			}
			else {
				if(r.playerOptions(currentPlayer, b, d)) {
					playerTurn(currentPlayer, b, r, DiceRoll(), d);
				}
			}
		}
	}
	
	/*
	 * This method contains the logic for player movement
	 * First the method will prompt for a direction
	 * Then based on the input the method will do several checks
	 *  - First checks for a free space in the desired location
	 *  - If space is empty, remove the current position of the characters Enum
	 *  - then change the players coordinates accordingly and sets the Enum position on the board
	 *  - An invalid input will not count towards the dice roll counter, allowing for safe errors
	 */
	private void playerMovement(Player currentPlayer, Board b, RoomLogic r, int spacesRemaining, Deck d) throws IOException {
		
		if(!currentPlayer.isInsideRoom()) {
			boolean isValidInput = false;
			while(!isValidInput) {
				if(checkForRoom(currentPlayer, b)) {
					System.out.println("You found a room! \n"
							+ "Where do you want to move?"
							+ "\n 1 = Up"
							+ "\n 2 = Left" 
							+ "\n 3 = Down"
							+ "\n 4 = Right"
							+ "\n 5 = Enter Room"
							+ "\n Press '9' to access your notepad");
				}
				else {
					System.out.println("Where do you want to move?"
							+ "\n 1 = Up"
							+ "\n 2 = Left" 
							+ "\n 3 = Down"
							+ "\n 4 = Right"
							+ "\n Press '9' to access your notepad");
				}
				String rawInput = in.readLine();
				int input = Integer.parseInt(rawInput);
					
				/*
				 * Eventually, there needs to be a method to check for a room
				 * Once there is a room, ask player if they wish to enter (likely by adding the option to the movement menu)
				 */
				
				switch(input) {
					case 1:
						// Up
						if(b.isEmpty(currentPlayer, input)) {
							b.removePreviousSpot(currentPlayer.getyCoordinate(), currentPlayer.getxCoordinate());
							currentPlayer.setyCoordinate(currentPlayer.getyCoordinate() - 1);
							isValidInput = true;
						}
						else {
							System.out.println("You can't move here! There is a " + b.board[currentPlayer.getyCoordinate() +1][currentPlayer.getxCoordinate()] + " there! try again.");
						}
						break;
					case 2:
						// Left
						if(b.isEmpty(currentPlayer, input)) {
							b.removePreviousSpot(currentPlayer.getyCoordinate(), currentPlayer.getxCoordinate());
							currentPlayer.setxCoordinate(currentPlayer.getxCoordinate() - 1);
							isValidInput = true;
						}
						else {
							System.out.println("You can't move here! There is " + b.board[currentPlayer.getyCoordinate() +1][currentPlayer.getxCoordinate()] + " there! try again.");
						}
						break;
					case 3:
						// Down
						if(b.isEmpty(currentPlayer, input)) {
							b.removePreviousSpot(currentPlayer.getyCoordinate(), currentPlayer.getxCoordinate());
							currentPlayer.setyCoordinate(currentPlayer.getyCoordinate() + 1);
							isValidInput = true;
						}
						else {
							System.out.println("You can't move here! There is " + b.board[currentPlayer.getyCoordinate() +1][currentPlayer.getxCoordinate()] + " there! try again.");
						}
						break;
					case 4:
						// Right
						if(b.isEmpty(currentPlayer, input)) {
							b.removePreviousSpot(currentPlayer.getyCoordinate(), currentPlayer.getxCoordinate());
							currentPlayer.setxCoordinate(currentPlayer.getxCoordinate() + 1);
							isValidInput = true;
						}
						else {
							System.out.println("You can't move here! There is something already there! try again.");
						}
						break;
					case 5:
						// Enter Room
						if(checkForRoom(currentPlayer, b)) {
							// The player is on a doorway
							roomLogicMagic(currentPlayer, b, r, d);
							isValidInput = true;
							break;
						}
						else {
							System.out.println("That's not a valid coordinate");
						}
					case 9:
						useNotePad(currentPlayer);
						break;
					default:
						System.out.println("Please select a valid coordinate");
				} // End of Switch
			} // End of WHILE loop
		}// End of IF statement
		else {
			r.playerOptions(currentPlayer, b, d);
		}
	} // End of method
	
	private void useNotePad(Player currentPlayer) throws IOException {
		System.out.println("Your notes:");
		for(int i=0; i<currentPlayer.getNotepad().size(); i++) {
			System.out.println((i+1) + " - " +currentPlayer.getNotepad().get(i));
		}
		System.out.println("Press enter after leaving a note");
		String newNotepadEntry = in.readLine();
		if(newNotepadEntry != null && newNotepadEntry.length()>0) {
			currentPlayer.getNotepad().add(newNotepadEntry);
			System.out.println("Note added!");
		}
		else {
			System.out.println("Nothing new added.");
		}
	}

	/*
	 * This Method will ask the player to reset their position
	 * This will be used when a player's last space has been made
	 * If the player says yes then the players piece will move to where it was originally save in
	 * Then the board reprints and the player starts their turn again with the same dice count
	 */
	private void askForResetMovement(Player currentPlayer, Board b, RoomLogic r, Deck d) throws IOException {
		placePlayers(b);
		
		boolean isValidInput = false;
		while(!isValidInput) {
			if(!currentPlayer.isInsideRoom()) {
				System.out.println("\n" + "Its the end of your turn, \n" 
						+ "did you want to reset your position and move again? (y/n)");
				if(checkForRoom(currentPlayer, b)) {
					System.out.println("there is also a room you can enter nearby (1)");
				}
				String input = in.readLine();
				switch(input) {
				case "1":
					roomLogicMagic(currentPlayer, b, r, d);
					break;
				case "y":
					b.removePreviousSpot(currentPlayer.getyCoordinate(), currentPlayer.getxCoordinate());
					currentPlayer.setxCoordinate(currentPlayer.getPreviousxCoordinate());
					currentPlayer.setyCoordinate(currentPlayer.getPreviousyCoordinate());
					placePlayers(b);
					System.out.println();
					playerTurn(currentPlayer, b, r, dice, d);
					isValidInput = true;
					break;
				case "n":
					System.out.println("\n" + "Okay, onto the next Player!");
					isValidInput = true;
					break;
				default:
					System.out.println("Not a valid answer");
					break;
				}
			}
			else {
				isValidInput = true;
			}
		}
	}

	private void saveCurrentSpot(Player currentPlayer, Board b) {
		currentPlayer.setPreviousxCoordinate(currentPlayer.getxCoordinate());
		currentPlayer.setPreviousyCoordinate(currentPlayer.getyCoordinate());
	}

	private int DiceRoll() {
		int max = 12;
		int min = 2;
		return generator.nextInt(max + 1 - min) + min;
	}

	/*
	 * This Method will set all player locations and refresh the board
	 */
	private void placePlayers(Board b) {
		b.setPlayerLocation(player1);
		b.setPlayerLocation(player2);
		b.setPlayerLocation(player3);
		b.setPlayerLocation(player4);
		b.setPlayerLocation(player5);
		b.setPlayerLocation(player6);
		b.boardTranslations();
		b.printBoard();
	}
	
	/*
	 * This will return a boolean
	 * By checking if the player is on top of a door way
	 * by checking its location through the roomLocation[][] where all the doorway positions are
	 */
	private boolean checkForRoom(Player currentPlayer, Board b) {
		for(int i=0; i<27; i++) {
			for(int j=0; j<25; j++) {
				if(b.roomLocation[currentPlayer.getyCoordinate()][currentPlayer.getxCoordinate()] == Rooms.Study) {
					return true;
				}
				if(b.roomLocation[currentPlayer.getyCoordinate()][currentPlayer.getxCoordinate()] == Rooms.Hall) {
					return true;
				}
				if(b.roomLocation[currentPlayer.getyCoordinate()][currentPlayer.getxCoordinate()] == Rooms.Lounge) {
					return true;
				}
				if(b.roomLocation[currentPlayer.getyCoordinate()][currentPlayer.getxCoordinate()] == Rooms.Library) {
					return true;
				}
				if(b.roomLocation[currentPlayer.getyCoordinate()][currentPlayer.getxCoordinate()] == Rooms.DiningRoom) {
					return true;
				}
				if(b.roomLocation[currentPlayer.getyCoordinate()][currentPlayer.getxCoordinate()] == Rooms.BilliardRoom) {
					return true;
				}
				if(b.roomLocation[currentPlayer.getyCoordinate()][currentPlayer.getxCoordinate()] == Rooms.Conservatory) {
					return true;
				}
				if(b.roomLocation[currentPlayer.getyCoordinate()][currentPlayer.getxCoordinate()] == Rooms.BallRoom) {
					return true;
				}
				if(b.roomLocation[currentPlayer.getyCoordinate()][currentPlayer.getxCoordinate()] == Rooms.Kitchen) {
					return true;
				}
			}
		}
		return false;
	}

	private void roomLogicMagic(Player currentPlayer, Board b, RoomLogic r, Deck d) throws IOException {
		if(b.roomLocation[currentPlayer.getyCoordinate()][currentPlayer.getxCoordinate()] == Rooms.Study) {
			System.out.println("You entered the Study!");
			if(r.StudyRoomWeapon.size() == 0) {
				System.out.println("There's nothing of interest here...");
			}
			else {
				System.out.println("There is a " + r.StudyRoomWeapon + " here");
			}
			r.movePlayersToRoom(currentPlayer, b, d);
			b.removePreviousSpot(currentPlayer.getyCoordinate(), currentPlayer.getxCoordinate());
		}
		if(b.roomLocation[currentPlayer.getyCoordinate()][currentPlayer.getxCoordinate()] == Rooms.BallRoom) {
			System.out.println("You entered the BallRoom!");
			if(r.BallRoomWeapon.size() == 0) {
				System.out.println("There's nothing of interest here...");
			}
			else {
				System.out.println("There is a " + r.BallRoomWeapon + " here");
			}
			r.movePlayersToRoom(currentPlayer, b, d);
			b.removePreviousSpot(currentPlayer.getyCoordinate(), currentPlayer.getxCoordinate());
		}
		if(b.roomLocation[currentPlayer.getyCoordinate()][currentPlayer.getxCoordinate()] == Rooms.BilliardRoom) {
			System.out.println("You entered the Billiard Room!");
			if(r.BilliardRoomWeapon.size() == 0) {
				System.out.println("There's nothing of interest here...");
			}
			else {
				System.out.println("There is a " + r.BilliardRoomWeapon + " here");
			}
			r.movePlayersToRoom(currentPlayer, b, d);
			b.removePreviousSpot(currentPlayer.getyCoordinate(), currentPlayer.getxCoordinate());
		}
		if(b.roomLocation[currentPlayer.getyCoordinate()][currentPlayer.getxCoordinate()] == Rooms.Conservatory) {
			System.out.println("You entered the Conservatory!");
			if(r.ConservatoryWeapon.size() == 0) {
				System.out.println("There's nothing of interest here...");
			}
			else {
				System.out.println("There is a " + r.ConservatoryWeapon + " here");
			}
			r.movePlayersToRoom(currentPlayer, b, d);
			b.removePreviousSpot(currentPlayer.getyCoordinate(), currentPlayer.getxCoordinate());
		}
		if(b.roomLocation[currentPlayer.getyCoordinate()][currentPlayer.getxCoordinate()] == Rooms.DiningRoom) {
			System.out.println("You entered the Dining Room!");
			if(r.DiningRoomWeapon.size() == 0) {
				System.out.println("There's nothing of interest here...");
			}
			else {
				System.out.println("There is a " + r.DiningRoomWeapon + " here");
			}
			r.movePlayersToRoom(currentPlayer, b, d);
			b.removePreviousSpot(currentPlayer.getyCoordinate(), currentPlayer.getxCoordinate());
		}
		if(b.roomLocation[currentPlayer.getyCoordinate()][currentPlayer.getxCoordinate()] == Rooms.Hall) {
			System.out.println("You entered the hall!");
			if(r.HallRoomWeapon.size() == 0) {
				System.out.println("There's nothing of interest here...");
			}
			else {
				System.out.println("There is a " + r.HallRoomWeapon + " here");
			}
			r.movePlayersToRoom(currentPlayer, b, d);
			b.removePreviousSpot(currentPlayer.getyCoordinate(), currentPlayer.getxCoordinate());
		}
		if(b.roomLocation[currentPlayer.getyCoordinate()][currentPlayer.getxCoordinate()] == Rooms.Kitchen) {
			System.out.println("You entered the Kitchen!");
			if(r.KitchenRoomWeapon.size() == 0) {
				System.out.println("There's nothing of interest here...");
			}
			else {
				System.out.println("There is a " + r.KitchenRoomWeapon + " here");
			}
			r.movePlayersToRoom(currentPlayer, b, d);
			b.removePreviousSpot(currentPlayer.getyCoordinate(), currentPlayer.getxCoordinate());
		}
		if(b.roomLocation[currentPlayer.getyCoordinate()][currentPlayer.getxCoordinate()] == Rooms.Library) {
			System.out.println("You entered the Library!");
			if(r.LibraryRoomWeapon.size() == 0) {
				System.out.println("There's nothing of interest here...");
			}
			else {
				System.out.println("There is a " + r.LibraryRoomWeapon + " here");
			}
			r.movePlayersToRoom(currentPlayer, b, d);
			b.removePreviousSpot(currentPlayer.getyCoordinate(), currentPlayer.getxCoordinate());
		}
		if(b.roomLocation[currentPlayer.getyCoordinate()][currentPlayer.getxCoordinate()] == Rooms.Lounge) {
			System.out.println("You have entered the Lounge!");
			if(r.LoungeRoomWeapon.size() == 0) {
				System.out.println("There's nothing of interest here...");
			}
			else {
				System.out.println("There is a " + r.LoungeRoomWeapon + " here");
			}
			r.movePlayersToRoom(currentPlayer, b, d);
			b.removePreviousSpot(currentPlayer.getyCoordinate(), currentPlayer.getxCoordinate());
		}
	}
} // End of class
