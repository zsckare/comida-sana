package com.example.comidasana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MemoramaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memorama);
        
        fillList();
    }

    private void fillList() {
        CardModel comida9 = new CardModel("NARANJA", "https://i0.wp.com/historiasdelahistoria.com/wordpress-2.3.1-ES-0.1-FULL/wp-content/uploads/2015/11/naranja.jpg?fit=607%2C335&ssl=1",2,0);
    }
}