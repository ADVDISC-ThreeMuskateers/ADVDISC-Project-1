package shapes;

import java.awt.Graphics2D;

public class Vector extends LineSegment {

	public Vector(Point p1, Point p2) {
		super(p1, p2);
		// TODO Auto-generated constructor stub
	}
	
	public void draw(Graphics2D g) {
		int x1 = originX + (p1.getX() * inc);
		int y1 = originY + (-p1.getY() * inc);
		int x2 = originX + (p2.getX() * inc);
		int y2 = originY + (-p2.getY() * inc);
        
		g.drawLine(x1, y1, x2, y2);
	}

}
