package shapes;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Polygon extends Shape {
	private ArrayList<Point> corners;
	
	public Polygon(Point[] points) {
		
		corners = new ArrayList<>();
		
		for(Point p: points) {
			corners.add(p);
		}
	}
	
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		int[] x = new int[corners.size()];
		int[] y = new int[corners.size()];
		
		int ctr = 0;
		for(Point p: corners) {
			x[ctr] = originX + (p.getX() * inc);
			y[ctr] = originY + (-p.getY() * inc);
			ctr++;
		}
		
		g.drawPolygon(x, y, x.length);
		
	}

}
