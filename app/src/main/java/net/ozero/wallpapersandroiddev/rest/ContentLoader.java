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

    private static final int FIRS_PAGE = 1;

    private RVAdapter mAdapter;
    private LoadingType mLoadingType;
    private Api mApi;
    private String mQuery;
    private String mColor;

    public ContentLoader(RVAdapter adapter, LoadingType loadingType, String query, String color) {
        mAdapter = adapter;
        mLoadingType = loadingType;
        mApi = App.getRestClient().getApi();
        mQuery = query;
        mColor = color;
    }

    public void load(int page) {
        switch (mLoadingType) {
            case search:
                mApi
                        .search(mQuery, page)
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
                break;

            case category:
                mApi
                        .loadCategory(mQuery, page)
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
                break;

            case categoryWithColor:
                mApi
                        .loadCategoryWithColor(mQuery, mColor, page)
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
                break;

            case editorChose:
                mApi
                        .loadEditorsChose(true, page)
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
                break;

            case editorChoseWithColor:
                mApi
                        .loadEditorsChoiceWithColor(mColor, true, page)
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
                break;

            default:
                break;
        }
    }

    public enum LoadingType {
        search, category, categoryWithColor, editorChose, editorChoseWithColor
    }
}
