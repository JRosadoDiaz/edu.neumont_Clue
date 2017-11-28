package rosado.jose.csc110;

public enum BoardSpaces {
	Empty, // Space on board is empty
	Wall, // Wall from the a room, should not be passed
	Occupied, // A player has taken this spot
	Room // A room space, should use an ArrayList of players and items when this is active
}
