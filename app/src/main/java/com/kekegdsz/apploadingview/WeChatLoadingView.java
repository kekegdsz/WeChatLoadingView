package com.kekegdsz.apploadingview;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by keke on 2018/12/7.
 */

public class WeChatLoadingView extends View {

    private Paint mPaint;
    private int circleColor = getResources().getColor(R.color.loading_view_color);
    private float defaultCircleSize = 5;


    public WeChatLoadingView(Context context) {
        this(context, null);
    }

    public WeChatLoadingView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WeChatLoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        canvas.drawCircle(20, 20, defaultCircleSize, mPaint);
        canvas.drawCircle(90, 20, defaultCircleSize + 5, mPaint);
        canvas.drawCircle(160, 20, defaultCircleSize + 10, mPaint);
        startScaleAnimator(defaultCircleSize);
    }


    public float getDefaultCircleSize() {
        return defaultCircleSize;
    }

    public void setDefaultCircleSize(float defaultCircleSize) {
        this.defaultCircleSize = defaultCircleSize;
    }

    private void startScaleAnimator(float value) {
        ObjectAnimator mScaleAnimator = ObjectAnimator
                .ofFloat(this, "defaultCircleSize", value, 15);
        mScaleAnimator.setDuration(30);
        mScaleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                defaultCircleSize = (float) animation.getAnimatedValue();

            }
        });
        mScaleAnimator.setRepeatCount(ValueAnimator.INFINITE);
        mScaleAnimator.start();

    }

}
