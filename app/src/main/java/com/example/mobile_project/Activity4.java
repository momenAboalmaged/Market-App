package com.example.mobile_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity4 extends AppCompatActivity {

    private RecyclerView cartRecyclerView;
    private CartAdapter cAdapter;
    private TextView test;
    private ImageView confirm;
    private TextView Total;
    private int totalprice;
    private ImageView share;
    private ImageView out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        totalprice=0;
        try {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e) {}

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        share=findViewById(R.id.imageView10);

        Bundle extras = getIntent().getExtras();
        ArrayList<CourseModel>cartproducts  = (ArrayList<CourseModel>) extras.getSerializable("cart");
        for(int i=0;i<cartproducts.size();i++){
            String X=cartproducts.get(i).getItem_price().toString();
            X=X.replaceAll("(?<=\\d),(?=\\d)|\\$","");
            int y=Integer.parseInt(X);
            totalprice+=y;
        }
        out=findViewById(R.id.imageView4);
       createNotificationChannel();
       // ArrayList<CourseModel>cartproducts = (ArrayList<CourseModel>)savedInstanceState.getSerializable("cart");
        Total=findViewById(R.id.textView6);
        Total.setText("$"+totalprice);
        cartRecyclerView = findViewById(R.id.recyclerview2);
        cAdapter = new CartAdapter(this,cartproducts);
        cartRecyclerView.setAdapter(cAdapter);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        confirm=findViewById(R.id.imageView8);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "confirm")
                .setSmallIcon(R.drawable.shopping_bag)
                .setContentTitle("Shopping App")
                .setContentText("Confirm Order")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Your Order Has Been Confirmed"))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat NotificationManager= NotificationManagerCompat.from(this);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager.notify(100,builder.build());

            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String body = "your total price is $"+totalprice+" share using:";
                String sub = "Share Price";
                myIntent.putExtra(Intent.EXTRA_SUBJECT,sub);
                myIntent.putExtra(Intent.EXTRA_TEXT,body);
                startActivity(Intent.createChooser(myIntent, "your total price is $"+totalprice+" share using"));
            }
        });
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("MYPRESS",MODE_PRIVATE);
                SharedPreferences.Editor editor= preferences.edit();
                editor.putBoolean("logged",false);
                editor.commit();
                Intent intent=new Intent(Activity4.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "customer Channel";
            String description = "channel for Customer";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("confirm", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}