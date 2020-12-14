/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campotextoboton;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Rafa
 */
public class CampoTextoBotonExample extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        CampoTextoBoton campoTextoBoton = new CampoTextoBoton();
        campoTextoBoton.setText("Hello!");
        
        stage.setScene(new Scene(campoTextoBoton));
        stage.setTitle("Custom Control");
        stage.setWidth(300);
        stage.setHeight(200);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
