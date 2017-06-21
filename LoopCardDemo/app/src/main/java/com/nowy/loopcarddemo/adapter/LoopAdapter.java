package com.nowy.loopcarddemo.adapter;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Nowy on 2017/6/21.
 */

public abstract class LoopAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {


    @Override
    final public int getItemCount() {
        int rawCount = getRawItemCount();
        if (rawCount > 0) {
            return Integer.MAX_VALUE;
        }
        return 0;
    }


    @Override
    final public int getItemViewType(int position) {
        return getLoopItemViewType(position % getRawItemCount());
    }

    protected int getLoopItemViewType(int position) {
        return 0;
    }



    @Override
    final public void onBindViewHolder(T holder, int position) {
        onBindLoopViewHolder(holder, position);
    }

    public abstract void onBindLoopViewHolder(T holder, int position);


    /**
     * 获取真实的item数量
     * @return
     */
    public abstract int getRawItemCount();
}
