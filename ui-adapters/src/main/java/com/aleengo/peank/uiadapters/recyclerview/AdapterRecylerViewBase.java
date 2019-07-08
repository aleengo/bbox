package com.aleengo.peank.uiadapters.recyclerview;

import com.aleengo.peank.uiadapters.AdapterBase;

/**
 * Copyright (c) Aleengo, 2019. All rights reserved.
 * Created by bau.cj on 08/07/2019.
 */
public interface AdapterRecylerViewBase<E> extends AdapterBase<E> {
    E getItem(int position);
}
