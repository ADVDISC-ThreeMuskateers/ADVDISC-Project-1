package shapes;
import java.awt.Graphics2D;

public class Point extends Shape{
	private int x;
	private int y;
	private int r;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		this.r = 10;
	}
	
	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		int x = originX + (this.x * inc) - this.getR()/2;
		int y = originY + (-this.y * inc) - this.getR()/2;
		g.drawOval(x, y, this.getR(), this.getR());
		g.fillOval(x, y, r, r);
	}
}
