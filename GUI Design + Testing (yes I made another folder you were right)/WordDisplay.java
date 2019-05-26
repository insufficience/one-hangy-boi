import pkg.*;
import java.util.ArrayList;

public class WordDisplay {
	
	private Text[] letters;
	private Text[] underscores;
	private LettersDisplay l;
	private int startX = 100;
	private int centerY = 515;
	private int growth = 2;
	
	public WordDisplay(String word) {
		double size = 16*growth;
		word = word.toUpperCase();
		letters = new Text[word.length()];
		underscores = new Text[word.length()];
		Text temp = new Text(-100, -100, word.substring(0, 1));
		underscores[0] = new Text(startX+((int)(((size-16)/16)*7)), centerY-5, "_");
		underscores[0].grow((((size-16)/16)*7), ((size-16)/2));
		letters[0] = new Text(startX+(((size-16)/16)*7), centerY-5, word.substring(0, 1));
		letters[0].grow((((size-16)/32)*(temp.getWidth())), ((size-16)/2));
		letters[0].translate((underscores[0].getX()+underscores[0].getWidth()/2)-(letters[0].getX()+letters[0].getWidth()/2), 0);
		System.out.println(underscores[0].getX()+", "+underscores[0].getWidth()+", "+underscores[0].getY()+", "+underscores[0].getHeight()+", "+letters[0].getX()+", "+letters[0].getWidth()+", "+letters[0].getY()+", "+letters[0].getHeight());
		for(int i = 1; i < letters.length; i++) {
			temp = new Text(-100, -100, word.substring(i, i+1));
			underscores[i] = new Text(startX+((int)(((size-16)/16)*7))+(size/16*7*i)+(i*5*(size/16)), centerY-5, "_");
			underscores[i].grow((((size-16)/16)*7), ((size-16)/2));
			letters[i] = new Text(startX+((int)(((size)/16)*7))+(size/16*7*i)+(i*5*(size/16)), centerY-5, word.substring(i, i+1));
			letters[i].grow((((size-16)/32)*(temp.getWidth())), ((size-16)/2));
			letters[i].translate((underscores[i].getX()+underscores[i].getWidth()/2)-(letters[i].getX()+letters[i].getWidth()/2), 0);
			System.out.println(underscores[i].getX()+", "+underscores[i].getWidth()+", "+underscores[i].getY()+", "+underscores[i].getHeight()+", "+letters[i].getX()+", "+letters[i].getWidth()+", "+letters[i].getY()+", "+letters[i].getHeight());
		}
		l = new LettersDisplay();
		l.draw();
	}
	
	public void guess(String guessedLetter) {
		for(int i = 0; i < letters.length; i++) {
			if(guessedLetter.toUpperCase().equals(letters[i])) {
				letters[i].draw();
				l.setGreen(guessedLetter);
			}
			else {
				l.setRed(guessedLetter);
			}
		}
	}
	
	public void draw() {
		for(int i = 0; i < underscores.length; i++) {
			underscores[i].draw();
			letters[i].draw();
		}
	}
}
