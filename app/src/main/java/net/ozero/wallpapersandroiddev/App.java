package net.ozero.wallpapersandroiddev;

import android.app.Application;

import net.ozero.wallpapersandroiddev.rest.RestClient;

public class App extends Application {

    private static RestClient restClient;

    @Override
    public void onCreate() {
        super.onCreate();

        restClient = new RestClient();
    }
}
