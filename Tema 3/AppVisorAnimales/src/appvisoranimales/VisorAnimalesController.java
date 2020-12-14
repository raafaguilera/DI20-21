/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvisoranimales;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

/**
 *
 * @author Rafa
 */
public class VisorAnimalesController implements Initializable {

    @FXML
    private ListView<Animal> listViewAnimales;
    @FXML
    private ImageView imageViewAnimales;

    private ObservableList<Animal> animalesList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        animalesList = FXCollections.observableArrayList();

        Animal perro = new Animal("Perro", "img/pequeno/perro.jpg", "img/grande/perro.jpg");
        Animal pajaro = new Animal("Pajaro", "img/pequeno/pajaro.jpg", "img/grande/pajaro.jpg");
        Animal gato = new Animal("Gato", "img/pequeno/gato.jpeg", "img/grande/gato.jpeg");

        animalesList.addAll(perro, gato, pajaro);

        listViewAnimales.setItems(animalesList);
        listViewAnimales.getSelectionModel().select(gato);
        imageViewAnimales.setImage(new Image(gato.getImgGrande()));

        listViewAnimales.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                Animal animal = (Animal) newValue;
                imageViewAnimales.setImage(new Image(animal.getImgGrande()));
            }
        });
        
        listViewAnimales.setCellFactory((ListView<Animal> l) -> new CeldaImagenTexto());

    }

}
