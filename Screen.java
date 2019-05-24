import pkg.*;
import java.util.ArrayList;

public class Screen implements DesignTeamExpectations, InputKeyControl,InputControl {
	
	private double ex = 0;
	private double why = 0;
	private String a;
	private boolean askingForGuess = false;
	private String b;
	
	public Screen() {
		KeyController kC = new KeyController(Canvas.getInstance(), new Screen());
		MouseController mC = new MouseController(Canvas.getInstance(), new Screen());
	}
	
	public void keyPress(String es) {
		if(askingForGuess) {
			b = a;
			a = es;
			askingForGuess = false;
		}
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
			if(ex >= one.getX() && ex <= one.getX()+one.getLength()&&why >= one.getY() && why <= one.getY()+one.getHeight()){
				return false;
			}
			if(ex >= two.getX() && ex <= two.getX()+two.getLength()&&why >= two.getY() && why <= two.getY()+two.getHeight()){
				return true;
			}
		}
		return false;
	}
	public void onMouseClick(double x, double y){
		ex=x;
		why=y;
	}
	public String getGuess() {
		askingForGuess = true;
		while(a.equals(b)) {
			
		}
		guess(a);
		return a;
	}
}
