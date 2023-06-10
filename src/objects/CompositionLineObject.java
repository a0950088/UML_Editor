package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class CompositionLineObject extends LineObject{
	
	public CompositionLineObject(Point start,Point end,BasicObject startobj, BasicObject endobj) {
		super(startobj, endobj);
		super.type = "COMPOSITIONLINE";
		super.startport = start;
		super.endport = end;
	}
	@Override
	public void testprint() {
		System.out.println("class CompositionLineObject"+super.getDepth());
	}
	
	@Override
	public void drawObject(Graphics g) {
		int x1 = startport.x;
	    int y1 = startport.y;
	    int x2 = endport.x;
	    int y2 = endport.y;

	    int width = 10;
	    int height = 5;
	    int distanceX = x2 - x1, distanceY = y2 - y1;
	    double D = Math.sqrt(distanceX*distanceX + distanceY*distanceY);
	    if(D == 0.0) {
	      D = 1;
	    }
	    double x3 = D - width, x4 = x3, y3 = height, y4 = -height, x5 = D-width*2, y5, x;
	    double sin = distanceY / D, cos = distanceX / D;

	    x = x3*cos - y3*sin + x1;
	    y3 = x3*sin + y3*cos + y1;
	    x3 = x;

	    x = x4*cos - y4*sin + x1;
	    y4 = x4*sin + y4*cos + y1;
	    x4 = x;
	    
	    x = x5*cos + x1;
	    y5 = x5*sin + y1;
	    x5 = x;
	    
	    int[] xpoints = {x2, (int)x3, (int)x5, (int)x4};
	    int[] ypoints = {y2, (int)y3, (int)y5, (int)y4};
	    g.setColor(Color.white);
	    g.fillPolygon(xpoints,ypoints,xpoints.length);
	    g.setColor(Color.black);
	    g.drawPolygon(xpoints,ypoints,xpoints.length);
	    g.drawLine(x1, y1, (int)x5, (int)y5);
	}
}
