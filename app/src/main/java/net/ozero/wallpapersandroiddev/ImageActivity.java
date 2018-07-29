package net.ozero.wallpapersandroiddev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ImageActivity extends AppCompatActivity {

    private String imageURL = "";
    private String pageURL = "";
    private String wallpaperURL = "";
    private ImageView imageView;
    private TextView textView;
    private TextView setWallpaperButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        imageView = findViewById(R.id.imageViewImageActivity);
        textView = findViewById(R.id.imageInfoTextView);
        setWallpaperButton = findViewById(R.id.setWallpapersButton);

        if (getIntent().hasExtra(App.EXTRA_IMAGE)) {

            imageURL = getIntent().getStringExtra(App.EXTRA_IMAGE);
            pageURL = getIntent().getStringExtra(App.EXTRA_URL);
            wallpaperURL = getIntent().getStringExtra(App.EXTRA_WALLPAPER);

            Glide
                    .with(this)
                    .load(wallpaperURL)
                    .into(imageView);

            textView.setText(pageURL);
        }
    }
}
