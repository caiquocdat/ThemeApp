package com.caiquocdat.theme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.caiquocdat.theme.adapter.ThemeAdapter;
import com.caiquocdat.theme.data.DataGenerator;
import com.caiquocdat.theme.databinding.ActivityHomeBinding;
import com.caiquocdat.theme.databinding.ActivityThemeBinding;
import com.caiquocdat.theme.model.ThemeModel;

import java.util.ArrayList;
import java.util.List;

public class ThemeActivity extends AppCompatActivity {
    private ActivityThemeBinding themeBinding;
    private ThemeAdapter themeAdapter;
    private ThemeModel themeModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        themeBinding = ActivityThemeBinding.inflate(getLayoutInflater());
        View view = themeBinding.getRoot();
        setContentView(view);
        hideSystemUI();
        setUpRcv();
        themeBinding.themeRcv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                themeBinding.contentEdt.clearFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(themeBinding.contentEdt.getWindowToken(), 0);
                return false;
            }
        });
        themeBinding.seeAllImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent= new Intent(HomeActivity.this,BuildClockActivity.class);
//                startActivity(intent);
                Intent intent= new Intent(ThemeActivity.this, DetailThemeActivity.class);
                intent.putExtra("potition",8);
                startActivity(intent);
            }
        });

        themeBinding.contentEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ArrayList<ThemeModel> filteredList=null;
                String searchText = themeBinding.contentEdt.getText().toString();
                if(searchText.isEmpty()){
                   setUpRcv();
                }else {
                    if (filterThemesByTitle(themeBinding.contentEdt.getText().toString()).size() > 0) {
                        filteredList = filterThemesByTitle(searchText);
                        themeAdapter= new ThemeAdapter(ThemeActivity.this,filteredList);
                        themeBinding.themeRcv.setLayoutManager(new GridLayoutManager(ThemeActivity.this, 2));
                        themeBinding.themeRcv.setAdapter(themeAdapter);
                    } else {
                        filteredList= new ArrayList<>();
                        themeAdapter= new ThemeAdapter(ThemeActivity.this,filteredList);
                        themeBinding.themeRcv.setLayoutManager(new GridLayoutManager(ThemeActivity.this, 2));
                        themeBinding.themeRcv.setAdapter(themeAdapter);
                    }
                }
            }
        });
        themeBinding.backRel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ThemeActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });
    }
    public ArrayList<ThemeModel> filterThemesByTitle(String search) {
        ArrayList<ThemeModel> themeModels = DataGenerator.getThemeModels();
        ArrayList<ThemeModel> result = new ArrayList<>();

        for (ThemeModel themeModel : themeModels) {
            if (themeModel.getTitle().toLowerCase().contains(search.toLowerCase())) {
                result.add(themeModel);
            }
        }

        return result;
    }

    private void setUpRcv() {
        DataGenerator.initializeData(this);
        ArrayList<ThemeModel> themeModels = DataGenerator.getThemeModels();
        themeAdapter= new ThemeAdapter(ThemeActivity.this,themeModels);
        themeBinding.themeRcv.setLayoutManager(new GridLayoutManager(this, 2));
        themeBinding.themeRcv.setAdapter(themeAdapter);

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
    @Override
    public void onBackPressed() {

    }
}