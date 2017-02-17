package com.mindorks.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.mindorks.butterknifelite.ButterKnifeLite;
import com.mindorks.butterknifelite.annotations.BindView;
import com.mindorks.butterknifelite.annotations.OnClick;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.listeners.ItemRemovedListener;
import com.mindorks.test.swipe.TinderCardWithDirection;

public class ActivityTinderWithDirection extends AppCompatActivity {

    private static final String TAG = "ActivityTinder";

    @BindView(R.id.swipeView)
    private SwipePlaceHolderView mSwipView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinder_swipe);
        ButterKnifeLite.bind(this);

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mSwipView.addItemRemoveListener(new ItemRemovedListener() {

            @Override
            public void onItemRemoved(int count) {
                Log.d(TAG, "onItemRemoved: " + count);
                if (count == 0) {
                    mSwipView.addView(new TinderCardWithDirection())
                            .addView(new TinderCardWithDirection())
                            .addView(new TinderCardWithDirection())
                            .addView(new TinderCardWithDirection())
                            .addView(new TinderCardWithDirection())
                            .addView(new TinderCardWithDirection())
                            .addView(new TinderCardWithDirection())
                            .addView(new TinderCardWithDirection())
                            .addView(new TinderCardWithDirection())
                            .addView(new TinderCardWithDirection());
                }
            }
        });
        mSwipView.getBuilder()
//                .setSwipeType(SwipePlaceHolderView.SWIPE_TYPE_VERTICAL)
                .setDisplayViewCount(3)
                .setIsUndoEnabled(true)
                .setSwipeVerticalThreshold(Utils.dpToPx(50))
                .setSwipeHorizontalThreshold(Utils.dpToPx(50))
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.tinder_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.tinder_swipe_out_msg_view));

        mSwipView.addView(new TinderCardWithDirection())
                .addView(new TinderCardWithDirection())
                .addView(new TinderCardWithDirection())
                .addView(new TinderCardWithDirection())
                .addView(new TinderCardWithDirection())
                .addView(new TinderCardWithDirection())
                .addView(new TinderCardWithDirection())
                .addView(new TinderCardWithDirection())
                .addView(new TinderCardWithDirection())
                .addView(new TinderCardWithDirection());
    }

    @OnClick(R.id.rejectBtn)
    private void onRejectClick() {
        mSwipView.doSwipe(false);
    }

    @OnClick(R.id.acceptBtn)
    private void onAcceptClick() {
        mSwipView.doSwipe(true);
    }

    @OnClick(R.id.undoBtn)
    private void onUndoClick() {
        mSwipView.undoLastSwipe();
    }
}
