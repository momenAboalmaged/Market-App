package com.example.mobile_project;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.IntegerRes;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.Viewholder>  {
    private final ArrayList<CourseModel>cartproducts;
    private int totalprice = 0;




    private LayoutInflater mInflater;

    public CartAdapter(Context context, ArrayList<CourseModel> cartlist) {
        mInflater = LayoutInflater.from(context);
        this.cartproducts = cartlist;

    }

    @NonNull
    @Override
    public com.example.mobile_project.CartAdapter.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mCartView = mInflater.inflate(R.layout.cart_list, parent, false);
        return new Viewholder(mCartView);
    }


    @Override
    public void onBindViewHolder(com.example.mobile_project.CartAdapter.Viewholder holder, int position) {
        CourseModel model = cartproducts.get(position);
        holder.cartImg.setImageResource(model.getItem_img());
        holder.cartName.setText(model.getItem_name());
        holder.cartDisc.setText(model.getItem_disc());
        holder.cartPrice.setText(model.getItem_price());
//        holder.cartPlus.setImageResource(model.getPlus_img());
//        holder.cartCount.setText(model.getItem_count());
//        holder.cartMinus.setImageResource(model.getMinus_img());
        String Price=model.getItem_price().replaceAll("(?<=\\d),(?=\\d)|\\$","");
        int p=Integer.parseInt(Price);
        totalprice +=p;




//        holder.cartPlus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String x=holder.cartCount.getText().toString();
//                int y=Integer.parseInt(x);
//                y++;
//                Log.d("src", ""+x+"");
//                String _stringVal = Integer.toString(y);
//                holder.cartCount.setText(_stringVal);
//                String ojo=holder.cartPrice.getText().toString();
//                ojo=ojo.replaceAll("(?<=\\d),(?=\\d)|\\$","");
//                Log.d("src", ojo);
//                Integer G=Integer.parseInt(ojo);
//                G=G+Integer.parseInt(Price);
//                totalprice+=Integer.parseInt(Price);
//                t.setTprice(totalprice);
//                Log.d("src", ""+G+"");
//                String string2= "$"+Integer.toString(G);
//                holder.cartPrice.setText(string2);
//
//
//            }
//        });
//        holder.cartMinus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String x=holder.cartCount.getText().toString();
//                int y=Integer.parseInt(x);
//                String _stringVal;
//                if(y<=1){
//                    _stringVal = Integer.toString(y);
//
//                }
//                else{
//                    y--;
//                    _stringVal = Integer.toString(y);
//                    String z=holder.cartPrice.getText().toString();
//                    z=z.replaceAll("(?<=\\d),(?=\\d)|\\$","");
//                    Log.d("src", z);
//                    Integer o=Integer.parseInt(z);
//                    o=o-Integer.parseInt(Price);
//                    totalprice-=Integer.parseInt(Price);
//                    t.setTprice(totalprice);
//                    Log.d("src", ""+o+"");
//                    String string3= "$"+Integer.toString(o);
//                    holder.cartPrice.setText(string3);
//
//                }
//                Log.d("src", ""+x+"");
//
//
//                holder.cartCount.setText(_stringVal);
//
//
//
//            }
//        });



    }


    public int getItemCount() {
        return cartproducts.size();
    }



    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageView cartImg;
        private TextView cartName, cartDisc, cartPrice, cartCount ;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            cartImg = itemView.findViewById(R.id.cartimg);
            cartName = itemView.findViewById(R.id.cartname);
            cartDisc = itemView.findViewById(R.id.cartdisc);
            cartPrice = itemView.findViewById(R.id.cartprice);
//            cartPlus = itemView.findViewById(R.id.addquantity);
//            cartCount = itemView.findViewById(R.id.quantity);
//            cartMinus = itemView.findViewById(R.id.imageView9);




        }
    }
}