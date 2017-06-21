package com.nowy.loopcarddemo.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.nowy.loopcarddemo.adapter.BaseCardAdapter;
import com.nowy.loopcarddemo.utils.CardScaleHelper;

/**
 * Created by Nowy on 2017/6/21.
 * 画廊recyclerView，无限循环（假的）
 */

public class GalleryRecyclerView extends RecyclerView {
    private CardScaleHelper mCardScaleHelper = new CardScaleHelper();
    private BaseCardAdapter mAdapter;

    public GalleryRecyclerView(Context context) {
        super(context);
    }

    public GalleryRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public GalleryRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
        if(adapter instanceof BaseCardAdapter){
            this.mAdapter = (BaseCardAdapter) adapter;
            mCardScaleHelper.setCurrentItemPos(1000);
            mCardScaleHelper.attachToRecyclerView(this);

        }
    }

    /**
     * 设置适配器
     * @param adapter 适配器
     * @param position 如果是{@link BaseCardAdapter},position可以滑动到指定条目
     */
    public void setAdapter(Adapter adapter, int position) {
        super.setAdapter(adapter);
        if(adapter instanceof BaseCardAdapter){
            this.mAdapter = (BaseCardAdapter) adapter;
            mCardScaleHelper.setCurrentItemPos(position);
            mCardScaleHelper.attachToRecyclerView(this);
        }
    }



    public void setScale(float scale) {
        mCardScaleHelper.setScale(scale);
    }


    /**
     * 单位是dp
     * @param pagePadding
     */
    public void setPagePadding(int pagePadding) {
        mCardScaleHelper.setPagePadding(pagePadding);
        if(mAdapter != null){
            mAdapter.setPagePadding(pagePadding);
        }
    }

    /**
     * 单位是dp
     * @param showLeftCardWidth
     */
    public void setShowLeftCardWidth(int showLeftCardWidth) {
        mCardScaleHelper.setShowLeftCardWidth(showLeftCardWidth);
        if(mAdapter != null){
            mAdapter.setShowLeftCardWidth(showLeftCardWidth);
        }
    }

    public CardScaleHelper getCardScaleHelper() {
        return mCardScaleHelper;
    }

    public void setCardScaleHelper(CardScaleHelper cardScaleHelper) {
        this.mCardScaleHelper = cardScaleHelper;
    }
}
