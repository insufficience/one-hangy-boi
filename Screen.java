import pkg.*;
import java.util.ArrayList;

public class Screen implements InputKeyControl,InputControl {
	
	private Rectangle background;
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
		background = new Rectangle(0, 0, 600, 600);
		background.setColor(Color.WHITE);
		onePlayerBox = new Rectangle(20, 50, 100,50);
		twoPlayerBox = new Rectangle(140, 50, 100,50);
		onePlayerBox.setColor(new Color(200, 200, 255));
		twoPlayerBox.setColor(new Color(200, 200, 255));
		onePlayerLabel = new Text(30, 60, "Single Player");
		twoPlayerLabel = new Text(150, 60, "Double Player");
	}
	
	public void keyPress(String s) {
		// System.out.println("clunkityclank: "+s);
		if(askingForGuess) {
			playerGuess = s;
			askingForGuess = false;
		}
	}
	
	public boolean didYouDoIt() {
		return gui.gameOver();
	}
	
	public boolean chooseMode() {
		askingForMode = true;
		background.fill();
		onePlayerBox.fill();
		twoPlayerBox.fill();
		onePlayerLabel.draw();
		twoPlayerLabel.draw();
		while(askingForMode) {
			System.out.print(""); // for some reason it has to be doing something to work
		}
		if(playerMode) {
			gui = new Display("shithowdowedothis");
		}
		else {
			EasyReader words = new EasyReader("RandomWords.txt");
			int fileLength = 0;
			while(!words.eof()) {
				words.readLine();
				fileLength++;
			}
			// System.out.println(fileLength);
			words = new EasyReader("RandomWords.txt");
			String chosenWord = words.readLine();
			for(int j = 0; j < (int)(Math.random()*fileLength); j++) {
				chosenWord = words.readLine();
			}
			gui = new Display(chosenWord);
		}
		gui.draw();
		return playerMode;
	}
	
	// public String getTarget() { // ????? what is this
		// if() {
			
		// }
	// }
	
	public void onMouseClick(double x, double y) {
		x -= 8;
		y -= 31;
		// System.out.println("clickityclack: "+x+", "+y);
		if(askingForMode && x > onePlayerBox.getX() && x < onePlayerBox.getX()+onePlayerBox.getWidth() && y > onePlayerBox.getY() && y < onePlayerBox.getY()+onePlayerBox.getHeight()) {
			askingForMode = false;
		}
		if(askingForMode && x > twoPlayerBox.getX() && x < twoPlayerBox.getX()+twoPlayerBox.getWidth() && y > twoPlayerBox.getY() && y < twoPlayerBox.getY()+twoPlayerBox.getHeight()) {
			askingForMode = false;
			playerMode = true;
		}
	}
	
	public String getGuess() {
		askingForGuess = true;
		while(askingForGuess) {
			System.out.print(""); // same here
		}
		gui.guess(playerGuess);
		return playerGuess;
	}
}
