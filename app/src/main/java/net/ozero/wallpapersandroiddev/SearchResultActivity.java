package net.ozero.wallpapersandroiddev;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class SearchResultActivity extends AppCompatActivity {

    private static final int NUM_OF_COLUMS = 3;
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
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);



            }
        });


    }

}
