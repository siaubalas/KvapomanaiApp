package com.example.moksleivis.kvapomanai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button btnRegister2 = (Button) findViewById(R.id.ButtonRegAcc);
        final EditText etUsername= (EditText) findViewById(R.id.RegUsername);
        final EditText etPassword= (EditText) findViewById(R.id.RegPassword);
        final EditText etEmail= (EditText) findViewById(R.id.RegEmail) ;

        etUsername.setError(null);
        etPassword.setError(null);



        btnRegister2.setOnClickListener(new View.OnClickListener() {
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
                    etPassword.setError(getResources().getString(R.string.login_invalid_email));
                    // Toast.makeText(LoginActivity.this, getResources().getString(R.string.login_invalid_password),
                    // Toast.LENGTH_SHORT).show();
                } else if (!Validation.isValidEmail(etEmail.getText().toString())) {
                cancel = true;
                etEmail.requestFocus();
                etEmail.setError(getResources().getString(R.string.login_invalid_password));
                // Toast.makeText(LoginActivity.this, getResources().getString(R.string.login_invalid_password),
                // Toast.LENGTH_SHORT).show();
            }
                if (!cancel){
                    Toast.makeText(RegisterActivity.this,
                            "Prisijungimo vardas: " + etUsername.getText().toString() + "\n" +
                                    "Slaptažodis: " + etPassword.getText().toString(), Toast.LENGTH_SHORT).show();
                    Intent goToSearchActivity = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(goToSearchActivity);
                }


            }
        });







    }



}