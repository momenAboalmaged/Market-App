
package com.example.mobile_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_main);
        reg = (TextView) findViewById(R.id.reg);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInsideActivity1();
            }
        });
        final EditText email = findViewById(R.id.editTextTextEmailAddress);
        final EditText Password=findViewById(R.id.editTextTextPassword);
        Button login=findViewById(R.id.button );
        SharedPreferences preferences = getSharedPreferences("MYPRESS",MODE_PRIVATE);
        boolean log=preferences.getBoolean("looged",false);
        if(log==true){

                Intent intent=new Intent(MainActivity.this,Activity3.class);
                startActivity(intent);

        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em=email.getText().toString();
                String pwd=Password.getText().toString();

                SharedPreferences preferences = getSharedPreferences("MYPRESS",MODE_PRIVATE);
                if(preferences.contains(em+pwd+"data")){

                    Intent intent=new Intent(MainActivity.this,Activity3.class);
                    startActivity(intent);
                }


            }
        });
    }
    public void openInsideActivity1()
    {
        Intent intent = new Intent(this,Activity2.class);
        startActivity(intent);
    }
}