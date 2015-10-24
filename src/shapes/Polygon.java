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
	
	public void reflectX(Graphics2D g){
		int[] x = new int[corners.size()];
		int[] y = new int[corners.size()];
		
		int ctr = 0;
		for(Point p: corners) {
			x[ctr] = originX + (p.getX() * inc);
			y[ctr] = originY + -1*(-p.getY() * inc);
			ctr++;
		}
		
		g.drawPolygon(x, y, x.length);
	}
	public void reflectY(Graphics2D g){
		int[] x = new int[corners.size()];
		int[] y = new int[corners.size()];
		
		int ctr = 0;
		for(Point p: corners) {
			x[ctr] = originX + -1*(p.getX() * inc);
			y[ctr] = originY + (-p.getY() * inc);
			ctr++;
		}
		
		g.drawPolygon(x, y, x.length);
	}
	public void reflect(Graphics2D g){
		int[] x = new int[corners.size()];
		int[] y = new int[corners.size()];
		
		int ctr = 0;
		for(Point p: corners) {
			x[ctr] = originX + -1*(p.getX() * inc);
			y[ctr] = originY + -1*(-p.getY() * inc);
			ctr++;
		}
	
		
		g.drawPolygon(x, y, x.length);
	}
	public void translate(Graphics2D g){
	
	}
	public void rotateClw(Graphics2D g){
		int[] x = new int[corners.size()];
		int[] y = new int[corners.size()];
		
		int ctr = 0;
		for(Point p: corners) {
			x[ctr] = originY + -1*(-p.getY() * inc);
			y[ctr] = originX + (p.getX() * inc);
			ctr++;
		}
	
		
		g.drawPolygon(x, y, x.length);
	}
	public void rotateCtr(Graphics2D g){
		int[] x = new int[corners.size()];
		int[] y = new int[corners.size()];
		
		int ctr = 0;
		for(Point p: corners) {
			x[ctr] = originY + (-p.getY() * inc);
			y[ctr] = originX + -1*(p.getX() * inc);
			ctr++;
		}
	
		
		g.drawPolygon(x, y, x.length);
	}

}
