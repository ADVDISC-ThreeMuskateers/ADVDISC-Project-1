package shapes;
import java.awt.Graphics2D;

public class LineSegment extends Shape {
	protected Point p1, p2;
	
	public LineSegment(Point p1, Point p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
	}
	
	@Override
	public void draw(Graphics2D g) {
		int x1 = originX + (p1.getX() * inc);
		int y1 = originY + (-p1.getY() * inc);
		int x2 = originX + (p2.getX() * inc);
		int y2 = originY + (-p2.getY() * inc);
		
		g.drawLine(x1, y1, x2, y2);
		
	}
	public void reflectX(Graphics2D g){
		int x1 = originX + (p1.getX() * inc);
		int y1 = originY + -1*(-p1.getY() * inc);
		int x2 = originX + (p2.getX() * inc);
		int y2 = originY + -1*(-p2.getY() * inc);
	
		g.drawLine(x1, y1, x2, y2);
	
	}
		
	
	public void reflectY(Graphics2D g){
		int x1 = originX + -1*(p1.getX() * inc);
		int y1 = originY + (-p1.getY() * inc);
		int x2 = originX + -1*(p2.getX() * inc);
		int y2 = originY + (-p2.getY() * inc);
	
		g.drawLine(x1, y1, x2, y2);
	
	}
	public void reflect(Graphics2D g){
		int x1 = originX + -1*(p1.getX() * inc);
		int y1 = originY + -1*(-p1.getY() * inc);
		int x2 = originX + -1*(p2.getX() * inc);
		int y2 = originY + -1*(-p2.getY() * inc);
	
		g.drawLine(x1, y1, x2, y2);
	}
	
	public void rotateClw(Graphics2D g){
		int x1 = originY + -1*(-p1.getY() * inc);
		int y1 = originX + (p1.getX() * inc);
		int x2 = originY + -1*(-p2.getY() * inc);
		int y2 = originX + (p2.getX() * inc);
	
		g.drawLine(x1, y1, x2, y2);
	}
	public void rotateCtr(Graphics2D g){
		int x1 = originY + (-p1.getY() * inc);
		int y1 = originX + -1*(p1.getX() * inc);
		int x2 = originY + (-p2.getY() * inc);
		int y2 = originX + -1*(p2.getX() * inc);
	
		g.drawLine(x1, y1, x2, y2);
	}
	
	public LineSegment reflectX(){
		int x1 = originX + (p1.getX());
		int y1 = originY + -1*(p1.getY());
		int x2 = originX + (p2.getX());
		int y2 = originY + -1*(p2.getY());
		
		return new LineSegment(new Point(x1,y1),new Point(x2, y2));
	}
		
	
	public LineSegment reflectY(){
		int x1 = originX + -1*(p1.getX());
		int y1 = originY + (p1.getY());
		int x2 = originX + -1*(p2.getX());
		int y2 = originY + (p2.getY());
		
		return new LineSegment(new Point(x1,y1),new Point(x2, y2));
	
	}
	public LineSegment reflect(){
		int x1 = originX + -1*(p1.getX());
		int y1 = originY + -1*(p1.getY());
		int x2 = originX + -1*(p2.getX());
		int y2 = originY + -1*(p2.getY());
		
		return new LineSegment(new Point(x1,y1),new Point(x2, y2));
	}
	public void translate(Graphics2D g){
		
	}
	public LineSegment rotateClw(){
		int x1 = originY + (p1.getY());
		int y1 = originX + -(p1.getX());
		int x2 = originY + (p2.getY());
		int y2 = originX + -(p2.getX());
		
		return new LineSegment(new Point(x1,y1),new Point(x2, y2));
	}
	public LineSegment rotateCtr(){
		int x1 = originY + (-p1.getY());
		int y1 = originX + (p1.getX());
		int x2 = originY + (-p2.getY());
		int y2 = originX + (p2.getX());
		
		return new LineSegment(new Point(x1,y1),new Point(x2, y2));
	}
}
