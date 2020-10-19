/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraprestamo;

import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Rafa
 */
public class CalculadoraPrestamo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        /*
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        */
        
        Label text1=new Label("Annual interest Rate: ");
        Label text2=new Label("Number of years: ");
        Label text3=new Label("Loan Amount: ");
        Label text4=new Label("Monthly payment: ");
        Label text5=new Label("Total payment: ");
        
        TextField campo1=new TextField();
        TextField campo2=new TextField();
        TextField campo3=new TextField();
        TextField campo4=new TextField();
        TextField campo5=new TextField();
        
        Button calcula=new Button("Calculate");
        
        GridPane root = new GridPane();
        root.add(text1,0,0);
        root.add(text2,0,1);
        root.add(text3,0,2);
        root.add(text4,0,3);
        root.add(text5,0,4);
        root.add(campo1,1,0);
        root.add(campo2,1,1);
        root.add(campo3,1,2);
        root.add(campo4,1,3);
        root.add(campo5,1,4);
        root.add(calcula,1,5);
        
        calcula.setOnAction((ActionEvent event) -> {
            double h=0, n=0, i=0,r,m;
            String cad;
            
            try {
            cad=campo1.getText();
            i=Double.parseDouble(cad);
            } catch(NumberFormatException ex) {
                System.out.println(ex.getMessage()+" en el campo 1");
                campo4.setText("Error");
                campo5.setText("Error");
                return;
            }
            
            try {
            cad=campo2.getText();
            n=Double.parseDouble(cad);
            } catch(NumberFormatException ex) {
                System.out.println(ex.getMessage()+" en el campo 2");
                campo4.setText("Error");
                campo5.setText("Error");
                return;
            }
            
            try {
            cad=campo3.getText();
            h=Double.parseDouble(cad);
            } catch(NumberFormatException ex) {
                System.out.println(ex.getMessage()+" en el campo 3");
                campo4.setText("Error");
                campo5.setText("Error");
                return;
            }
            
            r=i/(100*12);
            m=(h*r)/(1-Math.pow((1+r),-12*n));
            
            campo4.setText("$"+new DecimalFormat("#.##").format(m));
            campo5.setText("$"+new DecimalFormat("#.##").format(m*n*12));
            
        
        });
        
        
        
        
        root.setAlignment(Pos.CENTER);
        root.setVgap(10);
        root.setHgap(10);
        Scene scene = new Scene(root, 400, 350);
        
        primaryStage.setTitle("CalculadoraPrestamo");
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
