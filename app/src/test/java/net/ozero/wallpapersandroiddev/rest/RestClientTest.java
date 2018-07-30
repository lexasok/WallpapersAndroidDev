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
    }
}