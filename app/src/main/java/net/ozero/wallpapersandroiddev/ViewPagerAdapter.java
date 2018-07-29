package net.ozero.wallpapersandroiddev;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

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

    public void addFragments(ArrayList<String> titles, String color) {
        mFragments.clear();
        mTitles.clear();
        for (String title : titles) {
            Bundle bundle = new Bundle();
            bundle.putString(App.KEY_TITLE, title);
            MainFragment fragment = new MainFragment();
            fragment.setArguments(bundle);
            mFragments.add(fragment);
            mTitles.add(title);
        }
    }

//    @Override
//    public int getItemPosition(@NonNull Object object) {
//        return POSITION_NONE;
//    }

}
