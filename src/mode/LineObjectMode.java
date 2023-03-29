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
	
	@Override
	public void testprint() {
		System.out.println("LineObjectMode");
	}
	@Override  
    public void mouseClicked(MouseEvent e) {  
        // TODO Auto-generated method stub  
//        System.out.println("LineObjectMode clicked");
        
//        super.canvas.repaint();
    }  
    @Override  
    public void mousePressed(MouseEvent e) {
    	int i=0;
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
        	if(super.getObjectType() == "ASSOCIATION") {
            	super.generativeobj = new AssociationLineObject(startport,endport,startobj,endobj);
            }
            else if(super.getObjectType() == "GENERALIZATION") {    	
            	super.generativeobj = new GeneralizationLineObject(startport,endport,startobj,endobj);
            }
            else if(super.getObjectType() == "COMPOSITION") {    	
            	super.generativeobj = new CompositionLineObject(startport,endport,startobj,endobj);
            }
//            System.out.println("--------------------------------"); 
            super.setObjectList();
            super.canvas.repaint();
        }
    }  
    @Override
    public void mouseDragged(MouseEvent e) {
//    	System.out.println("LineObjectMode mouseDragged");  
//    	System.out.println(e.getX() + "，" + e.getY());  
    	
    }
  
//    @Override  
//    public void mouseEntered(MouseEvent e) {  
//        // TODO Auto-generated method stub  
//    	System.out.println("LineObjectMode in canvas"); 
//    }  
//  
//    @Override  
//    public void mouseExited(MouseEvent e) {  
//        // TODO Auto-generated method stub  
//    	System.out.println("LineObjectMode out canvas"); 
//    } 
}
