package com.aleengo.peank.uiadapters.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;

import lombok.Getter;


/**
 * Copyright Aleengo 2019. All rights reserved.
 * Created by bau.cj on 22/06/2019.
 */

public abstract class ViewItemBase<E> {

    @Getter
    private final Context context;
    protected final View itemView;

    public ViewItemBase(ViewGroup parent, @LayoutRes int id) {
       this(parent, id, false);
    }

    public ViewItemBase(ViewGroup parent, @LayoutRes int id, boolean attachToRoot) {
        this(LayoutInflater.from(parent.getContext()).inflate(id, parent, attachToRoot));
    }

    public ViewItemBase(View view) {
        this.itemView = view;
        this.context = view.getContext();
    }

    public View get() {
        return itemView;
    }

    public abstract void bind(E item, int position);

}
