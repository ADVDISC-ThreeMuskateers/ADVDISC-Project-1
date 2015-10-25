package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import shapes.Point;
import shapes.Shape;

public class OperationsPanel extends JPanel {
	String[] operations = {"Reflect X", "Reflect Y", "Translate", "Rotate Clockwise","Rotate Counter-Clockwise",};
	private JComboBox operationsCombo = new JComboBox(operations);
	private BorderLayout operationLayout = new BorderLayout();
	private CartesianPanel cartesian;
	private JButton submit = new JButton("Submit");
	private Shape shape;
	private OperationsPanel oper =this;
	OperationsPanel(CartesianPanel cartesian){
		this.cartesian = cartesian;
		this.setLayout(operationLayout);
		this.add(operationsCombo, BorderLayout.PAGE_START);
		submit.setEnabled(false);
		this.add(submit, BorderLayout.PAGE_END);
		submit.addActionListener(new ButtListener());
		operationsCombo.addActionListener(new ComboListener());
	}
	public void setShape(Shape shape){
		this.shape = shape;
		
	}
	
			
	class ButtListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(submit == e.getSource()){
				if(submit.getText().equals("Reflect X")){
					System.out.println("SHAPE IS A: " + shape.getClass());
					cartesian.clearShapes();
					cartesian.addShapes(shape.reflectX());
				}
				if(submit.getText().equals("Reflect Y")){
					cartesian.clearShapes();
					cartesian.addShapes(shape.reflectY());		
				}
				if(submit.getText().equals("Translate")){
					cartesian.clearShapes();
					//							cartesian.addShapes(shape.translate());
				}
				if(submit.getText().equals("Rotate Clockwise")){
					cartesian.clearShapes();
					cartesian.addShapes(shape.rotateClw());
				}
				if(submit.getText().equals("Rotate Counter-Clockwise")){
					cartesian.clearShapes();
					cartesian.addShapes(shape.rotateCtr());
				}
			}
			
		}
		
			
	}
	class ComboListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		    JComboBox cb = (JComboBox) e.getSource();

			if(cb.getSelectedIndex()==0){
				submit.setEnabled(true);
				submit.setText("Reflect X");
				oper.repaint();
				oper.revalidate();
		    }
			if(cb.getSelectedIndex()==1){
				submit.setEnabled(true);
				submit.setText("Reflect Y");
				oper.repaint();
				oper.revalidate();
		    }
			if(cb.getSelectedIndex()==2){
				submit.setEnabled(true);
				submit.setText("Tanslate");
				oper.repaint();
				oper.revalidate();
			}
			if(cb.getSelectedIndex()==3){
				submit.setEnabled(true);
				submit.setText("Rotate Clockwise");
				oper.repaint();
				oper.revalidate();
			}
			if(cb.getSelectedIndex()==4){
				submit.setEnabled(true);
				submit.setText("Rotate Counter-Clockwise");
				oper.repaint();
				oper.revalidate();
			}
			
		}
	}
}

		
	

