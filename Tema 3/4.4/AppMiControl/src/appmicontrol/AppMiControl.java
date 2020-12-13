/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appmicontrol;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import proyectomicontrol.MiControl;

/**
 *
 * @author Rafa
 */
public class AppMiControl extends Application {

    @Override
    public void start(Stage primaryStage) {
        MiControl micontrol = new MiControl();

        micontrol.setOnAction(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                try {
                    introspeccion(micontrol);
                } 
                
                catch (NoSuchMethodException ex) {
                    Logger.getLogger(AppMiControl.class.getName()).log(Level.SEVERE, null, ex);
                } 
                
                catch (NoSuchFieldException ex) {
                    Logger.getLogger(AppMiControl.class.getName()).log(Level.SEVERE, null, ex);
                } 
                
                catch (ClassNotFoundException ex) {
                    Logger.getLogger(AppMiControl.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        Pane root = new Pane();
        root.getChildren().add(micontrol);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static void introspeccion(MiControl miControl) throws NoSuchMethodException, NoSuchFieldException, ClassNotFoundException {

        Method[] methods;
        methods = miControl.getClass().getDeclaredMethods();

        System.out.println("GetName: " + miControl.getClass().getName());

        System.out.println("Métodos: ");
        for (int i = 0; i < methods.length; i++) {
            System.out.println("Metodo " + (i + 1) + " : " + methods[i]);
        }
        System.out.println("Constructores: " + miControl.getClass().getConstructor());


        Class miClase = Class.forName("proyectomicontrol.MiControl");
        System.out.println("Clase: " + miClase.getName());

        
    }

}
