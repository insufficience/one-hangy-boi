import pkg.*;
import java.util.ArrayList;

public class Gallows {
	
	private Rectangle[] gallows;
	private ArrayList<Rectangle> hardOutlines = new ArrayList<>();
	private int hardOutlineWidth = 4;
	private Color gallowsColor = new Color(140, 70, 20);
	private int x = 50;
	private int y = 115;
	
	public Gallows() {
		gallows = new Rectangle[5];
		gallows[0] = new Rectangle(x, y+315, 250, 20);
		gallows[1] = new Rectangle(x+20, y+15, 15, 300);
		gallows[2] = new Rectangle(x+10, y, 128, 15);
		gallows[3] = new Rectangle(x+125, y+17, 0, 10);
		gallows[4] = new Rectangle(x+123, y+29, 4, 46);
		for(int i = 0; i < gallows.length; i++) {
			gallows[i].setColor(gallowsColor);
		}
		gallows[3].setColor(Color.BLACK);
		gallows[4].setColor(new Color(120, 50, 0));
	}
	
	public void addOutline() {
		for(int top = 0; top < gallows.length; top++) {
			ArrayList<Integer> touchPoints = new ArrayList<>();
			for(int a = 0; a < top; a++) {
				if(gallows[a].getY() <= gallows[top].getY() && gallows[a].getY()+gallows[a].getHeight() >= gallows[top].getY() && ((gallows[a].getX() > gallows[top].getX() && gallows[a].getX() < gallows[top].getX()+gallows[top].getWidth()) || (gallows[a].getX()+gallows[a].getWidth() > gallows[top].getX() && gallows[a].getX()+gallows[a].getWidth() < gallows[top].getX()+gallows[top].getWidth()) || (gallows[a].getX() < gallows[top].getX() && gallows[a].getX()+gallows[a].getWidth() > gallows[top].getX()+gallows[top].getWidth()))) {
					touchPoints.add(gallows[a].getX());
					touchPoints.add(gallows[a].getX()+gallows[a].getWidth());
				}
			}
			for(int b = top+1; b < gallows.length; b++) {
				if(gallows[b].getY() <= gallows[top].getY() && gallows[b].getY()+gallows[b].getHeight() >= gallows[top].getY() && ((gallows[b].getX() > gallows[top].getX() && gallows[b].getX() < gallows[top].getX()+gallows[top].getWidth()) || (gallows[b].getX()+gallows[b].getWidth() > gallows[top].getX() && gallows[b].getX()+gallows[b].getWidth() < gallows[top].getX()+gallows[top].getWidth()) || (gallows[b].getX() < gallows[top].getX() && gallows[b].getX()+gallows[b].getWidth() > gallows[top].getX()+gallows[top].getWidth()))) {
					touchPoints.add(gallows[b].getX());
					touchPoints.add(gallows[b].getX()+gallows[b].getWidth());
				}
			}
			if(touchPoints.size() == 0) {
				hardOutlines.add(new Rectangle(gallows[top].getX()-(hardOutlineWidth/2), gallows[top].getY()-(hardOutlineWidth/2), gallows[top].getWidth()+hardOutlineWidth, hardOutlineWidth));
				hardOutlines.get(hardOutlines.size()-1).fill();
			}
			else {
				System.out.println("top "+top+" "+touchPoints);
				int start = gallows[top].getX();
				while(start < gallows[top].getX()+gallows[top].getWidth()) {
					for(int c = 0; c < touchPoints.size(); c = c+2) {
						if(touchPoints.get(c) <= start) {
							start = touchPoints.get(c+1);
							touchPoints.remove(c);
							touchPoints.remove(c);
							c = c-2;
						}
					}
					int end = gallows[top].getX()+gallows[top].getWidth();
					int nextStart = end;
					for(int d = 0; d < touchPoints.size(); d = d+2) {
						if(touchPoints.get(d) < end) {
							end = touchPoints.get(d);
							nextStart = touchPoints.get(d+1);
						}
					}
					hardOutlines.add(new Rectangle(start-(hardOutlineWidth/2), gallows[top].getY()-(hardOutlineWidth/2), end-start+hardOutlineWidth, hardOutlineWidth));
					hardOutlines.get(hardOutlines.size()-1).fill();
					start = nextStart;
				}
			}
		}
		for(int left = 0; left < gallows.length; left++) {
			ArrayList<Integer> touchPoints = new ArrayList<>();
			for(int a = 0; a < left; a++) {
				if(gallows[a].getX() <= gallows[left].getX() && gallows[a].getX()+gallows[a].getWidth() >= gallows[left].getX() && ((gallows[a].getY() > gallows[left].getY() && gallows[a].getY() < gallows[left].getY()+gallows[left].getHeight()) || (gallows[a].getY()+gallows[a].getHeight() > gallows[left].getY() && gallows[a].getY()+gallows[a].getHeight() < gallows[left].getY()+gallows[left].getHeight()) || (gallows[a].getY() < gallows[left].getY() && gallows[a].getY()+gallows[a].getHeight() > gallows[left].getY()+gallows[left].getHeight()))) {
					touchPoints.add(gallows[a].getY());
					touchPoints.add(gallows[a].getY()+gallows[a].getHeight());
				}
			}
			for(int b = left+1; b < gallows.length; b++) {
				if(gallows[b].getX() <= gallows[left].getX() && gallows[b].getX()+gallows[b].getWidth() >= gallows[left].getX() && ((gallows[b].getY() > gallows[left].getY() && gallows[b].getY() < gallows[left].getY()+gallows[left].getHeight()) || (gallows[b].getY()+gallows[b].getHeight() > gallows[left].getY() && gallows[b].getY()+gallows[b].getHeight() < gallows[left].getY()+gallows[left].getHeight()) || (gallows[b].getY() < gallows[left].getY() && gallows[b].getY()+gallows[b].getHeight() > gallows[left].getY()+gallows[left].getHeight()))) {
					touchPoints.add(gallows[b].getY());
					touchPoints.add(gallows[b].getY()+gallows[b].getHeight());
				}
			}
			if(touchPoints.size() == 0) {
				hardOutlines.add(new Rectangle(gallows[left].getX()-(hardOutlineWidth/2), gallows[left].getY()-(hardOutlineWidth/2), hardOutlineWidth, gallows[left].getHeight()+hardOutlineWidth));
				hardOutlines.get(hardOutlines.size()-1).fill();
			}
			else {
				System.out.println("left "+left+" "+touchPoints);
				int start = gallows[left].getY();
				while(start < gallows[left].getY()+gallows[left].getHeight()) {
					for(int c = 0; c < touchPoints.size(); c = c+2) {
						if(touchPoints.get(c) <= start) {
							start = touchPoints.get(c+1);
							touchPoints.remove(c);
							touchPoints.remove(c);
							c = c-2;
						}
					}
					int end = gallows[left].getY()+gallows[left].getHeight();
					int nextStart = end;
					for(int d = 0; d < touchPoints.size(); d = d+2) {
						if(touchPoints.get(d) < end) {
							end = touchPoints.get(d);
							nextStart = touchPoints.get(d+1);
						}
					}
					hardOutlines.add(new Rectangle(gallows[left].getX()-(hardOutlineWidth/2), start-(hardOutlineWidth/2), hardOutlineWidth, end-start+hardOutlineWidth));
					hardOutlines.get(hardOutlines.size()-1).fill();
					start = nextStart;
				}
			}
		}
		for(int bottom = 0; bottom < gallows.length; bottom++) {
			ArrayList<Integer> touchPoints = new ArrayList<>();
			for(int a = 0; a < bottom; a++) {
				if(gallows[a].getY()+gallows[a].getHeight() >= gallows[bottom].getY()+gallows[bottom].getHeight() && gallows[a].getY() <= gallows[bottom].getY()+gallows[bottom].getHeight() && ((gallows[a].getX()+gallows[bottom].getWidth() > gallows[bottom].getX() && gallows[a].getX() < gallows[bottom].getX()+gallows[bottom].getWidth()) || (gallows[a].getX()+gallows[a].getWidth() > gallows[bottom].getX() && gallows[a].getX()+gallows[a].getWidth() < gallows[bottom].getX()+gallows[bottom].getWidth()) || (gallows[a].getX() < gallows[bottom].getX() && gallows[a].getX()+gallows[a].getWidth() > gallows[bottom].getX()+gallows[bottom].getWidth()))) {
					touchPoints.add(gallows[a].getX());
					touchPoints.add(gallows[a].getX()+gallows[a].getWidth());
				}
			}
			for(int b = bottom+1; b < gallows.length; b++) {
				if(gallows[b].getY()+gallows[b].getHeight() >= gallows[bottom].getY()+gallows[bottom].getHeight() && gallows[b].getY() <= gallows[bottom].getY()+gallows[bottom].getHeight() && ((gallows[b].getX()+gallows[bottom].getWidth() > gallows[bottom].getX() && gallows[b].getX() < gallows[bottom].getX()+gallows[bottom].getWidth()) || (gallows[b].getX()+gallows[b].getWidth() > gallows[bottom].getX() && gallows[b].getX()+gallows[b].getWidth() < gallows[bottom].getX()+gallows[bottom].getWidth()) || (gallows[b].getX() < gallows[bottom].getX() && gallows[b].getX()+gallows[b].getWidth() > gallows[bottom].getX()+gallows[bottom].getWidth()))) {
					touchPoints.add(gallows[b].getX());
					touchPoints.add(gallows[b].getX()+gallows[b].getWidth());
				}
			}
			if(touchPoints.size() == 0) {
				hardOutlines.add(new Rectangle(gallows[bottom].getX()-(hardOutlineWidth/2), gallows[bottom].getY()+gallows[bottom].getHeight()-(hardOutlineWidth/2), gallows[bottom].getWidth()+hardOutlineWidth, hardOutlineWidth));
				hardOutlines.get(hardOutlines.size()-1).fill();
			}
			else {
				System.out.println("bottom "+bottom+" "+touchPoints);
				int start = gallows[bottom].getX();
				while(start < gallows[bottom].getX()+gallows[bottom].getWidth()) {
					for(int c = 0; c < touchPoints.size(); c = c+2) {
						if(touchPoints.get(c) <= start) {
							start = touchPoints.get(c+1);
							touchPoints.remove(c);
							touchPoints.remove(c);
							c = c-2;
						}
					}
					int end = gallows[bottom].getX()+gallows[bottom].getWidth();
					int nextStart = end;
					for(int d = 0; d < touchPoints.size(); d = d+2) {
						if(touchPoints.get(d) < end) {
							end = touchPoints.get(d);
							nextStart = touchPoints.get(d+1);
						}
					}
					hardOutlines.add(new Rectangle(start-(hardOutlineWidth/2), gallows[bottom].getY()+gallows[bottom].getHeight()-(hardOutlineWidth/2), end-start+hardOutlineWidth, hardOutlineWidth));
					hardOutlines.get(hardOutlines.size()-1).fill();
					start = nextStart;
				}
			}
		}
		for(int right = 0; right < gallows.length; right++) {
			ArrayList<Integer> touchPoints = new ArrayList<>();
			for(int a = 0; a < right; a++) {
				if(gallows[a].getX()+gallows[a].getWidth() >= gallows[right].getX()+gallows[right].getWidth() && gallows[a].getX() <= gallows[right].getX()+gallows[right].getWidth() && ((gallows[a].getY() > gallows[right].getY() && gallows[a].getY() < gallows[right].getY()+gallows[right].getHeight()) || (gallows[a].getY()+gallows[a].getHeight() > gallows[right].getY() && gallows[a].getY()+gallows[a].getHeight() < gallows[right].getY()+gallows[right].getHeight()) || (gallows[a].getY() < gallows[right].getY() && gallows[a].getY()+gallows[a].getHeight() > gallows[right].getY()+gallows[right].getHeight()))) {
					touchPoints.add(gallows[a].getY());
					touchPoints.add(gallows[a].getY()+gallows[a].getHeight());
				}
			}
			for(int b = right+1; b < gallows.length; b++) {
				if(gallows[b].getX()+gallows[b].getWidth() >= gallows[right].getX()+gallows[right].getWidth() && gallows[b].getX() <= gallows[right].getX()+gallows[right].getWidth() && ((gallows[b].getY() > gallows[right].getY() && gallows[b].getY() < gallows[right].getY()+gallows[right].getHeight()) || (gallows[b].getY()+gallows[b].getHeight() > gallows[right].getY() && gallows[b].getY()+gallows[b].getHeight() < gallows[right].getY()+gallows[right].getHeight()) || (gallows[b].getY() < gallows[right].getY() && gallows[b].getY()+gallows[b].getHeight() > gallows[right].getY()+gallows[right].getHeight()))) {
					touchPoints.add(gallows[b].getY());
					touchPoints.add(gallows[b].getY()+gallows[b].getHeight());
				}
			}
			if(touchPoints.size() == 0) {
				hardOutlines.add(new Rectangle(gallows[right].getX()+gallows[right].getWidth()-(hardOutlineWidth/2), gallows[right].getY()-(hardOutlineWidth/2), hardOutlineWidth, gallows[right].getHeight()+hardOutlineWidth));
				hardOutlines.get(hardOutlines.size()-1).fill();
			}
			else {
				System.out.println("right "+right+" "+touchPoints);
				int start = gallows[right].getY();
				while(start < gallows[right].getY()+gallows[right].getHeight()) {
					for(int c = 0; c < touchPoints.size(); c = c+2) {
						if(touchPoints.get(c) <= start) {
							start = touchPoints.get(c+1);
							touchPoints.remove(c);
							touchPoints.remove(c);
							c = c-2;
						}
					}
					int end = gallows[right].getY()+gallows[right].getHeight();
					int nextStart = end;
					for(int d = 0; d < touchPoints.size(); d = d+2) {
						if(touchPoints.get(d) < end) {
							end = touchPoints.get(d);
							nextStart = touchPoints.get(d+1);
						}
					}
					hardOutlines.add(new Rectangle(gallows[right].getX()+gallows[right].getWidth()-(hardOutlineWidth/2), start-(hardOutlineWidth/2), hardOutlineWidth, end-start+hardOutlineWidth));
					hardOutlines.get(hardOutlines.size()-1).fill();
					start = nextStart;
				}
			}
		}
	}
	
	public void draw() {
		for(int i = 0; i < gallows.length; i++) {
			gallows[i].fill();
		}
		for(int j = 0; j < hardOutlines.size(); j++) {
			hardOutlines.get(j).fill();
		}
	}
}
