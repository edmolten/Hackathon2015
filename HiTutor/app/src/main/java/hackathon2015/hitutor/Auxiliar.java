package hackathon2015.hitutor;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class Auxiliar {
    public static int getLocalUserId(AppCompatActivity activity){
        SharedPreferences sharedPref = activity.getSharedPreferences("hitutor", Context.MODE_PRIVATE);
        String idString = sharedPref.getString("userId", "error");
        if(idString.equalsIgnoreCase("error")){
            Log.e("ERROR", "ERROR FATAL, NO HAY USUARIO O EL ID ESTA MAL");
            activity.finish();
        }
        return Integer.valueOf(idString);
    }
}
