package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import shapes.*;
import shapes.Point;
import shapes.Polygon;

public class PolygonPanel extends JPanel {
	private JLabel numOfPointsLbl  = new JLabel("Number of Sides:");
	private NumberTextField numOfPointsTxtField = new NumberTextField(5);
	private JButton numOfPointsButt = new JButton("OK");
	private JButton submitButt = new JButton("Submit");
	
	private ArrayList<NumberTextField> pointTextFields =  new ArrayList<>();
	private JLabel pointLabel = new JLabel(); 
	
	private CartesianPanel cartesian;
	
	private JPanel pointsPanel = new JPanel();
	private JPanel polyPanel = this;
	private JPanel numOfPointsPanel =  new JPanel();
	private JScrollPane scrollPoints = new JScrollPane(pointsPanel);
	
	private Dimension min = new Dimension(5,5);
	private Dimension max = new Dimension(5,5);
	
	private OperationsPanel oper;
	
	public PolygonPanel(CartesianPanel cartesian, OperationsPanel oper){
		this.cartesian = cartesian;
		this.oper = oper;
		this.setLayout(new BorderLayout());
		numOfPointsButt.addActionListener(new Listener());
		submitButt.addActionListener(new Listener());
		numOfPointsTxtField.setMaximumSize(max);
		
		numOfPointsPanel.add(numOfPointsLbl);
		numOfPointsPanel.add(numOfPointsTxtField);
		numOfPointsPanel.add(numOfPointsButt);
		this.add(numOfPointsPanel, BorderLayout.PAGE_START);
		pointsPanel.setLayout(new SpringLayout());
		this.add(scrollPoints, BorderLayout.CENTER);
		this.add(submitButt, BorderLayout.SOUTH);
		
	}
	class Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			  if(e.getSource() == numOfPointsButt){
				pointsPanel.removeAll();
			    pointTextFields.removeAll(pointTextFields);
			    int numOfPoints =  Integer.parseInt(numOfPointsTxtField.getText());
				
			    for(int i=1;i<=numOfPoints;i++){
					NumberTextField tempField1 = new NumberTextField(6);
					NumberTextField tempField2 = new NumberTextField(6);
	//				tempField1.setMaximumSize(max);
	//				tempField2.setMaximumSize(max);
	//				tempField1.setMinimumSize(max);
	//				tempField2.setMinimumSize(max);
	//				
					
					pointTextFields.add(tempField1);
			    	pointsPanel.add(new JLabel("X" + i + ":"));
					pointsPanel.add(tempField1);
					
					pointTextFields.add(tempField2);
					pointsPanel.add(new JLabel("Y" + i + ":"));
					pointsPanel.add(tempField2);
				}
				SpringUtilities.makeCompactGrid(pointsPanel,
						numOfPoints, 4, 		 //rows, cols
						6, 6,        //initX, initY
						6, 6);       //xPad, yPad
				pointsPanel.repaint();
				pointsPanel.revalidate();
				scrollPoints.repaint();
				scrollPoints.revalidate();
				polyPanel.repaint();
				polyPanel.revalidate();
			 }
			 if(e.getSource() == submitButt){
				 cartesian.clearShapes();
				 //cartesian.addShapes(new Parabola(-10,10,6,true));
				 Point points[] = new Point[pointTextFields.size()/2];
				 int x, y;
				 ArrayList<Point> tempPoints = new ArrayList<Point>();
				 for(int i=0;i<pointTextFields.size();i+=2){
				 	 x = Integer.parseInt(pointTextFields.get(i).getText());
					 y = Integer.parseInt(pointTextFields.get(i+1).getText());
					 tempPoints.add(new Point(x,y));
				 }
				 points = tempPoints.toArray(points);
				 Polygon polygon = new Polygon(points);
				 oper.setShape(polygon);
				 cartesian.addShapes(polygon);
			 }
		}
	} 
	
}
