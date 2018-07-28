package net.ozero.wallpapersandroiddev;

import android.app.Application;

import net.ozero.wallpapersandroiddev.rest.RestClient;

public class App extends Application {

    public static final String API_KEY = "9667021-21784dd25c2c815960cdbbd86";

    private static RestClient restClient;

    @Override
    public void onCreate() {
        super.onCreate();

        restClient = new RestClient();
    }


    //getters
    public static String getApiKey() {
        return API_KEY;
    }

    public static RestClient getRestClient() {
        return restClient;
    }
}
