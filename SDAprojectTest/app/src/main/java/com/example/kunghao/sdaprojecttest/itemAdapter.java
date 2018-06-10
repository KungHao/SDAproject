package com.example.kunghao.sdaprojecttest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class itemAdapter extends RecyclerView.Adapter<itemAdapter.ViewHolder>
        implements ItemTouchHelpAdapter{

    private List<Integer> item = new ArrayList<>();

    public itemAdapter(){
        for (int i = 0 ; i < 10 ; i++){
            item.add(i+1);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTxt;
        ImageView mImage;
        public ViewHolder(final View itemView) {
            super(itemView);
            mTxt = itemView.findViewById(R.id.restaurantTxt);
            mImage = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    // item clicked
                    Toast.makeText(itemView.getContext(), "123", Toast.LENGTH_SHORT).show();
                }
            });

            mImage.setImageDrawable(itemView.getResources().getDrawable(R.drawable.buffet));
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // 把資料設定給 ViewHolder
        holder.mTxt.setText(item.get(position).toString());
    }



    @Override
    public int getItemCount() {
        return item.size();
    }



    //長按並移動項目
    public void onItemMove(int fromPosition, int toPostion){
        if (fromPosition < toPostion){
            //往下拉
            for (int i = fromPosition ; i < toPostion ; i++){
                Collections.swap(item, i, i+1);
            }
        }
        else{
            //往上拉
            for (int i = fromPosition ; i > toPostion;i--){
                Collections.swap(item, i , i-1);
            }
        }
    }

}
