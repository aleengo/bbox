package com.aleengo.peank.uiutils.util;

/**
 * Copyright (c) Aleengo, 2019. All rights reserved.
 * Created by bau.cj on 20/06/2019.
 */
public class Preconditions {

    private Preconditions() {
    }

    public static <T> T checkNotNull(final T reference) {
        if (reference == null) {
            throw new NullPointerException();
        }
        return reference;
    }

    public static <T> T checkNotNull(final T reference, String errorMessage) {
        if (reference == null) {
            throw new NullPointerException(errorMessage);
        }
        return reference;
    }
}
