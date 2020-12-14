/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvisoranimales;

/**
 *
 * @author Rafa
 */
public class Animal {

    private String nombre;
    private String imgMiniatura;
    private String imgGrande;

    public Animal(String nombre, String imgMiniatura, String imgGrande) {
        this.nombre = nombre;
        this.imgMiniatura = imgMiniatura;
        this.imgGrande = imgGrande;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImgGrande() {
        return imgGrande;
    }

    public void setImgGrande(String imgGrande) {
        this.imgGrande = imgGrande;
    }

    public String getImgMiniatura() {
        return imgMiniatura;
    }

    public void setImgMiniatura(String imgMiniatura) {
        this.imgMiniatura = imgMiniatura;
    }



}
