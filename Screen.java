import pkg.*;
import java.util.ArrayList;

public class Screen implements DesignTeamExpectations, InputKeyControl {
	
	public Screen() {
		KeyController kC = new KeyController(Canvas.getInstance(),new starter());
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
		
	}
}
