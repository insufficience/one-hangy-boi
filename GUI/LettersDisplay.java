import pkg.*;
import java.util.ArrayList;

public class LettersDisplay {
	
	private Text[] letters;
	
	public LettersDisplay() {
		letters = new Text[26];
		for(int i = 0; i < letters.length; i++) {
			letters[i] = new Text(200+(i%6*20), 10+(i/6*20), Character.toString((char)(i+65)));
		}
	}
	
	public void setGreen(String greenLetter) {
		letters[greenLetter.toUpperCase().codePointAt(0)-65].setColor(Color.GREEN);
	}
	
	public void setRed(String redLetter) {
		letters[redLetter.toUpperCase().codePointAt(0)-65].setColor(Color.RED);
	}
	
	public void draw() {
		for(int i = 0; i < letters.length; i++) {
			letters[i].draw();
		}
	}
}
