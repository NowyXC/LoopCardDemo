package com.nowy.loopcarddemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.nowy.loopcarddemo.view.GalleryRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Integer> mList = new ArrayList<>();
        mList.add(R.mipmap.pic4);
        mList.add(R.mipmap.pic5);
        mList.add(R.mipmap.pic6);

        GalleryRecyclerView grvData = (GalleryRecyclerView) findViewById(R.id.grvData);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        grvData.setLayoutManager(linearLayoutManager);

        grvData.setAdapter(new CardAdapter(mList),mList.size()*50);
        grvData.setPagePadding(4);
        grvData.setShowLeftCardWidth(20);
    }
}
