/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvisoranimales;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 *
 * @author Rafa
 */
public class CeldaImagenTexto extends ListCell<Animal>{

    private VBox imgVBox;
    private ImageView img;
    private Label nombre;

    public CeldaImagenTexto() {
        img = new ImageView();
        imgVBox = new VBox();
        nombre = new Label();

        img.setFitWidth(100);
        img.setFitHeight(100);
        
        imgVBox.getChildren().addAll(img, nombre);
        imgVBox.setAlignment(Pos.CENTER);
    }

    @Override
    protected void updateItem(Animal item, boolean empty) {
        super.updateItem(item, empty); 
        
        if(item != null) {
            nombre.setText(item.getNombre());
            img.setImage(new Image(item.getImgMiniatura()));
            setGraphic(imgVBox);
        }
    }
    
    

}
