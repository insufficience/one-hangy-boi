import pkg.*;
import java.util.ArrayList;

public class Screen implements InputKeyControl,InputControl {
	
	private Rectangle background;
	private Text title;
	private Rectangle onePlayerBoxOutline;
	private Rectangle onePlayerBox;
	private Rectangle twoPlayerBoxOutline;
	private Rectangle twoPlayerBox;
	private Rectangle select;
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
	private ArrayList<Integer> usedWords;
	
	public Screen() {
		background = new Rectangle(0, 0, 600, 600);
		background.setColor(Color.WHITE);
		KeyController kC = new KeyController(Canvas.getInstance(), this);
		MouseController mC = new MouseController(Canvas.getInstance(), this);
		title = new Text(50, 50, "ONE HANGY BOI");
		title.grow((500-title.getWidth())/2,(225-title.getHeight())/2);
		title.translate(50-title.getX(), 50-title.getY());
		onePlayerBox = new Rectangle(50, 325, 225, 225);
		onePlayerBoxOutline = new Rectangle(onePlayerBox.getX()-2, onePlayerBox.getY()-2, onePlayerBox.getWidth()+4, onePlayerBox.getHeight()+4);
		twoPlayerBox = new Rectangle(325, 325, 225, 225);
		twoPlayerBoxOutline = new Rectangle(twoPlayerBox.getX()-2, twoPlayerBox.getY()-2, twoPlayerBox.getWidth()+4, twoPlayerBox.getHeight()+4);
		onePlayerBox.setColor(new Color(200, 200, 255));
		twoPlayerBox.setColor(new Color(200, 200, 255));
		onePlayerLabel = new Text(onePlayerBox.getX()+10, onePlayerBox.getY()+10, "Player vs. Computer");
		onePlayerLabel.translate((onePlayerBox.getWidth()-onePlayerLabel.getWidth())/2+onePlayerBox.getX()-onePlayerLabel.getX(), (onePlayerBox.getHeight()-onePlayerLabel.getHeight())/2+onePlayerBox.getY()-onePlayerLabel.getY());
		twoPlayerLabel = new Text(twoPlayerBox.getX()+10, twoPlayerBox.getY()+10, "Player vs. Player");
		twoPlayerLabel.translate((twoPlayerBox.getWidth()-twoPlayerLabel.getWidth())/2+twoPlayerBox.getX()-twoPlayerLabel.getX(), (twoPlayerBox.getHeight()-twoPlayerLabel.getHeight())/2+twoPlayerBox.getY()-twoPlayerLabel.getY());
		select = new Rectangle(twoPlayerBox.getX(), twoPlayerBox.getY(), twoPlayerBox.getWidth(), twoPlayerBox.getHeight());
		select.setColor(new Color(200, 200, 255));
		input = new Text(select.getX()+10, select.getY()+10, "");
		submit = new Text(select.getX()+10, select.getY()+select.getHeight()-26, "Click to submit");
		select.translate(-600, 0);
		submit.translate(-600, 0);
		input.translate(-600, 0);
		usedWords = new ArrayList<>();
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
		title.draw();
		onePlayerBoxOutline.fill();
		twoPlayerBoxOutline.fill();
		onePlayerBox.fill();
		twoPlayerBox.fill();
		onePlayerLabel.draw();
		twoPlayerLabel.draw();
		select.fill();
		submit.draw();
		input.draw();
		int r = (int)(Math.random()*256);
		int rIncrement;
		if((int)(Math.random()*2) == 0) {
			rIncrement = 1;
		}
		else {
			rIncrement = -1;
		}
		int g = (int)(Math.random()*256);
		int gIncrement;
		if((int)(Math.random()*2) == 0) {
			gIncrement = 1;
		}
		else {
			gIncrement = -1;
		}
		int b = (int)(Math.random()*256);
		int bIncrement;
		if((int)(Math.random()*2) == 0) {
			bIncrement = 1;
		}
		else {
			bIncrement = -1;
		}
		while(askingForMode) {
			title.setColor(new Color(r, g, b));
			if(r >= 185) {
				rIncrement = -1;
			}
			if(r <= 70) {
				rIncrement = 1;
			}
			r = r+(int)(Math.random()*2*rIncrement);
			if(g >= 185) {
				gIncrement = -1;
			}
			if(g <= 70) {
				gIncrement = 1;
			}
			g = g+(int)(Math.random()*2*gIncrement);
			if(b >= 185) {
				bIncrement = -1;
			}
			if(b <= 70) {
				bIncrement = 1;
			}
			b = b+(int)(Math.random()*2*bIncrement);
			Canvas.pause(2);
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
			gui = new Display(inputWord);
			gui.draw();
			select.translate(-600, 0);
			submit.translate(-600, 0);
			input.translate(-600, 0);
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
			int num = (int)(Math.random()*fileLength);
			while(usedWords.contains(num)) {
				num = (int)(Math.random()*fileLength);
			}
			usedWords.add(num);
			for(int i = 0; i < num; i++) {
				chosenWord = words.readLine();
			}
			gui = new Display(chosenWord);
			gui.draw();
		}
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
