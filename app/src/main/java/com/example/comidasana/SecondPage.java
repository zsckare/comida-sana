package com.example.comidasana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.emredavarci.noty.Noty;

public class SecondPage extends AppCompatActivity {
     GridView gridView;
     CustomAdapter adaptador;
    RelativeLayout rl;
    static int puntuacion = 0;
    TextView tvPuntuacion;
    boolean loser = false;
    Button btnOmitir;
    MediaPlayer ambiente,gameover;

    TextView mTextField;

    CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        tvPuntuacion = (TextView)findViewById(R.id.textView3);
        btnOmitir = (Button) findViewById(R.id.button2);
        mTextField = (TextView)findViewById(R.id.textView4);
        rl = (RelativeLayout) findViewById(R.id.myLayout) ;
        gridView = (GridView)findViewById(R.id.gridview);
        adaptador = new CustomAdapter(this);
        gridView.setAdapter(adaptador);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            int tipo = Comun.selectedFoodList.get(position).getTipo();
                if (!loser){
                    if(tipo == 1){
                        loser=true;
                        btnOmitir.setText("Reiniciar juego");
                        showLostGame();

                    }else{
                        YoYo.with(Techniques.BounceIn)
                                .duration(1000)
                                .repeat(0)
                                .playOn(findViewById(R.id.gridview));
                        setItems();
                        puntuacion = puntuacion+1;
                        tvPuntuacion.setText("Puntuacion: "+puntuacion);
                        Log.d("DEB", "onItemClick: "+puntuacion);
                        countDownTimer.start();
                        if(puntuacion ==20){
                            ambiente.stop();

                            startActivity(new Intent(getApplicationContext(),WinnerActivity.class));
                        }
                    }
                }
            }
        });
        setItems();
        YoYo.with(Techniques.BounceIn)
                .duration(1000)
                .repeat(0)
                .playOn(findViewById(R.id.gridview));
        btnOmitir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!loser){
                    if(checkComida()){
                        setItems();
                        countDownTimer.start();
                        ambiente.start();

                    }else{
                        countDownTimer.cancel();
                        ambiente.pause();
                        gameover.start();
                        YoYo.with(Techniques.Shake)
                                .duration(1000)
                                .repeat(0)
                                .playOn(findViewById(R.id.gridview));
                        Noty.init(SecondPage.this, "Perdiste \n Si habia una cpmida saludable en las imagenes", rl,
                                Noty.WarningStyle.ACTION)
                                .setActionText("OK")
                                .setHeight(new RelativeLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT))
                                .setWarningBoxBgColor("#00b8e6")
                                .setWarningTappedColor("#00ccff")
                                .setWarningBoxMargins(40,0,40,0)
                                .setWarningBoxPosition(Noty.WarningPos.CENTER)
                                .setAnimation(Noty.RevealAnim.FADE_IN, Noty.DismissAnim.FADE_OUT, 400,400)
                                .show();
                        tvPuntuacion.setText("Puntuacion: 0");
                        puntuacion = 0;
                    }
                }else{
                    loser = false;
                    btnOmitir.setText("Omitir");
                    setItems();
                    countDownTimer.start();
                    ambiente.start();
                }
            }
        });

        ambiente = MediaPlayer.create(SecondPage.this,R.raw.ambiente);
        gameover = MediaPlayer.create(SecondPage.this,R.raw.gameover);
        ambiente.setLooping(true);
        ambiente.start();
        countDownTimer = new CountDownTimer(7000, 1000) {

            public void onTick(long millisUntilFinished) {
                long resta = millisUntilFinished / 1000;
                mTextField.setText("Restan  "+resta + " segundos");
                //here you can have your logic to set text to edittext

            }

            public void onFinish() {
                if (puntuacion!= 20){
                    mTextField.setText("Se ha acabo el tiempo");
                    countDownTimer.cancel();
                    ambiente.pause();
                    gameover.start();
                    YoYo.with(Techniques.Shake)
                            .duration(1000)
                            .repeat(0)
                            .playOn(findViewById(R.id.gridview));
                    Noty.init(SecondPage.this, "Perdiste \n Se acabo el tiempo.", rl,
                            Noty.WarningStyle.ACTION)
                            .setActionText("OK")
                            .setHeight(new RelativeLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT))
                            .setWarningBoxBgColor("#00b8e6")
                            .setWarningTappedColor("#00ccff")
                            .setWarningBoxMargins(40,0,40,0)
                            .setWarningBoxPosition(Noty.WarningPos.CENTER)
                            .setAnimation(Noty.RevealAnim.FADE_IN, Noty.DismissAnim.FADE_OUT, 400,400)
                            .show();
                    tvPuntuacion.setText("Puntuacion: 0");
                    puntuacion = 0;

                }
            }

        };
        countDownTimer.start();
    }
    public void setItems(){
        if(!Comun.selectedFoodList.isEmpty()){
            Comun.selectedFoodList.clear();
        }
        for (int i = 0; i < 4; i++) {

            int r = (int) (Math.random() * (17 - 1)) + 1;
            Comun.selectedFoodList.add(Comun.foodList.get(r));
        }
        adaptador.notifyDataSetChanged();
        Log.d("DEB","Toal="+Comun.selectedFoodList.toString());
    }
    void showLostGame(){
        countDownTimer.cancel();
        ambiente.pause();
        gameover.start();
        YoYo.with(Techniques.Shake)
                .duration(1000)
                .repeat(0)
                .playOn(findViewById(R.id.gridview));
        Noty.init(SecondPage.this, "Perdiste \n Ese no era un alimento sano..", rl,
                Noty.WarningStyle.ACTION)
                .setActionText("OK")
                .setHeight(new RelativeLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT))
                .setWarningBoxBgColor("#00b8e6")
                .setWarningTappedColor("#00ccff")
                .setWarningBoxMargins(40,0,40,0)
                .setWarningBoxPosition(Noty.WarningPos.CENTER)
                .setAnimation(Noty.RevealAnim.FADE_IN, Noty.DismissAnim.FADE_OUT, 400,400)
                .show();
        tvPuntuacion.setText("Puntuacion: 0");
        puntuacion = 0;

    }
    boolean checkComida(){
        boolean comida = false;
        for (int i = 0; i < Comun.selectedFoodList.size(); i++) {

            int tipo = Comun.selectedFoodList.get(i).getTipo();
            Log.d("DEB", "checkComida: "+tipo);
            if (tipo == 2){
                comida =true;
            }else{
                comida = false;
            }

        }
        return comida;
    }

}