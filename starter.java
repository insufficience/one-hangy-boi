public class starter {
	
	public static void main(String args[]) {
		GameState g = new TheDorkKnight();
		GameDriver game = new GameDriver(g);
		game.play();
	}
}
