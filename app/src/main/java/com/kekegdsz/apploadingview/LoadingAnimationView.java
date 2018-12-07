package com.kekegdsz.apploadingview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by keke on 2018/12/7.
 */

public class LoadingAnimationView extends View {

    private Paint mPaint;
    private int circleColor = getResources().getColor(R.color.colorPrimary);
    private int leftCircle = 5;
    private int midCircle = 15;
    private int rightCircle = 20;
    private boolean leftZoom = true;
    private boolean midZoom = true;
    private boolean rightZoom = false;

    public LoadingAnimationView(Context context) {
        this(context, null);
    }

    public LoadingAnimationView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingAnimationView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(circleColor);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int desiredWidth = 180;
        int desiredHeight = 40;

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;

        //Measure Width
        if (widthMode == MeasureSpec.EXACTLY) {
            //Must be this size
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            width = Math.min(desiredWidth, widthSize);
        } else {
            //Be whatever you want
            width = desiredWidth;
        }

        //Measure Height
        if (heightMode == MeasureSpec.EXACTLY) {
            //Must be this size
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            //Can't be bigger than...
            height = Math.min(desiredHeight, heightSize);
        } else {
            //Be whatever you want
            height = desiredHeight;
        }
        //MUST CALL THIS
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(20, 20, leftCircle, mPaint);
        canvas.drawCircle(90, 20, midCircle, mPaint);
        canvas.drawCircle(160, 20, rightCircle, mPaint);
        leftCircle = leftAnimationSizeCount(leftCircle);
        midCircle = midAnimationSizeCount(midCircle);
        rightCircle = rightAnimationSizeCount(rightCircle);
        postInvalidateDelayed(25);
    }

    private int rightAnimationSizeCount(int size) {
        if (leftZoom) {
            if (size == 20) {
                leftZoom = false;
            } else {
                size++;
            }
        } else {
            if (size == 5) {
                leftZoom = true;
                size++;
            } else {
                size--;
            }
        }
        return size;
    }

    private int midAnimationSizeCount(int size) {
        if (midZoom) {
            if (size == 20) {
                midZoom = false;
            } else {
                size++;
            }
        } else {
            if (size == 5) {
                midZoom = true;
                size++;
            } else {
                size--;
            }
        }
        return size;
    }

    private int leftAnimationSizeCount(int size) {
        if (rightZoom) {
            if (size == 20) {
                rightZoom = false;
            } else {
                size++;
            }
        } else {
            if (size == 5) {
                rightZoom = true;
                size++;
            } else {
                size--;
            }
        }
        return size;
    }

}
