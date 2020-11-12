package com.example.comidasana;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class FirstPage extends AppCompatActivity {
    CardView card1, card2;
    ImageView img1, img2;
    TextView mTextField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        getSupportActionBar().setTitle("Selecciona la comida saludable");

        card1 = (CardView)findViewById(R.id.card1);
        card2 = (CardView)findViewById(R.id.card2);
        img1 = (ImageView)findViewById(R.id.imageView2);
        img2 = (ImageView)findViewById(R.id.imageView3);
        mTextField = (TextView)findViewById(R.id.textView2) ;
        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SecondPage.class));
            }
        });
        Picasso.get().load("https://cdn.kiwilimon.com/recetaimagen/29848/31748.jpg").into(img1, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {
                Log.d("DEB", "onError: "+e.getMessage());
            }
        });

        Picasso.get().load("https://cadenaser00.epimg.net/ser/imagenes/2013/11/27/gastro/1385554450_468547_1457968650_noticia_normal.jpg").into(img2, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {
                Log.d("DEB", "onError: "+e.getMessage());
            }
        });

        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                long resta = millisUntilFinished / 1000;
                mTextField.setText("Restan  "+resta + " segundos");
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                mTextField.setText("Se ha acabo el tiempo");
            }

        }.start();

    }
}