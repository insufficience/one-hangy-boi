public interface DesignTeamExpectations {
	
	boolean didYouDoIt(); // returns true if the game is over
	boolean chooseMode(); // starts up the game and returns true if they choose two player mode
	String getGuess(); // gets the guesses
}
