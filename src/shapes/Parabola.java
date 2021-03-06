package shapes;

import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

import matrix.Matrix;

public class Parabola extends Conic {	
	private double p;
	private int h, k;
	
	public Parabola(int xMin, int xMax, double p, boolean isVertical) {
		super(xMin, xMax, isVertical);
		this.xMin = xMin;
		this.xMax = xMax;
		this.h = 0;
		this.k = 0;
		this.p = p;
		this.isVertical = isVertical;
		/*** 	Vertical Parabolas follow the equation:
		 * 		(y - h)^2 = 4px;
		 * 		x = (y - h)^2 / 4p
		 * 		Horizontal Parabolas follow the equation:
		 * 		(x - k)^2 = 4py;
		 * 		y = x^2 / 4p
		 ***/
		
		f = x -> Math.pow(x - k, 2) / (4 * p) + h;
		
	}
	
	public Parabola(int xMin, int xMax, double p, int h, int k, boolean isVertical) {
		super(xMin, xMax, isVertical);
		this.xMin = xMin;
		this.xMax = xMax;
		this.h = h;
		this.k = k;
		this.p = p;
		this.isVertical = isVertical;
		/*** 	Vertical Parabolas follow the equation:
		 * 		(y - h)^2 = 4px;
		 * 		x = (y - h)^2 / 4p
		 * 		Horizontal Parabolas follow the equation:
		 * 		(x - k)^2 = 4py;
		 * 		y = x^2 / 4p
		 ***/
		
		if(isVertical) {
			f = x -> Math.pow(x - k, 2) / (4 * p) + h;
		} else {
			f = x -> Math.pow(x - h, 2) / (4 * p) + k;
		}
		
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
			x += 1;
			
			while(x < xMax) {
				y = f.apply(x);
				
				graphX = originX + (x * inc);
				graphY = originY + (-y * inc);
				
				vector.lineTo(graphX, graphY);
				x += 1;
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
	
	@Override
	public Matrix toMatrix() {
		Matrix matrix = new Matrix(1, 1);
		
		return matrix;
	}
}
