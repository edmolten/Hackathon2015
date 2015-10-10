package hackathon2015.hitutor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Collections;
import hackathon2015.hitutor.clases_result.Clase;
import hackathon2015.hitutor.clases_result.ClaseAdapter;
import hackathon2015.hitutor.connection.GetClases;
import hackathon2015.hitutor.constantes.Connection;

import static hackathon2015.hitutor.ClaseComparator.ascending;
import static hackathon2015.hitutor.ClaseComparator.decending;
import static hackathon2015.hitutor.ClaseComparator.getComparator;

public class Buscar extends AppCompatActivity {
    public RecyclerView.Adapter mAdapter;

    public ArrayList<Clase> clases;
    Spinner spinner_materia;
    Spinner spinner_nivel;
    Spinner buscar_sort;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_buscar);


        ArrayList<String> array = new ArrayList<>();
        for(Tema tema : Auxiliar.temas){
            array.add(tema.name);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, array);
        spinner_materia = (Spinner) findViewById(R.id.buscar_spinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner_materia.setAdapter(adapter);

        spinner_nivel = (Spinner) findViewById(R.id.buscar_spinner1);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.nivel, android.R.layout.simple_spinner_item);// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner_nivel.setAdapter(adapter1);

        buscar_sort = (Spinner) findViewById(R.id.buscar_sort);
        ArrayAdapter<CharSequence> buscar_adapter = ArrayAdapter.createFromResource(this, R.array.sort, android.R.layout.simple_spinner_item);// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        buscar_sort.setAdapter(buscar_adapter);

        clases = new ArrayList<>();
/*
        clases.add(new Clase(0,3000, 3 ,"Profe Trucho","Matemática","Ecuaciones Diferenciales 1"));
        clases.add(new Clase(1,4000, 1,"Profe Trucho2","Matemática","Ecuaciones Diferenciales 2"));
        clases.add(new Clase(2,6000, 5,"Profe Trucho3","Fisica","Ecuaciones Diferenciales 3"));
        clases.add(new Clase(3, 2000, 4, "Profe Trucho3", "Fisica", "Ecuaciones Cuaticas 3"));

*/


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

    public void onBuscarButtonClick(View v){
        String tema = spinner_materia.getSelectedItem().toString();
        int idTema = Auxiliar.getIdTemaByName(tema);
        String nivel = spinner_nivel.getSelectedItem().toString();
        JSONObject holder = new JSONObject();
        JSONObject filtros = new JSONObject();
        try {
            filtros.put("tema_id", idTema);
            filtros.put("nivel", nivel);
            holder.put("filtros",filtros);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        GetClases getClases = new GetClases(this, Connection.GET_CLASES_URL,"Cargando clases");
        getClases.setJSON(holder);
        getClases.execute();

    }
}
