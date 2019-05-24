import pkg.*;
import java.util.ArrayList;

public class WordDisplay {
	
	private Text[] letters;
	private Text[] underscores;
	
	public WordDisplay(String word) {
		word = word.toUpperCase();
		letters = new Text[word.length()];
		underscores = new Text[word.length()];
		Text temp = new Text(-100, -100, word.substring(0, 1));
		underscores[0] = new Text(100, 510, "_");
		letters[0] = new Text(100+((underscores[0].getWidth()-temp.getWidth())/2), 510, word.substring(0, 1));
		for(int i = 1; i < letters.length; i++) {
			temp = new Text(-100, -100, word.substring(i, i+1));
			underscores[i] = new Text(underscores[i-1].getX()+underscores[i-1].getWidth()+5, underscores[i-1].getY(), "_");
			letters[i] = new Text(underscores[i].getX()+((underscores[i].getWidth()-temp.getWidth())/2), underscores[i].getY(), word.substring(i, i+1));
		}
	}
	
	public void guess(String guessedLetter) {
		for(int i = 0; i < letters.length; i++) {
			if(guessedLetter.toUpperCase().equals(letters[i])) {
				letters[i].draw();
			}
		}
	}
	
	public void draw() {
		for(int i = 0; i < underscores.length; i++) {
			underscores[i].draw();
		}
	}
}
