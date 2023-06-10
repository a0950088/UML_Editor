package mode;

import gui.MyCanvas;

import objects.Objects;
import objects.BasicObject;
import objects.LineObject;
import objects.CompositeObject;
import controller.ObjectController;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.awt.Color;  
import java.awt.Frame;  
import java.awt.Label;
import java.awt.Point;
import java.awt.TextField;  
import java.awt.Graphics;
import java.awt.event.MouseEvent;  
import java.awt.event.MouseAdapter;  
import java.awt.event.MouseListener;  
import java.awt.event.MouseMotionListener;  
import java.awt.event.WindowAdapter;  
import java.awt.event.WindowEvent;  

public class ModeSelector extends MouseAdapter{
	protected MyCanvas canvas;
	protected String objecttype;
	protected Objects generativeobj;
	protected BasicObject selectedobj;
//	protected ArrayList<Objects> objlist;
	
	ModeSelector(String type){
		this.objecttype = type;
	}
	
	public void testprint() {
		System.out.println("ModeSeletor");
	}
	
	public void setCanvas(MyCanvas canvas) {
		this.canvas = canvas;
		if(canvas.getMouseListeners().length != 0) {
			canvas.removeMouseListener(canvas.getMouseListeners()[0]);
			canvas.removeMouseMotionListener(canvas.getMouseMotionListeners()[0]);
		}
		canvas.addMouseListener(this);
		canvas.addMouseMotionListener(this);
		canvas.setModeSelector(this);
	}
	
	public void setObjectType(String objtype) {
		this.objecttype = objtype;
	}
	public String getObjectType() {
		return this.objecttype;
	}
	
	public void setObjectList() {
		ObjectController.setList(generativeobj, getObjectType());
	}
	
	public BasicObject getSelectedObj() {
		return this.selectedobj;
	}
	
	public void drawObject(Graphics g) {
		ObjectController.drawObject(g);
	}
}
