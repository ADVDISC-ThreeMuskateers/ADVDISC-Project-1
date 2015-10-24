package shapes;

import java.awt.Graphics2D;

public class Ellipse extends Conic {
	private int a, b;
	
	public Ellipse(int xMax, int xMin, int a, int b) {
		super(xMin, xMax, true);
		this.a = a;
		this.b = b;
	}
	
	@Override
	public void draw(Graphics2D g) {
		int x, y;
		
		x = originX - (a * inc);
		y = originY + (-b * inc);
		g.drawOval(x, y, 2*a*inc, 2*b*inc);
		
		
	}
public void reflectX(Graphics2D g){
		
		
	}
public void reflectY(Graphics2D g){
	
	
}
public void reflect(Graphics2D g){
	
}
public void translate(Graphics2D g){
	
}
public void rotateClw(Graphics2D g){
	
}
public void rotateCtr(Graphics2D g){
	
}
}
