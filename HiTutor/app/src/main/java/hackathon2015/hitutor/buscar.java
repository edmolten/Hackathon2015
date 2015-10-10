package hackathon2015.hitutor;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

import hackathon2015.hitutor.clases_result.Clase;
import hackathon2015.hitutor.clases_result.ClaseAdapter;

public class Buscar extends AppCompatActivity {
    private RecyclerView.Adapter mAdapter;
    private EditText commentBox;
    private ArrayList<Clase> clases;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // SPINER
    Spinner buscar_spinner = (Spinner) findViewById(R.id.buscar_spinner); // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
            R.array.temas,android.R.layout.simple_spinner_item); // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);// Apply the adapter to the spinner
        buscar_spinner.setAdapter(adapter);

    Spinner buscar_spinner1 = (Spinner) findViewById(R.id.buscar_spinner1);// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.nivel, android.R.layout.simple_spinner_item);// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);// Apply the adapter to the spinner
        buscar_spinner1.setAdapter(adapter1);

        clases = new ArrayList<>();
        clases.add(new Clase(0,6000, 4,"Profe Trucho","Matemática","Ecuaciones Diferenciales"));
        clases.add(new Clase(1,6000, 3,"Profe Trucho2","Matemática","Ecuaciones Diferenciales2"));
        clases.add(new Clase(3,6000, 5,"Profe Trucho3","Matemática","Ecuaciones Diferenciales3"));


        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.listaclases);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)

        mAdapter = new ClaseAdapter(clases);
        mRecyclerView.setAdapter(mAdapter);
    }

}
