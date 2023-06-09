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
import objects.ClassObject;
import objects.UseCaseObject;
import toolkit.ObjectFactory;
import objects.BasicObject;

public class BasicObjectMode extends ModeSelector{
	
	public BasicObjectMode(String type){
		super(type);
	}
	
	@Override
	public void testprint() {
		System.out.println("BasicObjectMode");
	}
	@Override  
    public void mouseClicked(MouseEvent e) {  
        // Generate BasicObject	
//        System.out.println("BasicObjectMode clicked");
		System.out.println("Create Basic Object");
		super.generativeobj = ObjectFactory.createBasicObject(super.objecttype, e.getPoint());
//		if(super.getObjectType() == "CLASS") {
//        	super.generativeobj = new ClassObject(e.getPoint());
//        }
//        else if(super.getObjectType() == "USECASE") {   	
//        	super.generativeobj = new UseCaseObject(e.getPoint());
//        }
//    	System.out.println("--------------------------------");
        super.setObjectList();
        super.canvas.repaint();
        
        
    }  
    @Override  
    public void mousePressed(MouseEvent e) {  
        // TODO Auto-generated method stub  
//        System.out.println("BasicObjectMode pressed");  
    }  
  
    @Override  
    public void mouseReleased(MouseEvent e) {  
        // TODO Auto-generated method stub  
//        System.out.println("BasicObjectMode released");  
    }  
  
}
