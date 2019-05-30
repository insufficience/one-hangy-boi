import pkg.*;
import java.util.ArrayList;
import java.awt.Polygon;

public class Figure {
	
	public int count = 0;
	public int numOfLimbs = 6;
	private Ellipse headShape;
	
	public Figure() {
		headShape = new Ellipse(150, 190, 50, 50);
	}
	
	public void next() {
		if(count == 0) {
			head();
		}
		// else if(count == 1) {
			// body();
		// }
		// else if(count == 2) {
			// arm1();
		// }
		// else if(count == 3) {
			// arm2();
		// }
		// else if(count == 4) {
			// leg1();
		// }
		// else if(count == 5) {
			// leg2();
		// }
		// else {
			
		// }
		count++;
	}
	
	//173,190
	private void head() {
		headShape.fill();
	}
}
