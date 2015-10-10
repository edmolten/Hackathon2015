package hackathon2015.hitutor.clases_result;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import hackathon2015.hitutor.Auxiliar;
import hackathon2015.hitutor.R;

public class MyClaseAdapter extends RecyclerView.Adapter<MyClaseViewHolder>{

    private ArrayList<Clase> clases;

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyClaseAdapter(ArrayList<Clase> clases) {
        this.clases = clases;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyClaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_clases_card, parent, false);
        //set the view's size, margins, paddings and layout parameters.........
        return new MyClaseViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyClaseViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.text.setText(clases.get(position).title);
        holder.materia.setText(Auxiliar.getNameByIdTema(clases.get(position).temaId));
        holder.price.setText("$ "+ String.valueOf(clases.get(position).price));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return clases.size();
    }
}
