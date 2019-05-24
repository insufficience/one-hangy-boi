import pkg.*;
import java.util.ArrayList;

public class starter {
	
	public static void main(String args[]) {
		Gallows g = new Gallows();
		g.addOutline();
		g.draw();
		WordDisplay w = new WordDisplay("fish");
		w.draw();
	}
}
