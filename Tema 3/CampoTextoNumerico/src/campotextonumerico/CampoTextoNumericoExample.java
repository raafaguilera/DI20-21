/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campotextonumerico;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Rafa
 */
public class CampoTextoNumericoExample extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        CampoTextoNumerico campoTextoNumerico = new CampoTextoNumerico();

        stage.setScene(new Scene(campoTextoNumerico));
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
