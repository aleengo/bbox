package com.aleengo.peank.uiadapters;


import java.util.Collection;
import java.util.List;

/**
 * Copyright Aleengo 2019. All rights reserved.
 * Created by bau.cj on 22/06/2019.
 */
public interface AdapterBase<E> {

    int NO_POSITION = -1;

    void clear();

    List<E> getOriginalList();

    int getItemPosition(final E item);
    void addItem(E item);
    void addItem(int position, E item);
    void removeItem(int position);
    void updateItem(int position, E item);
    void addItems(Collection<E> collection);
    void addItems(Collection<E> collection, boolean extend);

}
