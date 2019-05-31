import pkg.*;
import java.util.ArrayList;

public class LettersDisplay {
	
	private Text[] letters;
	private int perRow = 3;
	private int spacing = 40;
	private int x = 400;
	private int y = 100;
	
	public LettersDisplay() {
		letters = new Text[26];
		for(int i = 0; i < letters.length-letters.length%perRow; i++) {
			letters[i] = new Text(x+(i%perRow*spacing), y+(i/perRow*spacing), Character.toString((char)(i+65)));
			letters[i].translate(x+(i%perRow*spacing)-(letters[i].getX()+letters[i].getWidth()/2), 0);
		}
		for(int j = letters.length-letters.length%perRow; j < letters.length; j++) {
			letters[j] = new Text(x+(j%perRow*spacing)+((spacing*perRow-(spacing*(letters.length%perRow)))/2), y+(letters.length/perRow*spacing), Character.toString((char)(j+65)));
			letters[j].translate(x+(j%perRow*spacing)+((spacing*perRow-(spacing*(letters.length%perRow)))/2)-(letters[j].getX()+letters[j].getWidth()/2), 0);
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
	
	public void translate(int x, int y) {
		for(int i = 0; i < letters.length; i++) {
			letters[i].translate(x, y);
		}
	}
}
