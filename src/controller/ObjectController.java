package controller;

import objects.Objects;
import objects.BasicObject;
import objects.LineObject;
import objects.CompositeObject;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;
public class ObjectController {
	private static ArrayList<BasicObject> basicobjlist = new ArrayList<BasicObject>();
	private static ArrayList<LineObject> lineobjlist = new ArrayList<LineObject>();
	private static ArrayList<Objects> objlist = new ArrayList<Objects>();
	private static int depth = 0;
	private static ArrayList<BasicObject> groupobjs = new ArrayList<BasicObject>();
	public static void setList(Objects obj, String type) {
		switch(type) {
		 case "CLASS":
		 case "USECASE":
		 case "COMPOSITE":
			 basicobjlist.add((BasicObject) obj);
			 break;
		 case "ASSOCIATION":
		 case "GENERALIZATION":
		 case "COMPOSITION":
			 lineobjlist.add((LineObject) obj);
			 break;
		}
		obj.setDepth(depth);
		depth++;
		objlist.add(obj);
		System.out.println("Controller----");
		for(Objects o:objlist) {
			o.testprint();
		}
		System.out.println("Controller----");
	}
	
	public static void isMultiObjInSelectRec(Point p1,Point p2) {
		Rectangle selectedrec = new Rectangle(Math.min(p1.x, p2.x), Math.min(p1.y, p2.y), Math.abs(p1.x - p2.x), Math.abs(p1.y - p2.y));
		for(BasicObject o:basicobjlist) {
			if(selectedrec.contains(o.getRange())) {
				System.out.println("In multi basicobj");
				o.setSelectedCondition(true);
				groupobjs.add(o);
			}
		}
	}
	
	public static BasicObject isInBasicobjRange(Point point) {		
		BasicObject lastobj = null;
		for(BasicObject o:basicobjlist) {
			o.setSelectedCondition(false);
			if(o.getRange().contains(point)) {
				System.out.println("In basicobj");
				lastobj = o;
			}
		}
		if(lastobj==null) {
			return null;
		}
		else {
			return lastobj;
		}
	}
	
	public static void Group() {
		if(groupobjs.size()<=1) {
			System.out.println("Can't Group!");
		}
		else {
			System.out.println("Group!");
			CompositeObject compositeobj = new CompositeObject(groupobjs);
			for(BasicObject o:groupobjs) {
				o.testprint();
				objlist.remove(o);
				basicobjlist.remove(o);
			}
			ObjectController.setList(compositeobj, "COMPOSITE");
		}
		groupobjs.clear();
	}
	
	public static void UnGroup(BasicObject obj) {
		System.out.println("UNGROUP");
		CompositeObject compositeobj = (CompositeObject) obj;
		objlist.addAll(compositeobj.getGroupObjList());
		Collections.sort(objlist, new Comparator<Objects>() {
	        @Override
	        public int compare(Objects o1, Objects o2) {
	        	return o1.getDepth() - o2.getDepth();
	        }
	    });
		basicobjlist.addAll(compositeobj.getGroupObjList());
		Collections.sort(basicobjlist, new Comparator<BasicObject>() {
	        @Override
	        public int compare(BasicObject o1, BasicObject o2) {
	        	return o1.getDepth() - o2.getDepth();
	        }
	    });
		objlist.remove(compositeobj);
		basicobjlist.remove(compositeobj);
		compositeobj = null;
		for(Objects o:objlist) {
			o.testprint();
		}
		System.out.println("-------------------");
		for(BasicObject o:basicobjlist) {
			o.testprint();
		}
	}
	
	public static ArrayList<LineObject> getLine(){
		return lineobjlist;		
	}
	
	public static void resetLine() {
		for(LineObject lo: lineobjlist) {
			lo.resetLinePosition();
		}
	}
	public static void unMove() {
		for(BasicObject o:basicobjlist) {
			o.setRange(0, 0);
		}
	}
	
	public static void drawObject(Graphics g) {
		if(objlist != null) {
			g.setColor(Color.black);
			for(Objects o:objlist) {
				o.drawObject(g);	
			}
		}
	}
}
