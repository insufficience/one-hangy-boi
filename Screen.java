import pkg.*;
import java.util.ArrayList;

public class Screen implements DesignTeamExpectations, InputKeyControl {
	private HangmanGame a;
	
<<<<<<< HEAD
	public Screen(HangmanGame b) {
		a = b;
		KeyController kC = new KeyController(Canvas.getInstance(),new starter());
=======
	
	public Screen(HangmanGame b) {
		a = b;
>>>>>>> 97391d241549ae7ce6c98c5fd29b0d8ffc507f29
	}
	
	public void keyPress(String es) {
		
	}
	
	public boolean didYouDoIt() {
		
	}
	
	public boolean chooseMode() {
		if(){
			return true;
		}
		return false;
	}
	
	public String getGuess() {
		return a.toString();
	}
}
