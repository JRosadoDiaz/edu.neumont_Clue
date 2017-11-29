package rosado.jose.csc110;

public class Game {
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
		 * the remaining is randomized among the cpus
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
	public void play(Player currentPlayer) {
		System.out.println("Hello " + currentPlayer.name + ", Where do you want to move?" +
				"\n 1 = Up" + "\n 2 = Right" + "\n 3 = Down" + "\n 4 = Left");
	}
}
