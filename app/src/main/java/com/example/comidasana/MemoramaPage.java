package com.example.comidasana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.LinkedList;

public class MemoramaPage extends AppCompatActivity {

    String TAG = getClass().getSimpleName();
    LinkedList<Integer>lastPosition = new LinkedList();
    GridView gridMemorama;
    AdapterMemorama adapterMemorama;

    ArrayList<Integer>movimientoAnterior = new ArrayList();

    /* CardModel
        Flipped == 2 -> Esta b oca abajo
        Flipped == 1 -> Esta Volteada
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorama_page);

        gridMemorama = (GridView)findViewById(R.id.gridMemorama);
        adapterMemorama = new AdapterMemorama(this);
        gridMemorama.setAdapter(adapterMemorama);

        gridMemorama.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //primero verificar que  no este volteada
                final CardModel card = Comun.cardList.get(position);
                if(card.getFlipped()==2){
                    if(movimientoAnterior.isEmpty()){
                        movimientoAnterior.add(position);
                        card.setFlipped(1);
                        adapterMemorama.notifyDataSetChanged();

                    }else{
                        if(movimientoAnterior.size()<2){
                            movimientoAnterior.add(position);
                            card.setFlipped(1);
                            adapterMemorama.notifyDataSetChanged();
                            if(card.getName().compareToIgnoreCase(Comun.cardList.get(movimientoAnterior.get(0)).getName())!=0){
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    public void run() {

                                        card.setFlipped(2);
                                        Comun.cardList.get(movimientoAnterior.get(0)).setFlipped(2);
                                        adapterMemorama.notifyDataSetChanged();
                                    }
                                }, 3000);
                            }
                        }else{
                            restartPreviusMove();
                        }

                    }
                }

            }
        });

        fillList();
    }

    private void restartPreviusMove() {
        for (int i = 0; i <movimientoAnterior.size() ; i++) {
            Comun.cardList.get(movimientoAnterior.get(i));
        }
        movimientoAnterior.clear();
        adapterMemorama.notifyDataSetChanged();
    }

    public void fillList(){
        CardModel comida10= new CardModel("NARANJA", "https://i0.wp.com/historiasdelahistoria.com/wordpress-2.3.1-ES-0.1-FULL/wp-content/uploads/2015/11/naranja.jpg?fit=607%2C335&ssl=1",2);
        CardModel comida11 = new CardModel("PLATANO", "https://innatia.info/images/galeria/platano-2.jpg",2);
        CardModel comida12 = new CardModel("TOMATE", "https://as.com/buenavida/imagenes/2017/04/14/portada/1492167267_473599_1492167754_noticia_normal.jpg",2);
        CardModel comida13 = new CardModel("ZANAHORIA", "https://frutasyverduras.info/wp-content/uploads/2018/08/zanahoria-1280x720.jpg",2);
        CardModel comida14 = new CardModel("KIWI", "https://gourmetdemexico.com.mx/wp-content/uploads/2020/05/diseno-sin-titulo-70.jpg",2);
        CardModel comida15 = new CardModel("NUECES", "https://www.lavanguardia.com/files/og_thumbnail/uploads/2019/08/07/5e998395e126a.jpeg",2);
        CardModel comida16 = new CardModel("SEMILLAS DE GIRASOL", "https://www.lavanguardia.com/files/article_main_microformat/uploads/2020/03/16/5e9964ba3ea4a.jpeg",2);
        CardModel comida17 = new CardModel("PESCADO", "https://estaticos.muyinteresante.es/media/cache/1140x_thumb/uploads/images/article/5dbffb145cafe8973e525d5d/pescado.jpg",2);
        CardModel comida18 = new CardModel("PASTA", "https://cdn.kiwilimon.com/recetaimagen/29848/31748.jpg",2);

        Comun.cardList.add(comida10);
        Comun.cardList.add(comida11);
        Comun.cardList.add(comida12);
        Comun.cardList.add(comida13);
        Comun.cardList.add(comida14);
        Comun.cardList.add(comida15);
        Comun.cardList.add(comida16);
        Comun.cardList.add(comida17);
        Comun.cardList.add(comida18);
        Log.d(TAG, "fillList: ");
        adapterMemorama.notifyDataSetChanged();
        Log.d(TAG, "fillList: "+Comun.cardList.toString());
    }



}