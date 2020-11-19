package com.example.comidasana;

public class CardModel {
    String name,imagen;
    int flipped;

    public CardModel(String name, String imagen, int flipped) {
        this.name = name;
        this.imagen = imagen;
        this.flipped = flipped;
    }
    public int getId() {
        return name.hashCode();
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

    public int getFlipped() {
        return flipped;
    }

    public void setFlipped(int flipped) {
        this.flipped = flipped;
    }

    @Override
    public String toString() {
        return "CardModel{" +
                "name='" + name + '\'' +
                ", imagen='" + imagen + '\'' +
                ", flipped=" + flipped +
                '}';
    }
}
