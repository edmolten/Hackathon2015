package hackathon2015.hitutor;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

import hackathon2015.hitutor.connection.GetTemas;
import hackathon2015.hitutor.connection.GetUsers;
import hackathon2015.hitutor.constantes.Connection;

public class Auxiliar {
    public static ArrayList<Tema> temas;
    private static ArrayList<User> users;

    public static void chargeTemas(AppCompatActivity activity){
        temas = new ArrayList<>();
        GetTemas getTemas = new GetTemas(temas,activity, Connection.GET_TEMAS_URL,"Cargando...");
        getTemas.execute();
    }

    public static void chargeUsers(AppCompatActivity activity){
        users = new ArrayList<>();
        GetUsers getTemas = new GetUsers(users,activity, Connection.GET_USERS_URL,"Cargando...");
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

    public static String getNameByIdTema(int id) {
        for(Tema tema: temas){
            if(tema.id == id){
                return tema.name;
            }
        }
        return "";
    }

    public static float getUserRatebyId(int userId) {
        for(User user: users){
            if(user.id == userId){
                return user.valoracion;
            }
        }
        return 0;
    }

    public static String getNamebyId(int userId) {
        for(User user: users){
            if(user.id == userId){
                return user.name;
            }
        }
        return "";
    }
}
