/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keyevent;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Rafa
 */
public class KeyEvent extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       
        Text txt = new Text(20,20,"A"); 
        Pane root = new Pane();
        root.getChildren().add(txt);
        
       
        
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Key Event");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
         scene.setOnKeyPressed(e -> {
            //System.out.println(e.getCode());
            KeyCode key=e.getCode();
            if (key==key.UP)
                if(txt.getY()<20) return;
                else txt.setY(txt.getY()-10);
            if (key==key.DOWN)
                if(txt.getY()>scene.getHeight()-20) return;
                else txt.setY(txt.getY()+10);
            if (key==key.LEFT)
                if(txt.getX()<20) return;
                else txt.setX(txt.getX()-10);
            if (key==key.RIGHT)
                if(txt.getX()>scene.getWidth()-20) return;
                else txt.setX(txt.getX()+10);

            
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
