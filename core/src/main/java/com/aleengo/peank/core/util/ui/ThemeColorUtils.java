package com.aleengo.peank.core.util.ui;

import android.content.Context;
import android.util.TypedValue;

import androidx.core.content.ContextCompat;

import com.aleengo.peank.core.R;

/**
 * Copyright (c) Aleengo, 2019. All rights reserved.
 * Created by bau.cj on 19/06/2019.
 */
public final class ThemeColorUtils {

    private ThemeColorUtils() {
        throw new AssertionError(ThemeColorUtils.class.getSimpleName() +
                " : No instanciates");
    }

    public static int getThemeColorPrimary(final Context context) {
        return getThemeColorAttributes(context, R.attr.colorPrimary);
    }

    public static int getThemeColorPrimaryDark(final Context context) {
        return getThemeColorAttributes(context, R.attr.colorPrimaryDark);
    }

    public static int getThemeColorAccent(final Context context) {
        return getThemeColorAttributes(context, R.attr.colorAccent);
    }

    private static int getThemeColorAttributes(final Context context, final int resId) {

        int color = ContextCompat.getColor(context, android.R.color.holo_green_light);

        final TypedValue value = new TypedValue();

        final boolean resolved = context.getTheme().resolveAttribute(resId, value, true);

        if (resolved) {

            if ( value.type == TypedValue.TYPE_REFERENCE ) {
                color = ContextCompat.getColor(context, value.resourceId);
            }

            else if ( value.type == TypedValue.TYPE_INT_COLOR_RGB8 ||
                    value.type == TypedValue.TYPE_INT_COLOR_RGB4 ) {
                color = value.data;
            }
        }
        return color;
    }
}
