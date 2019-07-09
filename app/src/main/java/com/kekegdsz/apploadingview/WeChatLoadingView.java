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
    private float leftCircleSize = 5;
    private float midCircleSize = 10;
    private float rightCircleSize = 15;
    private ObjectAnimator mLeftScaleAnimator;
    private ObjectAnimator mMidScaleAnimator;
    private ObjectAnimator mRightScaleAnimator;

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
        mLeftScaleAnimator = ObjectAnimator
                .ofFloat(leftCircleSize, "leftCircleSize", 5, 15);
        mLeftScaleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                leftCircleSize = (float) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        mMidScaleAnimator = ObjectAnimator
                .ofFloat(midCircleSize, "midCircleSize", 5, 15);
        mMidScaleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                midCircleSize = (float) animation.getAnimatedValue();
            }
        });
        mRightScaleAnimator = ObjectAnimator
                .ofFloat(rightCircleSize, "rightCircleSize", 5, 15);
        mRightScaleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                rightCircleSize = (float) animation.getAnimatedValue();
            }
        });
        setAnimValue(mLeftScaleAnimator);
        setAnimValue(mMidScaleAnimator);
        setAnimValue(mRightScaleAnimator);
    }

    private void setAnimValue(ObjectAnimator anim) {
        anim.setDuration(600);
        anim.setRepeatMode(ValueAnimator.REVERSE);
        anim.setRepeatCount(ValueAnimator.INFINITE);
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
        canvas.drawCircle(20, 20, leftCircleSize, mPaint);
        canvas.drawCircle(90, 20, midCircleSize, mPaint);
        canvas.drawCircle(160, 20, rightCircleSize, mPaint);
    }

    public float getLeftCircleSize() {
        return leftCircleSize;
    }

    public void setLeftCircleSize(float leftCircleSize) {
        this.leftCircleSize = leftCircleSize;
    }

    public float getMidCircleSize() {
        return midCircleSize;
    }

    public void setMidCircleSize(float midCircleSize) {
        this.midCircleSize = midCircleSize;
    }

    public float getRightCircleSize() {
        return rightCircleSize;
    }

    public void setRightCircleSize(float rightCircleSize) {
        this.rightCircleSize = rightCircleSize;
    }

    public void startScaleAnimator() {
        mLeftScaleAnimator.start();
        mMidScaleAnimator.setStartDelay(200);
        mMidScaleAnimator.start();
        mRightScaleAnimator.setStartDelay(400);
        mRightScaleAnimator.start();
    }

}
