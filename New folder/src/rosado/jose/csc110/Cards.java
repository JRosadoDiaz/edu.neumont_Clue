package rosado.jose.csc110;

public class Cards {
	
	// need to make 3 lists of cards
	// have one card from each list be randomly put into the confidential case file
	// then need all the remaining cards to be put into the same list and be randomized and then passed out to the players
	// suspects: Colonel Mustard, Miss Scarlet, Professor Plum, Mr. Green, Mrs. White, Mrs. Peacock
	// weapons: Rope, Lead Pipe, Knife, Wrench, Candlestick, Pistol
	// rooms: Lounge, Hall, Ballroom, Study, Library, Dining Room, Kitchen, Billiard Room, Conservatory
	
	private String name;
	
	private String type;
		
	private boolean inCaseFile;
		
	public Cards(String name, String type, boolean icf) {
			
	}
		
	public Cards() {
			
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isInCaseFile() {
		return inCaseFile;
	}

	public void setInCaseFile(boolean inCaseFile) {
		this.inCaseFile = inCaseFile;
	}
	
	

}
