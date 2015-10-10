package hackathon2015.hitutor.connection;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;

import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;


public abstract class JSONConnection extends AsyncTask<String, Void, JSONObject> {

    private ProgressDialog progressDialog;
    protected AppCompatActivity activity;
    private String loadingMessage;
    private boolean showdialog;
    protected String urlString;
    protected DefaultHttpClient client;
    protected JSONObject json;

    public JSONConnection(AppCompatActivity activity, String urlString) {
        this.activity = activity;
        this.urlString = urlString;
        this.showdialog = false;
    }

    public JSONConnection(AppCompatActivity context, String urlString, String loadingMessage) {
        this.activity = context;
        this.urlString = urlString;
        this.loadingMessage = loadingMessage;
        this.showdialog = true;
    }

    @Override
    protected void onPreExecute() {
        if(showdialog) {
            progressDialog = new ProgressDialog(activity);
            progressDialog.setMessage(loadingMessage);
            progressDialog.setCancelable(false);
            progressDialog.show();
        }
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        if(showdialog) {
            progressDialog.dismiss();
        }
        executeFinalTask(jsonObject);
    }

    public void setJSON(JSONObject json) {
        this.json = json;
    }

    /**Tareas finales a ejecutar en UI*/
    protected abstract void executeFinalTask(JSONObject jsonResponse);
}
