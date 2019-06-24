package com.aleengo.peank.uiadapters.recyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import lombok.Getter;

import static android.view.View.NO_ID;

/**
 * Copyright Aleengo 2019. All rights reserved.
 * Created by bau.cj on 22/06/2019.
 */
public abstract class AdapterRecyclerView<E, ITEMVIEW extends ItemView<E>>
        extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder>
        implements AdapterBase<E> {

    @Getter
    private Context context;
    private final List<E> items;
    private final List<E> mOriginalList;

    @Getter
    private OnItemClickListener onItemClickListener;
    @Getter
    private OnItemLongClickListener onItemLongClickListener;
    @Getter
    private OnMoreButtonClickListener onMoreButtonClickListener;

    public AdapterRecyclerView(Context context) {
        this(context, new LinkedList<E>());
    }

    public AdapterRecyclerView(Context context, List<E> items) {
        this.context = context;
        this.items = items;
        mOriginalList = items;
    }

    public List<E> getOriginalList() {
        final List<E> copy = new LinkedList<>();
        copy.addAll(mOriginalList);
        return copy;
    }

    @NonNull
    @Override
    public AdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final ITEMVIEW itemview = onCreateItemView(parent, viewType);
        return new ViewHolder(itemview);
    }

    public abstract ITEMVIEW onCreateItemView(ViewGroup parent, int viewType);

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public E getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getItemPosition(final E item) {
        final int count = getItemCount();

        for (int pos = 0; pos < count; pos++) {
            final E e = items.get(pos);
            if (!e.equals(item)) continue;
            return pos;
        }
        return RecyclerView.NO_POSITION;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public void clear() {
        final int oldSize = getItemCount();
        items.clear();
        notifyItemRangeChanged(getItemCount(), oldSize);
    }

    @Override
    public void addItem(E item) {
        items.add(item);
        notifyItemInserted(getItemCount() - 1);
    }

    @Override
    public void addItem(int position, E item) {
        items.add(position, item);
        notifyItemInserted(position);
    }

    @Override
    public void removeItem(int position) {
        items.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public void updateItem(int position, E item) {
        items.set(position, item);
        notifyItemChanged(position);
    }

    @Override
    public void addItems(Collection<E> newItems) {
        final int oldSize = getItemCount();

        if (oldSize == 0) {
            mOriginalList.addAll(newItems);
        }
        items.addAll(oldSize, newItems);
        notifyItemRangeChanged(oldSize, newItems.size());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Getter
        private View itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public void setOnMoreButtonClickListener(OnMoreButtonClickListener onMoreButtonClickListener) {
        this.onMoreButtonClickListener = onMoreButtonClickListener;
    }
}
