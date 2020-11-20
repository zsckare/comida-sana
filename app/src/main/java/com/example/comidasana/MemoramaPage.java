package com.example.comidasana;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.emredavarci.noty.Noty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class MemoramaPage extends AppCompatActivity {

    String TAG = getClass().getSimpleName();
    LinkedList<Integer>lastPosition = new LinkedList();
    GridView gridMemorama;
    AdapterMemorama adapterMemorama;
    RelativeLayout rl;
    MediaPlayer ambiente,gameover;
    int dificultad = 2;

    CountDownTimer countDownTimer;
    ArrayList<Integer>movimientoAnterior = new ArrayList();
    TextView mTextField;

    /* CardModel
        Flipped == 2 -> Esta b oca abajo
        Flipped == 1 -> Esta Volteada
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorama_page);
        mTextField = (TextView)findViewById(R.id.textView7);
        rl = (RelativeLayout) findViewById(R.id.myLayout2);
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
                                }, 1000);
                            }else{
                                movimientoAnterior.clear();
                            }
                        }else{
                            restartPreviusMove();
                        }

                    }
                }

            }
        });

        fillList();
        ambiente = MediaPlayer.create(MemoramaPage.this,R.raw.tetris);
        gameover = MediaPlayer.create(MemoramaPage.this,R.raw.gameover);
        ambiente.setLooping(true);
        ambiente.start();
        countDownTimer = new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                long resta = millisUntilFinished / 1000;
                mTextField.setText("Tiempo Restante:  "+resta + " segundos");
            }

            public void onFinish() {

                mTextField.setText("Se ha acabo el tiempo");
                countDownTimer.cancel();
                ambiente.pause();
                gameover.start();

                YoYo.with(Techniques.Shake)
                        .duration(1000)
                        .repeat(0)
                        .playOn(findViewById(R.id.gridview));
                Noty.init(MemoramaPage.this, "Perdiste \n Se acabo el tiempo.", rl,
                        Noty.WarningStyle.ACTION)
                        .setActionText("OK")
                        .setHeight(new RelativeLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT))
                        .setWarningBoxBgColor("#00b8e6")
                        .setWarningTappedColor("#00ccff")
                        .setWarningBoxMargins(40,0,40,0)
                        .setWarningBoxPosition(Noty.WarningPos.CENTER)
                        .setAnimation(Noty.RevealAnim.FADE_IN, Noty.DismissAnim.FADE_OUT, 400,400);
            }

        };
        countDownTimer.start();
    }

    private void restartPreviusMove() {
        for (int i = 0; i <movimientoAnterior.size() ; i++) {
            Comun.cardList.get(movimientoAnterior.get(i));
        }
        movimientoAnterior.clear();
        adapterMemorama.notifyDataSetChanged();
    }

    public void fillList(){
        if(!Comun.cardList.isEmpty()){
            Comun.cardList.clear();
        }
        CardModel comida0= new CardModel("NARANJA", "https://i0.wp.com/historiasdelahistoria.com/wordpress-2.3.1-ES-0.1-FULL/wp-content/uploads/2015/11/naranja.jpg?fit=607%2C335&ssl=1",2);
        CardModel comida1 = new CardModel("PLATANO", "https://innatia.info/images/galeria/platano-2.jpg",2);
        CardModel comida2 = new CardModel("TOMATE", "https://as.com/buenavida/imagenes/2017/04/14/portada/1492167267_473599_1492167754_noticia_normal.jpg",2);
        CardModel comida3 = new CardModel("ZANAHORIA", "https://frutasyverduras.info/wp-content/uploads/2018/08/zanahoria-1280x720.jpg",2);
        CardModel comida4 = new CardModel("KIWI", "https://gourmetdemexico.com.mx/wp-content/uploads/2020/05/diseno-sin-titulo-70.jpg",2);
        CardModel comida5 = new CardModel("GUAYABA", "https://www.tn8.tv/media/cache/85/a5/85a5c022dc7d09861ad4c338096f8a18.jpg",2);
        CardModel comida6 = new CardModel("MANZANA", "https://dalissanavarro.files.wordpress.com/2019/02/manzana.gif?w=400",2);
        CardModel comida7 = new CardModel("limon", "https://i1.wp.com/noticieros.televisa.com/wp-content/uploads/2020/08/beneficios-de-tomar-cucharada-de-jugo-de-limon-en-ayunas.jpg?w=1093&ssl=1",2);
        CardModel comida8 = new CardModel("sandia", "https://mk0lanoticiavesdar5g.kinstacdn.com/wp-content/uploads/2020/08/5-razones-para-comer-sandia-todos-los-dias.jpg.webp",2);
        CardModel comida10= new CardModel("NARANJA", "https://i0.wp.com/historiasdelahistoria.com/wordpress-2.3.1-ES-0.1-FULL/wp-content/uploads/2015/11/naranja.jpg?fit=607%2C335&ssl=1",2);
        CardModel comida11 = new CardModel("PLATANO", "https://innatia.info/images/galeria/platano-2.jpg",2);
        CardModel comida12 = new CardModel("TOMATE", "https://as.com/buenavida/imagenes/2017/04/14/portada/1492167267_473599_1492167754_noticia_normal.jpg",2);
        CardModel comida13 = new CardModel("ZANAHORIA", "https://frutasyverduras.info/wp-content/uploads/2018/08/zanahoria-1280x720.jpg",2);
        CardModel comida14 = new CardModel("KIWI", "https://gourmetdemexico.com.mx/wp-content/uploads/2020/05/diseno-sin-titulo-70.jpg",2);
        CardModel comida15 = new CardModel("GUAYABA", "https://www.tn8.tv/media/cache/85/a5/85a5c022dc7d09861ad4c338096f8a18.jpg",2);
        CardModel comida16 = new CardModel("MANZANA", "https://dalissanavarro.files.wordpress.com/2019/02/manzana.gif?w=400",2);
        CardModel comida17 = new CardModel("limon", "https://i1.wp.com/noticieros.televisa.com/wp-content/uploads/2020/08/beneficios-de-tomar-cucharada-de-jugo-de-limon-en-ayunas.jpg?w=1093&ssl=1",2);
        CardModel comida18 = new CardModel("sandia", "https://mk0lanoticiavesdar5g.kinstacdn.com/wp-content/uploads/2020/08/5-razones-para-comer-sandia-todos-los-dias.jpg.webp",2);

        Comun.cardList.add(comida1);
        Comun.cardList.add(comida2);
        Comun.cardList.add(comida3);
        Comun.cardList.add(comida0);
        Comun.cardList.add(comida4);
        Comun.cardList.add(comida5);
        Comun.cardList.add(comida6);
        Comun.cardList.add(comida7);
        Comun.cardList.add(comida8);

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
        Collections.shuffle(Comun.cardList);

        adapterMemorama.notifyDataSetChanged();
        Log.d(TAG, "fillList: "+Comun.cardList.toString());
    }



}