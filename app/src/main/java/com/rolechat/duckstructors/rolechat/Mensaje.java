package com.rolechat.duckstructors.rolechat;

import android.content.res.Resources;
import android.content.res.TypedArray;

/**
 * Created by Eros on 11/11/2017.
 */

public class Mensaje {

    //Constantes
    public static int EXP_DICE=0;
    public static int EXP_SUSURRA=1;
    public static int EXP_GRITA=2;
    public static int EXP_BROMEA=3;
    public static int EXP_RIE=4;
    public static int EXP_TEME=5;
    public static int EXP_FLITEA=6;

    /*
    private int EXP_BURLA=6;
    private int EXP_SARCASMO=7;
    */

    //Variables
    private String texto;
    private int exp;
    private String nombre;

    /**
     * Constructor de mensajes
     * @param txt Contenido del mensaje
     * @param nom Nombre del pj actual que habla
     */
    public Mensaje(String txt, int exp, String nom){
        this.texto = txt;
        this.nombre = nom;
    }

    public String getTexto() {
        return texto;
    }

    public String getNombre(){
        return nombre;
    }

    public int getExp(){
        return exp;
    }
}
