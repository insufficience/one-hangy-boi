import pkg.*;
import java.util.ArrayList;

public class HangmanGame implements GameState {
	
	private Screen theGame;
	private Player guesser, questioner;
	private boolean twoPlayer;
	private ArrayList<String> moves;
	
	public HangmanGame() {
		guesser = new Player("The guesser");
		theGame = new Screen();
		init();
	}
	
	private void init() {
		twoPlayer = theGame.chooseMode();
		if(twoPlayer) {
			questioner = new Player("The other guy");
		}
		else {
			questioner = new Player("The system");
		}
		moves = new ArrayList<>();
	}
	
	public boolean isGameOver() {
		return false;
	}
	
	public Player getWinner() {
		return new Player("Something's wrong with the code. Anarchy");
	}
	
	public Player getCurrentPlayer() {
		return guesser;
	}
	
	public ArrayList<String> getCurrentMoves() {
		return moves;
	}
	
	public void makeMove(String move) {
		if(theGame.didYouDoIt()) {
			init();
		}
	}
	
	public String toString() {
		moves.add(0, theGame.getGuess());
		return moves.toString();
	}
}
