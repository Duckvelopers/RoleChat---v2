package com.rolechat.duckstructors.rolechat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SalaChat extends AppCompatActivity {

    //Views
    private ListView listaMensajes;
    private ImageButton botonEnviar;
    private EditText editorMensaje;

    //Objetos para manejar los mensajes del chat.
    private List<Mensaje> arrayMensajes;
    private AdaptadorMensajes adaptaMens;

    //Usuario
    private String personaje;

    //Tamaño maximo de los mensajes
    private int TAM_MAX_MEN = 2000;

    //Conexion
    private Socket soc;
    private int PUERTO

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sala_chat);

        /**
         * Cuando se habilite el cambio de pj tengo que cambiar esto
         */
        personaje="Eros";

        /**
         * Damos valor a la lista de mensajes, el editor de mensajes y al boton envia
         */

        listaMensajes = (ListView) findViewById(R.id.ChatListaMensajes);
        botonEnviar = (ImageButton) findViewById(R.id.ChatBotonEnviar);
        editorMensaje = (EditText) findViewById(R.id.ChatEditorMensaje);

        /**
         * Hacemos que el boton enviar no este activo si no hay nada escrito
         * y limitamos el numero de caracteres del mensaje
         */

        editorMensaje.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() > 0) botonEnviar.setEnabled(true);
                else botonEnviar.setEnabled(false);}
            @Override
            public void afterTextChanged(Editable s) {}});
        editorMensaje.setFilters( new InputFilter[]{new InputFilter.LengthFilter(TAM_MAX_MEN)});

        /**
         * Iniciamos el Adaptador de mensajes, un Arraylist para contener los mensajes
         * y añadimos el adapter a la list View
         */

        arrayMensajes = new ArrayList<>();
        adaptaMens = new AdaptadorMensajes(this, R.layout.layout_mensaje, arrayMensajes);
        listaMensajes.setAdapter(adaptaMens);
    }

    public void ElegirPersonaje(View view) {
    }

    public void EnviarMensaje(View view) {

        /**
         * ESTOY AQUI TENGO QUE PASAR TEXTO, NOMBRE DE PJ , STRING IDIOMA CON " DICE:|N" O " SAY:\N"
         */
        Mensaje mensaje= new Mensaje(editorMensaje.getText().toString(),Mensaje.EXP_DICE,personaje);
        adaptaMens.add(mensaje);
        editorMensaje.setText("");
    }
}
