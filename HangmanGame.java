public class HangmanGame implements GameState {
	
	private Screen theGame;
	private Player guesser;
	private Player questioner;
	public HangmanGame(boolean twoPlayer) {
		theGame = new Screen();
		guesser = new Player("You");
		if(twoPlayer) {
			questioner = new Player("The other guy");
		}
		else {
			questioner = new Player("The system");
		}
	}
	public boolean isGameOver() {
		return false;
	}
	public Player getWinner() {
		
	}
	public Player getCurrentPlayer() {
		
	}
	public ArrayList<String> getCurrentMoves() {
		
	}
	public void makeMove(String move) {
		
	}
	public String toString() {
		
	}
}
