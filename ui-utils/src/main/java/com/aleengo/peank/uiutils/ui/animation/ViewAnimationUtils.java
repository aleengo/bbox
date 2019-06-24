package com.aleengo.peank.uiutils.ui.animation;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;

import com.aleengo.peank.uiutils.ui.util.DisplayMetricsUtils;

/**
 * Copyright 2019 Aleengo. All rights reserved.
 * Created by bau.cj on 08/06/2019.
 */
public final class ViewAnimationUtils {

    private ViewAnimationUtils() {}

    public static void expand(final View target, final Animation.AnimationListener animationListener) {

        final int initialHeight = target.getMeasuredHeight();

        // 1. expand the view
        target.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        target.getLayoutParams().height = 0;
        target.setVisibility(View.VISIBLE);

        final Animation animation = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    target.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
                    return;
                }
                target.getLayoutParams().height = (int) (initialHeight * interpolatedTime);
                target.requestLayout();
            }
        };

        final float density = DisplayMetricsUtils.getDisplayMetrics(target).density;
        animation.setDuration((int) (initialHeight / density));

        if (animationListener != null) {
            // 2. add listener to animation
            animation.setAnimationListener(animationListener);
        }
        target.startAnimation(animation);
    }

    public static void collapse(final View target) {

        final int initialHeight = target.getMeasuredHeight();

        final Animation animation = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    target.setVisibility(View.GONE);
                    return;
                }

                final int curHeight = (int) interpolatedTime * initialHeight;
                 target.getLayoutParams().height = initialHeight - curHeight;
                 target.requestLayout();
            }
        };

        final float density = DisplayMetricsUtils.getDisplayMetrics(target).density;
        final int duration = (int) (initialHeight / density);
        animation.setDuration(duration);
        target.startAnimation(animation);
    }

}
