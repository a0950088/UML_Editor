package objects;

import javax.swing.*;
import java.awt.event.*;
import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;  

public class ClassObject extends BasicObject{

	public ClassObject(Point point) {
//		super(point);
		super.type = "CLASSOBJ";
		super.width = 80;
	    super.height = 60;
	    super.range = new Rectangle(point.x, point.y, width, height);
	    objname = "Class";
	    setPorts();
	}
	@Override
	public void testprint() {
		System.out.println("class ClassObjects"+super.getDepth());
	}
	@Override
	public void drawObject(Graphics g) {
		System.out.println("Class paint");
		System.out.println(super.getSelectedCondition());
		if(super.getSelectedCondition()) {
			super.drawObject(g);
		}
	    g.setColor(Color.white);
	    g.fillRect(range.x, range.y, width, height);
	    g.setColor(Color.black);
	    g.drawRect(range.x, range.y, width, height);
	    g.drawLine(range.x, range.y + height / 3, range.x + width,
	        range.y + height / 3);
	    g.drawLine(range.x, range.y + (height / 3) * 2, range.x + width,
	        range.y + (height / 3) * 2);
	    g.drawString(objname, range.x+width/3, range.y+height/6);
	}
}
