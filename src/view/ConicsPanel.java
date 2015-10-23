package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ConicsPanel extends JPanel {
	private CartesianPanel cartesian;
	String[] conicsStrings = new String[]{"Ellipse", "Hyperbola", "Parabola"};
	private JComboBox conics = new JComboBox(conicsStrings);
	private BorderLayout borderLayout = new BorderLayout();
	private ConicsPanel con = this;
	private JPanel hyperPanel =  new JPanel();
	ConicsPanel(CartesianPanel cartesian){
		this.cartesian = cartesian;
		this.setLayout(borderLayout);
		this.add(conics, BorderLayout.PAGE_START);
	}
	class ItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		    JComboBox cb = (JComboBox) e.getSource();

			if(cb.getSelectedIndex()==0){
				//con.add(, BorderLayout.CENTER);
		    	con.repaint();
		    	con.revalidate();
		    }
			if(cb.getSelectedIndex()==1){
				//con.add(poly, BorderLayout.CENTER);
				con.repaint();
				con.revalidate();
			}
			if(cb.getSelectedIndex()==2){
				//con.add(con, BorderLayout.CENTER);
				con.repaint();
				con.revalidate();
			}
		}
	}
}
