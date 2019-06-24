package com.aleengo.peank.uiadapters.recyclerview;


import android.view.MenuItem;
import android.view.View;

import java.util.Collection;

/**
 * Copyright Aleengo 2019. All rights reserved.
 * Created by bau.cj on 22/06/2019.
 */
public interface AdapterBase<E> {

    interface OnItemClickListener<T> {
        void onItemClick(View view, T obj, int position);
    }

    interface OnMoreButtonClickListener<T> {
        void onItemClick(View view, T obj, MenuItem item);
    }

    interface OnItemLongClickListener<T> {
        void onItemLongClick(View view, T obj, int position);
    }

    void clear();
    E getItem(int position);
    void addItem(E item);
    void addItem(int position, E item);
    void removeItem(int position);
    void updateItem(int position, E item);
    void addItems(Collection<E> collection);

}
