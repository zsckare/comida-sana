package com.example.comidasana;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

        mTextField = (TextView)findViewById(R.id.textView2);
        Button btn = (Button)findViewById(R.id.button4);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),SecondPage.class));
            }
        });

        Button btnVide = (Button)findViewById(R.id.btnVideo);
        btnVide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),VideoActivity.class));
            }
        });
        new CountDownTimer(4000, 1000) {

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