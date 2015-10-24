package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import shapes.*;
import javax.swing.*;
import javax.swing.border.Border;

import javafx.scene.control.RadioButton;

class PointsAndLinesPanel extends JPanel {
	private JLabel pointX1Lbl = new JLabel("X1:");
	private JLabel pointY1Lbl = new JLabel("Y1:");
	private NumberTextField pointX1Txt = new NumberTextField(5);
	private NumberTextField pointY1Txt = new NumberTextField(5);
	private JLabel pointX2Lbl = new JLabel("X2:");
	private JLabel pointY2Lbl = new JLabel("Y2:");
	private NumberTextField pointX2Txt = new NumberTextField(5);
	private NumberTextField pointY2Txt = new NumberTextField(5);
	private SpringLayout layout = new SpringLayout();
	private JRadioButton pointButt = new JRadioButton("Point");
	private JRadioButton lineButt = new JRadioButton("Line");
	private ButtonGroup group = new ButtonGroup();
	private Dimension max = new Dimension(5,5);
	private JPanel pal = this;
	private JButton submitButt = new JButton("Submit");
	private JLabel submitLbl = new JLabel("Submit: ");
	private CartesianPanel cartesian;
	public PointsAndLinesPanel(CartesianPanel cartesian){
		
		this.cartesian = cartesian;
		this.setLayout(layout);
		group.add(pointButt);
		group.add(lineButt);
		this.add(pointButt);
		this.add(lineButt);
		pointX1Txt.setPreferredSize(max);
		pointY1Txt.setPreferredSize(max);
		pointX2Txt.setPreferredSize(max);
		pointY2Txt.setPreferredSize(max);
		
		pointButt.addActionListener(new JRadioListener());
		lineButt.addActionListener(new JRadioListener());
		SpringUtilities.makeCompactGrid(pal,
				1, 2, 		 //rows, cols
				6, 6,        //initX, initY
				6, 6);       //xPad, yPad
		submitButt.addActionListener(new JRadioListener());
		
	}
	class JRadioListener implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == pointButt){
				pal.remove(submitButt);
				pal.remove(pointX2Lbl);
				pal.remove(pointX2Txt);
				pal.remove(pointY2Lbl);
				pal.remove(pointY2Txt);
				pal.add(pointX1Lbl);
				pal.add(pointX1Txt);
				pal.add(pointY1Lbl);
				pal.add(pointY1Txt);
				pal.add(submitLbl);
				pal.add(submitButt);
				SpringUtilities.makeCompactGrid(pal,
						4, 2, 		 //rows, cols
						6, 6,        //initX, initY
						6, 6);       //xPad, yPad
				
				pal.repaint();
				pal.revalidate();
			}
			if(e.getSource() == lineButt){
				pal.remove(submitButt);
				pal.remove(pointX1Lbl);
				pal.remove(pointX1Txt);
				pal.remove(pointY1Lbl);
				pal.remove(pointY1Txt);
				pal.add(pointX1Lbl);
				pal.add(pointX1Txt);
				pal.add(pointY1Lbl);
				pal.add(pointY1Txt);
				pal.add(pointX2Lbl);
				pal.add(pointX2Txt);
				pal.add(pointY2Lbl);
				pal.add(pointY2Txt);
				pal.add(submitLbl);
				pal.add(submitButt);
				
				SpringUtilities.makeCompactGrid(pal,
						6, 2, 		 //rows, cols
						6, 6,        //initX, initY
						6, 6);       //xPad, yPad
				
				pal.repaint();
				pal.revalidate();
			}
			if(e.getSource()==submitButt&&pointButt.isSelected()){
				Point point = new Point(Integer.parseInt(pointX1Txt.getText()), Integer.parseInt(pointY1Txt.getText()));
				cartesian.clearShapes();
				cartesian.addShapes(point);
			}
			if(e.getSource()==submitButt&&lineButt.isSelected()){
				
				Point p1 = new Point(Integer.parseInt(pointX1Txt.getText()), Integer.parseInt(pointY1Txt.getText()));
				Point p2 = new Point(Integer.parseInt(pointX2Txt.getText()), Integer.parseInt(pointY2Txt.getText()));
				cartesian.clearShapes();
				cartesian.addShapes(new LineSegment(p1, p2));
			}
		}
	}
}
