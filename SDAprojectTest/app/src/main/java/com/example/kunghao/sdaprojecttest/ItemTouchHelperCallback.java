package com.example.kunghao.sdaprojecttest;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public class ItemTouchHelperCallback extends ItemTouchHelper.Callback{

    private final ItemTouchHelpAdapter adapter;

    public ItemTouchHelperCallback(ItemTouchHelpAdapter adapter){
        this.adapter = adapter;
    }

    //開啟長按
    public boolean isLongPressDragEnables(){
        return true;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlag = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlag = 0;
        return makeMovementFlags(dragFlag, swipeFlag);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        final int fromPos = viewHolder.getAdapterPosition();
        final int toPos = target.getAdapterPosition();
        // move item in `fromPos` to `toPos` in adapter.
        adapter.onItemMove(fromPos, toPos);
        return true;// true if moved, false otherwise
    }


    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }

}
