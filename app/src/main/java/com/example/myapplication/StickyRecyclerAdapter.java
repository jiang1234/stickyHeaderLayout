package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.viewholder.ContentViewHolder;
import com.example.myapplication.viewholder.StickyHeaderViewHolder;

import java.util.ArrayList;
import java.util.List;

public class StickyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Bean> beans ;
    public static final int NO_TYPE = -1;
    public static final int TYPE_STICKY_HEADER = 0;
    public static final int TYPR_CONTENT = 1;
    public StickyRecyclerAdapter(List<Bean> beans ) {
        this.beans = beans;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == TYPE_STICKY_HEADER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_stick_header, parent, false);
            return new StickyHeaderViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_content, parent, false);
            return new ContentViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        if(type == TYPE_STICKY_HEADER) {
            ((StickyHeaderViewHolder)holder).bindView(beans.get(position));
        } else if (type == TYPE_STICKY_HEADER){
            ((ContentViewHolder)holder).bindView(beans.get(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(position < 0 || position >= beans.size()) {
            return NO_TYPE;
        }
        Bean bean = beans.get(position);
        return bean.type;
    }

    @Override
    public int getItemCount() {
        return beans.size();
    }

    public void add(Bean bean) {
        beans.add(bean);
    }

    public void setData(List<Bean> beans) {

        this.beans.addAll(beans);
    }

}
