package rosado.jose.csc110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	 * This creates the cast of characters and their starting positions
	 * there will be a method after player 1 is made to ask how many players there will be
	 * Clue must have a minimum of 2 players
	 * and a maximum of 6 players total
	 */
	public void createPlayerList() {
		player1 = new Player();
		player1.setName(Suspects.Miss_Scarlet);
		player1.setxCoordinate(17);
		player1.setyCoordinate(1);
		
		/*
		 * The names past player1 will be put under a new method
		 * That starts giving other players the choice of who they want to be
		 * The process will be done doing an ArrayList of available names
		 * a player picks their name and afterwards the name gets removed from the list
		 * 
		 * for cpu's, the players chose what their names are
		 * the remaining is randomized among the cpu's
		 * the setName() lines will be removed once this has been implemented
		 */

		// This is just a placeholder, it has no function
		howManyPlayers();
		
		player2 = new Player();
		player2.setName(Suspects.Colonel_Mustard);
		player2.setxCoordinate(23);
		player2.setyCoordinate(8);
		
		player3 = new Player();
		player3.setName(Suspects.Mrs_White);
		player3.setxCoordinate(15);
		player3.setyCoordinate(25);
		
		player4 = new Player();
		player4.setName(Suspects.Mr_Green);
		player4.setxCoordinate(10);
		player4.setyCoordinate(25);

		player5 = new Player();
		player5.setName(Suspects.Mrs_Peacock);
		player5.setxCoordinate(1);
		player5.setyCoordinate(19);

		player6 = new Player();
		player6.setName(Suspects.Professor_Plum);
		player6.setxCoordinate(1);
		player6.setyCoordinate(6);
		
	}
	
	private void howManyPlayers() {
		/*
		 * This method will ask the user at the start how many players will there be
		 * There will also be another method inside asking who the players (except player 1) would like to be
		 * player 1 is always Miss Scarlet
		 * Currently this is just a placeholder
		 */
	}
	
	public void play() throws IOException {
		Board b = new Board();
		b.setupBoard();
		
		howManyPlayers();
		
		// This WHILE loop will change to win/lose condition once its implemented
		while(true) {
			// The players past player2 will have if statements depending on how may cpu's are active
			playerTurn(player1, b);
			
			playerTurn(player2, b);
			
			playerTurn(player3, b);
			
			playerTurn(player4, b);
			
			playerTurn(player5, b);
			
			playerTurn(player6, b);
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
	private void playerTurn(Player currentPlayer, Board b) throws IOException {
		DiceRoll();
		for(int i=dice; i>0; i--) {
			placePlayers(b);
			System.out.println();
			System.out.println("You rolled a " + dice);
			System.out.println("You have " + i + " more spaces to move \n");
			playerMovement(currentPlayer, b);
		}
	}
	
	private void DiceRoll() {
		dice = generator.nextInt(12) + 1;
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
	 * This method contains the logic for player movement
	 * First the method will prompt for a direction
	 * Then based on the input the method will do several checks
	 *  - First checks for a free space in the desired location
	 *  - If space is empty, remove the current position of the characters Enum
	 *  - then change the players coordinates accordingly and sets the Enum position on the board
	 *  - An invalid input will not count towards the dice roll counter, allowing for safe errors
	 */
	private void playerMovement(Player currentPlayer, Board b) throws IOException {
		System.out.println("Hello " + currentPlayer.getName() + ",");
		
		boolean isValidInput = false;
		while(!isValidInput) {
			System.out.println("Where do you want to move?" 
					+ "\n 1 = Up" 
					+ "\n 2 = Right" 
					+ "\n 3 = Down" 
					+ "\n 4 = Left");
			String rawInput = in.readLine();
			int input = Integer.parseInt(rawInput);
			
			/*
			 * Eventually, there needs to be a method to check for a room
			 * Once there is a room, ask player if they wish to enter (likely by adding the option to the movement menu)
			 */
			
			switch(input) {
				case 1:
					// Up
					if(!b.isEmpty(currentPlayer, input)) {
						b.removePreviousSpot(currentPlayer.getyCoordinate(), currentPlayer.getxCoordinate());
						currentPlayer.setyCoordinate(currentPlayer.getyCoordinate() - 1);
						isValidInput = true;
					}
					else {
						System.out.println("You can't move here! There is a " + b.board[currentPlayer.getyCoordinate() +1][currentPlayer.getxCoordinate()] + " there! try again.");
					}
					break;
				case 2:
					// Right
					if(!b.isEmpty(currentPlayer, input)) {
						b.removePreviousSpot(currentPlayer.getyCoordinate(), currentPlayer.getxCoordinate());
						currentPlayer.setxCoordinate(currentPlayer.getxCoordinate() + 1);
						isValidInput = true;
					}
					else {
						System.out.println("You can't move here! There is " + b.board[currentPlayer.getyCoordinate() +1][currentPlayer.getxCoordinate()] + " there! try again.");
					}
					break;
				case 3:
					// Down
					if(!b.isEmpty(currentPlayer, input)) {
						b.removePreviousSpot(currentPlayer.getyCoordinate(), currentPlayer.getxCoordinate());
						currentPlayer.setyCoordinate(currentPlayer.getyCoordinate() + 1);
						isValidInput = true;
					}
					else {
						System.out.println("You can't move here! There is " + b.board[currentPlayer.getyCoordinate() +1][currentPlayer.getxCoordinate()] + " there! try again.");
					}
					break;
				case 4:
					// Left
					if(!b.isEmpty(currentPlayer, input)) {
						b.removePreviousSpot(currentPlayer.getyCoordinate(), currentPlayer.getxCoordinate());
						currentPlayer.setxCoordinate(currentPlayer.getxCoordinate() - 1);
						isValidInput = true;
					}
					else {
						System.out.println("You can't move here! There is " + b.board[currentPlayer.getyCoordinate() +1][currentPlayer.getxCoordinate()] + " there! try again.");
					}
					break;
				default:
					System.out.println("Thats not a valid coordinate");
			} // End of Switch
		} // End of WHILE loop
	} // End of method
} // End of class
