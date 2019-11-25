package com.example.likeapp.models;

import android.graphics.Color;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SwipeRightViewModel extends ViewModel {
    private MutableLiveData<SwipeRightModel> stream = new MutableLiveData<>();

    private int currentIndex = 0;

    private SwipeRightCardModel[] data = {
            new SwipeRightCardModel(Color.parseColor("red")),
            new SwipeRightCardModel(Color.parseColor("blue")),
            new SwipeRightCardModel(Color.parseColor("green"))
    };

    private SwipeRightCardModel topCard;

    private SwipeRightCardModel bottomCard;

    public SwipeRightCardModel getBottomCard() {
        return data[currentIndex + 1];
    }

    public SwipeRightCardModel getTopCard() {
        return data[currentIndex];
    }

    public SwipeRightViewModel(){
        topCard = getTopCard();
        bottomCard = getBottomCard();
        updateStream();
    }

    public void swipe(){
        currentIndex++;
        updateStream();
    }

    public LiveData<SwipeRightModel> getStream() {
        return stream;
    }

    private void updateStream(){
        stream.postValue(new SwipeRightModel(getTopCard(), getBottomCard()));
    }
}
