/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fadetransitiondemo;


import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Rafa
 */
public class FadeTransitionDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Ellipse ellipse = new Ellipse(100, 80);
        ellipse.setFill(Color.RED);
        ellipse.setStroke(Color.BLACK);
        FadeTransition ft = new FadeTransition(Duration.millis(30), ellipse);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play(); // Start animation
        // Control animation
        ellipse.setOnMousePressed(e -> ft.pause());
        ellipse.setOnMouseReleased(e -> ft.play());

       
        
        Pane root = new Pane();
        root.getChildren().add(ellipse);
        
        Scene scene = new Scene(root, 300, 250);
        
        ellipse.setCenterX(scene.getWidth()/2);
        ellipse.setCenterY(scene.getHeight()/2);
        
        primaryStage.setTitle("Fade Transition");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
