package objects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class AssociationLineObject extends LineObject{
	
	public AssociationLineObject(Point start,Point end, BasicObject startobj, BasicObject endobj) {
		super(startobj,endobj);
		super.type = "ASSOCIATIONLINE";
		super.startport = start;
		super.endport = end;
	}
	@Override
	public void testprint() {
		System.out.println("class AssociationLineObject"+super.getDepth());
	}
	@Override
	public void drawObject(Graphics g) {
		Graphics2D graphics = (Graphics2D)g;
	    int x1 = startport.x;
	    int y1 = startport.y;
	    int x2 = endport.x;
	    int y2 = endport.y;
//	    if(endport != null) {
//	      x2 = endPort.getCentralPoint().x;
//	      y2 = endPort.getCentralPoint().y;
//	    }
//	    else {
//	      x2 = endPoint.x;
//	      y2 = endPoint.y;
//	    }
	    int d = 10;
	    int h = 5;
	    int dx = x2 - x1, dy = y2 - y1;
	    double D = Math.sqrt(dx*dx + dy*dy);
	    if(D == 0.0) {
	      D = 1;
	    }
	    double xm = D - d, xn = xm, ym = h, yn = -h, x;
	    double sin = dy / D, cos = dx / D;

	    x = xm*cos - ym*sin + x1;
	    ym = xm*sin + ym*cos + y1;
	    xm = x;

	    x = xn*cos - yn*sin + x1;
	    yn = xn*sin + yn*cos + y1;
	    xn = x;

	    g.drawLine(x1, y1, x2, y2);
	    g.drawLine(x2, y2, (int)xm, (int)ym);
	    g.drawLine(x2, y2, (int)xn, (int)yn);
	}
}
