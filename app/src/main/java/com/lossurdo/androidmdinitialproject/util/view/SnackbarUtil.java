package com.lossurdo.androidmdinitialproject.util.view;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by lossurdo on 29/12/15.
 */
public class SnackbarUtil {

    public static final void make(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

}
