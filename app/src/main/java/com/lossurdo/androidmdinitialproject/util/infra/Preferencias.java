package com.lossurdo.androidmdinitialproject.util.infra;

import android.content.Context;
import android.preference.PreferenceManager;

/**
 * Created by lossurdo on 31/12/15.
 */
public class Preferencias {

    public static final Float getFloat(Context context, String key) {
        return Float.parseFloat(PreferenceManager
                .getDefaultSharedPreferences(context)
                .getString(key, "0.0F"));
    }

    public static final Integer getInteger(Context context, String key) {
        return Integer.parseInt(PreferenceManager
                .getDefaultSharedPreferences(context)
                .getString(key, "0"));
    }

    public static final String getString(Context context, String key) {
        return PreferenceManager
                .getDefaultSharedPreferences(context)
                .getString(key, "");
    }

}
