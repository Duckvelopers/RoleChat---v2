package com.rolechat.duckstructors.rolechat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Toolbar PPBarraOpciones;
    LinearLayout listaPantallaPrincipal;
    LayoutInflater inflador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_principal);
        PPBarraOpciones = (Toolbar) findViewById(R.id.PPBarraOpciones);
        setSupportActionBar(PPBarraOpciones);
        this.listaPantallaPrincipal=(LinearLayout) findViewById(R.id.PPLista);
        inflador = getLayoutInflater();
        View perfil=inflador.inflate(R.layout.layout_perfil,null);
        listaPantallaPrincipal.addView(perfil,0);

        /**
         * Prueba de crear una sala
         * metemos vampiro
         */
        for(int i=0;i<12;i++) {
            View sala = inflador.inflate(R.layout.layout_sala, null);
            View imagen = inflador.inflate(R.layout.layout_perfil_reducido, null);
            GridLayout grid = (GridLayout) sala.findViewById(R.id.SalaImagenesUsuarios);
            grid.addView(imagen);
            //metemos gandalf
            imagen = inflador.inflate(R.layout.layout_perfil_reducido, null);
            ImageView img = (ImageView) imagen.findViewById(R.id.ImagenReducida);
            img.setImageResource(R.drawable.gandalf);
            grid.addView(imagen);
            //metemos el bosque a la sala
            ImageView bos = (ImageView) sala.findViewById(R.id.SalaImagen);
            bos.setImageResource(R.drawable.bosque);
            LinearLayout lista = (LinearLayout) findViewById(R.id.PPListaSalas);
            lista.addView(sala,0);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_pantalla_principal, menu);
        return true;
    }

    public void EntrarSala(View view) {
        Intent intentar = new Intent(this,SalaChat.class);
        startActivity(intentar);
    }
}
