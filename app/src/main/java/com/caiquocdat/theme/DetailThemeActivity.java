package com.caiquocdat.theme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import com.caiquocdat.theme.data.DataGenerator;
import com.caiquocdat.theme.databinding.ActivityDetailThemeBinding;
import com.caiquocdat.theme.databinding.ActivityHomeBinding;
import com.caiquocdat.theme.databinding.ActivityThemeBinding;
import com.caiquocdat.theme.model.ThemeModel;

import java.io.IOException;
import java.util.ArrayList;

public class DetailThemeActivity extends AppCompatActivity {
    private ActivityDetailThemeBinding activityDetailThemeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDetailThemeBinding = ActivityDetailThemeBinding.inflate(getLayoutInflater());
        View view = activityDetailThemeBinding.getRoot();
        setContentView(view);
        hideSystemUI();
        setUpImgTheme();
        activityDetailThemeBinding.downloadImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpTheme();
                Intent intent = new Intent(DetailThemeActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

    }

    private void setUpImgTheme() {
        activityDetailThemeBinding.themeImg.setImageDrawable(getDrawableTheme());
    }

    Drawable getDrawableTheme(){
        Intent intent= getIntent();
        int potition=intent.getIntExtra("potition",0);
        DataGenerator.initializeData(this);
        ArrayList<ThemeModel> themeModels = DataGenerator.getThemeModels();
        Drawable drawable = themeModels.get(potition).getDetailDrawable();
        return drawable;
    }
    void setUpTheme(){
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        Point size = new Point();
        display.getRealSize(size);
        int width = size.x;
        int height = size.y;
        Log.d("Test_1", "width: "+width+", height: "+height);

        Bitmap bitmap = ((BitmapDrawable) getDrawableTheme()).getBitmap();
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, 800, 600, true);

        WallpaperManager wallpaperManager = WallpaperManager.getInstance(DetailThemeActivity.this);
        try {
            wallpaperManager.setBitmap(scaledBitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void hideSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
    @Override
    protected void onResume() {
        hideSystemUI();
        super.onResume();
    }
}