package net.ozero.wallpapersandroiddev;

import android.app.Application;

import net.ozero.wallpapersandroiddev.rest.RestClient;

public class App extends Application {

    //constants
    public static final String API_KEY = "9667021-21784dd25c2c815960cdbbd86";
    public static final String COLOR_NONE = "none";
    public static final String CATEGORY_BEST = "best";
    public static final int NUM_OF_COLUMNS = 2;
    public static final int FIRST_PAGE = 1;

    //Extras
    public static final String EXTRA_SEARCH = "search";
    public static final String EXTRA_IMAGE = "image";
    public static final String EXTRA_URL = "URL";
    public static final String EXTRA_WALLPAPER = "wallpaper";

    private static RestClient restClient;

    @Override
    public void onCreate() {
        super.onCreate();

        restClient = new RestClient();
    }


    //getters
    public static RestClient getRestClient() {
        return restClient;
    }
}
