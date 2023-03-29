package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class UseCaseObject extends BasicObject{
	
	public UseCaseObject(Point point) {
		super.type = "USECASEOBJ";
		super.width = 80;
	    super.height = 40;
	    range = new Rectangle(point.x, point.y, width, height);
	    objname = "useCase";
	    setPorts();
	}
	@Override
	public void testprint() {
		System.out.println("class UseCaseObject"+super.getDepth());
	}
	@Override
	public void drawObject(Graphics g) {
//		System.out.println("UseCaseObject paint");
		if(super.getSelectedCondition()) {
			super.drawObject(g);			
		}
	    g.setColor(Color.white);
	    g.fillOval(range.x, range.y, width, height);
	    g.setColor(Color.black);
	    g.drawOval(range.x, range.y, width, height);
	    g.drawString(objname, range.x+width/3, range.y+height/2);
	}
}
