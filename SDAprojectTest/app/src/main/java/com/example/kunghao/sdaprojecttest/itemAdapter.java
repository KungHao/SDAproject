package com.example.kunghao.sdaprojecttest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;


public class itemAdapter extends RecyclerView.Adapter<itemAdapter.ViewHolder>
        implements ItemTouchHelpAdapter, View.OnClickListener{

    private List<Restaurant> restaurant_list;

    public itemAdapter(List<Restaurant> restaurant){
        restaurant_list = restaurant;
    }

    @Override
    public void onClick(View view) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView mTxt;
        public ViewHolder(final View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            mTxt = itemView.findViewById(R.id.restaurantTxt);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    // item clicked
                    Toast.makeText(itemView.getContext(), "123", Toast.LENGTH_SHORT).show();
                }
            });

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
        Restaurant restaurant = restaurant_list.get(position);

        holder.imageView.setImageResource(restaurant.drawable);
        holder.mTxt.setText(restaurant.name);
    }



    @Override
    public int getItemCount() {
        return restaurant_list.size();
    }



    //長按並移動項目
    public void onItemMove(int fromPosition, int toPostion){
        if (fromPosition < toPostion){
            //往下拉
            for (int i = fromPosition ; i < toPostion ; i++){
                Collections.swap(restaurant_list, i, i+1);
            }
        }
        else{
            //往上拉
            for (int i = fromPosition ; i > toPostion;i--){
                Collections.swap(restaurant_list, i , i-1);
            }
        }
        notifyItemMoved(fromPosition, toPostion);
    }

}
