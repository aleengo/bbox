package com.aleengo.peank.core.util.net;

import android.Manifest;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;

import androidx.annotation.IntDef;
import androidx.annotation.RequiresPermission;

import com.aleengo.peank.core.util.Preconditions;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Copyright (c) Aleengo, 2019. All rights reserved.
 * Created by bau.cj on 26/06/2019.
 */
public class NetworkStatus {

    private NetworkStatus() {
        throw new AssertionError();
    }

    @IntDef(value = {NetworkStatus.TYPE_NONE,
            NetworkStatus.TYPE_MOBILE,
            NetworkStatus.TYPE_WIFI})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ConnectionType {}
    public static final int TYPE_NONE = -1;
    public static final int TYPE_MOBILE = 0;
    public static final int TYPE_WIFI = 1;

    @RequiresPermission(allOf = {Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.INTERNET})
    public static boolean isNetworkAvailable(final Context context) {
        final ConnectivityManager cm = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

       try {
           Preconditions.checkNotNull(cm);
           final NetworkInfo neti = cm.getActiveNetworkInfo();
           try {
               Preconditions.checkNotNull(neti);
               return neti.isConnected();
           } catch (NullPointerException npe) {
               return false;
           }
       } catch (NullPointerException e) {
           return false;
       }
    }

    @RequiresPermission(allOf = {Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_NETWORK_STATE})
    public static @ConnectionType int connectionType(final Context context) {
        final ConnectivityManager cm = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

        try {
            Preconditions.checkNotNull(cm);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                final Network activeNetwork = cm.getActiveNetwork();
                final NetworkCapabilities capabilities =
                        cm.getNetworkCapabilities(activeNetwork);

                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI))
                    return TYPE_WIFI;
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR))
                    return TYPE_MOBILE;
            } else {
                final NetworkInfo neti = cm.getActiveNetworkInfo();
                try {
                    Preconditions.checkNotNull(neti);
                    if (neti.getType() == TYPE_MOBILE) return TYPE_MOBILE;
                    if (neti.getType() == TYPE_WIFI) return TYPE_WIFI;
                } catch (NullPointerException npe) {
                    return TYPE_NONE;
                }
            }
        } catch (NullPointerException npe) {
            return TYPE_NONE;
        }
        return TYPE_NONE;
    }

    public static String getTypeName(final @ConnectionType int connectionType) {
        String type = null;

        switch (connectionType) {
            case TYPE_MOBILE:
                type = "MOBILE";
                break;
            case TYPE_WIFI:
                type = "WIFI";
                break;
        }
        return type;
    }
}
