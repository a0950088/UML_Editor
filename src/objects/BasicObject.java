package objects;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;  

public class BasicObject extends Objects{
//	protected String type;
	protected String objname = "Objects";
	protected Rectangle range;
	protected boolean isSelected = false;
	protected int width;
	protected int height;
	protected Point[] port = {new Point(),new Point(),new Point(),new Point()};
	protected Polygon[] portsRange;
	protected int moveXoffset = 0, moveYoffset = 0;
//	public BasicObject(Point point){
//		
//	}
	
	@Override
	public void drawObject(Graphics g) {
		System.out.println("BasicClass paint");
	    g.setColor(Color.black);
	    g.fillRect(range.x+(width/2)-3, range.y-6, 6, 6);
	    g.fillRect(range.x-6, range.y+(height/2)-3, 6, 6);
	    g.fillRect(range.x+width, range.y+(height/2)-3, 6, 6);
	    g.fillRect(range.x+(width/2)-3, range.y+height, 6, 6);
	}
	
	public void setPorts() {
		port[0].setLocation(range.x+width/2, range.y);
		port[1].setLocation(range.x, range.y+height/2);
		port[2].setLocation(range.x+width/2, range.y+height);
		port[3].setLocation(range.x+width, range.y+height/2);
		
		portsRange = new Polygon[] {
	        new Polygon(new int[] {range.x, range.x+width, range.x+width/2},
	            new int[] {range.y, range.y, range.y+height/2}, 3),
	        new Polygon(new int[] {range.x, range.x, range.x+width/2},
		            new int[] {range.y+height, range.y, range.y+height/2}, 3),
	        new Polygon(new int[] {range.x+width, range.x, range.x+width/2},
	            new int[] {range.y+height, range.y+height, range.y+height/2}, 3),
	        new Polygon(new int[] {range.x+width, range.x+width, range.x+width/2},
		            new int[] {range.y, range.y+height, range.y+height/2}, 3)
	    };
	}
	
	public Point[] getPorts() {
		return this.port;
	}
	
	public Point checkPort(Point point) {
		for(int i=0; i<portsRange.length;i++) {
	        if(portsRange[i].contains(point))
	          return port[i];
	    }
		return null;
	}
	
	public Rectangle getRange() {
		return this.range;
	}
	
	public void setRange(int x,int y) {
		this.moveXoffset = x;
		this.moveYoffset = y;
	}
	
	public int[] getBasicObjMoveOffset() {
		int[] offset = {moveXoffset,moveYoffset};
		return offset;
	}
	
	public void resetObjPosition() {
		range.x += this.moveXoffset;
		range.y += this.moveYoffset;
		setPorts();
		this.moveXoffset = 0;
		this.moveYoffset = 0;
	}
	
	public void setSelectedCondition(boolean condition) {
		this.isSelected = condition;
	}
	
	public boolean getSelectedCondition() {
		return this.isSelected;
	}
	
	public void changeObjName(String newName) {
		this.objname = newName;
	}
	
//	public abstract ArrayList<BasicObject> getGroupObjList();
}
