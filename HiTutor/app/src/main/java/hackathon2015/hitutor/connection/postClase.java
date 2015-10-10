package hackathon2015.hitutor.connection;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONObject;


public class PostClase extends POSTJSONConnection {

    public PostClase(AppCompatActivity activity, String urlString, String loadingMessage) {
        super(activity, urlString, loadingMessage);
    }

    @Override
    protected void executeFinalTask(JSONObject jsonResponse) {
        Toast.makeText(activity,jsonResponse.toString(),Toast.LENGTH_LONG).show();
        activity.finish();
    }
}
