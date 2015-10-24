package shapes;

import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

public class Parabola extends Conic {	
	
	public Parabola(int xMin, int xMax, double p, boolean isVertical) {
		super(xMin, xMax, isVertical);
		this.xMin = xMin;
		this.xMax = xMax;
		this.isVertical = isVertical;
		/*** 	Vertical Parabolas follow the equation:
		 * 		(y - h)^2 = 4px;
		 * 		x = (y - h)^2 / 4p
		 * 		Horizontal Parabolas follow the equation:
		 * 		(x - k)^2 = 4py;
		 * 		y = x^2 / 4p
		 ***/
		f = x -> Math.pow(x, 2) / (4 * p);
		
	}
	
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		GeneralPath vector = new GeneralPath();
		
		if(isVertical) {
			double x = xMin;
			double y = f.apply(x);
			
			double graphX = originX + (x * inc);
			double graphY = originY + (-y * inc);
			
			vector.moveTo(graphX, graphY);
			x += 0.1;
			
			while(x < xMax) {
				y = f.apply(x);
				
				graphX = originX + (x * inc);
				graphY = originY + (-y * inc);
				
				vector.lineTo(graphX, graphY);
				x += 0.1;
			}
		} else {
			double y = xMin;
			double x = f.apply(y);
			
			double graphX = originX + (x * inc);
			double graphY = originY + (-y * inc);
			
			vector.moveTo(graphX, graphY);
			y += 0.1;
			
			while(y < xMax) {
				x = f.apply(y);
				
				graphX = originX + (x * inc);
				graphY = originY + (-y * inc);
				
				vector.lineTo(graphX, graphY);
				y += 0.1;
			}
		}
		

		g.draw(vector);
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
