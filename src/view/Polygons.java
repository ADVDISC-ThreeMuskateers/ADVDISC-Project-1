package view;

import java.awt.*
;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Polygons extends JPanel {
	private JLabel numOfPointsLbl  = new JLabel("Number of Sides:");
	private JTextField numOfPointsTxtField = new JTextField(5);
	private JButton numOfPointsButt = new JButton("OK");
	
	private ArrayList<JTextField> pointTextFields =  new ArrayList<>();
	private JLabel pointLabel = new JLabel(); 
	
	
	private JPanel pointsPanel = new JPanel();
	private JPanel polyPanel = this;
	private JPanel numOfPointsPanel =  new JPanel();
	private JScrollPane scrollPoints = new JScrollPane(pointsPanel);
	
	private Dimension min = new Dimension(5,5);
	private Dimension max = new Dimension(5,5);
	public Polygons(){
		this.setLayout(new BorderLayout());
		numOfPointsButt.addActionListener(new Listener());
		numOfPointsTxtField.setMaximumSize(max);
		
		numOfPointsPanel.add(numOfPointsLbl);
		numOfPointsPanel.add(numOfPointsTxtField);
		numOfPointsPanel.add(numOfPointsButt);
		this.add(numOfPointsPanel, BorderLayout.PAGE_START);
		pointsPanel.setLayout(new SpringLayout());
		this.add(scrollPoints, BorderLayout.CENTER);
		
	}
	class Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		    pointsPanel.removeAll();
		    pointTextFields.removeAll(pointTextFields);
		    int numOfPoints =  Integer.parseInt(numOfPointsTxtField.getText());
			
		    for(int i=1;i<=numOfPoints;i++){
				JTextField tempField1 = new JTextField(6);
				JTextField tempField2 = new JTextField(6);
				tempField1.setMaximumSize(max);
				tempField2.setMaximumSize(max);
				tempField1.setMinimumSize(max);
				tempField2.setMinimumSize(max);
				
				
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
	} 
	
}
