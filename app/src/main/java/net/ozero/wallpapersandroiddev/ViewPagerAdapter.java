package net.ozero.wallpapersandroiddev;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private final ArrayList<String> mTitles = new ArrayList<>();
    private final ArrayList<Fragment> mFragments = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mTitles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }

    public void addFragments(ArrayList<String> titles) {
        for (String title : titles) {
            MainFragment fragment = new MainFragment();
            fragment.setTitle(title);
            mFragments.add(fragment);
            mTitles.add(title);
        }
    }

}
