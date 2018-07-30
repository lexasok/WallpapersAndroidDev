package net.ozero.wallpapersandroiddev;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.WallpaperManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Looper;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

    //views
    private ImageView imageView;
    private TextView link;
    private TextView setWallpaperButton;
    private LinearLayout alertLinearLayout;
    private TextView confirmButton;
    private TextView discardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        //inti views
        imageView = findViewById(R.id.imageViewImageActivity);
        link = findViewById(R.id.imageInfoTextView);
        setWallpaperButton = findViewById(R.id.setWallpapersButton);
        alertLinearLayout = findViewById(R.id.alertLinearLayout);
        confirmButton = findViewById(R.id.confirmButton);
        discardButton = findViewById(R.id.discardButton);

        //init alert buttons
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setWallpaper();
                closeAlertMenu();
            }
        });
        discardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeAlertMenu();
            }
        });

        if (getIntent().hasExtra(App.EXTRA_IMAGE)) {

            //getting data
            imageURL = getIntent().getStringExtra(App.EXTRA_IMAGE);
            pageURL = getIntent().getStringExtra(App.EXTRA_URL);
            wallpaperURL = getIntent().getStringExtra(App.EXTRA_WALLPAPER);

            //loading preview
            Glide
                    .with(this)
                    .load(imageURL)
                    .into(imageView);

            link.setText(pageURL);

            //setting wallpaper
            setWallpaperButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showAlertMenu();
                }
            });

            link.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            //open source link
            link.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(pageURL));
                    startActivity(browserIntent);
                }
            });
        }
    }

    private void setWallpaper() {
        Glide
                .with(getApplicationContext())
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
        Toast
                .makeText(
                        getApplicationContext(),
                        getResources().getString(R.string.toast_wallpaper_set),
                        Toast.LENGTH_LONG
                ).show();
    }

    private void showAlertMenu() {
        alertLinearLayout.setVisibility(View.VISIBLE);
        setWallpaperButton.setText(getResources().getString(R.string.title_alert));
    }

    private void closeAlertMenu() {
        alertLinearLayout.setVisibility(View.GONE);
        setWallpaperButton.setText(getResources().getString(R.string.title_set_wallpaper_button));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
