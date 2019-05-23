import pkg.*;

public class starter {
	
	public static void main(String args[]) {
		Rectangle[] gallows = new Rectangle[3];
		Color gallowsColor = new Color(140 , 70 , 20);
		gallows[0] = new Rectangle(50 , 430 , 200 , 20);
		gallows[1] = new Rectangle(70 , 130 , 15 , 300);
		gallows[2] = new Rectangle( ,  ,  , );
		Rectangle[] outlines = new Rectangle[gallows.length];
		for(int x = 0; x < gallows.length; x++) {
			gallows[x].setColor(gallowsColor);
			gallows[x].fill();
			outlines[x] = new Rectangle(gallows[x].getX() , gallows[x].getY() , gallows[x].getWidth() , gallows[x].getHeight());
			outlines[x].draw();
			
		}
		Rectangle baseOutline = new Rectangle(50 , 430 , 200 , 20);
		baseOutline.draw();
		/*
		Rectangle hardOutline = new Rectangle(249 , 429 , 2 , 22);
		hardOutline.fill();
		
		boolean notTouching = true;
		for(int y = 0; y < ; y++) {
			if(y+1 == )
		}
		if(notTouching) {
			Rectangle hardOutline = new Rectangle(49 , 429 , 2 , 22);
			hardOutline.fill();
		}
		
		Rectangle hardOutline = new Rectangle(49 , 449 , 202 , 2);
		hardOutline.fill();
		
		
		*/
	}
}
