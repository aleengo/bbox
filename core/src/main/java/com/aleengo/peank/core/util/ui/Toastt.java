package com.aleengo.peank.core.util.ui;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.StringRes;

/**
 * Copyright (c) Aleengo, 2019. All rights reserved.
 * Created by bau.cj on 03/06/2019.
 */
public final class Toastt {

    private Toastt() {
        throw new AssertionError("No instance");
    }

    public static void i(Context context, @StringRes int resId) {
        //toast(context, resId, Toastt.LENGTH_SHORT);
    }

    public static void s(Context context, String message) {
        //toast(context, message, Toastt.LENGTH_SHORT);
    }

    public static void w(Context context, @StringRes int resId, int duration) {
        Toast.makeText(context, resId, duration).show();
    }

    public static void e(Context context, String message, int duration) {
       Toast.makeText(context, message, duration).show();
    }
}
