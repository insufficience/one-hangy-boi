import pkg.*;
import java.util.ArrayList;
import java.awt.Polygon;

public class Figure {
	
	public int count = 0;
	public int numOfLimbs = 6;
	private Ellipse headShape;
	private Rectangle bodyShape;
	private Rectangle leg1Shape;
	private Rectangle leg2Shape;
	
	public Figure() {
		headShape = new Ellipse(150, 190, 50, 50);
		bodyShape = new Rectangle(150,240,50,100);
		leg1Shape = new Rectangle(150,340,20,50);
		leg2Shape = new Rectangle(180,340,20,50);
	}
	
	private void arm1(){
		for(int i = 0; i<10; i++){
			Line a = new Line(150+i,240+i,110+i,300+i);
			Line b = new Line(150.5+i, 240.5+i, 110.5+i, 300.5+i);
			a.draw();
			b.draw();
		}
	}
	
	private void arm2(){
		for(int i = 0; i<10; i++){
			Line a = new Line(200-i, 240+i, 240-i, 300+i);
			Line b = new Line(200.5-i, 240.5+i, 240.5-i, 300.5+i);
			b.draw();
			a.draw();
		}
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
	
	//173,190
	private void head() {
		headShape.fill();
	}
	private void body() {
		bodyShape.fill();
	}
	private void leg1(){
		leg1Shape.fill();
	}
	private void leg2(){
		leg2Shape.fill();
	}
}
