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

public class WeChatLoadingView extends View {

    private Paint mPaint;
    private int circleColor = getResources().getColor(R.color.loading_view_color);
    private int circleColorHighlight = getResources().getColor(R.color.loading_view_color_highlight);
    private float circleSize = 10;

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

    private int highlightIndex = 0;

    @Override
    protected void onDraw(Canvas canvas) {
        switch (highlightIndex) {
            case 0:
                mPaint.setColor(circleColorHighlight);
                canvas.drawCircle(20, 20, circleSize, mPaint);
                mPaint.setColor(circleColor);
                canvas.drawCircle(90, 20, circleSize, mPaint);
                mPaint.setColor(circleColor);
                canvas.drawCircle(160, 20, circleSize, mPaint);
                break;
            case 1:
                mPaint.setColor(circleColor);
                canvas.drawCircle(20, 20, circleSize, mPaint);
                mPaint.setColor(circleColorHighlight);
                canvas.drawCircle(90, 20, circleSize, mPaint);
                mPaint.setColor(circleColor);
                canvas.drawCircle(160, 20, circleSize, mPaint);
                break;
            case 2:
                mPaint.setColor(circleColor);
                canvas.drawCircle(20, 20, circleSize, mPaint);
                mPaint.setColor(circleColor);
                canvas.drawCircle(90, 20, circleSize, mPaint);
                mPaint.setColor(circleColorHighlight);
                canvas.drawCircle(160, 20, circleSize, mPaint);
                break;
        }
        if (highlightIndex == 0) {
            highlightIndex++;
        } else if (highlightIndex == 2) {
            highlightIndex--;
        }
        postInvalidateDelayed(30);
    }

}
