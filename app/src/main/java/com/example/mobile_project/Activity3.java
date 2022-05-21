package com.example.mobile_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class Activity3 extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    private ImageView goToCart;
    private ImageView out;
    Bundle b;

    private final ArrayList<CourseModel> mWordList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        b=new Bundle();
        super.onCreate(savedInstanceState);

        try {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}


        setContentView(R.layout.activity_3);

        mRecyclerView = findViewById(R.id.recyclerview);
        mWordList.add(new CourseModel(R.drawable.bananas, "Bananas" , "By Weight 2 Kg", "$2",R.drawable.plus2 ,R.drawable.minus));
        mWordList.add(new CourseModel(R.drawable.watermelon, "Watermelon" , "By Weight $10 Kg", "$10",R.drawable.plus2 ,R.drawable.minus));
        mWordList.add(new CourseModel(R.drawable.meat, "Meat" , "By Weight $100 Kg", "$100",R.drawable.plus2 ,R.drawable.minus));
        mWordList.add(new CourseModel(R.drawable.thanksgiving, "Chicken" , "By Weight $80 Kg", "$80",R.drawable.plus2 ,R.drawable.minus));

        mWordList.add(new CourseModel(R.drawable.fish, "Fish" , "By Weight $50 Kg", "$50",R.drawable.plus2 ,R.drawable.minus));
        mWordList.add(new CourseModel(R.drawable.sushi, "Sushi" , "By Weight $200 Kg", "$200",R.drawable.plus2 ,R.drawable.minus));
        mWordList.add(new CourseModel(R.drawable.apple, "Apple" , "By Weight $25 Kg", "$25",R.drawable.plus2 ,R.drawable.minus));
        mWordList.add(new CourseModel(R.drawable.strawberry, "Strawberry" , "By Weight $30 Kg", "$30",R.drawable.plus2 ,R.drawable.minus));
        mWordList.add(new CourseModel(R.drawable.grapes, "Grapes" , "By Weight $40 Kg", "$40",R.drawable.plus2 ,R.drawable.minus));
        mWordList.add(new CourseModel(R.drawable.dragon_fruit, "Dragon Fruit" , "By Weight $150 Kg", "$150",R.drawable.plus2 ,R.drawable.minus));
        mWordList.add(new CourseModel(R.drawable.pizza, "Pizza" , "By piece $60", "$60",R.drawable.plus2 ,R.drawable.minus));
        mWordList.add(new CourseModel(R.drawable.hamburger, "Humburger" , "By piece $45", "$45",R.drawable.plus2 ,R.drawable.minus));

        mAdapter = new WordListAdapter(this, mWordList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));

        goToCart= findViewById(R.id.imageView2);
        out=findViewById(R.id.imageView4);
        goToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mAdapter.getData();
                b.putSerializable("cart",(Serializable) mAdapter.getData());
                Intent intent=new Intent(Activity3.this,Activity4.class);
                intent.putExtras(b);
                Log.d(TAG, "go to carttttttttttttttttttttttttttttttttttttttttttt");
                startActivity(intent);

            }
        });
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("MYPRESS",MODE_PRIVATE);
                SharedPreferences.Editor editor= preferences.edit();
                editor.putBoolean("logged",false);
                editor.commit();
                Intent intent=new Intent(Activity3.this,MainActivity.class);
                startActivity(intent);
            }


        });













    }
}