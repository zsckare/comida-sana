package com.example.comidasana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.emredavarci.noty.Noty;

public class SecondPage extends AppCompatActivity {
     GridView gridView;
     CustomAdapter adaptador;
    RelativeLayout rl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);
        rl = (RelativeLayout) findViewById(R.id.myLayout) ;
        gridView = (GridView)findViewById(R.id.gridview);
        adaptador = new CustomAdapter(this);
        gridView.setAdapter(adaptador);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            int tipo = Comun.selectedFoodList.get(position).getTipo();
                if(tipo == 1){
                    showLostGame();
                }else{
                    setItems();
                }
            }
        });
        setItems();
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
    }
}