package com.aleengo.peank.core.event;

import android.view.View;

/**
 * Copyright (c) Aleengo, 2019. All rights reserved.
 * Created by bau.cj on 27/06/2019.
 */
public interface ActionListener {

    /**
     * @return the name of the action; it can be any value
     */
    String action();

    /**
     * Action to perfom when an event occurs
     * @param source
     */
    void actionPerformed(View source);
}
