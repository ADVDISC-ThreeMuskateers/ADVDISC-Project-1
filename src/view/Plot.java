package view;

import java.util.function.Function;

import com.sun.org.apache.xpath.internal.axes.MatchPatternIterator;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

class Plot extends Pane {
    public Plot(
            Function<Double, Double> f,
            double xMin, double xMax, double xInc,
            Axes axes
    ) {
        Path path = new Path();
        path.setStroke(Color.ORANGE.deriveColor(0, 1, 1, 0.6));
        path.setStrokeWidth(2);

        path.setClip(
                new Rectangle(
                        0, 0, 
                        axes.getPrefWidth(), 
                        axes.getPrefHeight()
                )
        );

        double x = xMin;
        double y = f.apply(x);

        path.getElements().add(
                new MoveTo(
                        mapX(x, axes), mapY(y, axes)
                )
        );

        x += xInc;
        while (x < xMax) {
            y = f.apply(x);

            path.getElements().add(
                    new LineTo(
                            mapX(x, axes), mapY(y, axes)
                    )
            );

            x += xInc;
        }

        setMinSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);
        setPrefSize(axes.getPrefWidth(), axes.getPrefHeight());
        setMaxSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);

        getChildren().setAll(axes, path);
    }
    public Plot(
            double xMin, double xMax, double xInc,
            Axes axes, int sides
    ){
    	double i=0;
    	Path path = new Path();
    	 path.setStroke(Color.ORANGE.deriveColor(0, 1, 1, 0.6));
         path.setStrokeWidth(2);
         Function<Double, Double> fx =  x -> Math.cos((2*i)*Math.PI/sides);
         Function<Double, Double> fy = y -> Math.sin((2*i)*Math.PI/sides);
         while(i!=sides){
        	 double x = fx.apply(i);
        	 double y = fy.apply(i);
        	 i++;
         }
    	
    }

    private double mapX(double x, Axes axes) {
        double tx = axes.getPrefWidth() / 2;
        double sx = axes.getPrefWidth() / 
           (axes.getXAxis().getUpperBound() - 
            axes.getXAxis().getLowerBound());

        return x * sx + tx;
    }

    private double mapY(double y, Axes axes) {
        double ty = axes.getPrefHeight() / 2;
        double sy = axes.getPrefHeight() / 
            (axes.getYAxis().getUpperBound() - 
             axes.getYAxis().getLowerBound());

        return -y * sy + ty;
    }
}