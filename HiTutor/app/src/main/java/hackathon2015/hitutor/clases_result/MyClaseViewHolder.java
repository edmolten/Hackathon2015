package hackathon2015.hitutor.clases_result;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import hackathon2015.hitutor.Detalle_Clase;
import hackathon2015.hitutor.R;


// Provide a reference to the views for each data item
// Complex data items may need more than one view per item, and
// you provide access to all the views for a data item in a view holder
public class MyClaseViewHolder extends RecyclerView.ViewHolder {


    public TextView text;
    public TextView materia;
    public TextView price;

    public MyClaseViewHolder(final View v) {
        super(v);
        text = (TextView) v.findViewById(R.id.buscar_titulo);
        materia = (TextView) v.findViewById(R.id.buscar_materia);
        price = (TextView) v.findViewById(R.id.buscar_preciohora);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Detalle_Clase.class);
                Detalle_Clase.s_titulo = text.getText().toString();
                Detalle_Clase.s_precio = price.getText().toString();
                Detalle_Clase.s_materia = materia.getText().toString();
                v.getContext().startActivity(intent);
            }
        });

        }
    }

