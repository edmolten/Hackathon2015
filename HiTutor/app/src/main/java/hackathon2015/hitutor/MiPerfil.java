package hackathon2015.hitutor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class MiPerfil extends AppCompatActivity {

    public TextView Perfil_Nombre_DB = (TextView)findViewById(R.id.Perfil_TextViewNombreDB);
    public TextView Edad_DB = (TextView)findViewById(R.id.Perfil_TextViewEdadDB);
    public TextView Mail_DB = (TextView)findViewById(R.id.Perfil_TextViewMailDB);
    public TextView AboutMe_DB = (TextView)findViewById(R.id.Perfil_TextViewAboutMeDB);
    public RatingBar RatingBarDB = (RatingBar)findViewById(R.id.Perfil_RatingBarDB);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_perfil);
        Perfil_Nombre_DB.setText("/* WEA DE BD*/"); //insertar Nombre de la BD
        Edad_DB.setText("/* WEA DE BD*/"); //insertar la Edad de la BD
        Mail_DB.setText("/* WEA DE BD*/"); //Insertar Mail de la BD
        AboutMe_DB.setText("/* WEA DE BD*/"); //Insertar "About Me" de la BD
        RatingBarDB.setRating(1); //Cambiar el 1 !!!! Insertar "Rating" de la BD
        //TODO agregar funcionalidad: poder modificar EDAD y ABOUT ME !!!
    }
}
