package com.aleengo.peank.uiadapters.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;


/**
 * Copyright Aleengo 2019. All rights reserved.
 * Created by bau.cj on 22/06/2019.
 */

public abstract class ItemView<E> {

    private final View itemView;

    public ItemView(ViewGroup parent, @LayoutRes int id) {
       this(parent, id, false);
    }

    public ItemView(ViewGroup parent, @LayoutRes int id, boolean attachToRoot) {
        this(LayoutInflater.from(parent.getContext()).inflate(id, parent, attachToRoot));
    }

    public ItemView(View view) {
        this.itemView = view;
    }

    public View get() {
        return itemView;
    }

    public abstract void bind(E item, int position);

}
