import pkg.*;
import java.util.ArrayList;

public interface DesignTeamExpectations {
	
	boolean didYouDoIt(); // returns true if the game is over
	boolean chooseMode(); // starts up the game and returns true if they choose two player modeu
	String getGuess(); // gets the guesses
}
                            