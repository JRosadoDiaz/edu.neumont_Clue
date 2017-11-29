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
		player1.yCoordinate = 17;
		player1.xCoordinate = 1;
		
		player2 = new Player();
		player2.name = Suspects.Colonel_Mustard;
		player2.yCoordinate = 8;
		player2.xCoordinate = 23;
	}
	public void play() {
		
	}
}
