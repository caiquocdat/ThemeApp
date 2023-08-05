package com.caiquocdat.theme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.caiquocdat.theme.databinding.ActivityHomeBinding;
import com.caiquocdat.theme.databinding.ActivityMainBinding;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding homeBinding;
    private String check = "false";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = homeBinding.getRoot();
        setContentView(view);
        hideSystemUI();
        homeBinding.item2Rel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent= new Intent(HomeActivity.this,BuildClockActivity.class);
//                startActivity(intent);
                Intent intent = new Intent(HomeActivity.this, DetailThemeActivity.class);
                intent.putExtra("potition", 7);
                startActivity(intent);
            }
        });
        homeBinding.moreImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent= new Intent(HomeActivity.this,BuildClockActivity.class);
//                startActivity(intent);
                if (check.equals("false")) {
                    homeBinding.showMoreLinear.setVisibility(View.VISIBLE);
                    check="true";
                }else{
                    homeBinding.showMoreLinear.setVisibility(View.GONE);
                    check="false";
                }
            }
        });
        homeBinding.seeAllImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent= new Intent(HomeActivity.this,BuildClockActivity.class);
//                startActivity(intent);
                Intent intent = new Intent(HomeActivity.this, DetailThemeActivity.class);
                intent.putExtra("potition", 8);
                startActivity(intent);
            }
        });
        homeBinding.backRel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        homeBinding.item1Rel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ThemeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void hideSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
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

    @Override
    public void onBackPressed() {

    }
}