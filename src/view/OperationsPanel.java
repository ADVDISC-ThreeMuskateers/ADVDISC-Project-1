package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class OperationsPanel extends JPanel {
	String[] operations = {"Reflect X", "Reflect Y", "Translate", "Rotate Clockwise","Rotate Counter-Clockwise",};
	private JComboBox operationsCombo = new JComboBox(operations);
	private BorderLayout operationLayout = new BorderLayout();
	private CartesianPanel cartesian;
	private JButton submit = new JButton("Submit");
	OperationsPanel(CartesianPanel cartesian){
		this.cartesian = cartesian;
		this.setLayout(operationLayout);
		this.add(operationsCombo, BorderLayout.PAGE_START);
		submit.setEnabled(false);
		this.add(submit, BorderLayout.PAGE_END);
	}
	class InputItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		    JComboBox cb = (JComboBox) e.getSource();

			if(cb.getSelectedIndex()==0){
				submit.setEnabled(true);
				submit.setText("Refelct");
		    }
			if(cb.getSelectedIndex()==1){
				submit.setEnabled(true);
				submit.setText("Tanslate");
			}
			if(cb.getSelectedIndex()==2){
				submit.setEnabled(true);
				submit.setText("Rotate");
			}
		}
	}
}
