import pkg.*;
import java.util.ArrayList;

public class Screen implements DesignTeamExpectations, InputKeyControl {
	
	private double ex;
	private double why;
	
	public Screen() {
		KeyController kC = new KeyController(Canvas.getInstance(), new starter());
		MouseController mC = new MouseController(Canvas.getInstance(), new starter());
	}
	
	public void keyPress(String es) {
		
	}
	
	public boolean didYouDoIt() {
		
	}
	
	public boolean chooseMode() {
		Rectangle one = new Rectangle(20, 50, 100,50);
		Rectangle two = new Rectangle(140, 50, 100,50);
		one.setColor(Color.BLUE);
		two.setColor(Color.BLUE);
		one.fill();
		two.fill();
		Text single = new Text(30,60,"Single Player");
		Text dwouble = new Text(150,60,"Double Player");
		single.draw();
		dwouble.draw();
		int count =1000;
		while(count>0) {
			count--;
			Canvas.pause(100);
			if(ex >= one.getX() && ex <= one.getX()) {
				
			}
		}
	}
	public void onMouseClick(double x, double y){
		ex=x;
		why=y;
	}
	public String getGuess() {
		
	}
}
