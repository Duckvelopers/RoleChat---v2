package com.rolechat.duckstructors.rolechat;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Eros on 14/11/2017.
 */

public class AdaptadorMensajes extends ArrayAdapter<Mensaje>{
    public AdaptadorMensajes(Context context, int resource, List<Mensaje> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.layout_mensaje, parent, false);
        }
        TextView mensajeTV = (TextView) convertView.findViewById(R.id.MensajeTexto);

        Mensaje mensaje = getItem(position);
        mensajeTV.setText(mensaje.getTexto());
        mensajeTV.setVisibility(View.VISIBLE);

        return convertView;
    }
}
