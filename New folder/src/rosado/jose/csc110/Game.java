package rosado.jose.csc110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
	public BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public Player player1;
	
	public Player player2;
	
	public Player player3;
	
	public Player player4;
	
	public Player player5;
	
	public Player player6;

	public void createPlayerList() {
		player1 = new Player();
		player1.name = Suspects.Miss_Scarlet;
		player1.xCoordinate = 17;
		player1.yCoordinate = 1;
		
		/*
		 * The names past player1 will be put under a new method
		 * That starts giving other players the choice of who they want to be
		 * The process will be done doing an arraylist of available names
		 * a player picks their name and afterwards the name gets removed from the list
		 * 
		 * for cpu's, the players chose what their names are
		 * the remaining is randomized among the cpu's
		 */
		
		player2 = new Player();
		player2.name = Suspects.Colonel_Mustard;
		player2.xCoordinate = 23;
		player2.yCoordinate = 8;
		
		player3 = new Player();
		player3.name = Suspects.Mrs_White;
		player3.xCoordinate = 15;
		player3.yCoordinate = 25;
		
		player4 = new Player();
		player4.name = Suspects.Mr_Green;
		player4.xCoordinate = 10;
		player4.yCoordinate = 25;

		player5 = new Player();
		player5.name = Suspects.Mrs_Peacock;
		player5.xCoordinate = 1;
		player5.yCoordinate = 19;

		player6 = new Player();
		player6.name = Suspects.Professor_Plum;
		player6.xCoordinate = 1;
		player6.yCoordinate = 6;
		
	}
	
	public void play() throws IOException {
		Board b = new Board();
		b.setupBoard();
		
		while(true) {
			b.setupPlayerStartLocations(player1);
			b.setupPlayerStartLocations(player2);
			b.setupPlayerStartLocations(player3);
			b.setupPlayerStartLocations(player4);
			b.setupPlayerStartLocations(player5);
			b.setupPlayerStartLocations(player6);
			b.boardTranslations();
			b.printBoard();
			playerTurn(player1, b);
		}
	}
	
	private void playerTurn(Player currentPlayer, Board b) throws IOException {
		/*
		 * This method will contain all the code and methods that constitute a player turn
		 *  - playerMovement()
		 *  - checkSurroundingForRoom()
		 */
		
		playerMovement(currentPlayer, b);
	}
	
	private void playerMovement(Player currentPlayer, Board b) throws IOException {
		System.out.println("Hello " + currentPlayer.name + ",");
		boolean isValidInput = false;
		while(!isValidInput) {
		System.out.println("Where do you want to move?" 
				+ "\n 1 = Up" 
				+ "\n 2 = Right" 
				+ "\n 3 = Down" 
				+ "\n 4 = Left");
		String rawInput = in.readLine();
		int input = Integer.parseInt(rawInput);
		
			switch(input) {
			case 1:
				// Up
				if(b.isEmpty(currentPlayer, input)) {
					b.removePreviousSpot(currentPlayer.yCoordinate, currentPlayer.xCoordinate);
					currentPlayer.yCoordinate--;
					isValidInput = true;
				}
				else {
					System.out.println("You can't move here! There is " + b.board[currentPlayer.yCoordinate +1][currentPlayer.xCoordinate] + " there! try again.");
				}
				break;
			case 2:
				// Right
				if(b.isEmpty(currentPlayer, input)) {
					b.removePreviousSpot(currentPlayer.yCoordinate, currentPlayer.xCoordinate);
					currentPlayer.xCoordinate++;
					isValidInput = true;
				}
				else {
					System.out.println("You can't move here! There is " + b.board[currentPlayer.yCoordinate +1][currentPlayer.xCoordinate] + " there! try again.");
				}
				break;
			case 3:
				// Down
				if(b.isEmpty(currentPlayer, input)) {
					b.removePreviousSpot(currentPlayer.yCoordinate, currentPlayer.xCoordinate);
					currentPlayer.yCoordinate++;
					isValidInput = true;
				}
				else {
					System.out.println("You can't move here! There is " + b.board[currentPlayer.yCoordinate +1][currentPlayer.xCoordinate] + " there! try again.");
				}
				break;
			case 4:
				// Left
				if(b.isEmpty(currentPlayer, input)) {
					b.removePreviousSpot(currentPlayer.yCoordinate, currentPlayer.xCoordinate);
					currentPlayer.xCoordinate--;
					isValidInput = true;
				}
				else {
					System.out.println("You can't move here! There is " + b.board[currentPlayer.yCoordinate +1][currentPlayer.xCoordinate] + " there! try again.");
				}
				break;
			default:
				System.out.println("Thats not a valid coordinate");
			}
		}
	}
}
