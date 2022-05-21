package com.example.mobile_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.Viewholder>  {
    private final ArrayList<CourseModel> mWordList;
    private ArrayList<CourseModel> checked;

    private LayoutInflater mInflater;


    public WordListAdapter(Context context, ArrayList<CourseModel> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
        checked = new ArrayList<>();
    }

    @NonNull
    @Override
    public com.example.mobile_project.WordListAdapter.Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new Viewholder(mItemView);
    }

    @Override
    public void onBindViewHolder(com.example.mobile_project.WordListAdapter.Viewholder holder, int position) {
        CourseModel model = mWordList.get(position);
        holder.itemImg.setImageResource(model.getItem_img());
        holder.itemName.setText(model.getItem_name());
        holder.itemDisc.setText(model.getItem_disc());
        holder.itemPrice.setText(model.getItem_price());
        holder.plusImg.setImageResource(model.getPlus_img());

        holder.plusImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checked.add(model);

            }
        });


    }

    public ArrayList<CourseModel> getData()
    {
        return checked;
    }




    public int getItemCount() {
        return mWordList.size();
    }



    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageView itemImg , plusImg ;
        private TextView itemName, itemDisc, itemPrice ;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            itemImg = itemView.findViewById(R.id.itemimg);
            itemName = itemView.findViewById(R.id.cartname);
            itemDisc = itemView.findViewById(R.id.itemdisc);
            itemPrice = itemView.findViewById(R.id.itemprice);
            plusImg = itemView.findViewById(R.id.plus);

        }
    }
}