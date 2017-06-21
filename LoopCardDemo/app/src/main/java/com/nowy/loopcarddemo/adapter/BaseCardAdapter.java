package com.nowy.loopcarddemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.nowy.loopcarddemo.utils.CardAdapterHelper;


/**
 * 抽象的卡片布局适配器（无限循环）
 */
public abstract class BaseCardAdapter<T extends  RecyclerView.ViewHolder>  extends LoopAdapter<T>{
    private CardAdapterHelper mCardAdapterHelper = new CardAdapterHelper();
    @Override
    final public T onCreateViewHolder(ViewGroup parent, int viewType) {
        T holder = onCreateCardViewHolder(parent,viewType);
        mCardAdapterHelper.onCreateViewHolder(parent, holder.itemView);
        return holder;
    }

    @Override
    final public void onBindLoopViewHolder(final T holder, final int position) {
        mCardAdapterHelper.onBindViewHolder(holder.itemView, position, getItemCount());
        onBindCardViewHolder(holder, position % getRawItemCount());
    }

    public abstract T onCreateCardViewHolder(ViewGroup parent, int viewType);

    public abstract void onBindCardViewHolder(final T holder, final int position);


    public void setPagePadding(int pagePadding) {
        mCardAdapterHelper.setPagePadding(pagePadding);
    }

    public void setShowLeftCardWidth(int showLeftCardWidth) {
        mCardAdapterHelper.setShowLeftCardWidth(showLeftCardWidth);
    }


}
