package net.ozero.wallpapersandroiddev.rest;

import net.ozero.wallpapersandroiddev.App;
import net.ozero.wallpapersandroiddev.RVAdapter;
import net.ozero.wallpapersandroiddev.rest.model.Hit;
import net.ozero.wallpapersandroiddev.rest.model.Result;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContentLoader {

    private RVAdapter mAdapter;

    public ContentLoader(RVAdapter adapter) {
        mAdapter = adapter;
    }

    public void loadNext(int page) {
        App
                .getRestClient()
                .getApi()
                .searchPaginated("yellow", page)
                .enqueue(new Callback<Result>() {
                    @Override
                    public void onResponse(Call<Result> call, Response<Result> response) {
                        if (response.isSuccessful()) {
                            Result result = response.body();
                            ArrayList<Hit> hits = result.getHits();
                            mAdapter.addData(hits);
                        }
                    }

                    @Override
                    public void onFailure(Call<Result> call, Throwable t) {

                    }
                });
    }

    public void loadFirs() {
        App
                .getRestClient()
                .getApi()
                .search("yellow")
                .enqueue(new Callback<Result>() {
                    @Override
                    public void onResponse(Call<Result> call, Response<Result> response) {
                        if (response.isSuccessful()) {
                            Result result = response.body();
                            ArrayList<Hit> hits = result.getHits();
                            mAdapter.addData(hits);
                        }
                    }

                    @Override
                    public void onFailure(Call<Result> call, Throwable t) {

                    }
                });
    }
}
