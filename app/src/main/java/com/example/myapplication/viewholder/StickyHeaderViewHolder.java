package com.example.myapplication.viewholder;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Bean;
import com.example.myapplication.R;

public class StickyHeaderViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;

    public StickyHeaderViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.button_1);
    }

    public void bindView(Bean bean) {
        textView.setText("bind button");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Aaaa", Toast.LENGTH_SHORT);
            }
        });
    }
}
