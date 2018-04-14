package com.rolechat.duckstructors.rolechat;

import android.util.Log;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by Yossyneitor on 14/04/2018.
 */

public class HiloReceptor implements Runnable{

    //Conexion
    private Socket soc;
    private int NUM_PUERTO = 44444;

    @Override
    public void run() {

        /**
         * Arrancamos la conexion con el servidor
         */
        try{
            this.soc = new Socket("188.127.163.171",NUM_PUERTO);
        }catch(IOException io){
            io.printStackTrace();
            Log.e("CONEXION","Error al conectar con el servidor");
            System.out.println("ERROR_CONEXION: Error al conectar con el servidor");
        }
        System.out.println("Conectado");
    }
}
