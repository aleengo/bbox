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
        this(context, null);
    }

    public ItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public abstract void bind(E item, int position);

    public void setOnItemClickListener(AdapterBase.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(AdapterBase.OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public void setOnMoreButtonClickListener(AdapterBase.OnMoreButtonClickListener onMoreButtonClickListener) {
        this.onMoreButtonClickListener = onMoreButtonClickListener;
    }
}
