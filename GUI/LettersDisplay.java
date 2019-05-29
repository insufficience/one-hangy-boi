import pkg.*;
import java.util.ArrayList;

public class LettersDisplay {
	
	private Text[] letters;
	
	public LettersDisplay() {
		letters = new Text[26];
		for(int i = 0; i < letters.length; i++) {
			letters[i] = new Text(10,10 , Character.toString((char)(i+65)));
		}
	}
	
	public void setGreen(String greenLetter) {
		//letters[].setColor(Color.GREEN); //this gives error
	}
	
	public void setRed(String redLetter) {
		//letters[].setColor(Color.RED); //this gives error
	}
	
	public void draw() {
		for(int i = 0; i < letters.length; i++) {
			letters[i].draw();
		}
	}
}
