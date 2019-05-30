import pkg.*;
import java.util.ArrayList;

public class Screen implements InputKeyControl,InputControl {
	
	private Rectangle background;
	private Rectangle onePlayerBox;
	private Rectangle select;
	private Rectangle twoPlayerBox;
	private Text submit;
	private Text input;
	private Text onePlayerLabel;
	private Text twoPlayerLabel;
	private Display gui;
	private boolean askingForGuess = false;
	private boolean askingForWord = false;
	private String playerGuess;
	private String inputWord;
	private boolean askingForMode = false;
	private boolean askingForInput = false;
	private boolean Completion = false;
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
		
		select = new Rectangle(250, 200, 200,200);
		select.setColor(new Color(200, 200, 255));
		input = new Text(260, 230, "");
		submit = new Text(260, 370, "Click to submit");
	}
	
	public void keyPress(String s) {
		// System.out.println("clunkityclank: "+s);
		if(askingForGuess) {
			playerGuess = s;
			askingForGuess = false;
		}
		if(askingForWord) {
			inputWord = s;
			askingForWord = false;
		}
	}
	
	public boolean didYouDoIt() {
		return gui.gameOver();
	}
	
	public boolean chooseMode() {
		background.translate(0,0);
		onePlayerBox.translate(0,0);
		twoPlayerBox.translate(0,0);
		onePlayerLabel.translate(0,0);
		twoPlayerLabel.translate(0,0);
		askingForMode = true;
		background.fill();
		onePlayerBox.fill();
		twoPlayerBox.fill();
		onePlayerLabel.draw();
		twoPlayerLabel.draw();
		while(askingForMode) {
			System.out.print(""); // for some reason it has to be doing something to work
		}
		if(playerMode) { /**Daniel#1:works except always one step behind. Will fix later. btw, body thing doesn't work.**/
			background.translate(0,0);
			select.fill();
			submit.draw();
			input.draw();
			String word="";
			while(!Completion){
				askingForWord=true;
				while(askingForWord){
					System.out.print("");
				}
				input.setText(word);
				word+=inputWord;
			}
			background.translate(0,0);
			gui = new Display(word);
			System.out.print("hguyyu");
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
		background.translate(0,0);
		gui.draw();
		return playerMode;
	}
	public void onMouseClick(double x, double y) {
		if(x > select.getX() && x < select.getX()+select.getWidth() && y > select.getY() && y < select.getY()+select.getHeight()) {
			Completion = true;
		}
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
