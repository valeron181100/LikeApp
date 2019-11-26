package com.example.likeapp;


import android.os.Build;
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
import android.widget.ImageView;

import com.example.likeapp.models.SwipeRightModel;
import com.example.likeapp.models.SwipeRightViewModel;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

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

        mTopCard = v.findViewById(R.id.topCard);
        mBottomCard = v.findViewById(R.id.bottomCard);
        mMotionLayout = v.findViewById(R.id.motionLayout);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mTopCard.setClipToOutline(true);
            mBottomCard.setClipToOutline(true);
        }

        final SwipeRightViewModel swipeRightViewModel = SwipeRightViewModel.getInstance();

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

        Picasso.with(this.getContext()).load(model.getTop().getMainImageLink())
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .networkPolicy(NetworkPolicy.NO_STORE)
                .memoryPolicy(MemoryPolicy.NO_STORE)
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .into((ImageView) mTopCard.getChildAt(0));

        Picasso.with(this.getActivity()).load(model.getBottom().getMainImageLink())
                .networkPolicy(NetworkPolicy.NO_CACHE)
                .networkPolicy(NetworkPolicy.NO_STORE)
                .memoryPolicy(MemoryPolicy.NO_STORE)
                .memoryPolicy(MemoryPolicy.NO_CACHE)
                .into((ImageView) mBottomCard.getChildAt(0));
//        mTopCard.setBackgroundColor(model.getTop().getBackgroundColor());
//        mBottomCard.setBackgroundColor(model.getBottom().getBackgroundColor());
    }

}
