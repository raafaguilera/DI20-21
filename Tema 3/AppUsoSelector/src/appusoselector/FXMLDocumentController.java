/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appusoselector;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import selectordeslizamiento.Selector_deslizamiento;

/**
 *
 * @author Rafa
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Selector_deslizamiento selec1;
    @FXML
    private Selector_deslizamiento selec2;
    @FXML
    private Label labelTest;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ArrayList<String> numeros = new ArrayList<String>();
        numeros.add("uno");
        numeros.add("dos");
        numeros.add("tres");

        selec1.setItems(numeros);
        selec2.setItems(numeros);

        selec1.setOnAction((ActionEvent event) -> {
            labelTest.setText("Pulsado selector 1");
        });

        selec2.setOnAction((ActionEvent event) -> {
            labelTest.setText("Pulsado selector 2");
        });
    }

}
