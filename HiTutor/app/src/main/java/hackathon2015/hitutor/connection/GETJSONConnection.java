package hackathon2015.hitutor.connection;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;


public abstract class GETJSONConnection extends JSONConnection {

    public GETJSONConnection(AppCompatActivity activity, String urlString) {
        super(activity, urlString);
    }

    public GETJSONConnection(AppCompatActivity context, String urlString, String loadingMessage) {
        super(context, urlString, loadingMessage);
    }


    @Override
    protected JSONObject doInBackground(String... params) {
        client = new DefaultHttpClient();
        List<? extends NameValuePair> listParams = setParams(json);
        if(listParams != null){
            String paramString = URLEncodedUtils.format(listParams, "utf-8");
            urlString += "?";
            urlString += paramString;
        }
        HttpGet get = new HttpGet(urlString);
        JSONObject jsonResponse = new JSONObject();
        try {
            get.setHeader("Accept", "application/json");
            get.setHeader("Content-Type", "application/json");
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String response = client.execute(get, responseHandler);
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

    protected abstract List<? extends NameValuePair> setParams(JSONObject json);
}
