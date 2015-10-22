package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;

import javafx.scene.control.RadioButton;

class PointsAndLines extends JPanel {
	private JLabel pointX1Lbl = new JLabel("X1:");
	private JLabel pointY1Lbl = new JLabel("Y1:");
	private JTextField pointX1Txt = new JTextField(5);
	private JTextField pointY1Txt = new JTextField(5);
	private JLabel pointX2Lbl = new JLabel("X2:");
	private JLabel pointY2Lbl = new JLabel("Y2:");
	private JTextField pointX2Txt = new JTextField(5);
	private JTextField pointY2Txt = new JTextField(5);
	private SpringLayout layout = new SpringLayout();
	private JRadioButton pointButt = new JRadioButton("Point");
	private JRadioButton lineButt = new JRadioButton("Line");
	private ButtonGroup group = new ButtonGroup();
	private Dimension max = new Dimension(5,5);
	private JPanel pal = this;

	public PointsAndLines(){
		
		
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
		
	}
	class JRadioListener implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			JRadioButton r = (JRadioButton) e.getSource();
			if(r == pointButt){
				pal.remove(pointX2Lbl);
				pal.remove(pointX2Txt);
				pal.remove(pointY2Lbl);
				pal.remove(pointY2Txt);
				pal.add(pointX1Lbl);
				pal.add(pointX1Txt);
				pal.add(pointY1Lbl);
				pal.add(pointY1Txt);
				SpringUtilities.makeCompactGrid(pal,
						3, 2, 		 //rows, cols
						6, 6,        //initX, initY
						6, 6);       //xPad, yPad
				pal.repaint();
				pal.revalidate();
			}
			if(r == lineButt){
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
				SpringUtilities.makeCompactGrid(pal,
						5, 2, 		 //rows, cols
						6, 6,        //initX, initY
						6, 6);       //xPad, yPad
				pal.repaint();
				pal.revalidate();
			}
			
		}
		
		
	}


}
