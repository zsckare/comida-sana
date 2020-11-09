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

public class CustomAdapter extends BaseAdapter {
    private Context context;

    public CustomAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Comun.selectedFoodList.size();
    }

    @Override
    public FoodModel getItem(int position) {
        return Comun.selectedFoodList.get(position);
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
            view = inflater.inflate(R.layout.item_grid_view, viewGroup, false);
        }

        ImageView imagenCoche = (ImageView) view.findViewById(R.id.imageView4);
        Picasso.get().load(Comun.selectedFoodList.get(position).getImagen()).into(imagenCoche, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {
                Log.d("DEB", "onError: "+e.getMessage());
            }
        });
        Log.d("DEB", "getView: "+Comun.selectedFoodList.get(position).getImagen());
        /*
        final Coche item = getItem(position);
        imagenCoche.setImageResource(item.getIdDrawable());
        nombreCoche.setText(item.getNombre());
*/
        return view;
    }

}
