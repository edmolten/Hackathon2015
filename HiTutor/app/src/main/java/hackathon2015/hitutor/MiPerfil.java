package hackathon2015.hitutor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import hackathon2015.hitutor.clases_result.Clase;
import hackathon2015.hitutor.clases_result.ClaseAdapter;
import hackathon2015.hitutor.clases_result.MyClaseAdapter;

public class MiPerfil extends AppCompatActivity {

    public TextView Perfil_Nombre_DB;
    public TextView AboutMe_DB;
    public RatingBar RatingBarDB;
    public MyClaseAdapter mAdapter;
    public ArrayList<Clase> clases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_perfil);
       Perfil_Nombre_DB = (TextView)findViewById(R.id.Perfil_TextViewNombreDB);

      AboutMe_DB = (TextView)findViewById(R.id.Perfil_TextViewAboutMeDB);
         RatingBarDB = (RatingBar)findViewById(R.id.Perfil_RatingBarDB);

        User currentUser = getUser();
        Perfil_Nombre_DB.setText(currentUser.name);
        AboutMe_DB.setText(currentUser.about);
        RatingBarDB.setRating(currentUser.valoracion);
        //TODO agregar funcionalidad: poder modificar EDAD y ABOUT ME !!!

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.listaclases);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        clases = new ArrayList<>();
        mAdapter = new MyClaseAdapter(clases);
        mRecyclerView.setAdapter(mAdapter);
        Auxiliar.getClasesById(this);
    }

    private User getUser() {
        int id = Auxiliar.getLocalUserId(this);
        return Auxiliar.getUserById(id);
    }
}
