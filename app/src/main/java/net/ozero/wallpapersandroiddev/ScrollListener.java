package net.ozero.wallpapersandroiddev;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import net.ozero.wallpapersandroiddev.rest.ContentLoader;

public class ScrollListener extends RecyclerView.OnScrollListener{

    private static final int PER_PAGE = 20;
    private static final int FIRS_PAGE_NUM = 1;

    private GridLayoutManager mLayoutManager;
    private RVAdapter mAdapter;
    private int loadingPosition;
    private int page;


    public ScrollListener(GridLayoutManager layoutManager, RVAdapter adapter) {
        mLayoutManager = layoutManager;
        loadingPosition = PER_PAGE;
        mAdapter = adapter;
        page = FIRS_PAGE_NUM;
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        int lastVisibleItemPosition = mLayoutManager.findLastVisibleItemPosition();

    }
}
