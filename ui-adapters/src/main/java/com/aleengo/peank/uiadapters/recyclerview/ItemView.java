package com.aleengo.peank.uiadapters.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import lombok.Getter;


/**
 * Copyright Aleengo 2019. All rights reserved.
 * Created by bau.cj on 22/06/2019.
 */

public abstract class ItemView<E> extends FrameLayout {

    @Getter
    private AdapterBase.OnItemClickListener<E> onItemClickListener;
    @Getter
    private AdapterBase.OnItemLongClickListener<E> onItemLongClickListener;
    @Getter
    private AdapterBase.OnMoreButtonClickListener<E> onMoreButtonClickListener;

    public ItemView(Context context) {
        super(context);
    }

    public abstract void bind(final E item, final int position);

    public void setOnItemClickListener(final AdapterBase.OnItemClickListener<E> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(final AdapterBase.OnItemLongClickListener<E> onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public void setOnMoreButtonClickListener(final AdapterBase.OnMoreButtonClickListener<E> onMoreButtonClickListener) {
        this.onMoreButtonClickListener = onMoreButtonClickListener;
    }
}
