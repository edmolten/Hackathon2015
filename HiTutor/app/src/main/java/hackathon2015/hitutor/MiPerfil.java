package hackathon2015.hitutor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;
import android.widget.TextView;

public class MiPerfil extends AppCompatActivity {

    public TextView Perfil_Nombre_DB = (TextView)findViewById(R.id.Perfil_TextViewNombreDB);

    public TextView AboutMe_DB = (TextView)findViewById(R.id.Perfil_TextViewAboutMeDB);
    public RatingBar RatingBarDB = (RatingBar)findViewById(R.id.Perfil_RatingBarDB);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_perfil);
        User currentUser = getUser();
        Perfil_Nombre_DB.setText(currentUser.name);
        AboutMe_DB.setText(currentUser.about);
        RatingBarDB.setRating(currentUser.valoracion);
        //TODO agregar funcionalidad: poder modificar EDAD y ABOUT ME !!!
    }

    private User getUser() {
        int id = Auxiliar.getLocalUserId(this);
        return Auxiliar.getUserById(id);
    }
}
