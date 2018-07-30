package net.ozero.wallpapersandroiddev.rest;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import net.ozero.wallpapersandroiddev.App;
import net.ozero.wallpapersandroiddev.RVAdapter;
import net.ozero.wallpapersandroiddev.rest.model.Hit;
import net.ozero.wallpapersandroiddev.rest.model.Result;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContentLoader {

    private static final String ERROR = "ERROR";

    private RVAdapter mAdapter;
    private LoadingType mLoadingType;
    private Api mApi;
    private String mQuery;
    private String mColor;
    private Callback<Result> mCallback;
    private ProgressBar mProgressBar;
    private Context mContext;

    public ContentLoader(RVAdapter adapter, LoadingType loadingType, String query, String color, ProgressBar progressBar, Context context) {
        mAdapter = adapter;
        mLoadingType = loadingType;
        mApi = App.getRestClient().getApi();
        mQuery = query;
        mColor = color;
        mProgressBar = progressBar;
        mContext = context;

        mCallback = new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if (response.isSuccessful()) {
                    Result result = response.body();
                    assert result != null;
                    ArrayList<Hit> hits = result.getHits();
                    mAdapter.addData(hits);
                    mProgressBar.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Toast.makeText(mContext, ERROR, Toast.LENGTH_LONG).show();
            }
        };
    }

    public void load(int page) {
        switch (mLoadingType) {
            case search:
                mApi
                        .search(mQuery, page)
                        .enqueue(mCallback);
                break;

            case category:
                mApi
                        .loadCategory(mQuery, page)
                        .enqueue(mCallback);
                break;

            case categoryWithColor:
                mApi
                        .loadCategoryWithColor(mQuery, mColor, page)
                        .enqueue(mCallback);
                break;

            case editorChoice:
                mApi
                        .loadEditorsChose(true, page)
                        .enqueue(mCallback);
                break;

            case editorChoseWithColor:
                mApi
                        .loadEditorsChoiceWithColor(mColor, true, page)
                        .enqueue(mCallback);
                break;

            default:
                break;
        }
    }

    public enum LoadingType {
        search, category, categoryWithColor, editorChoice, editorChoseWithColor
    }
}
