package hackathon2015.hitutor;

import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import hackathon2015.hitutor.connection.PostClase;
import hackathon2015.hitutor.constantes.Connection;

public class Ofrecer extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {


    private GoogleApiClient googleApiClient;
    private LocationRequest locationRequest;
    private boolean requestingLocationUpdates;
    protected Location lastLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ofrecer2);
        requestingLocationUpdates = false;
        buildGoogleApiClient();

        //Ofre_spinner3 <-> Dropdown de Materias
        Spinner Ofre_spinner3 = (Spinner) findViewById(R.id.Ofre_spinner3);
        ArrayList<String> array = new ArrayList<>();
        for(Tema tema : Auxiliar.temas){
            array.add(tema.name);
        }
        ArrayAdapter<String> Ofre_adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, array);
        Ofre_adapter3.setDropDownViewResource(android.R.layout.simple_spinner_item);
        Ofre_spinner3.setAdapter(Ofre_adapter3);

        //Ofre_spinner4 <-> Dropdown de Nivel
        Spinner Ofre_spinner4 = (Spinner) findViewById(R.id.Ofre_spinner4);
        ArrayAdapter<CharSequence> Ofre_adapter4 = ArrayAdapter.createFromResource(this,
                R.array.nivel, android.R.layout.simple_spinner_item);
        Ofre_adapter4.setDropDownViewResource(android.R.layout.simple_spinner_item);
        Ofre_spinner4.setAdapter(Ofre_adapter4);

       /* //checkboxes
        CheckBox satView = (CheckBox) findViewById(R.id.Ofre_checkBox2);
        satView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {

                }
                                           }
        );
    */
        addListenerOnButton(); //inicia el listener del boton "Publicar"
    }

    protected synchronized void buildGoogleApiClient() {
        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        googleApiClient.connect();
    }
    //declaracion de variables
    public Button PublicarButton;
    public EditText Titulo; //OfreeditText
    public Spinner Drop1; //OfreSpinner3
    public Spinner Drop2; //OfreSpinner4
    public EditText Precio; //OfreEditText2
    public CheckBox ADomicilio; //OfreCheckBox
    public CheckBox Definido; //OfreCheckBox2
    public EditText Descripcion; //OfreEditText3
    public EditText Disponibilidad; //OfreEditText4
    public EditText Contacto; //OfreEditText5

    //holders - valores para pasar a la BD
    public String Val_Titulo;
    public String Val_Drop1;
    public String Val_Drop2;
    public int Val_Precio;
    public boolean Val_ADomicilio;
    public boolean Val_Definido;
    public String Val_Descripcion;
    public String Val_Disponibilidad;
    public String Val_Contacto;

    //Listener para el checkbox
    public void addListenerOnCheckBox(){
        Definido = (CheckBox)findViewById(R.id.Ofre_checkBox2);

        Definido.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //AQUI AGREGAR LA FUNCIONALIDAD DEL MAPA Y VOLAS
                //HAY QUE MANEJAR LA LAYOUT RELATIVA "INVISIBLE" PARA QUE SE EXPANDA Y MUESTRE LA UBICACION EN UN MAPA
            }
        });
    }

    //Listener para el boton "Publicar"
   public void addListenerOnButton(){
       //"atrapar" variables
       PublicarButton = (Button)findViewById(R.id.Ofre_button_Publicar);
       Titulo = (EditText)findViewById(R.id.Ofre_editText);
       Drop1 = (Spinner)findViewById(R.id.Ofre_spinner3); //MATERIA
       Drop2 = (Spinner)findViewById(R.id.Ofre_spinner4); //NIVEL
       Precio = (EditText)findViewById(R.id.Ofre_editText2);
       ADomicilio = (CheckBox)findViewById(R.id.Ofre_checkBox);
       Definido = (CheckBox)findViewById(R.id.Ofre_checkBox2);
       Descripcion = (EditText)findViewById(R.id.Ofre_editText3);
       Disponibilidad = (EditText)findViewById(R.id.Ofre_editText4);
       Contacto = (EditText)findViewById(R.id.Ofre_editText5);

        //Integer.valueOf(Ofre_editText2.getText().toString());
       PublicarButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                //se obtienen los valores respectivos
               Val_Titulo = Titulo.getText().toString();
               Val_Drop1 = Drop1.getSelectedItem().toString();
               Val_Drop2 = Drop2.getSelectedItem().toString();
               Val_Precio = Integer.valueOf(Precio.getText().toString());//TODO benjamin no tiene criterio
               Val_ADomicilio = ADomicilio.isChecked();
               Val_Definido = Definido.isChecked();
               Val_Descripcion = Descripcion.getText().toString();
               Val_Disponibilidad = Disponibilidad.getText().toString();
               Val_Contacto = Contacto.getText().toString();
               PostClase postClase = new PostClase(Ofrecer.this, Connection.POST_CLASE_URL, "Guardando clase...");
               JSONObject claseJSON = createClaseJSON();
               postClase.setJSON(claseJSON);
               postClase.execute();
           }

           private JSONObject createClaseJSON() {
               JSONObject holder = new JSONObject();
               JSONObject clase = new JSONObject();
               try {
                   //:title, :isADomicilio, :isDesignadoPorTutor, :price, :user_id,:tema_id,:description,:disponibilidad,:nivel,:activa, :lat, :long,:contacto )
                   clase.put("title", Val_Titulo);
                   clase.put("isADomicilio", Val_ADomicilio);
                   clase.put("isDesignadoPorTutor", Val_Definido);
                   clase.put("price", Val_Precio);
                   clase.put("user_id", Auxiliar.getLocalUserId(Ofrecer.this));
                   clase.put("tema_id", Auxiliar.getIdTemaByName(Val_Drop1));
                   clase.put("description", Val_Descripcion);
                   clase.put("disponibilidad", Val_Disponibilidad);
                   clase.put("nivel", Val_Drop2);
                   if(Definido.isChecked()){
                       clase.put("lat", lastLocation.getLatitude()); //TODO
                       clase.put("long", lastLocation.getLongitude()); //TODO
                   }
                   else{
                       clase.put("lat", 0f); //TODO
                       clase.put("long", 0f); //TODO
                   }

                   clase.put("activa", true);
                   clase.put("contacto", Val_Contacto);
                   holder.put("clase", clase);

               } catch (JSONException e) {
                   e.printStackTrace();
                   return null;
               }
               return holder;
           }
       });
   }



    @Override
    public void onConnected(Bundle bundle) {
        locationRequest = new LocationRequest();
        locationRequest.setInterval(1000);
        locationRequest.setFastestInterval(500);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);
        requestingLocationUpdates = true;
    }

    @Override
    protected void onPause(){
        super.onPause();
        LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, this);
        requestingLocationUpdates = false;
        stopLocationUpdates();
    }

    @Override
    protected void onResume(){
        super.onResume();
        if (googleApiClient.isConnected() && !requestingLocationUpdates) {
            requestingLocationUpdates = true;
            startLocationUpdates();
        }
    }

    protected void startLocationUpdates() {
        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this);
    }

    protected void stopLocationUpdates(){
        LocationServices.FusedLocationApi.removeLocationUpdates(googleApiClient, this);
    }

    @Override
    public void onLocationChanged(Location location) {
        lastLocation = location;
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
}
