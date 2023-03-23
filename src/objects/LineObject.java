package objects;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class LineObject extends Objects{
	protected Point startport;
	protected Point endport;
	protected BasicObject startobj;
	protected BasicObject endobj;
	protected int[] port;
	
	public LineObject(BasicObject start, BasicObject end) {
		startobj = start;
		endobj = end;
	}
	
	public void resetLinePosition() {
		startport.x += startobj.getBasicObjMoveOffset()[0];
		startport.y += startobj.getBasicObjMoveOffset()[1];
		endport.x += endobj.getBasicObjMoveOffset()[0];
		endport.y += endobj.getBasicObjMoveOffset()[1];
	}
	
	@Override
	public void drawObject(Graphics g) {
		
	}
}
