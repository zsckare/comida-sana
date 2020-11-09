package com.example.comidasana;

public class FoodModel {
    String name,imagen;
    int tipo;

    public FoodModel(String name, String imagen, int tipo) {
        this.name = name;
        this.imagen = imagen;
        this.tipo = tipo;
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "FoodModel{" +
                "name='" + name + '\'' +
                ", imagen='" + imagen + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
