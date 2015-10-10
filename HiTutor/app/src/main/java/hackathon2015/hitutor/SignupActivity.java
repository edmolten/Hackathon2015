package hackathon2015.hitutor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import hackathon2015.hitutor.connection.Cons;
import hackathon2015.hitutor.connection.Signup;


public class SignupActivity extends AppCompatActivity {

    private String mUserEmail;
    private String mUserName;
    private String mUserPassword;
    private String mUserPasswordConfirmation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }

    public void onRegistrarButtonClick(View button){
        EditText emailField = (EditText)findViewById(R.id.email);
        mUserEmail = emailField.getText().toString();
        EditText nameField = (EditText)findViewById(R.id.user);
        mUserName = nameField.getText().toString();
        EditText passField = (EditText)findViewById(R.id.pass);
        mUserPassword = passField.getText().toString();
        EditText passConfField = (EditText)findViewById(R.id.pass_confirm);
        mUserPasswordConfirmation = passConfField.getText().toString();
        Signup signup = new Signup(this, Cons.SIGNUP_URL,"Registrando...");
        JSONObject signupJson = createSigninJSON();
        signup.setJSON(signupJson);
        signup.execute();
    }

    private JSONObject createSigninJSON() {
        JSONObject holder = new JSONObject();
        JSONObject taskObj = new JSONObject();
        try {
            taskObj.put("email", mUserEmail);
            taskObj.put("name", mUserName);
            taskObj.put("password", mUserPassword);
            taskObj.put("password_confirmation", mUserPasswordConfirmation);
            holder.put("user", taskObj);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return holder;
    }

}
