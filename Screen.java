import pkg.*;
import java.util.ArrayList;

public class Screen implements DesignTeamExpectations, InputKeyControl,InputControl {
	
	private double ex = 0;
	private double why = 0;
	private String a;
	private boolean askingForGuess = false;
	private String b;
	private Rectangle one;
	private Text single;
	private Rectangle two;
	private Text dwouble;
	private WordDisplay word;
	private boolean bob;
	
	public Screen() {
		KeyController kC = new KeyController(Canvas.getInstance(), new Screen());
		MouseController mC = new MouseController(Canvas.getInstance(), new Screen());
		one = new Rectangle(20, 50, 100,50);
		two = new Rectangle(140, 50, 100,50);
		one.setColor(Color.BLUE);
		two.setColor(Color.BLUE);
		one.fill();
		two.fill();
		single = new Text(30,60,"Single Player");
		dwouble = new Text(150,60,"Double Player");
		single.draw();
		dwouble.draw();
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
		while(){
			
		}
		return bob;
	}
	public void onMouseClick(double ex, double why){
		if(ex >= one.getX() && ex <= one.getX()+one.getLength()&&why >= one.getY() && why <= one.getY()+one.getHeight()){
			bob= false;
		}
		if(ex >= two.getX() && ex <= two.getX()+two.getLength()&&why >= two.getY() && why <= two.getY()+two.getHeight()){
			bob= true;
		}
		
	}
	public String getGuess() {
		askingForGuess = true;
		while(a.equals(b)) {
			
		}
		guess(a);
		return a;
	}
}
