package hackathon2015.hitutor.connection;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import hackathon2015.hitutor.Auxiliar;
import hackathon2015.hitutor.Buscar;
import hackathon2015.hitutor.clases_result.Clase;

public class GetClases extends GETJSONConnection {
    public GetClases(AppCompatActivity context, String urlString, String loadingMessage) {
        super(context, urlString, loadingMessage);
    }

    @Override
    protected List<? extends NameValuePair> setParams(JSONObject json) {
        if (json != null) {
            List<NameValuePair> params = new LinkedList<NameValuePair>();
            try {
                JSONObject filtros = (JSONObject) json.get("filtros");
                String nivel = (String) filtros.get("nivel");
                int tema_id = (int) filtros.get("tema_id");
                params.add(new BasicNameValuePair("nivel",nivel));
                params.add(new BasicNameValuePair("tema_id",String.valueOf(tema_id)));
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
        Toast.makeText(activity,jsonResponse.toString(),Toast.LENGTH_LONG).show();
        ((Buscar)activity).clases.clear();
        ((Buscar)activity).clases.addAll(GetClases.getListFromJSON(jsonResponse));
        ((Buscar)activity).mAdapter.notifyDataSetChanged();
    }

    public static ArrayList<Clase> getListFromJSON(JSONObject jsonResponse) {
        JSONArray array;
        ArrayList<Clase> clases = new ArrayList<>();
        try {
            array = jsonResponse.getJSONArray("data");
            for (int i = 0; i < array.length(); i++) {
                JSONObject claseJSON = array.getJSONObject(i);
                int userId = (int) claseJSON.get("user_id");
                int temaId = (int) claseJSON.get("tema_id");
                boolean isADomicilio = (boolean) claseJSON.get("isADomicilio");
                boolean isDesignadoPorTutor = (boolean) claseJSON.get("isDesignadoPorTutor");
                String descripcion = (String) claseJSON.get("description");
                String disponibilidad = (String) claseJSON.get("disponibilidad");
                int price = (int) claseJSON.get("price");
                String title = (String) claseJSON.get("title");
                String nivel = (String) claseJSON.get("nivel");
                boolean activa = (boolean) claseJSON.get("activa");
                float lat = (( Double) claseJSON.get("lat")).floatValue();
                float lon = ((Double) claseJSON.get("long")).floatValue();
                float rate = Auxiliar.getUserRatebyId(userId);
                String contacto = (String) claseJSON.get("contacto");
                String userName = Auxiliar.getNamebyId(userId);
                Clase clase = new Clase(userId, temaId, isADomicilio, isDesignadoPorTutor, descripcion,
                        disponibilidad, price,userName, title, nivel, activa, lat, lon, contacto,rate);
                clases.add(clase);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return clases;
    }
}