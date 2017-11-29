package rosado.jose.csc110;

public class Main {

	public static void main(String[] args) {
		Game g = new Game();
		g.createPlayerList();
		
		Board b = new Board();
		b.setupBoard();
		b.setupPlayerLocations(g.player1.name, g.player1.xCoordinate, g.player1.yCoordinate);
		b.setupPlayerLocations(g.player2.name, g.player2.xCoordinate, g.player2.yCoordinate);
		b.setupPlayerLocations(g.player3.name, g.player3.xCoordinate, g.player3.yCoordinate);
		b.setupPlayerLocations(g.player4.name, g.player4.xCoordinate, g.player4.yCoordinate);
		b.setupPlayerLocations(g.player5.name, g.player5.xCoordinate, g.player5.yCoordinate);
		b.setupPlayerLocations(g.player6.name, g.player6.xCoordinate, g.player6.yCoordinate);
		b.printBoard();
		
		g.movePlayer(g.p)
	}

}
