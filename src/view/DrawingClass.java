package view;
import java.awt.Graphics2D;

import shapes.Shape;

public class DrawingClass {
	private int originX;
	private int originY;
	private int inc;
	private Graphics2D g;
	
	public DrawingClass(Graphics2D g, int originX, int originY, int inc) {
		this.originX = originX;
		this.originY = originY;
		this.inc = inc;
		this.g = g;
	}

	public void draw(Shape s) {
		s.setOffset(originX, originY, inc);
		s.draw(g);
		
	}
}
