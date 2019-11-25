package com.example.likeapp.models;

public class SwipeRightModel {

    private SwipeRightCardModel top;
    private SwipeRightCardModel bottom;

    public SwipeRightModel(SwipeRightCardModel top, SwipeRightCardModel bottom) {
        this.top = top;
        this.bottom = bottom;
    }

    public SwipeRightCardModel getBottom() {
        return bottom;
    }

    public void setBottom(SwipeRightCardModel bottom) {
        this.bottom = bottom;
    }

    public SwipeRightCardModel getTop() {
        return top;
    }

    public void setTop(SwipeRightCardModel top) {
        this.top = top;
    }
}
