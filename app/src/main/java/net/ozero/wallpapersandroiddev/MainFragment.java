package net.ozero.wallpapersandroiddev;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.ozero.wallpapersandroiddev.rest.ContentLoader;

public class MainFragment extends Fragment {

    private String mTitle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        //initRV
        RecyclerView recyclerView = view.findViewById(R.id.rvMainFragment);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), App.NUM_OFCOLLUMS);
        recyclerView.setLayoutManager(layoutManager);
        RVAdapter adapter = new RVAdapter(getContext());
        recyclerView.setAdapter(adapter);

        //loading data


        return view;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
