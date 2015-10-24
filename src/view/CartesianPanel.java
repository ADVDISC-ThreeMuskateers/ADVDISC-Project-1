package view;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JPanel;

import shapes.*;

public class CartesianPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Shape> shapes = new ArrayList<>();
	
	public static final int XMAX = 10;
	public static final int XMIN = -10;
	
	public CartesianPanel() {
		this.setBackground(Color.WHITE);
		this.setSize(600, 600);
	}
	 
	 public void paintComponent(Graphics g) {
	  
	  super.paintComponent(g);
	  
	  Graphics2D g2 = (Graphics2D) g;
	  
	  g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	    RenderingHints.VALUE_ANTIALIAS_ON);
	  
	  int X_AXIS_Y_COORD = this.getHeight()/2;
	  int X_AXIS_COORD_BEGIN = 0;
	  int X_AXIS_COORD_END = this.getWidth();
	  
	  int Y_AXIS_X_COORD = this.getWidth()/2;
	  int Y_AXIS_COORD_BEGIN = 0;
	  int Y_AXIS_COORD_END = this.getHeight();
	  
	  int ORIGIN_X_COORD = this.getWidth()/2;
	  int ORIGIN_Y_COORD = this.getHeight()/2;

	  int INC = this.getHeight()/(Math.abs(XMIN) + Math.abs(XMAX));
	  int xCtr = 0;
	  
	  DrawingClass dc = new DrawingClass(g2, ORIGIN_X_COORD, ORIGIN_Y_COORD, INC);
	  
	  for(int yGrid = ORIGIN_X_COORD; yGrid < this.getWidth(); yGrid += INC) {
		  g2.setColor(Color.GRAY);
		  g2.drawLine(yGrid, 0, yGrid, this.getHeight());
		  g2.drawString(""+xCtr, yGrid, ORIGIN_Y_COORD);
		  xCtr++;
	  }
	  
	  xCtr = 0;
	  for(int yGrid = ORIGIN_X_COORD; yGrid >= 0; yGrid -= INC) {
		  g2.drawLine(yGrid, 0, yGrid, this.getHeight());
		  g2.drawString(""+xCtr, yGrid, ORIGIN_Y_COORD);
		  xCtr--;
	  }
	  
	  xCtr = 0;
	  for(int xGrid = ORIGIN_Y_COORD; xGrid < this.getHeight(); xGrid += INC) {
		  g2.drawLine(0, xGrid, this.getWidth(), xGrid);
		  g2.drawString("" + -xCtr, ORIGIN_X_COORD, xGrid);
		  xCtr++;
	  }
	  
	  xCtr = 0;
	  for(int xGrid = ORIGIN_Y_COORD; xGrid >= 0; xGrid -= INC) {
		  g2.drawLine(0, xGrid, this.getWidth(), xGrid);
		  g2.drawString("" + -xCtr, ORIGIN_X_COORD, xGrid);
		  xCtr--;
	  }
	  
	  g2.setColor(Color.BLACK);
	  g2.setStroke(new BasicStroke(2));
	  g2.drawLine(X_AXIS_COORD_BEGIN, X_AXIS_Y_COORD, X_AXIS_COORD_END, X_AXIS_Y_COORD);
	  g2.drawLine(Y_AXIS_X_COORD, Y_AXIS_COORD_BEGIN, Y_AXIS_X_COORD, Y_AXIS_COORD_END);
	  
	  for(Shape s: shapes) {
		  dc.draw(s);
		  //dc.reflectX(s);
		  //dc.reflectY(s);
		  //dc.rotateCtr(s);
		  //dc.rotateClw(s);
	  }
	  
//	  dc.draw(new Point(1, 2));
//	  dc.draw(new Point(5, 5));
//	  dc.draw(new LineSegment(new Point(1, 2), new Point(5, 5)));
//	  
//	  Point[] polyPoints = new Point[4];
//	  polyPoints[0] = new Point(1, 2);
//	  polyPoints[1] = new Point(5, 1);
//	  polyPoints[2] = new Point(5, 5);
//	  polyPoints[3] = new Point(4, 5);
//	  
//	  dc.draw(new Polygon(polyPoints));
	 
//	  dc.draw(new Vector(7, 0, XMIN, XMAX));
//	  dc.draw(new Vector(polyPoints[0], polyPoints[1]));
//	  dc.draw(new Ellipse(XMIN, XMAX, 6, 2));
	 }
	 
	 public void addShapes(Shape s) {
		 this.shapes.add(s);
		 this.repaint();
	 }
	 
	 public void clearShapes() {
		 this.shapes.clear();
		 this.repaint();
	 }
}
