package net.ozero.wallpapersandroiddev;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.ozero.wallpapersandroiddev.rest.ContentLoader;

public class MainFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{

    private String mTitle;
    private String mColor = App.COLOR_NONE;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RVAdapter mAdapter;
    private RecyclerView recyclerView;
    private GridLayoutManager layoutManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //init swipe to refresh
        swipeRefreshLayout = view.findViewById(R.id.swipeToRefresh);
        swipeRefreshLayout.setOnRefreshListener(this);

        //initRV
        recyclerView = view.findViewById(R.id.rvMainFragment);
        layoutManager = new GridLayoutManager(getActivity(), App.NUM_OF_COLUMNS);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new RVAdapter(getContext());
        recyclerView.setAdapter(mAdapter);

        //loading data
        load();
    }

    @Override
    public void onRefresh() {
//        load();
    }

    private void load() {

        boolean isColorFiltered = !mColor.equals(App.COLOR_NONE);
        boolean isEditorChoice = mTitle.equals(App.CATEGORY_BEST);
        if (!isColorFiltered) {
            if (isEditorChoice) {

                ContentLoader contentLoader = new ContentLoader(
                        mAdapter,
                        ContentLoader.LoadingType.editorChoice,
                        mTitle,
                        mColor
                );
                contentLoader.load(App.FIRST_PAGE);
                //pagination
                recyclerView.addOnScrollListener(new ScrollListener(
                        layoutManager,
                        mAdapter,
                        contentLoader
                ));

            } else {

                ContentLoader contentLoader = new ContentLoader(
                        mAdapter,
                        ContentLoader.LoadingType.category,
                        mTitle,
                        mColor
                );
                contentLoader.load(App.FIRST_PAGE);
                //pagination
                recyclerView.addOnScrollListener(new ScrollListener(
                        layoutManager,
                        mAdapter,
                        contentLoader
                ));
            }
        } else {

            if (isEditorChoice) {
                ContentLoader contentLoader = new ContentLoader(
                        mAdapter,
                        ContentLoader.LoadingType.editorChoseWithColor,
                        mTitle,
                        mColor
                );
                contentLoader.load(App.FIRST_PAGE);
                //pagination
                recyclerView.addOnScrollListener(new ScrollListener(
                        layoutManager,
                        mAdapter,
                        contentLoader
                ));
            } else {

                ContentLoader contentLoader = new ContentLoader(
                        mAdapter,
                        ContentLoader.LoadingType.categoryWithColor,
                        mTitle,
                        mColor
                );
                contentLoader.load(App.FIRST_PAGE);
                //pagination
                recyclerView.addOnScrollListener(new ScrollListener(
                        layoutManager,
                        mAdapter,
                        contentLoader
                ));
            }
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    public void setmTitle(String title) {
        mTitle = title;
    }

    public void setmColor(String color) {
        mColor = color;
    }
}
