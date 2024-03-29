package hackathon2015.hitutor.clases_result;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import hackathon2015.hitutor.Auxiliar;
import hackathon2015.hitutor.R;

public class ClaseAdapter extends RecyclerView.Adapter<ClaseViewHolder>{

    private ArrayList<Clase> clases;

    // Provide a suitable constructor (depends on the kind of dataset)
    public ClaseAdapter(ArrayList<Clase> clases) {
        this.clases = clases;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ClaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.clases_card, parent, false);
        //set the view's size, margins, paddings and layout parameters.........
        return new ClaseViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ClaseViewHolder holder, int position) {

        holder.text.setText(clases.get(position).title);
        holder.rate.setRating(clases.get(position).rate);
        holder.price.setText("$ "+String.valueOf(clases.get(position).price));
        holder.materia.setText(Auxiliar.getNameByIdTema(clases.get(position).temaId));
        holder.userName.setText(Auxiliar.getNamebyId(clases.get(position).userId));//clases.get(position).user);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return clases.size();
    }
}
