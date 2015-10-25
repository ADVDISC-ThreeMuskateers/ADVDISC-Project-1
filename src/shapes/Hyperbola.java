package shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

public class Hyperbola extends Conic {
	private int a, b;
	private Line[] asymptotes;
	
	public Hyperbola(int a, int b, int xMin, int xMax, boolean isVertical) {
		super(xMin, xMax, isVertical);
		this.a = a;
		this.b = b;
		f = x -> Math.sqrt((1 + Math.pow(x, 2)/Math.pow(b, 2)) * Math.pow(a, 2));
		
		asymptotes = new Line[2];
	}
	
	public void draw(Graphics2D g) {
		GeneralPath path = new GeneralPath();
		GeneralPath negPath = new GeneralPath();
		
		if(isVertical) {
			double x = xMin;
			double y = f.apply(x);
			
			double graphX = originX + (x * inc);
			double graphY = originY + (-y * inc);
			double negGraphY = originY + (y * inc);
			
			path.moveTo(graphX, graphY);
			negPath.moveTo(graphX, negGraphY);
			
			x += 0.1;
			
			while(x < xMax) {
				y = f.apply(x);
				
				graphX = originX + (x * inc);
				graphY = originY + (-y * inc);
				negGraphY = originY + (y * inc);
				
				path.lineTo(graphX, graphY);
				negPath.lineTo(graphX, negGraphY);
				x += 0.1;
			}
			
			asymptotes[0] = new Line((a + 0.0) / b, 0, xMin, xMax);
			asymptotes[1] = new Line(-(a + 0.0)/b, 0, xMin, xMax);
		} else {
			double y = xMin;
			double x = f.apply(y);
			
			double graphX = originX + (x * inc);
			double negGraphX = originX + (-x * inc);
			double graphY = originY + (-y * inc);
			
			path.moveTo(graphX, graphY);
			negPath.moveTo(negGraphX, graphY);
			y += 0.1;
			
			while(y < xMax) {
				x = f.apply(y);
				
				negGraphX = originX + (-x * inc);
				graphX = originX + (x * inc);
				graphY = originY + (-y * inc);
				
				path.lineTo(graphX, graphY);
				negPath.lineTo(negGraphX, graphY);
				y += 0.1;
				
			}
			
			asymptotes[0] = new Line((b + 0.0) / a, 0, xMin, xMax);
			asymptotes[1] = new Line(-(b + 0.0)/a, 0, xMin, xMax);
		}

		g.draw(negPath);
		g.draw(path);
		asymptotes[0].draw(g);
		asymptotes[1].draw(g);
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
