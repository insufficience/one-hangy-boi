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
	private boolean playerMode = false;
	
	public Screen() {
		background = new Rectangle(0, 0, 600, 600);
		background.setColor(Color.WHITE);
		KeyController kC = new KeyController(Canvas.getInstance(), this);
		MouseController mC = new MouseController(Canvas.getInstance(), this);
		onePlayerBox = new Rectangle(20, 50, 100, 50);
		twoPlayerBox = new Rectangle(140, 50, 100,50);
		onePlayerBox.setColor(new Color(200, 200, 255));
		twoPlayerBox.setColor(new Color(200, 200, 255));
		onePlayerLabel = new Text(30, 60, "Single Player");
		twoPlayerLabel = new Text(150, 60, "Double Player");
		select = new Rectangle(250, 200, 200,200);
		select.setColor(new Color(200, 200, 255));
		input = new Text(260, 230, "");
		submit = new Text(260, 370, "Click to submit");
		select.translate(-600, 0);
		submit.translate(-600, 0);
		input.translate(-600, 0);
	}
	
	public void keyPress(String s) {
		if(s.toUpperCase().codePointAt(0) >= 65 && s.toUpperCase().codePointAt(0) <= 90) {
			if(askingForGuess) {
				playerGuess = s;
				askingForGuess = false;
			}
			if(askingForInput) {
				inputWord += s;
				input.setText(inputWord);
			}
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
		
		select.fill();
		submit.draw();
		input.draw();
		while(askingForMode) {
			System.out.print("");
		}
		if(playerMode) {
			askingForInput = true;
			select.translate(600, 0);
			submit.translate(600, 0);
			input.translate(600, 0);
			inputWord = "";
			input.setText(inputWord);
			while(askingForInput) {
				System.out.print("");
			}
			select.translate(-600, 0);
			submit.translate(-600, 0);
			input.translate(-600, 0);
			gui = new Display(inputWord);
		}
		else {
			EasyReader words = new EasyReader("RandomWords.txt");
			int fileLength = 0;
			while(!words.eof()) {
				words.readLine();
				fileLength++;
			}
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
	public void onMouseClick(double x, double y) {
		x -= 8;
		y -= 31;
		if(askingForMode && x > onePlayerBox.getX() && x < onePlayerBox.getX()+onePlayerBox.getWidth() && y > onePlayerBox.getY() && y < onePlayerBox.getY()+onePlayerBox.getHeight()) {
			askingForMode = false;
			playerMode = false;
		}
		if(askingForMode && x > twoPlayerBox.getX() && x < twoPlayerBox.getX()+twoPlayerBox.getWidth() && y > twoPlayerBox.getY() && y < twoPlayerBox.getY()+twoPlayerBox.getHeight()) {
			askingForMode = false;
			playerMode = true;
		}
		if(askingForInput && x > select.getX() && x < select.getX()+select.getWidth() && y > select.getY() && y < select.getY()+select.getHeight()) {
			askingForInput = false;
		}
	}
	
	public String getGuess() {
		askingForGuess = true;
		while(askingForGuess) {
			System.out.print("");
		}
		gui.guess(playerGuess);
		return playerGuess;
	}
}
