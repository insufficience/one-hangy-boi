import pkg.*;
import java.util.ArrayList;

public class Screen implements DesignTeamExpectations, InputKeyControl {
	private HangmanGame a;
	
	
	public Screen(HangmanGame b) {
		a = b;
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
		return a.guess();
	}
}
