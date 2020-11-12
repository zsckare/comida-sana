package com.example.comidasana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class WinnerActivity extends AppCompatActivity {

    ImageView img;
    TextView textView;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        img = (ImageView)findViewById(R.id.imageView5);
        textView = (TextView)findViewById(R.id.textView5);
        btn = (Button)findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SecondPage.class));
            }
        });

        YoYo.with(Techniques.BounceIn)
                .duration(1000)
                .repeat(0)
                .playOn(findViewById(R.id.imageView5));
        YoYo.with(Techniques.BounceIn)
                .duration(1000)
                .repeat(0)
                .playOn(findViewById(R.id.textView5));
        YoYo.with(Techniques.BounceIn)
                .duration(1000)
                .repeat(0)
                .playOn(findViewById(R.id.button3));

    }
}