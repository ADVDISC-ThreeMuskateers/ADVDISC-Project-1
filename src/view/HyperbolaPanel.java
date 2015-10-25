package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import shapes.Ellipse;
import shapes.Hyperbola;
import shapes.Parabola;

public class HyperbolaPanel extends JPanel {
	private HyperbolaPanel hyp = this;
	private String vertical = "<html>y<sup>2</sup> / a<sup>2</sup> - x<sup>2</sup> / b<sup>2</sup> = 1</html>";
	private String horizontal = "<html>x<sup>2</sup> / a<sup>2</sup> - y<sup>2</sup> / b<sup>2</sup> = 1</html>";
	
	private JLabel verEquation = new JLabel(vertical);
	private JLabel horEquation = new JLabel(horizontal);
	
	private NumberTextField aTxt = new NumberTextField();
	private JLabel aLbl = new JLabel("a:");
	private NumberTextField bTxt = new NumberTextField();
	private JLabel bLbl = new JLabel("b:");
	
	private JRadioButton horizontalButt = new JRadioButton("Horizontal");
	private JRadioButton verticalButt = new JRadioButton("Vertical");
	private ButtonGroup orientation = new ButtonGroup();
	private JButton submit = new JButton("Submit");
	
	private JPanel pointPanel = new JPanel();
	
	private BorderLayout layout = new BorderLayout();
	private SpringLayout spring = new SpringLayout();
	private CartesianPanel cartesian;
	
	private OperationsPanel oper;
	HyperbolaPanel(CartesianPanel cartesian, OperationsPanel oper){
		this.setLayout(layout);
		this.oper = oper;
		
		this.cartesian = cartesian;
		
		
		orientation.add(horizontalButt);
		orientation.add(verticalButt);
		
		horizontalButt.addActionListener(new ItemListener());
		verticalButt.addActionListener(new ItemListener());
		submit.addActionListener(new ItemListener());
		
		
		pointPanel.setLayout(spring);
		pointPanel.add(aLbl);
		pointPanel.add(aTxt);
		pointPanel.add(bLbl);
		pointPanel.add(bTxt);
		SpringUtilities.makeCompactGrid(pointPanel, 2, 2, 6, 6, 6, 6);
		
		
		
		this.add(submit, BorderLayout.PAGE_END);
		this.add(horizontalButt, BorderLayout.LINE_START);
		this.add(verticalButt, BorderLayout.LINE_END);
		this.add(pointPanel, BorderLayout.CENTER);
		
		
	}
	class ItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==horizontalButt){
				hyp.remove(verEquation);
				hyp.add(horEquation, BorderLayout.PAGE_START);
				hyp.repaint();
				hyp.revalidate();
			}
			if(e.getSource()==verticalButt){
				hyp.remove(horEquation);
				hyp.add(verEquation, BorderLayout.PAGE_START);
				hyp.repaint();
				hyp.revalidate();
			}
			
			if(e.getSource()==submit&&verticalButt.isSelected()){
				Hyperbola hyperbola = new Hyperbola(Integer.parseInt(aTxt.getText()), Integer.parseInt(bTxt.getText()), -10, 10, true);
				oper.setShape(hyperbola);
				cartesian.clearShapes();
				cartesian.addShapes(hyperbola);
			}

			if(e.getSource()==submit&&horizontalButt.isSelected()){
				Hyperbola hyperbola = new Hyperbola(Integer.parseInt(aTxt.getText()), Integer.parseInt(bTxt.getText()), -10, 10, false);
				oper.setShape(hyperbola);
				cartesian.clearShapes();
				cartesian.addShapes(hyperbola);
			}

		}
	}
	

	
}
