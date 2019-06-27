package com.aleengo.peank.core.event;

import android.view.View;

/**
 * Copyright (c) Aleengo, 2019. All rights reserved.
 * Created by bau.cj on 27/06/2019.
 */
public interface ActionListener {

    String action();
    void actionPerformed(View source);
}
