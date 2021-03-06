package net.ozero.wallpapersandroiddev;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import net.ozero.wallpapersandroiddev.rest.ContentLoader;

public class ScrollListener extends RecyclerView.OnScrollListener{

    private static final int PER_PAGE = 20;
    private static final int FIRS_PAGE_NUM = 1;
    private static final int LOADING_ALLOWANCE = 6;

    private GridLayoutManager mLayoutManager;
    private int loadingPosition;
    private int page;
    private ContentLoader mContentLoader;


    public ScrollListener(GridLayoutManager layoutManager, ContentLoader contentLoader) {
        mLayoutManager = layoutManager;
        loadingPosition = PER_PAGE;
        page = FIRS_PAGE_NUM;
        mContentLoader = contentLoader;

    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        int lastVisibleItemPosition = mLayoutManager.findLastVisibleItemPosition();
        if (lastVisibleItemPosition == loadingPosition - LOADING_ALLOWANCE - 1) {
            page += 1;
            loadingPosition += PER_PAGE;
            mContentLoader.load(page);
        }
    }
}
