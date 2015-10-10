package hackathon2015.hitutor.clases_result;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import hackathon2015.hitutor.R;


// Provide a reference to the views for each data item
// Complex data items may need more than one view per item, and
// you provide access to all the views for a data item in a view holder
public class ClaseViewHolder extends RecyclerView.ViewHolder {


    public TextView text;

    public ClaseViewHolder(View v) {
        super(v);
        text = (TextView) v.findViewById(R.id.buscar_titulo);

        };
    }

