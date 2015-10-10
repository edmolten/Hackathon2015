package hackathon2015.hitutor.clases_result;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import hackathon2015.hitutor.R;


// Provide a reference to the views for each data item
// Complex data items may need more than one view per item, and
// you provide access to all the views for a data item in a view holder
public class ClaseViewHolder extends RecyclerView.ViewHolder {


    public TextView text;
    public TextView materia;
    public TextView userName;
    public TextView price;
    public RatingBar rate;

    public ClaseViewHolder(View v) {
        super(v);
        text = (TextView) v.findViewById(R.id.buscar_titulo);
        rate = (RatingBar) v.findViewById(R.id.buscar_ratingBar);
        userName = (TextView) v.findViewById(R.id.buscar_nombre);
        materia = (TextView) v.findViewById(R.id.buscar_materia);
        price = (TextView) v.findViewById(R.id.buscar_preciohora);


        };
    }

