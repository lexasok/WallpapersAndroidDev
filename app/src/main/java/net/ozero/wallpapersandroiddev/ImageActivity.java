package net.ozero.wallpapersandroiddev;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Looper;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.ExecutionException;

public class ImageActivity extends AppCompatActivity {

    private String imageURL = "";
    private String pageURL = "";
    private String wallpaperURL = "";
    private ImageView imageView;
    private TextView link;
    private TextView setWallpaperButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        imageView = findViewById(R.id.imageViewImageActivity);
        link = findViewById(R.id.imageInfoTextView);
        setWallpaperButton = findViewById(R.id.setWallpapersButton);

        if (getIntent().hasExtra(App.EXTRA_IMAGE)) {

            imageURL = getIntent().getStringExtra(App.EXTRA_IMAGE);
            pageURL = getIntent().getStringExtra(App.EXTRA_URL);
            wallpaperURL = getIntent().getStringExtra(App.EXTRA_WALLPAPER);

            Glide
                    .with(this)
                    .load(wallpaperURL)
                    .into(imageView);

            link.setText(pageURL);

            setWallpaperButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Glide.with(getApplicationContext())
                            .asBitmap()
                            .load(wallpaperURL)
                            .into(new SimpleTarget<Bitmap>() {
                                @Override
                                public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                                    WallpaperManager wallpaperManager
                                            = WallpaperManager.getInstance(getApplicationContext());
                                    try {
                                        wallpaperManager.setBitmap(resource);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                }
            });

            link.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
