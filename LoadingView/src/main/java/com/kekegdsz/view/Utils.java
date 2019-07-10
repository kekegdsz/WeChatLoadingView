package com.kekegdsz.view;

import android.content.res.Resources;
import android.util.TypedValue;

/**
 * develop：keke
 * des:
 * time:2019/7/10 0010 14:20
 **/
public class Utils {

    public static float dpToPixel(float dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                Resources.getSystem().getDisplayMetrics());
    }
}
