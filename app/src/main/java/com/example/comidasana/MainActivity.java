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
        FoodModel comida2 = new FoodModel("PANQUE", "https://cdn.kiwilimon.com/recetaimagen/14453/th5-640x426-6841.jpg",1);
        FoodModel comida3 = new FoodModel("GALLETAS", "https://cdn.kiwilimon.com/recetaimagen/3329/38990.jpg",1);
        FoodModel comida4 = new FoodModel("PAPAS FRITAS", "https://www.recetas360.com/wp-content/uploads/2019/07/como-hacer-papas-fritas-de-mcdonals.jpg",1);
        FoodModel comida5 = new FoodModel("HAMBURGUESA", "https://cadenaser00.epimg.net/ser/imagenes/2013/11/27/gastro/1385554450_468547_1457968650_noticia_normal.jpg",1);
        FoodModel comida6 = new FoodModel("ALITAS", "https://cdn2.cocinadelirante.com/sites/default/files/styles/gallerie/public/images/2018/02/comohaceralitas.jpg",1);
        FoodModel comida7 = new FoodModel("PALETAS", "https://i.pinimg.com/originals/35/8d/0b/358d0bc424f58996f14962557858a867.jpg",1);
        FoodModel comida8 = new FoodModel("REFRESCO", "https://www.revistamoi.com/wp-content/uploads/2016/04/refresco-mar-b.jpg",1);
        FoodModel comida9 = new FoodModel("HOTDOG", "https://placeralplato.com/files/2015/11/Pan-para-hot-dogs-640x480.jpg?width=1200&enable=upscale",1);
        FoodModel comida10= new FoodModel("NARANJA", "https://i0.wp.com/historiasdelahistoria.com/wordpress-2.3.1-ES-0.1-FULL/wp-content/uploads/2015/11/naranja.jpg?fit=607%2C335&ssl=1",2);
        FoodModel comida11 = new FoodModel("PLATANO", "https://innatia.info/images/galeria/platano-2.jpg",2);
        FoodModel comida12 = new FoodModel("TOMATE", "https://as.com/buenavida/imagenes/2017/04/14/portada/1492167267_473599_1492167754_noticia_normal.jpg",2);
        FoodModel comida13 = new FoodModel("ZANAHORIA", "https://frutasyverduras.info/wp-content/uploads/2018/08/zanahoria-1280x720.jpg",2);
        FoodModel comida14 = new FoodModel("KIWI", "https://gourmetdemexico.com.mx/wp-content/uploads/2020/05/diseno-sin-titulo-70.jpg",2);
        FoodModel comida15 = new FoodModel("NUECES", "https://www.lavanguardia.com/files/og_thumbnail/uploads/2019/08/07/5e998395e126a.jpeg",2);
        FoodModel comida16 = new FoodModel("SEMILLAS DE GIRASOL", "https://www.lavanguardia.com/files/article_main_microformat/uploads/2020/03/16/5e9964ba3ea4a.jpeg",2);
        FoodModel comida17 = new FoodModel("PESCADO", "https://estaticos.muyinteresante.es/media/cache/1140x_thumb/uploads/images/article/5dbffb145cafe8973e525d5d/pescado.jpg",2);
        FoodModel comida18 = new FoodModel("PASTA", "https://cdn.kiwilimon.com/recetaimagen/29848/31748.jpg",2);

        Comun.foodList.add(comida1);
        Comun.foodList.add(comida2);
        Comun.foodList.add(comida3);
        Comun.foodList.add(comida4);
        Comun.foodList.add(comida5);
        Comun.foodList.add(comida6);
        Comun.foodList.add(comida7);
        Comun.foodList.add(comida8);
        Comun.foodList.add(comida9);
        Comun.foodListSaludable.add(comida10);
        Comun.foodListSaludable.add(comida11);
        Comun.foodListSaludable.add(comida12);
        Comun.foodListSaludable.add(comida13);
        Comun.foodListSaludable.add(comida14);
        Comun.foodListSaludable.add(comida15);
        Comun.foodListSaludable.add(comida16);
        Comun.foodListSaludable.add(comida17);
        Comun.foodListSaludable.add(comida18);

    }
}