package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;


import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StickyHeaderLayout stickyHeaderLayout = findViewById(R.id.sticky_header_layout);
        RecyclerView recyclerView = stickyHeaderLayout.getRecycler();
     //   RecyclerView recyclerView = findViewById(R.id.recycler_view);
        StickyRecyclerAdapter adapter = new StickyRecyclerAdapter(initData());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter.setData(initData());
//        adapter.notifyDataSetChanged();
    }

    public List<Bean> initData() {
        List<Bean> beans = new ArrayList<>();
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 1));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 2));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 3));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 4));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 5));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 6));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 7));
        beans.add(new Bean(StickyRecyclerAdapter.TYPE_STICKY_HEADER, 1));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 8));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 9));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 10));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 11));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 12));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 13));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 14));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 15));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 16));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 17));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 18));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 19));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 10));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 10));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 10));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 10));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 10));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 10));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 10));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 10));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 10));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 10));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 10));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 10));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 10));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 10));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 10));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 10));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 10));
        beans.add(new Bean(StickyRecyclerAdapter.TYPR_CONTENT, 10));

        return beans;


    }

}
