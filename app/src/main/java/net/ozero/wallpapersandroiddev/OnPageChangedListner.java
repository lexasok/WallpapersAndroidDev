package net.ozero.wallpapersandroiddev;

import android.support.v4.view.ViewPager;

public class OnPageChangedListner extends ViewPager.SimpleOnPageChangeListener {

    private int currentPage;

    @Override
    public void onPageSelected(int position) {
        currentPage = position;
    }

    public final int getCurrentPage() {
        return currentPage;
    }
}
