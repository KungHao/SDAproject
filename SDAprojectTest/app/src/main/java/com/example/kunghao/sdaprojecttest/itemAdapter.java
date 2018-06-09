package com.example.kunghao.sdaprojecttest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.ViewHolder>{

    private List<Integer> item = new ArrayList<>();

    public itemAdapter(){
        for (int i = 0 ; i < 10 ; i++){
            item.add(i+1);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTxt;
        public ViewHolder(View itemView) {
            super(itemView);
            mTxt = itemView.findViewById(R.id.restaurantTxt);

        }
    }

    @Override
    public itemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(itemAdapter.ViewHolder holder, int position) {
        // 把資料設定給 ViewHolder
        holder.mTxt.setText(item.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return item.size();
    }


    public void setRestaurant(List<String> restaurant){
        for(int i = 0 ; i<restaurant.size();i++){

        }
    }
}
