package hackathon2015.hitutor.connection;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import hackathon2015.hitutor.Result;


public class Login extends POSTJSONConnection {
    public Login(AppCompatActivity activity, String urlString, String loadingMessage) {
        super(activity, urlString, loadingMessage);
    }

    @Override
    protected void executeFinalTask(JSONObject jsonResponse) {
        Toast.makeText(activity, jsonResponse.toString(), Toast.LENGTH_LONG).show();
        try {
            if (jsonResponse.getBoolean("success")) {
                SharedPreferences sharedPref = activity.getSharedPreferences("denuncity", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("token", jsonResponse.getJSONObject("session").getString("remember_token"));
                editor.putString("id", jsonResponse.getJSONObject("session").getString("user_id"));
                editor.apply();
                activity.setResult(Result.ok);
            }
        } catch (JSONException e1) {
            e1.printStackTrace();
            activity.setResult(Result.fail);
            Toast.makeText(activity, "No existe el usuario", Toast.LENGTH_LONG).show();
        }
        activity.finish();
    }
}
