package com.caiquocdat.theme.model;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class ThemeModel {
    private int id;
    private String title;
    private Drawable drawable;
    private Drawable detailDrawable;

    public ThemeModel(int id, String title, Drawable drawable, Drawable detailDrawable) {
        this.id = id;
        this.title = title;
        this.drawable = drawable;
        this.detailDrawable = detailDrawable;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public Drawable getDetailDrawable() {
        return detailDrawable;
    }

    public void setDetailDrawable(Drawable detailDrawable) {
        this.detailDrawable = detailDrawable;
    }
}
