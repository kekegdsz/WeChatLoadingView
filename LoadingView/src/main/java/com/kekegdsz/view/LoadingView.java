package com.kekegdsz.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by keke on 2018/12/7.
 */

public class LoadingView extends View {

    private Paint mPaint;
    private int circleColor;
    private int circleColorHighlight;
    private float radius;
    private float spacing;
    private int num;
    private int speed;

    public LoadingView(Context context) {
        this(context, null);
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.LoadingView);
        radius = typedArray.getDimension(R.styleable.LoadingView_loading_view_radius, Utils.dpToPixel(5));
        spacing = typedArray.getDimension(R.styleable.LoadingView_loading_view_spacing, Utils.dpToPixel(30));
        circleColor = typedArray.getColor(R.styleable.LoadingView_loading_view_circleColor, getResources().getColor(R.color.loading_view_color));
        circleColorHighlight = typedArray.getColor(R.styleable.LoadingView_loading_view_circleColorHighlight, getResources().getColor(R.color.loading_view_color_highlight));
        num = typedArray.getInt(R.styleable.LoadingView_loading_view_num, 3);
        speed = typedArray.getInt(R.styleable.LoadingView_loading_view_speed, 250);
        typedArray.recycle();
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(circleColor);
        mPaint.setAntiAlias(true);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int desiredWidth = (int) ((int) radius * 2 + ((spacing + radius) * (num - 1)));
        int desiredHeight = (int) (radius * 2);
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
        for (int i = 0; i < num; i++) {
            if (highlightIndex == i) {
                mPaint.setColor(circleColorHighlight);
            } else {
                mPaint.setColor(circleColor);
            }
            canvas.drawCircle(radius + ((spacing + radius) * i), radius, radius, mPaint);
        }
        highlightIndex++;
        postInvalidateDelayed(speed);
        if (highlightIndex > num) {
            highlightIndex = 0;
        }
    }

}
