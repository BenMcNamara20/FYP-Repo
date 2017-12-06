package com.example.benmc.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button RegButton = (Button)findViewById(R.id.NewUser);
        RegButton.setOnClickListener(new View.OnClickListener(){
            @Override
        public void onClick(View view){
                String LinkToPhp="http://10.0.2.2/SavvySlimes/Register.php";
                EditText UserEmail=(EditText) findViewById(R.id.NewEmail);
                EditText UserPass = (EditText) findViewById(R.id.NewPass);

                if(UserEmail.getText().toString().contains(" ")){
                    Context context = getApplicationContext();
                    CharSequence text = "User email cannot contain special characters";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    //test
                    toast.show();
                }
                else {
                    Context context = getApplicationContext();
                    doBackgroundRegTask RegTask = new doBackgroundRegTask(context);
                    String TaskResponse=RegTask.execute(LinkToPhp, UserEmail.getText().toString(), UserPass.getText().toString()).toString();


                    System.out.println(TaskResponse);

                    CharSequence text = TaskResponse;
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, TaskResponse, duration);
                    toast.show();

                }
        }});
    }

    public void ReturnToLogin(){
        Intent newIntent = new Intent(this,LoginActivity.class);
        startActivity(newIntent);

    }

}
