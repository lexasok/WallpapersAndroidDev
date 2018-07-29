package net.ozero.wallpapersandroiddev;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import net.ozero.wallpapersandroiddev.rest.ContentLoader;

public class ScrollListner extends RecyclerView.OnScrollListener{

    private static final int PER_PAGE = 20;

    private GridLayoutManager mLayoutManager;
    private RVAdapter mAdapter;
    private int loadingPosition;


    public ScrollListner(GridLayoutManager layoutManager, RVAdapter adapter) {
        mLayoutManager = layoutManager;
        loadingPosition = 0;
        mAdapter = adapter;
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        int firstVisibleItemPosition = mLayoutManager.findFirstVisibleItemPosition();
        if (firstVisibleItemPosition >= loadingPosition) {
            ContentLoader contentLoader = new ContentLoader();
            contentLoader.load(mAdapter, loadingPosition + 1);
            loadingPosition += PER_PAGE;
        }
    }
}
