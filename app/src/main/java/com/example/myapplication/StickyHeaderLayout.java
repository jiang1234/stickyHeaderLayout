package com.example.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.myapplication.viewholder.StickyHeaderViewHolder;

public class StickyHeaderLayout extends FrameLayout {
    private RecyclerView recyclerView;
    private FrameLayout stickyHeaderViewLayout;
    private int headerPosition = -2;
    //用于在吸顶布局中保存viewType的key。
    private final int VIEW_TAG_TYPE = -101;

    //用于在吸顶布局中保存ViewHolder的key。
    private final int VIEW_TAG_HOLDER = -102;


    public StickyHeaderLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public StickyHeaderLayout(@NonNull Context context) {
        this(context, null);
    }

    public void initView(Context context) {
        recyclerView = new RecyclerView(context);
        addView(recyclerView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        stickyHeaderViewLayout = new FrameLayout(context);
        addView(stickyHeaderViewLayout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        addScrollListener();
    }

//    @Override
//    public void addView(View child, int index, ViewGroup.LayoutParams params) {
//        if (getChildCount() > 1 || !(child instanceof RecyclerView)) {
//            throw new IllegalArgumentException("StickyHeaderLayout can host only one direct child --> RecyclerView");
//        }
//        super.addView(child, index, params);
//        recyclerView = recyclerView;
//    }

    private void addScrollListener() {
        if(recyclerView == null) {
            return;
        }
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                updateStickyHeader();
            }
        });
    }

    private void updateStickyHeader() {
        if(recyclerView == null) {
            return;
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if(adapter instanceof StickyRecyclerAdapter) {
            StickyRecyclerAdapter stickyRecyclerAdapter = (StickyRecyclerAdapter) adapter;

            int firstVisibilePos = getFirstVisibleItemPos();
            int type = stickyRecyclerAdapter.getItemViewType(firstVisibilePos);

            if(type == StickyRecyclerAdapter.TYPE_STICKY_HEADER) {
                //recycler中的标题显示出来了
                headerPosition = firstVisibilePos;
                //添加header
                if (getHeaderView() == null) {
                    StickyHeaderViewHolder viewHolder = (StickyHeaderViewHolder) stickyRecyclerAdapter.createViewHolder(stickyHeaderViewLayout, type);
                    stickyRecyclerAdapter.bindViewHolder(viewHolder, firstVisibilePos);
                    stickyHeaderViewLayout.addView(viewHolder.itemView);
                }
            }

            if(firstVisibilePos >= headerPosition) {
                stickyHeaderViewLayout.setVisibility(VISIBLE);
            } else {
                stickyHeaderViewLayout.setVisibility(GONE);
            }

            //这是是处理第一次打开时，吸顶布局已经添加到StickyLayout，但StickyLayout的高依然为0的情况。
            if (stickyHeaderViewLayout.getChildCount() > 0 && stickyHeaderViewLayout.getHeight() == 0) {
                stickyHeaderViewLayout.requestLayout();
            }
        }
    }

    private View getHeaderView() {
        if (stickyHeaderViewLayout.getChildCount() <= 0) {
            return null;
        }
        return stickyHeaderViewLayout.getChildAt(0);

    }



    /**
     * 获取当前第一个显示的item .
     */
    private int getFirstVisibleItemPos() {
        int firstVisibleItem = -1;
        RecyclerView.LayoutManager layout = recyclerView.getLayoutManager();
        if (layout != null) {
            if (layout instanceof LinearLayoutManager) {
                firstVisibleItem = ((LinearLayoutManager) layout).findFirstVisibleItemPosition();
            } else if (layout instanceof GridLayoutManager) {
                firstVisibleItem = ((GridLayoutManager) layout).findFirstVisibleItemPosition();
            } else if (layout instanceof StaggeredGridLayoutManager) {
                int[] firstPositions = new int[((StaggeredGridLayoutManager) layout).getSpanCount()];
                ((StaggeredGridLayoutManager) layout).findFirstVisibleItemPositions(firstPositions);
                firstVisibleItem = getMin(firstPositions);
            }
        }
        return firstVisibleItem;

    }

    private int getMin(int[] arr) {
        int min = arr[0];
        for (int x = 1; x < arr.length; x++) {
            if (arr[x] < min)
                min = arr[x];
        }
        return min;
    }

    public RecyclerView getRecycler() {
        return recyclerView;
    }
}
