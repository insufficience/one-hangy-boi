public class HangmanGame implements GameState {
	
	private Screen theGame;
	private Player guesser;
	private Player questioner;
	private boolean twoPlayer;
	public HangmanGame() {
		guesser = new Player("You");
		theGame = new Screen();
		twoPlayer = theGame.start();
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
