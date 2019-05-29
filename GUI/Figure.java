import pkg.*;
import java.util.ArrayList;

public class Figure {
	private int count = 0;
	
	
	public Figure(){
		
	}
	
	public void next(){
		if(count == 0){
			head();
		}
		// else if(count == 1){
			// body();
		// }
		// else if(count == 2){
			// arm1();
		// }
		// else if(count == 3){
			// arm2();
		// }
		// else if(count == 4){
			// leg1();
		// }
		// else if(count == 5){
			// leg2();
		// }
		// else{
			
		// }
	}
	
	//173,190
	private void head(){
		Ellipse head = new Ellipse(150,190,50,50);
		head.fill();
	}
}
