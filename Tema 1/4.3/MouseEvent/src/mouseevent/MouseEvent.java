/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mouseevent;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Rafa
 */
public class MouseEvent extends Application {
    
    @Override
    public void start(Stage primaryStage) {
           
        Text txt=new Text("Programing in fun");
        
        
        
        Pane root = new Pane();
        root.getChildren().add(txt);
        
        
        
        txt.setOnMouseDragged(e -> {
                txt.setX(e.getX());
                txt.setY(e.getY());
           
        
        });
        
        
        Scene scene = new Scene(root, 300, 250);
        
        txt.setX(scene.getWidth()/2);
        txt.setY(scene.getHeight()/2);
        

        
        primaryStage.setTitle("Mouse Event");
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
