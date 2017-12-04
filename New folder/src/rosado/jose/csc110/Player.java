package rosado.jose.csc110;

import java.util.ArrayList;

public class Player {
	/*
	 * This class must contain:
	 * Name (Character name)
	 * Players position on the 2d array
	 * Spaces available to move (as well as original spot)
	 * player hand (reminder: all cards will be an ArrayList of strings)
	 */
	
	/*
	 * Players must select from a list of available players before starting the game
	 */
	
	private Suspects name;
	
	// These coordinates will be adjusted tied to their position on the board array
	private int xCoordinate;
	
	private int yCoordinate;
	
	public ArrayList<String> hand = new ArrayList<>();
	
	private boolean insideRoom = false;

	public Suspects getName() {
		return name;
	}
	
	public void setName(Suspects name) {
		this.name = name;
	}
	
	public int getxCoordinate() {
		return xCoordinate;
	}
	
	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	
	public int getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public boolean isInsideRoom() {
		return insideRoom;
	}

	public void setInsideRoom(boolean insideRoom) {
		this.insideRoom = insideRoom;
	}


}
