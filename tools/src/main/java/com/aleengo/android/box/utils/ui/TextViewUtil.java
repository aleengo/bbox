package com.aleengo.android.box.utils.ui;

import android.widget.TextView;

/**
 * Copyright (c) Aleengo, 2019. All rights reserved.
 * Created by bau.cj on 03/06/2019.
 */
public final class TextViewUtil {

    private TextViewUtil() {}

    public static String getString(final TextView view) {
        return view != null ? view.getText().toString() : null;
    }
}
