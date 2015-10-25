package shapes;

import java.awt.Graphics2D;

import matrix.Matrix;

public class Ellipse extends Conic {
	private int a, b, h, k;
	
	public Ellipse(int xMax, int xMin, int a, int b) {
		super(xMin, xMax, true);
		this.a = a;
		this.b = b;
		this.h = 0;
		this.k = 0;
	}
	
	public Ellipse(int xMax, int xMin, int a, int b, int h, int k) {
		super(xMin, xMax, true);
		this.a = a;
		this.b = b;
		this.h = h;
		this.k = k;
	}
	
	@Override
	public void draw(Graphics2D g) {
		int x, y;
		
		x = originX - ((a - h) * inc);
		y = originY + ((-b - k) * inc);
		g.drawOval(x, y, 2*a*inc, 2*b*inc);
		
		
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
		Matrix matrix;
		
		matrix = new Matrix(2, 1);
		
		matrix.setValueAt(0, 0, a);
		matrix.setValueAt(1, 0, b);
		
		return matrix;
	}
}
