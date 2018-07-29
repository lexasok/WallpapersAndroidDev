package net.ozero.wallpapersandroiddev;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import net.ozero.wallpapersandroiddev.rest.ContentLoader;

public class SearchResultActivity extends AppCompatActivity {

    private RVAdapter rvAdapter;
    private GridLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        String query = "yellow";

        //init RV
        RecyclerView recyclerView = findViewById(R.id.rvSearchResult);
        layoutManager = new GridLayoutManager(this,App.NUM_OFCOLLUMS);
        recyclerView.setLayoutManager(layoutManager);
        rvAdapter = new RVAdapter(this);
        recyclerView.setAdapter(rvAdapter);

        //loading data
        ContentLoader contentLoader = new ContentLoader(
                rvAdapter,
                ContentLoader.LoadingType.search,
                query,
                null
        );
        contentLoader.load(App.FIRST_PAGE);

        //paginate data
        recyclerView.addOnScrollListener(new ScrollListener(layoutManager, rvAdapter, contentLoader));
    }

}
