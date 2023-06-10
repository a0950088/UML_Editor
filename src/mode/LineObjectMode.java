package mode;

import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;  
import objects.GeneralizationLineObject;
import objects.CompositionLineObject;
import objects.AssociationLineObject;
import objects.LineObject;
import toolkit.ObjectFactory;
import objects.BasicObject;
import controller.ObjectController;
import java.lang.Math.*;
import java.util.ArrayList;
import java.util.Arrays;

public class LineObjectMode extends ModeSelector{
	Point startport = null;
	Point endport = null;
	BasicObject startobj = null;
	BasicObject endobj = null;
	
	public LineObjectMode(String type){
		super(type);
	}
	
	@Override
	public void testprint() {
		System.out.println("LineObjectMode");
	}
	@Override  
    public void mouseClicked(MouseEvent e) {}
    @Override  
    public void mousePressed(MouseEvent e) {
//    	System.out.println("LineObjectMode pressed");
        startobj = ObjectController.isInBasicobjRange(e.getPoint()); 
        if(startobj.getObjType()=="COMPOSITEOBJ") {
        	startobj = null;
        }
        if(startobj!=null) {
        	startport = startobj.checkPort(e.getPoint());
    	}
    }
  
    @Override  
    public void mouseReleased(MouseEvent e) {  
        // TODO Auto-generated method stub  
//        System.out.println("LineObjectMode released");  
        endobj = ObjectController.isInBasicobjRange(e.getPoint());
        if(endobj.getObjType()=="COMPOSITEOBJ") {
        	endobj = null;
        }
        if(startobj!=null && endobj!=null && endobj!=startobj) {
        	endport = endobj.checkPort(e.getPoint());
        	System.out.println("Create Line"); 
        	super.generativeobj = ObjectFactory.createLineObject(objecttype, startport, endport, startobj, endobj);
            super.setObjectList();
            super.canvas.repaint();
        }
    }  
    @Override
    public void mouseDragged(MouseEvent e) {}
}
