package hackathon2015.hitutor.connection;

import android.support.v7.app.AppCompatActivity;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import hackathon2015.hitutor.MiPerfil;
import hackathon2015.hitutor.constantes.Connection;

public class GetClasesById extends GETJSONConnection {

    public GetClasesById(AppCompatActivity activity) {
        super(activity, Connection.GET_CLASES_URL, "Cargando");
    }

    @Override
    protected List<? extends NameValuePair> setParams(JSONObject json) {
        if (json != null) {
            List<NameValuePair> params = new LinkedList<NameValuePair>();
            try {
                params.add(new BasicNameValuePair("user_id",json.getString("user_id")));
                return params;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override
    protected void executeFinalTask(JSONObject jsonResponse) {
        ((MiPerfil) activity).clases.clear();
        ((MiPerfil) activity).clases.addAll(GetClases.getListFromJSON(jsonResponse));
        ((MiPerfil) activity).mAdapter.notifyDataSetChanged();
    }
}
