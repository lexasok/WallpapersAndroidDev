package net.ozero.wallpapersandroiddev;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import net.ozero.wallpapersandroiddev.rest.ContentLoader;

public class SearchResultActivity extends AppCompatActivity {

    private RVAdapter rvAdapter;
    private GridLayoutManager layoutManager;
    private String mQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        ProgressBar progressBar = findViewById(R.id.progressBarSearchActivity);

        //getting query
        if (getIntent().hasExtra(App.EXTRA_SEARCH)) {
            mQuery = getIntent().getStringExtra(App.EXTRA_SEARCH);
            setTitle(mQuery);
        }

        //init RV
        RecyclerView recyclerView = findViewById(R.id.rvSearchResult);
        layoutManager = new GridLayoutManager(this,App.NUM_OF_COLUMNS);
        recyclerView.setLayoutManager(layoutManager);
        rvAdapter = new RVAdapter(this);
        recyclerView.setAdapter(rvAdapter);

        //loading data
        progressBar.setVisibility(View.VISIBLE);
        ContentLoader contentLoader = new ContentLoader(
                rvAdapter,
                ContentLoader.LoadingType.search,
                mQuery,
                null,
                progressBar,
                getApplicationContext()
        );
        contentLoader.load(App.FIRST_PAGE);

        //paginate data
        recyclerView.addOnScrollListener(new ScrollListener(layoutManager, contentLoader));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
