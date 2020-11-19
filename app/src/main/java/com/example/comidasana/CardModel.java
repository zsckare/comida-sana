package com.example.comidasana;

public class CardModel {
    String name,imagen;
    int tipo,fliped;

    public CardModel(String name, String imagen, int tipo, int fliped) {
        this.name = name;
        this.imagen = imagen;
        this.tipo = tipo;
        this.fliped = fliped;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getFliped() {
        return fliped;
    }

    public void setFliped(int fliped) {
        this.fliped = fliped;
    }

    @Override
    public String toString() {
        return "CardModel{" +
                "name='" + name + '\'' +
                ", imagen='" + imagen + '\'' +
                ", tipo=" + tipo +
                ", fliped=" + fliped +
                '}';
    }
}
