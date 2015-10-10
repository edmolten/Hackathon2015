package hackathon2015.hitutor.connection;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public abstract class POSTJSONConnection extends JSONConnection {

    public POSTJSONConnection(AppCompatActivity activity, String urlString) {
        super(activity, urlString);
    }

    public POSTJSONConnection(AppCompatActivity activity, String urlString, String loadingMessage) {
        super(activity, urlString, loadingMessage);
    }

    protected JSONObject doInBackground(String... params) {
        client = new DefaultHttpClient();
        HttpPost post = new HttpPost(urlString);
        JSONObject jsonResponse = new JSONObject();
        try {
            if (json != null) {
                StringEntity se = new StringEntity(this.json.toString());
                post.setEntity(se);
            }
            post.setHeader("Accept", "application/json");
            post.setHeader("Content-Type", "application/json");
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String response = client.execute(post, responseHandler);
            jsonResponse = new JSONObject(response);
        } catch (HttpResponseException e) {
            e.printStackTrace();
            Log.e("Error de conexion", e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Error IO", e.getMessage());
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("Error JSON", e.getMessage());
        }
        return jsonResponse;
    }

}
