package com.example.moksleivis.kvapomanai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin = (Button) findViewById(R.id.ButtonLog);
        final EditText etUsername= (EditText) findViewById(R.id.LoginUserName);
        final EditText etPassword= (EditText) findViewById(R.id.LoginPassword);

        etUsername.setError(null);
        etPassword.setError(null);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cia vykdomas kodas, kai paspaudziamas mygtukas
                boolean cancel = false;
                if (!Validation.isValidCredentials(etUsername.getText().toString())) {
                    cancel = true;
                    etUsername.requestFocus();
                    etUsername.setError(getResources().getString(R.string.login_invalid_username));
                    //Toast.makeText(LoginActivity.this, getResources().getString(R.string.login_invalid_username),
                    //Toast.LENGTH_SHORT).show();
                } else if (!Validation.isValidCredentials(etPassword.getText().toString())) {
                    cancel = true;
                    etPassword.requestFocus();
                    etPassword.setError(getResources().getString(R.string.login_invalid_password));
                    // Toast.makeText(LoginActivity.this, getResources().getString(R.string.login_invalid_password),
                    // Toast.LENGTH_SHORT).show();
                }
                if (!cancel){
                    Toast.makeText(LoginActivity.this,
                            "Prisijungimo vardas: " + etUsername.getText().toString() + "\n" +
                                    "Slaptažodis: " + etPassword.getText().toString(), Toast.LENGTH_SHORT).show();
                    Intent goToSearchActivity = new Intent(LoginActivity.this, SearchActivity.class);
                    startActivity(goToSearchActivity);
                }


            }
        });




        Button btnRegister = (Button) findViewById(R.id.ButtonReg);

        btnRegister.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent GoToSearchActivity = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(GoToSearchActivity);}
        });


    }



}
