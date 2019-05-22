import pkg.*;

public class starter {
	
	public static void main(String args[]) {
		GameState g = new HangmanGame();
		GameDriver game = new GameDriver(g);
		game.play();
	}
}
