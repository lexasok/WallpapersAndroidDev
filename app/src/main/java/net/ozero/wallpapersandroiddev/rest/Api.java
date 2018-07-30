package net.ozero.wallpapersandroiddev.rest;

import net.ozero.wallpapersandroiddev.App;
import net.ozero.wallpapersandroiddev.rest.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("?key=" + App.API_KEY)
    Call<Result> search(
            @Query("q") String query,
            @Query("page") int page
    );

    @GET("?key=" + App.API_KEY)
    Call<Result> loadCategory(
        @Query("category") String category,
        @Query("page") int page
    );

    @GET("?key=" + App.API_KEY)
    Call<Result> loadCategoryWithColor(
            @Query("category") String category,
            @Query("colors") String color,
            @Query("page") int page
    );

    @GET("?key=" + App.API_KEY)
    Call<Result> loadEditorsChose(
            @Query("editors_choice") boolean editorsChoice,
            @Query("page") int page
    );

    @GET("?key=" + App.API_KEY)
    Call<Result> loadEditorsChoiceWithColor(
            @Query("colors") String color,
            @Query("editors_choice") boolean editorsChoice,
            @Query("page") int page
    );
}
