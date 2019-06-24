package com.aleengo.peank.uiutils.ui.util;

import android.util.DisplayMetrics;
import android.view.View;

/**
 * Copyright 2019 Aleengo. All rights reserved.
 * Created by bau.cj on 08/06/2019.
 */
public final class DisplayMetricsUtils {

    private DisplayMetricsUtils(){
        throw new AssertionError(DisplayMetricsUtils.class.getSimpleName() +
                " cannot be instanciated");
    }

    public static DisplayMetrics getDisplayMetrics(final View target) {
        return target.getContext().getResources().getDisplayMetrics();
    }
}
