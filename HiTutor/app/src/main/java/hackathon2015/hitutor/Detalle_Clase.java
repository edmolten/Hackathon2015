package hackathon2015.hitutor;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class Detalle_Clase extends AppCompatActivity {

    public static String s_titulo;
    public static float s_rating;
    public static String s_precio;
    public static String s_user;
    public static String s_materia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clase__detail);
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


        TextView text = (TextView) findViewById(R.id.detail_title);
        TextView level = (TextView) findViewById(R.id.detail_level);
        RatingBar rate = (RatingBar) findViewById(R.id.detail_rating);
        TextView  userName = (TextView) findViewById(R.id.detail_nombre);
        TextView mater = (TextView) findViewById(R.id.detail_materia);
        TextView price = (TextView) findViewById(R.id.detail_price);
        text.setText(s_titulo);

        rate.setRating(s_rating);
        price.setText(s_precio);
        mater.setText(s_materia);
        userName.setText(s_user);
    }

}
