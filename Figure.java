import pkg.*;
import java.util.ArrayList;
import java.awt.Polygon;

public class Figure {
	
	public int count = 0;
	public int numOfLimbs = 6;
	private Ellipse headShape;
	private Rectangle bodyShape;
	private Rectangle arm1ShapeA;
	private Rectangle arm1ShapeB;
	private Rectangle arm2ShapeA;
	private Rectangle arm2ShapeB;
	private Rectangle leg1Shape;
	private Rectangle leg2Shape;
	
	public Figure() {
		headShape = new Ellipse(150, 190, 50, 50);
		bodyShape = new Rectangle(150, 240, 50, 100);
		arm1ShapeA = new Rectangle(125, 245, 30, 20);
		arm1ShapeB = new Rectangle(125, 245, 20, 65);
		arm2ShapeA = new Rectangle(195, 245, 30, 20);
		arm2ShapeB = new Rectangle(205, 245, 20, 65);
		leg1Shape = new Rectangle(150, 340, 20, 50);
		leg2Shape = new Rectangle(180, 340, 20, 50);
	}
	
	public void next() {
		if(count == 0) {
			head();		
		}
		else if(count == 1) {
			body();
		}
		else if(count == 2) {
			arm1();
		}
		else if(count == 3) {
			arm2();
		}
		else if(count == 4) {
			leg1();
		}
		else if(count == 5) {
			leg2();
		}
		else {
			
		}
		count++;
	}
	
	//175,190
	private void head() {
		headShape.fill();
	}
	
	private void body() {
		bodyShape.fill();
	}
	
	private void arm1() {
		arm1ShapeA.fill();
		arm1ShapeB.fill();
	}
	
	private void arm2() {
		arm2ShapeA.fill();
		arm2ShapeB.fill();
	}
	
	private void leg1() {
		leg1Shape.fill();
	}
	
	private void leg2() {
		leg2Shape.fill();
	}
	
	public void translate(int x, int y) {
		headShape.translate(x, y);
		bodyShape.translate(x, y);
		arm1ShapeA.translate(x, y);
		arm1ShapeB.translate(x, y);
		arm2ShapeA.translate(x, y);
		arm2ShapeB.translate(x, y);
		leg1Shape.translate(x, y);
		leg2Shape.translate(x, y);
	}
}
