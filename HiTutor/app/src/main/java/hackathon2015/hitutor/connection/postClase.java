package hackathon2015.hitutor.connection;

import android.support.v7.app.AppCompatActivity;

import org.json.JSONObject;

import hackathon2015.hitutor.Auxiliar;

public class PostClase extends POSTJSONConnection {
    private int userId;
    public PostClase(AppCompatActivity activity, String urlString, String loadingMessage) {
        super(activity, urlString, loadingMessage);
        userId = Auxiliar.getLocalUserId(activity);

    }

    @Override
    protected void executeFinalTask(JSONObject jsonResponse) {
        activity.finish();
    }
}
