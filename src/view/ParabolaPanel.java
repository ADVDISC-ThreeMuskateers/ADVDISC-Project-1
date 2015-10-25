package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;

import shapes.Parabola;

public class ParabolaPanel extends JPanel {
	private ParabolaPanel par = this;
	private String vertical = "<html>4py = x<sup>2</sup></html>";
	private String horizontal = "<html>4px = y<sup>2</sup></html>";
	
	private JLabel verEquation = new JLabel(vertical);
	private JLabel horEquation = new JLabel(horizontal);
	
	private NumberTextField pTxt = new NumberTextField();
	private JLabel pLbl = new JLabel("p:");
	
	private JRadioButton horizontalButt = new JRadioButton("Horizontal");
	private JRadioButton verticalButt = new JRadioButton("Vertical");
	private ButtonGroup orientation = new ButtonGroup();
	private JButton submit = new JButton("Submit");
	
	private JPanel pointPanel = new JPanel();
	
	private BorderLayout layout = new BorderLayout();
	private SpringLayout spring = new SpringLayout();
	private CartesianPanel cartesian;
	
	private OperationsPanel oper;
	ParabolaPanel(CartesianPanel cartesian, OperationsPanel oper){
		this.setLayout(layout);
		this.oper = oper;
		
		this.cartesian = cartesian;
		
		orientation.add(horizontalButt);
		orientation.add(verticalButt);
		
		horizontalButt.addActionListener(new ItemListener());
		verticalButt.addActionListener(new ItemListener());
		submit.addActionListener(new ItemListener());
		
		
		pointPanel.setLayout(spring);
		pointPanel.add(pLbl);
		pointPanel.add(pTxt);
		SpringUtilities.makeCompactGrid(pointPanel, 1, 2, 6, 6, 6, 6);
		
		
		
		this.add(submit, BorderLayout.PAGE_END);
		this.add(horizontalButt, BorderLayout.LINE_START);
		this.add(verticalButt, BorderLayout.LINE_END);
		this.add(pointPanel, BorderLayout.CENTER);
		
		
	}
	class ItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==horizontalButt){
				par.remove(verEquation);
				par.add(horEquation, BorderLayout.PAGE_START);
				par.repaint();
				par.revalidate();
			}
			if(e.getSource()==verticalButt){
				par.remove(horEquation);
				par.add(verEquation, BorderLayout.PAGE_START);
				par.repaint();
				par.revalidate();
			}
			
			if(e.getSource()==submit&&verticalButt.isSelected()){
				Parabola parabola = new Parabola(-10, 10, Integer.parseInt(pTxt.getText()), true);
				oper.setShape(parabola);
				cartesian.clearShapes();
				cartesian.addShapes(parabola);
			}

			if(e.getSource()==submit&&horizontalButt.isSelected()){
				Parabola parabola = new Parabola(-10, 10, Integer.parseInt(pTxt.getText()), false);
				oper.setShape(parabola);
				cartesian.clearShapes();
				cartesian.addShapes(parabola);
			}

		}
	}
	

	
}
