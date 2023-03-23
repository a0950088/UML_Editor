package gui;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;  
import mode.ModeSelector;
import objects.ClassObject;
import objects.UseCaseObject;
import java.awt.event.MouseAdapter;  
import java.awt.event.MouseListener; 
public class MyCanvas extends Canvas{
	ModeSelector mode;
	public MyCanvas() {    
	    setBackground (Color.white);    
//	    setSize(300, 200);    
	 }    
  
	public void setModeSelector(ModeSelector m) {
		System.out.println("add setModeSelector!");
		m.testprint();
		mode = m;
	}
	
	@Override
	public void paint(Graphics g)
	{    
		System.out.println("paint!");
		super.paint(g);
		mode.drawObject(g);
	}
}
