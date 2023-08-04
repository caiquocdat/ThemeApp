package com.caiquocdat.theme.data;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.caiquocdat.theme.R;
import com.caiquocdat.theme.model.ThemeModel;

import java.util.ArrayList;

public class DataGenerator {
    private static ArrayList<ThemeModel> themeModels;

    public static void initializeData(Context context) {
        themeModels = new ArrayList<>();

        Drawable drawable_1 = context.getResources().getDrawable(R.drawable.img_theme_1);
        Drawable drawable_2 = context.getResources().getDrawable(R.drawable.img_theme_2);
        Drawable drawable_3 = context.getResources().getDrawable(R.drawable.img_theme_3);
        Drawable drawable_4 = context.getResources().getDrawable(R.drawable.img_theme_4);
        Drawable drawable_5 = context.getResources().getDrawable(R.drawable.img_theme_5);
        Drawable drawable_6 = context.getResources().getDrawable(R.drawable.img_theme_6);
        Drawable detailDrawable_1 = context.getResources().getDrawable(R.drawable.img_detail_1);
        Drawable detailDrawable_2 = context.getResources().getDrawable(R.drawable.img_detail_2);
        Drawable detailDrawable_3 = context.getResources().getDrawable(R.drawable.img_detail_3);
        Drawable detailDrawable_4 = context.getResources().getDrawable(R.drawable.img_detail_4);
        Drawable detailDrawable_5 = context.getResources().getDrawable(R.drawable.img_detail_5);
        Drawable detailDrawable_6 = context.getResources().getDrawable(R.drawable.img_detail_6);
        // Add more drawables as needed

        themeModels.add(new ThemeModel(1, "Luxury", drawable_1,detailDrawable_1));
        themeModels.add(new ThemeModel(2, "Classic", drawable_2,detailDrawable_2));
        themeModels.add(new ThemeModel(3, "Fiction", drawable_3,detailDrawable_3));
        themeModels.add(new ThemeModel(4, "Hourglass", drawable_4,detailDrawable_4));
        themeModels.add(new ThemeModel(5, "Modern", drawable_5,detailDrawable_5));
        themeModels.add(new ThemeModel(6, "Recall", drawable_6,detailDrawable_6));
        // Add more theme models as needed
    }

    public static ArrayList<ThemeModel> getThemeModels() {
        return themeModels;
    }
}
