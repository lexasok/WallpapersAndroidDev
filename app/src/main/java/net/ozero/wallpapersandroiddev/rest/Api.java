package net.ozero.wallpapersandroiddev.rest;

import net.ozero.wallpapersandroiddev.App;
import net.ozero.wallpapersandroiddev.SearchResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("?key=" + App.API_KEY)
    Call<SearchResult> search(
            @Query("q") String query,
            @Query("image_type") String imageType
    );


}
