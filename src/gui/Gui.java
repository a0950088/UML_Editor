package gui;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.MouseEvent;  
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import mode.BasicObjectMode;
import mode.LineObjectMode;
import mode.ModeSelector;
import mode.SelectMode;
import controller.ObjectController;

public class Gui {
	private JFrame frame;
	private MyCanvas canvas;
	private ArrayList<JButton> buttons;
	private ModeSelector mode;
	
	private Gui(String name) {
		initial(name);
	}
	private void initial(String name) {
		frame = new JFrame(name);
		canvas = new MyCanvas();
		buttons = new ArrayList<JButton>();
		frame.setSize(640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Bar
		JMenuBar mb = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenuItem change_objname = new JMenuItem("Change Object Name");
		change_objname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mode.getObjectType() == "SELECT") {
					System.out.println("Change Object Name");
					String newObjName = JOptionPane.showInputDialog(frame, "Change Object Name:");
					if(newObjName != null) {
						mode.getSelectedObj().changeObjName(newObjName);						
					}
					canvas.repaint();
				}
			}
		});
		JMenuItem group = new JMenuItem("Group");
		group.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mode.getObjectType() == "SELECT") {
					System.out.println("Group Object");
					ObjectController.Group();
				}
	
			}
		});
		JMenuItem ungroup = new JMenuItem("UnGroup");
		ungroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mode.getObjectType() == "SELECT") {
					System.out.println("Ungroup Object");
					ObjectController.UnGroup(mode.getSelectedObj());					
				}
			}
		});
		edit.add(change_objname);
		edit.add(group);
		edit.add(ungroup);
		mb.add(file);mb.add(edit);
		
		//Button
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(null);
		frame.getContentPane().add(buttonPanel, BorderLayout.WEST);
		buttonPanel.setLayout(new GridLayout(0, 1, 0, 0));
		for(int i=0; i<AllButton.values().length; i++) {
			JButton b = new JButton(AllButton.values()[i].getImageIcon());
			b.setBackground(Color.white);
			b.setActionCommand(String.valueOf(AllButton.values()[i]));
			b.addActionListener(new ActionListener() {
				@Override
		        public void actionPerformed(ActionEvent e) {
					JButton clickButton = (JButton) e.getSource();
					String actionCommand = e.getActionCommand();
					
					System.out.println(actionCommand);
					setButtonsSelect(clickButton);
					switch(actionCommand) {
						case "CLASS":
						case "USECASE":
							System.out.println("BasicObjectMode");
							mode = new BasicObjectMode(actionCommand);
							mode.setCanvas(canvas);
							break;
						case "ASSOCIATION":
						case "GENERALIZATION":
						case "COMPOSITION":
							System.out.println("LineObjectMode");
							mode = new LineObjectMode(actionCommand);
							mode.setCanvas(canvas);
							break;
						case "SELECT":
							System.out.println("SelectMode");
							mode = new SelectMode(actionCommand);
							mode.setCanvas(canvas);
							break;
						default:
							System.out.println("Commmand error");
							break;
					}
		        }
			});
			if(i == 0) {
				b.setSelected(true);
				b.setBackground(Color.lightGray);
				mode = new SelectMode("SELECT");
				mode.setCanvas(canvas);
			}
			buttonPanel.add(b);
			buttons.add(b);
		}
		
		//Canvas
		frame.add(canvas,BorderLayout.CENTER);
		frame.setJMenuBar(mb);
		frame.setVisible(true);
	}
	
	public void setButtonsSelect(JButton clickButton) {
		for(JButton b : buttons) {
			b.setBackground(Color.white);
			b.setSelected(false);
		}
		clickButton.setBackground(Color.lightGray);
		clickButton.setSelected(true);
	}
	
	public static void main(String[] args) {
		new Gui("UML");
	}
}
