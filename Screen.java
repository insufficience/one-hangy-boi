import pkg.*;
import GUI.*;
import java.util.ArrayList;

public class Screen implements DesignTeamExpectations, InputKeyControl,InputControl {
	
	private Rectangle background = new Rectangle(0, 0, 600, 600);
	//screenCover.setColor(Color.WHITE);    caused errors
	private Rectangle onePlayerBox;
	private Rectangle twoPlayerBox;
	private Text onePlayerLabel;
	private Text twoPlayerLabel;
	private Display gui;
	private boolean askingForGuess = false;
	private String playerGuess;
	private boolean askingForMode = false;
	private boolean playerMode = false;
	
	public Screen() {
		KeyController kC = new KeyController(Canvas.getInstance(), new Screen());
		MouseController mC = new MouseController(Canvas.getInstance(), new Screen());
		onePlayerBox = new Rectangle(20, 50, 100,50);
		twoPlayerBox = new Rectangle(140, 50, 100,50);
		onePlayerBox.setColor(Color.BLUE);
		twoPlayerBox.setColor(Color.BLUE);
		onePlayerLabel = new Text(30, 60, "Single Player");
		twoPlayerLabel = new Text(150, 60, "Double Player");
	}
	
	public void keyPress(String es) {
		if(askingForGuess) {
			playerGuess = es;
			askingForGuess = false;
		}
	}
	public boolean didYouDoIt() {
		gui.gameOver();
	}
	public boolean chooseMode() {
		askingForMode = true;
		background.fill();
		onePlayerBox.fill();
		twoPlayerBox.fill();
		onePlayerLabel.draw();
		twoPlayerLabel.draw();
		while(askingForMode) {
			
		}
		background.translate(0,0);
		return playerMode;
		
	}
	public void onMouseClick(double ex, double why) {
		ex -= 8;
		why -= 31;
		if(askingForMode && ex > onePlayerBox.getX() && ex < onePlayerBox.getX()+onePlayerBox.getWidth() && why > onePlayerBox.getY() && why < onePlayerBox.getY()+onePlayerBox.getHeight()) {
			askingForMode = false;
		}
		if(askingForMode && ex > twoPlayerBox.getX() && ex < twoPlayerBox.getX()+twoPlayerBox.getWidth() && why > twoPlayerBox.getY() && why < twoPlayerBox.getY()+twoPlayerBox.getHeight()) {
			playerMode = true;
			askingForMode = false;
		}
	}
	public String getGuess() {
		askingForGuess = true;
		while(askingForGuess) {
		}
		//word.guess(playerGuess);   ///????? no idea where word came from
		return playerGuess;
	}
}
