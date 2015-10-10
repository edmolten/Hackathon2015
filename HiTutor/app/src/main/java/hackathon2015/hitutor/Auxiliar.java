package hackathon2015.hitutor;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

import hackathon2015.hitutor.connection.GetTemas;
import hackathon2015.hitutor.constantes.Connection;

public class Auxiliar {
    public static ArrayList<Tema> temas;

    public static void chargeTemas(AppCompatActivity activity){
        temas = new ArrayList<>();
        GetTemas getTemas = new GetTemas(temas,activity, Connection.GET_TEMAS_URL,"Cargando...");
        getTemas.execute();
    }

    public static int getLocalUserId(AppCompatActivity activity){
        SharedPreferences sharedPref = activity.getSharedPreferences("hitutor", Context.MODE_PRIVATE);
        String idString = sharedPref.getString("id", "error");
        if(idString.equals("error")) {
            Log.e("ERROR", "ERROR FATAL, NO HAY USUARIO O EL ID ESTA MAL");
            activity.finish();
        }
        return Integer.valueOf(idString);
    }

    public static int getIdTemaByName(String nombre) {
        for(Tema tema: temas){
            if(tema.name.equals(nombre)){
                return tema.id;
            }
        }
        return 0;
    }
}
