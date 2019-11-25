package com.example.likeapp;


import android.os.Bundle;

import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.likeapp.models.SwipeRightModel;
import com.example.likeapp.models.SwipeRightViewModel;

public class CardFragment extends Fragment {

    private FrameLayout mTopCard;
    private FrameLayout mBottomCard;
    private MotionLayout mMotionLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_card, container, false);

        final SwipeRightViewModel swipeRightViewModel = ViewModelProviders.of(this).get(SwipeRightViewModel.class);

        swipeRightViewModel.getStream().observe(this, new Observer<SwipeRightModel>() {
            @Override
            public void onChanged(SwipeRightModel swipeRightModel) {
                bind(swipeRightModel);
            }
        });

        mMotionLayout.setTransitionListener(new MotionLayout.TransitionListener() {
            @Override
            public void onTransitionStarted(MotionLayout motionLayout, int i, int i1) {

            }

            @Override
            public void onTransitionChange(MotionLayout motionLayout, int i, int i1, float v) {

            }

            @Override
            public void onTransitionCompleted(MotionLayout motionLayout, int i) {
                switch (i){
                    case R.id.offScreenPass:
                    case R.id.offScreenLike:
                        motionLayout.setProgress(0f);
                        motionLayout.setTransition(R.id.rest, R.id.like);
                        swipeRightViewModel.swipe();
                    break;
                }
            }

            @Override
            public void onTransitionTrigger(MotionLayout motionLayout, int i, boolean b, float v) {

            }
        });




        return v;
    }

    private void bind(SwipeRightModel model){
        mTopCard.setBackgroundColor(model.getTop().getBackgroundColor());
        mBottomCard.setBackgroundColor(model.getBottom().getBackgroundColor());
    }

}
