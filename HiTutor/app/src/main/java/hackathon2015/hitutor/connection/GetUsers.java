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
import hackathon2015.hitutor.User;
import hackathon2015.hitutor.connection.GETJSONConnection;
import hackathon2015.hitutor.connection.GetTemas;

public class GetUsers extends GETJSONConnection {

    ArrayList<User> users;

    public GetUsers(ArrayList<User> users, AppCompatActivity context, String urlString, String loadingMessage) {
        super(context, urlString, loadingMessage);
        this.users = users;
    }

    public GetUsers(AppCompatActivity activity, String urlString) {
        super(activity, urlString);
    }

    @Override
    protected List<? extends NameValuePair> setParams(JSONObject json) {
        return null;
    }

    @Override
    protected void executeFinalTask(JSONObject jsonResponse) {
        JSONArray arr = null;
        try {
            arr = jsonResponse.getJSONArray("users");
            for (int i = 0; i < arr.length(); i++) {
                JSONObject temaObject = arr.getJSONObject(i);
                int id = temaObject.getInt("id");
                String name = temaObject.getString("name");
                float valoracion =(float) temaObject.getDouble("valoracion");
                User user = new User(id,name,valoracion);
                users.add(user);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Toast.makeText(activity, users.toString(), Toast.LENGTH_LONG).show();
    }
}
