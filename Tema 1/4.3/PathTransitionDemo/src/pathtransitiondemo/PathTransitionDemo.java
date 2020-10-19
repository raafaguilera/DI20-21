/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pathtransitiondemo;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Rafa
 */
public class PathTransitionDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
       
        Pane root = new Pane();
        Scene scene = new Scene(root, 300, 250);
        Circle circulo = new Circle(scene.getWidth()/2, scene.getHeight()/2, 100);
        circulo.setFill(Color.TRANSPARENT);
        circulo.setStroke(Color.BLACK);
        Rectangle rectangulo = new Rectangle(20,30);
        rectangulo.setFill(Color.ORANGE);
        
        root.getChildren().add(circulo);
        root.getChildren().add(rectangulo);

        
        
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath(circulo);
        pt.setNode(rectangulo);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(false);
        pt.play();
        circulo.setOnMousePressed(e -> pt.pause());
        circulo.setOnMouseReleased(e -> pt.play());
        
        
        
        primaryStage.setTitle("Path Transition");
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
