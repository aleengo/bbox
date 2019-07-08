package com.aleengo.peank.uiadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;

import lombok.Getter;

/**
 * Copyright (c) Aleengo, 2019. All rights reserved.
 * Created by bau.cj on 08/07/2019.
 */
public class ItemView<E> implements ItemViewBase<E> {

    @Getter
    private final Context context;
    protected final View view;

    public ItemView(ViewGroup parent, @LayoutRes int id) {
        this(parent, id, false);
    }

    public ItemView(ViewGroup parent, @LayoutRes int id, boolean attachToRoot) {
        this(LayoutInflater.from(parent.getContext()).inflate(id, parent, attachToRoot));
    }

    public ItemView(View view) {
        this.view = view;
        this.context = view.getContext();
    }

    public View get() {
        return view;
    }

    @Override
    public void bind(E item, int position) {
        // default implementation
        // noop
    }
}
