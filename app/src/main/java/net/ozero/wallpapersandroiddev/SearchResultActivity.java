package net.ozero.wallpapersandroiddev;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import net.ozero.wallpapersandroiddev.rest.ContentLoader;

public class SearchResultActivity extends AppCompatActivity {

    private static final int NUM_OF_COLUMS = 2;
    private RVAdapter rvAdapter;
    private GridLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        RecyclerView recyclerView = findViewById(R.id.rvSearchResult);
        layoutManager = new GridLayoutManager(this, NUM_OF_COLUMS);
        recyclerView.setLayoutManager(layoutManager);
        rvAdapter = new RVAdapter(this);
        recyclerView.setAdapter(rvAdapter);
        ContentLoader contentLoader = new ContentLoader(rvAdapter);
        contentLoader.loadFirs();
//        recyclerView.addOnScrollListener(new ScrollListener(layoutManager, rvAdapter));
    }

}
