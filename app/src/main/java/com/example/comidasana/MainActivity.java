package com.example.comidasana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.button);
        fillList();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),FirstPage.class));
            }
        });
    }

    public void fillList(){
        FoodModel comida1 = new FoodModel("CHOCOLATE", "https://t2.rg.ltmcdn.com/es/images/1/2/9/img_fundir_chocolate_12921_600_square.jpg",1);
        FoodModel comida2 = new FoodModel("PANQUE", "",1);
        FoodModel comida3 = new FoodModel("GALLETAS", "",1);
        FoodModel comida4 = new FoodModel("PAPAS FRITAS", "",1);
        FoodModel comida5 = new FoodModel("HAMBURGUESA", "https://cadenaser00.epimg.net/ser/imagenes/2013/11/27/gastro/1385554450_468547_1457968650_noticia_normal.jpg",1);
        FoodModel comida6 = new FoodModel("ALITAS", "",1);
        FoodModel comida7 = new FoodModel("PALETAS", "",1);
        FoodModel comida8 = new FoodModel("REFRESCO", "",1);
        FoodModel comida9 = new FoodModel("HOTDOG", "",1);
        FoodModel comida10= new FoodModel("NARANJA", "",2);
        FoodModel comida11 = new FoodModel("PLATANO", "",2);
        FoodModel comida12 = new FoodModel("TOMATE", "",2);
        FoodModel comida13 = new FoodModel("ZANAHORIA", "",2);
        FoodModel comida14 = new FoodModel("KIWI", "",2);
        FoodModel comida15 = new FoodModel("NUECES", "",2);
        FoodModel comida16 = new FoodModel("SEMILLAS DE GIRASOL", "",2);
        FoodModel comida17 = new FoodModel("PESCADO", "",2);
        FoodModel comida18 = new FoodModel("PASTA", "",2);

        Comun.foodList.add(comida1);
        Comun.foodList.add(comida1);
        Comun.foodList.add(comida1);
        Comun.foodList.add(comida1);
        Comun.foodList.add(comida1);
        Comun.foodList.add(comida1);
        Comun.foodList.add(comida1);
        Comun.foodList.add(comida1);
        Comun.foodList.add(comida1);
        Comun.foodList.add(comida1);
        Comun.foodList.add(comida1);
        Comun.foodList.add(comida1);
        Comun.foodList.add(comida1);
        Comun.foodList.add(comida1);
        Comun.foodList.add(comida1);
        Comun.foodList.add(comida1);
        Comun.foodList.add(comida1);
        Comun.foodList.add(comida1);

    }
}