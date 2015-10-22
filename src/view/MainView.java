package view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;

import com.sun.istack.internal.FragmentContentHandler;
import javafx.application.Platform;
import com.sun.xml.internal.bind.v2.runtime.output.IndentingUTF8XmlOutput;

import javafx.embed.swing.JFXPanel;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

@SuppressWarnings("serial")
public class MainView extends JFrame {
	private static void initFX(JFXPanel fxPanel) {
        // This method is invoked on JavaFX thread
        Scene scene = createScene();
        fxPanel.setScene(scene);
    }
	
	private static Scene createScene() {
		Group  root  =  new  Group();
        Axes axes = new Axes(
	            600, 600,
	            -20, 20, 1,
	            -20, 20, 1
	    );
	    
	    Plot plot = new Plot(
	            //x -> -x*x/4,// parabola function
	    		//x -> Math.pow(4*x, 0.5),
	    		x -> -x*x/4,
	    		
	    		-8, 8, 0.1,
	            axes
	    );
	    
	
	    StackPane layout = new StackPane(plot);
	    layout.setPadding(new Insets(20));
	    layout.setStyle("-fx-background-color: rgb(35, 39, 50);");
	    Scene  theScene  =  new Scene(layout, Color.rgb(35, 39, 50));
	    return theScene;
	}

	private JFrame mainFrame = new JFrame();
	private JPanel inputsPanel =  new JPanel();
	private JPanel controlPanel = new JPanel();
	private JPanel operationPanel = new JPanel();
	private JFXPanel planePane = new JFXPanel();
	
	private JPanel planePanel;
	
	
	String[] types = {"Points, Lines", "Polygons", "Conics"};
	String[] conics = {"Cirlce", "Ellipse", "Parabola", "Hyperbola"};
	private JComboBox typesCombo = new JComboBox(types);
	private JComboBox ConicsCombo = new JComboBox(conics);
	
	
	private BorderLayout inputLayout = new BorderLayout();
	private GridBagLayout frameLayout = new GridBagLayout();
	private GridLayout controlsLayout = new GridLayout(2,1);
	
	
	private PointsAndLines pal = new PointsAndLines(); 
	private Polygons poly = new Polygons();
	public MainView(){
		
		ItemListener comboListener = new ItemListener();
		typesCombo.addActionListener(comboListener);
		
		inputsPanel.setLayout(inputLayout);
		inputsPanel.add(typesCombo, BorderLayout.PAGE_START);
		
		
		 
		Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(planePane);
            }
       });
		
		
		
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
	class ItemListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		    JComboBox cb = (JComboBox) e.getSource();

			if(cb.getSelectedIndex()==0){
		    	inputsPanel.remove(poly);
				inputsPanel.add(pal, BorderLayout.CENTER);
		    	inputsPanel.repaint();
		    	inputsPanel.revalidate();
		    }
			if(cb.getSelectedIndex()==1){
				inputsPanel.remove(pal);
				inputsPanel.add(poly, BorderLayout.CENTER);
				inputsPanel.repaint();
				inputsPanel.revalidate();
			}
		}
	}
}

//NumberAxis Source: http://stackoverflow.com/questions/24005247/draw-cartesian-plane-graphi-with-canvas-in-javafx
