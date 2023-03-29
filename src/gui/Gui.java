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
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import mode.ModeSelector;
import controller.ObjectController;

public class Gui {
	private JFrame frame;
	private MyCanvas canvas;
	private JButton previousButton;
	private ModeSelector mode;
	
	private Gui(String name) {
		initial(name);
	}
	private void initial(String name) {
		frame = new JFrame(name);
		canvas = new MyCanvas();
		
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
		for(int i=0;i<AllButton.values().length;i++) {
			JButton b = new JButton(AllButton.values()[i].getImageIcon());
			b.setBackground(Color.white);
			b.setActionCommand(String.valueOf(i));
			b.addActionListener(new ActionListener() {
				@Override
		        public void actionPerformed(ActionEvent e) {
//					System.out.println("ActionEvent!");
					previousButton.setBackground(Color.white);
					previousButton.setSelected(false);
					
					previousButton = (JButton) e.getSource();
					previousButton.setBackground(Color.lightGray);
					previousButton.setSelected(true);
//					System.out.println(String.valueOf(AllButton.values()[Integer.parseInt(e.getActionCommand())]));
//					AllButton.values()[Integer.parseInt(e.getActionCommand())].getMode().testprint();
					mode = AllButton.values()[Integer.parseInt(e.getActionCommand())].getMode();
					mode.setCanvas(canvas);
					mode.setObjectType(String.valueOf(AllButton.values()[Integer.parseInt(e.getActionCommand())]));
		        }
			});
			if(i == 0) {
				b.setBackground(Color.lightGray);
				b.setSelected(true);
//				System.out.println(AllButton.values()[0]);
//				AllButton.values()[0].getMode().testprint();
				mode = AllButton.values()[0].getMode();
				mode.setCanvas(canvas);
				mode.setObjectType(String.valueOf(AllButton.values()[0]));
				previousButton = b;
			}
			buttonPanel.add(b);
		}
		
		//Canvas
		frame.add(canvas,BorderLayout.CENTER);
		frame.setJMenuBar(mb);
		frame.setVisible(true);
		
		//mouse
	}
	public static void main(String[] args) {
		new Gui("UML");
	}
}
