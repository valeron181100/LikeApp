package com.example.likeapp.models;


import android.graphics.Bitmap;

public class SwipeRightCardModel {

    private String mainImageLink;

    public SwipeRightCardModel(String mainImageLink) {
        this.mainImageLink = mainImageLink;
    }

    public String getMainImageLink() {
        return mainImageLink;
    }

    public void setMainImageLink(String mainImageLink) {
        this.mainImageLink = mainImageLink;
    }
}
