package mode;

import java.awt.Point;
import java.awt.event.MouseEvent;

import controller.ObjectController;
import objects.BasicObject;
import objects.CompositeObject;
public class SelectMode extends ModeSelector{
//	BasicObject selectedobj;
	Point startrec = null;
	Point endrec = null;
	boolean isdrag = false;
	boolean ismoveobj = false;
	@Override
	public void testprint() {
		System.out.println("SelectMode");
	}
	@Override  
    public void mouseClicked(MouseEvent e) {  
        // TODO Auto-generated method stub  
//        System.out.println("SelectMode clicked");
        if(selectedobj != null) {
        	System.out.println("Selected object: "+selectedobj.getObjType());
        	selectedobj.setSelectedCondition(true);
//        	if(selectedobj.getObjType() == "COMPOSITEOBJ") {
//        		super.selectedcompositeobj = (CompositeObject) selectedobj;
//        	}
        }
        super.canvas.repaint();
    }  
    @Override  
    public void mousePressed(MouseEvent e) {  
        // TODO Auto-generated method stub
//        System.out.println("SelectMode pressed");
        selectedobj = ObjectController.isInBasicobjRange(e.getPoint());
        startrec = e.getPoint();
//        ObjectController.unMove();
        if(selectedobj == null) {
        	ismoveobj = false;
        }
        else {
        	//move selectobj
//            selectedobj.setRange(0,0);
        	ismoveobj = true;
        	
        }
    }  
  
    @Override  
    public void mouseReleased(MouseEvent e) {  
        // TODO Auto-generated method stub  
//        System.out.println("SelectMode released");
        if(isdrag) {
        	endrec = e.getPoint();
        	if(!ismoveobj) {
        		ObjectController.isMultiObjInSelectRec(startrec,endrec);
        		super.canvas.repaint();        		
        	}
        	else {
        		selectedobj.setBasicPbjMoveOffset(endrec.x-startrec.x,endrec.y-startrec.y);
        		selectedobj.resetObjPosition();
        		ObjectController.resetLine();
        		super.canvas.repaint(); 
        	}
        }
        isdrag = false;
    }  
    
    @Override
    public void mouseDragged(MouseEvent e) {
//    	System.out.println("SelectMode mouseDragged");   
    	isdrag = true;
    }

}
