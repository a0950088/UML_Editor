package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import controller.ObjectController;

public class CompositeObject extends BasicObject{
	public ArrayList<BasicObject> groupobjsarr = new ArrayList<BasicObject>();
	public CompositeObject(ArrayList<BasicObject> groupobjs) {
	    for(BasicObject o:groupobjs) {
	    	o.setSelectedCondition(false);
	    	groupobjsarr.add(o);
	    }
	    super.type = "COMPOSITEOBJ";
		super.range = setGroupRange();
		super.width = super.range.width;
	    super.height = super.range.height;
	    objname = "Composite";
//	    setPorts();
	}
	
	@Override
	public void testprint() {
		System.out.println("class CompositeObject"+super.getDepth());
	}
	
	private Rectangle setGroupRange() {
		int xmin = Integer.MAX_VALUE,ymin = Integer.MAX_VALUE;
		int xmax = Integer.MIN_VALUE,ymax = Integer.MIN_VALUE;
		for(BasicObject o:groupobjsarr) {
			System.out.println(o.range);
			xmin = Math.min(xmin, o.range.x);
			ymin = Math.min(ymin, o.range.y);
			xmax = Math.max(xmax, o.range.x+o.range.width);
			ymax = Math.max(ymax, o.range.y+o.range.height);
		}
		System.out.println(xmin+" "+ymin+" "+xmax+" "+ymax);
		return new Rectangle(xmin,ymin,Math.abs(xmax-xmin),Math.abs(ymax-ymin));
	}
	
	@Override
	public void drawObject(Graphics g) {
		g.setColor(Color.white);
	    g.drawRect(range.x, range.y, width, height);//changed
	    g.setColor(Color.black);
	    for(BasicObject o:this.groupobjsarr) {
	    	o.drawObject(g);
	    }
	    g.drawString(objname, range.x+width-20, range.y+10);
	}
	
	@Override
	public void setRange(int x,int y) {
		super.moveXoffset = x;
		super.moveYoffset = y;
		for(BasicObject o:groupobjsarr) {
			o.setRange(moveXoffset, moveYoffset);
			o.resetObjPosition();
		}
	}
	
	public ArrayList<BasicObject> getGroupObjList(){
		return groupobjsarr;
	}
}
