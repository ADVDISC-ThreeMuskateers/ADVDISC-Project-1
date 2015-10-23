package shapes;
import java.awt.Graphics2D;

public abstract class Shape {
	protected int originX;
	protected int originY;
	protected int inc;
	
	public Shape(int originx, int originy, int inc) {
		this.originX = originx;
		this.originY = originy;
		this.inc = inc;
	}
	
	public Shape() {
		this.originX = 0;
		this.originY = 0;
		this.inc = 0;
	}
	
	public abstract void draw(Graphics2D g);

	public void setOffset(int originX2, int originY2, int inc2) {
		// TODO Auto-generated method stub
		this.originX = originX2;
		this.originY = originY2;
		this.inc = inc2;
	}
}
