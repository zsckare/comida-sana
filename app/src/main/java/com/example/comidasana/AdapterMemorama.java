package com.example.comidasana;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class AdapterMemorama extends BaseAdapter {
    private Context context;

    public AdapterMemorama(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Comun.cardList.size();
    }

    @Override
    public CardModel getItem(int position) {
        return Comun.cardList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_card_item, viewGroup, false);
        }

        ImageView imagenCoche = (ImageView) view.findViewById(R.id.cardImage);
        CardModel card = Comun.cardList.get(position);
        if( card.getFlipped() == 2) {
            Picasso.get().load(R.drawable.naipe).into(imagenCoche, new Callback() {
                @Override
                public void onSuccess() {

                }

                @Override
                public void onError(Exception e) {
                    Log.d("DEB", "onError: " + e.getMessage());
                }
            });
        }else{
            Picasso.get().load(card.getImagen()).into(imagenCoche, new Callback() {
                @Override
                public void onSuccess() {

                }

                @Override
                public void onError(Exception e) {
                    Log.d("DEB", "onError: " + e.getMessage());
                }
            });
        }
        /*
        final Coche item = getItem(position);
        imagenCoche.setImageResource(item.getIdDrawable());
        nombreCoche.setText(item.getNombre());
*/
        return view;
    }

}
