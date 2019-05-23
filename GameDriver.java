import pkg.*;
import java.util.ArrayList;

public class GameDriver {
	
	private GameState state;
	
	public GameDriver(GameState initial) {
		state = initial;
	}
	
	public void play() {
		while(!state.isGameOver()) {
			System.out.println(state);
			System.out.print(state.getCurrentPlayer().getName()+": ");
			System.out.println(state.getCurrentPlayer().getNextMove(state));
			state.makeMove(state.getCurrentPlayer().getNextMove(state));
		}
		
		if(state.getWinner() == null) {
			System.out.println("Game ends in a draw.");
		}
		
		else {
			System.out.println(state.getWinner()+" wins.");
		}
	}
}