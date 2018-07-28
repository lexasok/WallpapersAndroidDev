package net.ozero.wallpapersandroiddev.rest;

import net.ozero.wallpapersandroiddev.SearchResultActivity;
import net.ozero.wallpapersandroiddev.rest.model.Result;

import org.junit.Test;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.*;

public class RestClientTest {

    @Test
    public void search() {
        RestClient restClient = new RestClient();
        try {
            Response response = restClient.getApi().search("yellow", "photo").execute();
            System.out.println("resp");
            Result result = (Result) response.body();

            System.out.println(result.getTotalHits());

        } catch (IOException e) {
            e.printStackTrace();
        }

//        restClient.getApi().search("yellow", "photo").enqueue(new Callback<Result>() {
//            @Override
//            public void onResponse(Call<Result> call, Response<Result> response) {
//                System.out.println("response");
//            }
//
//            @Override
//            public void onFailure(Call<Result> call, Throwable t) {
//                System.out.println("fail");
//            }
//        });
    }

    @Test
    public void searchPaginated() {
        RestClient restClient = new RestClient();
        try {
            Response response = restClient.getApi().searchPaginated("yellow", "photo", 1, 10).execute();
            System.out.println("resp");
            Result result = (Result) response.body();

            System.out.println(result.getHits().size());
            assertEquals(10, result.getHits().size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}