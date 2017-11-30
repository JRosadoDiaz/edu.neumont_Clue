package rosado.jose.csc110;

import java.util.ArrayList;

public class Player {
	/*
	 * This class must contain:
	 * Name (Character name)
	 * Players position on the 2d array
	 * Spaces available to move (as well as original spot)
	 * player hand (reminder: all cards will be an array list of strings)
	 */
	
	/*
	 * Players must select from a list of available players
	 */
	public Suspects name;
	
	// These coordinates will be adjusted tied to their position on the board array
	public int xCoordinate;
	
	public int yCoordinate;
	
	public ArrayList<Cards> hand;
}
