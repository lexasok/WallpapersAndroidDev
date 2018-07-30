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
import android.widget.ProgressBar;
import android.widget.TextView;

import net.ozero.wallpapersandroiddev.rest.ContentLoader;

import java.util.Objects;

public class MainFragment extends Fragment {

    private String mTitle;
    private String mColor;
    private RVAdapter mAdapter;
    private RecyclerView recyclerView;
    private GridLayoutManager layoutManager;
    private ProgressBar progressBar;

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

        progressBar = view.findViewById(R.id.progressBarFragment);

        //initRV
        recyclerView = view.findViewById(R.id.rvMainFragment);
        layoutManager = new GridLayoutManager(getActivity(), App.NUM_OF_COLUMNS);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new RVAdapter(getContext());
        recyclerView.setAdapter(mAdapter);

        //loading data
        loadData(getLoadingType());
    }

    private ContentLoader.LoadingType getLoadingType() {

        ContentLoader.LoadingType loadingType;

        boolean isColorFiltered = !mColor.equals(App.COLOR_NONE);
        boolean isEditorChoice = mTitle.equals(App.CATEGORY_BEST);
        if (!isColorFiltered) {
            if (isEditorChoice) {
                loadingType = ContentLoader.LoadingType.editorChoice;
            } else {
                loadingType = ContentLoader.LoadingType.category;
            }
        } else {
            if (isEditorChoice) {
                loadingType = ContentLoader.LoadingType.editorChoseWithColor;
            } else {
                loadingType = ContentLoader.LoadingType.categoryWithColor;
            }
        }

        return loadingType;
    }

    private void loadData(ContentLoader.LoadingType loadingType) {

        progressBar.setVisibility(View.VISIBLE);

        ContentLoader contentLoader = new ContentLoader(
                mAdapter,
                loadingType,
                mTitle,
                mColor,
                progressBar,
                getContext()
        );
        contentLoader.load(App.FIRST_PAGE);
        //pagination
        recyclerView.addOnScrollListener(new ScrollListener(
                layoutManager,
                mAdapter,
                contentLoader
        ));

    }

    public void setmTitle(String title) {
        mTitle = title;
    }

    public void setmColor(String color) {
        mColor = color;
    }
}
