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
//	private HyperbolaPanel hyp;
	private EllipsePanel ell;
	private ParabolaPanel par;
	private OperationsPanel oper;
	ConicsPanel(CartesianPanel cartesian, OperationsPanel oper){
		this.cartesian = cartesian;
		this.oper = oper;
		this.setLayout(borderLayout);
		this.add(conics, BorderLayout.PAGE_START);
//		hyp = new HyperbolaPanel();
		ell = new EllipsePanel(cartesian, oper);
		par = new ParabolaPanel(cartesian, oper);
		con.add(ell, BorderLayout.CENTER);
    	conics.addActionListener(new ItemListener());
    	
	}
	class ItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		    JComboBox cb = (JComboBox) e.getSource();

			if(cb.getSelectedIndex()==0){
				//cartesian.addShapes(new shapes.Point(2, 2));
//				con.remove(hyp);
				con.remove(par);
				con.add(ell, BorderLayout.CENTER);
		    	con.repaint();
		    	con.revalidate();
		    }
			if(cb.getSelectedIndex()==1){
				con.remove(ell);
				con.remove(par);
//				con.add(hyp, BorderLayout.CENTER);
				con.repaint();
				con.revalidate();
			}
			if(cb.getSelectedIndex()==2){
				con.remove(ell);
//				con.remove(hyp);
				con.add(par, BorderLayout.CENTER);
				con.repaint();
				con.revalidate();
			}
		}
	}
}
