package com.lossurdo.androidmdinitialproject.util.view;

import android.app.Activity;

import com.lossurdo.androidmdinitialproject.R;

/**
 * Created by lossurdo on 29/12/15.
 */
public class ActivityUtil {

    public static final void toFadeInTransition(Activity activity) {
        activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public static final void toFlipVerticalTransition(Activity activity) {
        activity.overridePendingTransition(R.anim.flip_vertical_in, R.anim.flip_vertical_out);
    }

    public static final void toLeftTransition(Activity activity) {
        activity.overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_left);
    }

    public static final void toRightTransition(Activity activity) {
        activity.overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_right);
    }

    public static final void toAppearRightTransition(Activity activity) {
        activity.overridePendingTransition(R.anim.appear_bottom_right_in, R.anim.appear_bottom_right_out);
    }

}
