package hackathon2015.hitutor.connection;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONObject;

import hackathon2015.hitutor.Result;

public class Signup extends POSTJSONConnection {
    public Signup(AppCompatActivity activity, String urlString, String loadingMessage) {
        super(activity, urlString, loadingMessage);
    }

    @Override
    protected void executeFinalTask(JSONObject jsonResponse) {
        Toast.makeText(activity, jsonResponse.toString(), Toast.LENGTH_LONG).show();
        activity.setResult(Result.ok);
        activity.finish();
        return;
    }
}
