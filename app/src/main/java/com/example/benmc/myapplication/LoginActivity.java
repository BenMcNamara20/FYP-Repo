package com.example.benmc.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button RegisterButton = (Button) findViewById(R.id.RegButton);
        RegisterButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                OpenRegister();
            }
        });
        Button LoginButton=(Button) findViewById((R.id.LoginButton));
        LoginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Login();
            }
        });
    }
        public void OpenRegister(){
            Intent newIntent = new Intent(this,RegisterActivity.class);
            startActivity(newIntent);

    }
    public void Login(){
        String LinkToPhp="http://10.0.2.2/SavvySlimes/Register.php";
        EditText UserEmail=(EditText) findViewById(R.id.NewEmail);
        EditText UserPass = (EditText) findViewById(R.id.NewPass);
    }
    public void changeScreen(){
        Intent newIntent = new Intent(this,MainActivity.class);
        startActivity(newIntent);
    }

}
