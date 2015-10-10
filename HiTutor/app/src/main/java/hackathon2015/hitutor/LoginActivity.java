package hackathon2015.hitutor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import hackathon2015.hitutor.connection.Cons;
import hackathon2015.hitutor.connection.Login;

public class LoginActivity extends AppCompatActivity {

    private String mUserEmail;
    private String mUserPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onLoginButtonClick(View button){
        EditText emailField = (EditText)findViewById(R.id.email);
        mUserEmail = emailField.getText().toString();
        EditText passField = (EditText)findViewById(R.id.pass);
        mUserPassword = passField.getText().toString();
        JSONObject loginJSON = createLoginJSON();
        Login login = new Login(this, Cons.LOGIN_URL ,"Ingresando...");
        login.setJSON(loginJSON);
        login.execute();
    }

    private JSONObject createLoginJSON() {
        JSONObject holder = new JSONObject();
        JSONObject userObj = new JSONObject();
        try {
            userObj.put("email", mUserEmail);
            userObj.put("password", mUserPassword);
            holder.put("login", userObj);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return holder;
    }
}

