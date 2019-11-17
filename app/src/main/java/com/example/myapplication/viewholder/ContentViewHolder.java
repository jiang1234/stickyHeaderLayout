package com.example.myapplication.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Bean;
import com.example.myapplication.R;

public class ContentViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;
    public ContentViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.text);
    }

    public void bindView(Bean bean) {
        textView.setText(bean.message);

    }
}
