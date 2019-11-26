package com.example.likeapp.models;

import android.graphics.Color;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SwipeRightViewModel extends ViewModel {

    private static SwipeRightViewModel instance;

    private MutableLiveData<SwipeRightModel> stream = new MutableLiveData<>();

    private int currentIndex = 0;

    private ArrayList<SwipeRightCardModel> data = new ArrayList<>();

    private SwipeRightCardModel topCard;

    private SwipeRightCardModel bottomCard;

    public static SwipeRightViewModel getInstance() {
        if(instance == null){
            instance = new SwipeRightViewModel();
        }
        return instance;
    }

    public SwipeRightCardModel getBottomCard() {
        return data.get((currentIndex + 1) % data.size());
    }

    public SwipeRightCardModel getTopCard() {
        return data.get(currentIndex % data.size());
    }

    private SwipeRightViewModel(){

        if(data.size() == 0){
            for (int i = 0; i < 10; i++) {
                data.add(new SwipeRightCardModel("https://picsum.photos/1080/1920"));
            }
        }

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
