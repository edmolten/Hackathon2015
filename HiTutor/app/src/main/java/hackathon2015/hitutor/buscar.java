package hackathon2015.hitutor;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import hackathon2015.hitutor.clases_result.Clase;
import hackathon2015.hitutor.clases_result.ClaseAdapter;

import static hackathon2015.hitutor.ClaseComparator.ascending;

import static hackathon2015.hitutor.ClaseComparator.decending;
import static hackathon2015.hitutor.ClaseComparator.getComparator;

public class Buscar extends AppCompatActivity {
    private RecyclerView.Adapter mAdapter;
    private EditText commentBox;
    private ArrayList<Clase> clases;
    Spinner buscar_sort;
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

      buscar_sort = (Spinner) findViewById(R.id.buscar_sort);// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> buscar_adapter = ArrayAdapter.createFromResource(this,
                R.array.sort, android.R.layout.simple_spinner_item);// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);// Apply the adapter to the spinner
        buscar_sort.setAdapter(buscar_adapter);

        clases = new ArrayList<>();

        clases.add(new Clase(0,3000, 3 ,"Profe Trucho","Matemática","Ecuaciones Diferenciales 1"));
        clases.add(new Clase(1,4000, 1,"Profe Trucho2","Matemática","Ecuaciones Diferenciales 2"));
        clases.add(new Clase(2,6000, 5,"Profe Trucho3","Fisica","Ecuaciones Diferenciales 3"));
        clases.add(new Clase(3, 2000, 4, "Profe Trucho3", "Fisica", "Ecuaciones Cuaticas 3"));




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
        buscar_sort.setOnItemSelectedListener(new MyOnItemSelectedListener());

    }
    public class MyOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent,
                                   View view, int pos, long id) {
            String text = buscar_sort.getSelectedItem().toString();
            if(text.equals("Precio")){
               Collections.sort(clases, ascending(getComparator(ClaseComparator.PRICE_SORT)));
                mAdapter.notifyDataSetChanged();
            }
            if(text.equals("Rating")){
                Collections.sort(clases, decending(getComparator(ClaseComparator.RATE_SORT)));
                mAdapter.notifyDataSetChanged();
            }
        }

        public void onNothingSelected(AdapterView parent) {
            // Do nothing.
        }
    }
}
