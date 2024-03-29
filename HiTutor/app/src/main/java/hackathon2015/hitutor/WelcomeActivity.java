package hackathon2015.hitutor;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import hackathon2015.hitutor.constantes.Request;
import hackathon2015.hitutor.constantes.Result;

import static hackathon2015.hitutor.constantes.Request.login;
import static hackathon2015.hitutor.constantes.Request.signup;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
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
    }

    public void onNuevoUsuarioClick(View v){
        startActivityForResult(new Intent(this, SignupActivity.class), Request.signup);
    }

    public void onIngresarClick(View v){
        startActivityForResult(new Intent(this,LoginActivity.class),Request.login);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        View v = findViewById(R.id.nuevo_usuario);
        switch (requestCode){
            case login:
                switch (resultCode) {
                    case Result.ok:
                        Snackbar.make(v,"Login correcto",Snackbar.LENGTH_LONG).show();
                        finish();
                        break;
                    case Result.fail:
                        Snackbar.make(v,"Error al ingresar. Intentelo nuevamente",Snackbar.LENGTH_LONG).show();
                        break;
                }
            case signup:
                switch (resultCode){
                    case Result.ok:
                        Snackbar.make(v,"Usuario creado",Snackbar.LENGTH_LONG).show();
                        break;
                    case Result.fail:
                        Snackbar.make(v,"No se pudo crear usuario",Snackbar.LENGTH_LONG).show();
                        break;
                }
        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();

    }

}
