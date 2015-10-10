package hackathon2015.hitutor.connection;


import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import hackathon2015.hitutor.Tema;

public class GetTemas extends  GETJSONConnection {
    ArrayList<Tema> temas;
    public GetTemas(ArrayList<Tema> temas, AppCompatActivity activity, String urlString,String message) {
        super(activity, urlString, message);
        this.temas = temas;
    }

    @Override
    protected void executeFinalTask(JSONObject jsonResponse) {
        JSONArray arr = null;
        try {
            arr = jsonResponse.getJSONArray("temas");
            for (int i = 0; i < arr.length(); i++) {
                JSONObject temaObject = arr.getJSONObject(i);
                int id = temaObject.getInt("id");
                String name = temaObject.getString("name");
                Tema tema = new Tema(id,name);
                temas.add(tema);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Toast.makeText(activity,temas.toString(),Toast.LENGTH_LONG).show();

    }

    @Override
    protected List<? extends NameValuePair> setParams(JSONObject json) {
        return null;
    }
}
