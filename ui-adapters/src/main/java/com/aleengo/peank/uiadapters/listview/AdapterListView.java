package com.aleengo.peank.uiadapters.listview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.aleengo.peank.uiadapters.AdapterBase;
import com.aleengo.peank.uiadapters.ItemView;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import lombok.Getter;

/**
 * Copyright Aleengo 2019. All rights reserved.
 * Created by bau.cj on 22/06/2019.
 */
public abstract class AdapterListView<E, ITEMVIEW extends ItemView<E>> extends BaseAdapter
        implements AdapterBase<E> {

    @Getter
    private Context context;
    private final List<E> items;
    private final List<E> mOriginalList;

    public AdapterListView(Context context) {
       this(context, new LinkedList<E>());
    }

    public AdapterListView(Context context, List<E> items) {
        this.context = context;
        this.items = items;
        this.mOriginalList =  new LinkedList<E>();
    }

    protected abstract ITEMVIEW instantiateItemView(ViewGroup parent, int viewType);

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ITEMVIEW iv;

        if (convertView == null) {
            final int viewType = getItemViewType(position);
            // inflate
            iv = instantiateItemView(parent, viewType);
            convertView = iv.get();
        }
        iv = (ITEMVIEW) new ItemView<E>(convertView);
        final E item = (E) getItem(position);
        iv.bind(item, position);
        return convertView;
    }

    @Override
    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    @Override
    public List<E> getOriginalList() {
        return new LinkedList<>(mOriginalList);
    }

    @Override
    public int getItemPosition(E item) {
        for (E e : items) {
            if (e.equals(item)) return items.indexOf(e);
        }
        return NO_POSITION;
    }

    @Override
    public void addItem(E item) {
        items.add(item);
        notifyDataSetChanged();
    }

    @Override
    public void addItem(int position, E item) {
        items.add(position, item);
        notifyDataSetChanged();
    }

    @Override
    public void removeItem(int position) {
        items.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public void updateItem(int position, E item) {
        items.set(position, item);
        notifyDataSetChanged();
    }

    @Override
    public void addItems(Collection<E> collection) {
        addItems(collection, false);
    }

    @Override
    public void addItems(Collection<E> collection, boolean extend) {
        int count  = getCount();

        if (count == 0) {
            mOriginalList.addAll(collection);
        }

        if (!extend) {
            items.clear();
            count = 0;
        }
        items.addAll(count, collection);
        notifyDataSetChanged();
    }
}
