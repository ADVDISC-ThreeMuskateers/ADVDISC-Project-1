package view;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import shapes.Ellipse;

public class EllipsePanel extends JPanel {
	public CartesianPanel cartesian;
	
	String horiEquation = "<html>x<sup>2</sup> / a<sup>2</sup> + y<sup>2</sup> / b<sup>2</sup> = 1</html>";
	String verEquation = "<html>y<sup>2</sup> / a<sup>2</sup> + x<sup>2</sup> / b<sup>2</sup> = 1</html>";
	private JLabel verticalEquation = new JLabel(verEquation);
	private JLabel horizontalEquation = new JLabel(horiEquation);
	
	private JPanel pointsPanel = new JPanel();
	private JLabel aLbl = new JLabel("a:");
	private JTextField aTxt = new JTextField();
	private JLabel bLbl = new JLabel("b:");
	private JTextField bTxt = new JTextField();
	private SpringLayout spring = new SpringLayout();
	
	private ButtonGroup orientation = new ButtonGroup();
	private JRadioButton vertical = new JRadioButton("Vertical");
	private JRadioButton horizontal = new JRadioButton("Horizontal");
	
	private JButton submit = new JButton("Submit");
	
	private BorderLayout layout = new BorderLayout();
	
	private EllipsePanel ell = this;
	EllipsePanel(CartesianPanel cartesian){
		this.cartesian = cartesian;
		
		
		
		submit.addActionListener(new ItemListener());
		//vertical.addActionListener(new ItemListener());
		//horizontal.addActionListener(new ItemListener());
		
		
		this.setLayout(layout);
		//orientation.add(vertical);
		//orientation.add(horizontal);
		//this.add(vertical, BorderLayout.LINE_START);
		//this.add(horizontal, BorderLayout.LINE_END);
		this.add(horizontalEquation,BorderLayout.PAGE_START);
		this.add(submit, BorderLayout.PAGE_END);
		pointsPanel.setLayout(spring);
		pointsPanel.add(aLbl);
		pointsPanel.add(aTxt);
		pointsPanel.add(bLbl);
		pointsPanel.add(bTxt);
		SpringUtilities.makeCompactGrid(pointsPanel,
				2, 2, 		 //rows, cols
				6, 6,        //initX, initY
				6, 6);       //xPad, yPad
		ell.add(pointsPanel, BorderLayout.CENTER);
		}
	class ItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

//			if(e.getSource() == vertical){
//				ell.remove(horizontalEquation);
//				ell.add(verticalEquation,BorderLayout.PAGE_START);
//				
//				ell.repaint();
//				ell.revalidate();
//			}
//			if(e.getSource() == horizontal){
//				ell.remove(verticalEquation);
//				ell.add(horizontalEquation,BorderLayout.PAGE_START);
//				
//				ell.repaint();
//				ell.revalidate();
//			}
//			if(e.getSource()==submit&&vertical.isSelected()){
//				cartesian.clearShapes();
//				//cartesian.addShapes(new Ellipse(-10, 10, Integer.parseInt(aTxt.getText()), Integer.parseInt(bTxt.getText()),true));
//				cartesian.addShapes(new Ellipse(-10, 10, Integer.parseInt(aTxt.getText()), Integer.parseInt(bTxt.getText())));
//			}
//			if(e.getSource()==submit&&!vertical.isSelected()){
//				cartesian.clearShapes();
//				//cartesian.addShapes(new Ellipse(-10, 10, Integer.parseInt(aTxt.getText()), Integer.parseInt(bTxt.getText()),false));
//				cartesian.addShapes(new Ellipse(-10, 10, Integer.parseInt(aTxt.getText()), Integer.parseInt(bTxt.getText())));
//			}
			if(e.getSource()==submit){
				cartesian.clearShapes();
				cartesian.addShapes(new Ellipse(-10, 10, Integer.parseInt(aTxt.getText()), Integer.parseInt(bTxt.getText())));
			}

		}
		
		
		
		
	}
}
