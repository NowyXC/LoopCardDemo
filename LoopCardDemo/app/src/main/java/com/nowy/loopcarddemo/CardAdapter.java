package com.nowy.loopcarddemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nowy.loopcarddemo.adapter.BaseCardAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by jameson on 8/30/16.
 */
class CardAdapter extends BaseCardAdapter<CardAdapter.ViewHolder> {
    private List<Integer> mList = new ArrayList<>();

    public CardAdapter(List<Integer> mList) {
        this.mList = mList;
    }


    @Override
    public ViewHolder onCreateCardViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(ViewHolder.RES_LAYOUT, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindCardViewHolder(ViewHolder holder, int position) {
        holder.mImageView.setImageResource(mList.get(position%mList.size()));
    }



    @Override
    public int getRawItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        static final int RES_LAYOUT = R.layout.view_card_item;
        public final ImageView mImageView;

        public ViewHolder(final View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.imageView);
        }

    }



}
