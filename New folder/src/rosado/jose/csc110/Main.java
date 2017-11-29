package rosado.jose.csc110;

public class Main {

	public static void main(String[] args) {
		Game g = new Game();
		g.createPlayerList();
		
		Board b = new Board();
		b.setupBoard();
		b.setupPlayerLocations(g.player1.name, g.player1.xCoordinate, g.player1.yCoordinate);
		b.setupPlayerLocations(g.player2.name, g.player2.xCoordinate, g.player2.yCoordinate);
		b.printBoard();
	}

}
