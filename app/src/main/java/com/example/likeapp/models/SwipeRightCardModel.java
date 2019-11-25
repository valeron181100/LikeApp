package com.example.likeapp.models;

import androidx.annotation.ColorInt;

public class SwipeRightCardModel {

    @ColorInt
    private int backgroundColor;

    public SwipeRightCardModel(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
}
