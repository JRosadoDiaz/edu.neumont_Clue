package rosado.jose.csc110;

public class Board {
	// an extra row and column is added to create a border around the board
	private final int BOARD_HEIGHT = 27; // Up/Down
	
	private final int BOARD_WIDTH = 25; // Left/Right
	
	public BoardSpaces[][] board = new BoardSpaces[BOARD_HEIGHT][BOARD_WIDTH];
	
	public String[][] asciiBoard = new String[BOARD_HEIGHT][BOARD_WIDTH];
	
	public void setupBoard() {
		for(int i=0; i<BOARD_HEIGHT; i++) {
			for(int j=0; j<BOARD_WIDTH; j++) {
				board[i][j] = BoardSpaces.Empty;
			}
		}
		
		
		boardBorders();
		
		studyRoomPlacement();
		hallRoomPlacement();
		loungeRoomPlacement();
		libraryRoomPlacement();
		clueRoomPlacement();
		billiardRoomPlacement();
		diningRoomPlacement();
		conservatoryRoomPlacement();
		ballroomPlacement();
		kitchenRoomPlacement();
		boardTranslations();
		
//		printBoard();
	}
	
	public void setupPlayerLocations(Suspects name, int xCoordinate, int yCoordinate) {
		if(name == Suspects.Miss_Scarlet) {
			board[yCoordinate][xCoordinate] = BoardSpaces.Miss_Scarlet;
		}
		if(name == Suspects.Colonel_Mustard) {
			board[yCoordinate][xCoordinate] = BoardSpaces.Colonel_Mustard;
		}
		if(name == Suspects.Mrs_White) {
			board[yCoordinate][xCoordinate] = BoardSpaces.Mrs_White;
		}
		if(name == Suspects.Mr_Green) {
			board[yCoordinate][xCoordinate] = BoardSpaces.Mr_Green;
		}
		if(name == Suspects.Mrs_Peacock) {
			board[yCoordinate][xCoordinate] = BoardSpaces.Mrs_Peacock;
		}
		if(name == Suspects.Professor_Plum) {
			board[yCoordinate][xCoordinate] = BoardSpaces.Professor_Plum;
		}
		boardTranslations();
//		printBoard();
	}
	
	private void boardBorders() {
		// Horizontal borders
		for(int i=0; i<BOARD_WIDTH; i++) {
			board[0][i] = BoardSpaces.Wall;
			board[BOARD_HEIGHT-1][i] = BoardSpaces.Wall;
		}
		
		// Vertical borders
		for(int i=0; i<BOARD_HEIGHT; i++) {
			board[i][0] = BoardSpaces.Wall;
			board[i][BOARD_WIDTH-1] = BoardSpaces.Wall;
		}
	}

	private void studyRoomPlacement() {
		for(int i=1; i<5; i++) {
			for(int j=1; j<8; j++) {
				board[i][j] = BoardSpaces.Wall;
			}
		}
		board[5][1] = BoardSpaces.Wall;
		
		//Room Tile
		board[4][7] = BoardSpaces.Room;
	}
	
	private void hallRoomPlacement() {
		for(int i=1; i<8; i++) {
			for(int j=10; j<16; j++) {
				board[i][j] = BoardSpaces.Wall;
			}
		}
		board[1][9] = BoardSpaces.Wall;
		board[1][16] = BoardSpaces.Wall;
		
		// Room Tiles
		board[5][10] = BoardSpaces.Room; // Left Side room
		board[7][12] = BoardSpaces.Room;
		board[7][13] = BoardSpaces.Room;
	}
	
	private void loungeRoomPlacement() {
		for(int i=1; i<7; i++) {
			for(int j=18; j<BOARD_WIDTH-1; j++) {
				board[i][j] = BoardSpaces.Wall;
			}	
		}
		board[7][23] = BoardSpaces.Wall;
		
		// Room tile
		board[6][18] = BoardSpaces.Room;
	}
	
	private void libraryRoomPlacement() {
		for(int i=7; i<12; i++) {
			for(int j=1; j<7; j++) {
				board[i][j] = BoardSpaces.Wall;
			}
		}
		board[8][7] = BoardSpaces.Wall;
		board[10][7] = BoardSpaces.Wall;
		board[12][1] = BoardSpaces.Wall;
		
		// Room Tile
		board[9][7] = BoardSpaces.Room; // Right side door
		board[11][4] = BoardSpaces.Room; // Bottom side door
	}
	
	private void clueRoomPlacement() {
		for(int i=9; i<16; i++) {
			for(int j=10; j<15; j++) {
				board[i][j] = BoardSpaces.Wall;
			}
		}
	}
	
	private void billiardRoomPlacement() {
		for(int i=13; i<18; i++) {
			for(int j=1; j<7; j++) {
				board[i][j] = BoardSpaces.Wall;
			}
		}
		board[18][1] = BoardSpaces.Wall;
		
		// Room Tile
		board[13][2] = BoardSpaces.Room; // Top Room
		board[16][6] = BoardSpaces.Room; // Right Side Room
	}

	private void diningRoomPlacement() {
		for(int i=10; i<17; i++) {
			for(int j=17; j<BOARD_WIDTH-1; j++) {
				board[i][j] = BoardSpaces.Wall;
			}
		}
		board[9][23] = BoardSpaces.Wall;
		board[16][17] = BoardSpaces.Empty;
		board[16][18] = BoardSpaces.Empty;
		board[16][19] = BoardSpaces.Empty;
		board[17][24] = BoardSpaces.Wall;
		
		// Room Tile
		board[10][18] = BoardSpaces.Room; //Top Side Room
		board[13][17] = BoardSpaces.Room; //Left Side Room
	}
	
	private void conservatoryRoomPlacement() {
		for(int i=20; i<BOARD_HEIGHT-1; i++) {
			for(int j=1; j<7; j++) {
				board[i][j] = BoardSpaces.Wall;
			}
		}
		board[20][6] = BoardSpaces.Empty;
		board[25][7] = BoardSpaces.Wall;
		board[24][7] = BoardSpaces.Wall;
		board[25][8] = BoardSpaces.Wall;
		board[25][9] = BoardSpaces.Wall;
		
		// Room Tile
		board[20][5] = BoardSpaces.Room;
	}
	
	private void ballroomPlacement() {
		for(int i=18; i<24; i++) {
			for(int j=9; j<17; j++) {
				board[i][j] = BoardSpaces.Wall;
			}
		}
		
		for(int i=24; i<26; i++) {
			for(int j=11; j<15; j++) {
				board[i][j] = BoardSpaces.Wall;
			}
		}
		
		// Room Tile
		board[18][10] = BoardSpaces.Room;
		board[18][15] = BoardSpaces.Room;
		board[20][9] = BoardSpaces.Room;
		board[20][16] = BoardSpaces.Room;
		
	}
	
	private void kitchenRoomPlacement() {
		for(int i=19; i<BOARD_HEIGHT; i++) {
			for(int j=19; j<BOARD_WIDTH; j++) {
				board[i][j] = BoardSpaces.Wall;
			}
		}
		board[24][18] = BoardSpaces.Wall;
		board[25][18] = BoardSpaces.Wall;
		board[25][17] = BoardSpaces.Wall;
		board[25][16] = BoardSpaces.Wall;
		board[18][23] = BoardSpaces.Wall;

		board[19][20] = BoardSpaces.Room;
	}
	
	private void boardTranslations() {
		
		for(int i=0; i<BOARD_HEIGHT; i++) {
			for(int j=0; j<BOARD_WIDTH; j++) {
				if(board[i][j] == BoardSpaces.Empty) {
					asciiBoard[i][j] = "  ";
				}
				else if(board[i][j] == BoardSpaces.Wall) {
					asciiBoard[i][j] = "XX";
				}
				else if(board[i][j] == BoardSpaces.Room) {
					asciiBoard[i][j] = "[]";
				}
				else if(board[i][j] == BoardSpaces.Miss_Scarlet) {
					asciiBoard[i][j] = "P1";
				}
				else if(board[i][j] == BoardSpaces.Colonel_Mustard) {
					asciiBoard[i][j] = "P2";
				}
				else if(board[i][j] == BoardSpaces.Mrs_White) {
					asciiBoard[i][j] = "P3";
				}
				else if(board[i][j] == BoardSpaces.Mr_Green) {
					asciiBoard[i][j] = "P4";
				}
				else if(board[i][j] == BoardSpaces.Mrs_Peacock) {
					asciiBoard[i][j] = "P5";
				}
				else if(board[i][j] == BoardSpaces.Professor_Plum) {
					asciiBoard[i][j] = "P6";
				}
			}
		}
	}
	
	public void printBoard() {
		for(int i=0; i<BOARD_HEIGHT; i++) {
			for(int j=0; j<BOARD_WIDTH; j++) {
				System.out.print(asciiBoard[i][j] + " ");
			}
			System.out.println();
		}
	}
}
