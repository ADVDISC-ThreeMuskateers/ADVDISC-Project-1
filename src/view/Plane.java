package view;

import java.awt.Canvas;


import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Plane extends Scene {
	
	
	
	
	public Plane(Parent arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	
	private void start(Stage stage){
		Axes axes = new Axes(
	            400, 300,
	            -8, 8, 1,
	            -6, 6, 1
	    );
	    
	    //Axes axes2 = new Axes(300, 400, )
	    Plot plot = new Plot(
	            //x -> -x*x/4,// parabola function
	    		//x -> Math.pow(4*x, 0.5),
	    		x -> -x*x/4,
	    		-8, 8, 0.1,
	            axes
	    );
	
	    StackPane layout = new StackPane(
	            plot
	    );
	    layout.setPadding(new Insets(20));
	    layout.setStyle("-fx-background-color: rgb(35, 39, 50);");
	
	}
        
    
}
