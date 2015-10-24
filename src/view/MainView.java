package view;

import java.awt.*;
import java.awt.event.*;
import java.util.function.Function;

import javax.swing.*;
import javax.swing.border.Border;



@SuppressWarnings("serial")
public class MainView extends JFrame {
	private JFrame mainFrame = new JFrame();
	private JPanel inputsPanel =  new JPanel();
	private JPanel controlPanel = new JPanel();
	private JPanel operationPanel = new JPanel();
	public CartesianPanel planePane = new CartesianPanel();
	
	private JPanel planePanel;
	
	private double[] polyPoints;
	
	String[] types = {"Points, Lines", "Polygons", "Conics"};
	String[] conics = {"Cirlce", "Ellipse", "Parabola", "Hyperbola"};
	
	private JComboBox typesCombo = new JComboBox(types);
	private JComboBox ConicsCombo = new JComboBox(conics);
	
	
	private BorderLayout inputLayout = new BorderLayout();
	private GridBagLayout frameLayout = new GridBagLayout();
	private GridLayout controlsLayout = new GridLayout(2,1);
	
	
	private PointsAndLinesPanel pal = new PointsAndLinesPanel(planePane); 
	private PolygonPanel poly = new PolygonPanel(planePane);
	private ConicsPanel con = new ConicsPanel(planePane);
	
	

	
	public MainView(){
		
		InputItemListener comboListener = new InputItemListener();
		typesCombo.addActionListener(comboListener);
		
		inputsPanel.setLayout(inputLayout);
		
		
		inputsPanel.add(typesCombo, BorderLayout.PAGE_START);
		
		
		 
		
		
		
		//setting mainFrame Components
		JSplitPane split = new JSplitPane();
		split.add(planePane, JSplitPane.LEFT);
		split.add(controlPanel, JSplitPane.RIGHT);
		split.setOneTouchExpandable(true);
		split.setDividerSize(10);
		split.setDividerLocation(700);
		mainFrame.add(split);
		
	//	planePanel.setBorder(blackline);
		//TODO  planePanel.add();
		
		//setting up controlPanel
	//	controlPanel.setBorder(blackline);
		controlPanel.setLayout(controlsLayout);
	//	inputsPanel.setBorder(blackline);
	//	operationPanel.setBorder(blackline);
		controlPanel.add(inputsPanel);
		controlPanel.add(operationPanel);
		
		
		
		
		mainFrame.setResizable(true);
		mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);	
		mainFrame.setSize(1000, 700);
		mainFrame.setVisible(true);
		
	}
	class InputItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		    JComboBox cb = (JComboBox) e.getSource();

			if(cb.getSelectedIndex()==0){
		    	inputsPanel.remove(poly);
		    	inputsPanel.remove(con);
		    	inputsPanel.add(pal, BorderLayout.CENTER);
		    	inputsPanel.repaint();
		    	inputsPanel.revalidate();
		    }
			if(cb.getSelectedIndex()==1){
				inputsPanel.remove(pal);
				inputsPanel.remove(con);
				inputsPanel.add(poly, BorderLayout.CENTER);
				inputsPanel.repaint();
				inputsPanel.revalidate();
			}
			if(cb.getSelectedIndex()==2){
				inputsPanel.remove(pal);
				inputsPanel.remove(poly);
				inputsPanel.add(con, BorderLayout.CENTER);
				inputsPanel.repaint();
				inputsPanel.revalidate();
			}
		}
	}
}

//NumberAxis Source: http://stackoverflow.com/questions/24005247/draw-cartesian-plane-graphi-with-canvas-in-javafx
