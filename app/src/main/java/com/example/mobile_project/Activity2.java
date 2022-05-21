package com.example.mobile_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            this.getSupportActionBar().hide();
        }
        catch(NullPointerException e){}
        setContentView(R.layout.activity_2);
        final EditText FName = findViewById(R.id.editTextTextPersonName3);
        final EditText Email=findViewById(R.id.editTextTextPersonName4);
        final EditText UName=findViewById(R.id.editTextTextPersonName5);
        final EditText pwd=findViewById(R.id.Pass);
        Button Register=findViewById(R.id.button2);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences=getSharedPreferences("MYPRESS",MODE_PRIVATE);
                String FullName = FName.getText().toString();
                String email = Email.getText().toString();
                String UserName = UName.getText().toString();
                String Password = pwd.getText().toString();

                SharedPreferences.Editor editor= preferences.edit();
                editor.putString(email+Password+"data",UserName);
                editor.putBoolean("logged",true);
                editor.commit();
                Intent intent = new Intent(Activity2.this,MainActivity.class);
                startActivity(intent);

            }
        });

    }
}