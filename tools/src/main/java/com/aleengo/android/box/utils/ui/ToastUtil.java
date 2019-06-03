package com.aleengo.android.box.utils.ui;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.StringRes;

/**
 * Copyright (c) Aleengo, 2019. All rights reserved.
 * Created by bau.cj on 03/06/2019.
 */
public final class ToastUtil {

    private ToastUtil() {}

    public static void toast(Context context, @StringRes int resId) {
        toast(context, resId, Toast.LENGTH_SHORT);
    }

    public static void toast(Context context, String message) {
        toast(context, message, Toast.LENGTH_SHORT);
    }

    public static void toast(Context context, @StringRes int resId, int duration) {
        Toast.makeText(context, resId, duration).show();
    }

    public static void toast(Context context, String message, int duration) {
        Toast.makeText(context, message, duration).show();
    }
}
