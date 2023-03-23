package objects;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Objects {
	protected int depth;   
	protected String type;
	
	public void setDepth(int depth) {
		this.depth = depth;
	}
  
	public int getDepth() {
		return depth;
	}
	public void testprint() {
		System.out.println("class Objects");
	}
	
	public abstract void drawObject(Graphics g);
	
	public String getObjType() {
		return this.type;
	}
}
