import pkg.*;
import java.util.ArrayList;

public class Display {
	
	private Rectangle background;
	private Text[] letters;
	private Text[] underscores;
	private Gallows g;
	private LettersDisplay l;
	private Figure f;
	private int startX = 100;
	private int centerY = 515;
	private int growth = 2;
	private String guessWord;
	private String originalWord;
	private ArrayList<String> unguessed;
	
	public Display(String word) {
		background = new Rectangle(0, 0, 600, 600);
		background.setColor(Color.WHITE);
		double size = 16*growth;
		word = word.toUpperCase();
		letters = new Text[word.length()];
		underscores = new Text[word.length()];
		Text temp = new Text(-100, -100, word.substring(0, 1));
		underscores[0] = new Text(startX+((int)(((size-16)/16)*7)), centerY-5, "_");
		underscores[0].grow((((size-16)/16)*7), ((size-16)/2));
		letters[0] = new Text(startX+(((size-16)/16)*7), centerY-5, word.substring(0, 1));
		letters[0].grow((((size-16)/32)*(temp.getWidth())), ((size-16)/2));
		letters[0].translate((underscores[0].getX()+underscores[0].getWidth()/2)-(letters[0].getX()+letters[0].getWidth()/2)-1, 0);
		for(int i = 1; i < letters.length; i++) {
			temp = new Text(-100, -100, word.substring(i, i+1));
			underscores[i] = new Text(startX+((int)(((size-16)/16)*7))+(size/16*7*i)+(i*5*(size/16)), centerY-5, "_");
			underscores[i].grow((((size-16)/16)*7), ((size-16)/2));
			letters[i] = new Text(startX+((int)(((size)/16)*7))+(size/16*7*i)+(i*5*(size/16)), centerY-5, word.substring(i, i+1));
			letters[i].grow((((size-16)/32)*(temp.getWidth())), ((size-16)/2));
			letters[i].translate((underscores[i].getX()+underscores[i].getWidth()/2)-(letters[i].getX()+letters[i].getWidth()/2)-1, 0);
		}
		g = new Gallows();
		l = new LettersDisplay();
		f = new Figure();
		unguessed = l.getLetters();
		guessWord = word;
		originalWord = word;
	}
	
	public void guess(String guessedLetter) {
		guessedLetter = guessedLetter.toUpperCase();
		boolean trueGuess = false;
		int index = 0;
		if(unguessed.contains(guessedLetter)) {
			unguessed.remove(unguessed.indexOf(guessedLetter));
			while(guessWord.indexOf(guessedLetter) >= 0) {
				letters[originalWord.indexOf(guessedLetter, index)].draw();
				guessWord = guessWord.substring(0, guessWord.indexOf(guessedLetter))+guessWord.substring(guessWord.indexOf(guessedLetter)+1, guessWord.length());
				trueGuess = true;
				index = originalWord.indexOf(guessedLetter, index)+1;
			}
			if(trueGuess) {
				l.setGreen(guessedLetter);
			}
			else {
				if(originalWord.indexOf(guessedLetter) < 0) {
					l.setRed(guessedLetter);
					f.next();
				}
			}
		}
		
	}
	
	public boolean gameOver() {
		if(f.count == f.numOfLimbs) {
			for(int i = 0; i < letters.length; i++) {
				letters[i].draw();
			}
		}
		if(guessWord.length() == 0 || f.count == f.numOfLimbs) {
			Canvas.pause(1000);
			translate(-600, 0);
		}
		return (guessWord.length() == 0 || f.count == f.numOfLimbs);
	}
	
	public void draw() {
		background.fill();
		g.addOutline();
		g.draw();
		l.draw();
		for(int i = 0; i < underscores.length; i++) {
			underscores[i].draw();
		}
	}
	
	public void translate(int x, int y) {
		background.translate(x, y);
		for(int i = 0; i < letters.length; i++) {
			letters[i].translate(x, y);
			underscores[i].translate(x, y);
		}
		g.translate(x, y);
		l.translate(x, y);
		f.translate(x, y);;
	}
}
