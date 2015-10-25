package shapes;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.util.function.Function;

public class Line extends Shape {
	private Function<Double, Double> f;
	private int xMin, xMax;
	
	public Line(int slope, int constant, int xMin, int xMax) {
		f = x -> slope * x + constant;		//equation of a line
		this.xMax = xMax;
		this.xMin = xMin;
	}
	
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		double x = xMin;
		double y = f.apply(x);
		
		double graphX = originX + (x * inc);
		double graphY = originY + (-y * inc);
		
		GeneralPath vector = new GeneralPath();
		vector.moveTo(graphX, graphY);
		x += 0.1;
		
		while(x < xMax) {
			y = f.apply(x);
			
			graphX = originX + (x * inc);
			graphY = originY + (-y * inc);
			
			vector.lineTo(graphX, graphY);
			x += 0.1;
		}
		
		g.draw(vector);
	}
	public void reflectX(Graphics2D g){
		double x = xMin;
		double y = f.apply(x);
		
		double graphX = originX + (x * inc);
		double graphY = originY + (-y * inc);
		
		GeneralPath vector = new GeneralPath();
		vector.moveTo(graphX, graphY);
		x += 0.1;
		
		while(x < xMax) {
			y = f.apply(x);
			
			graphX = originX + (x * inc);
			graphY = originY + -1*(-y * inc);
			
			vector.lineTo(graphX, graphY);
			x += 0.1;
		}
		
		g.draw(vector);
		
	}
	public void reflectY(Graphics2D g){
		double x = xMin;
		double y = f.apply(x);
		
		double graphX = originX + (x * inc);
		double graphY = originY + (-y * inc);
		
		GeneralPath vector = new GeneralPath();
		vector.moveTo(graphX, graphY);
		x += 0.1;
		
		while(x < xMax) {
			y = f.apply(x);
			
			graphX = originX + -1*(x * inc);
			graphY = originY + (-y * inc);
			
			vector.lineTo(graphX, graphY);
			x += 0.1;
		}
		
		g.draw(vector);
	
	}
	public void reflect(Graphics2D g){
	
	}
	public void translate(Graphics2D g){
	
	}
	public void rotateClw(Graphics2D g){
	
	}
	public void rotateCtr(Graphics2D g){
	
	}

	@Override
	public Shape reflectX() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shape reflectY() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shape reflect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shape rotateClw() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shape rotateCtr() {
		// TODO Auto-generated method stub
		return null;
	}

}
