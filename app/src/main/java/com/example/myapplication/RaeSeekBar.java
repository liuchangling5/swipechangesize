package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;

import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.core.content.ContextCompat;

/**
 * 带文本的滑杆
 * Created by ChenRui on 2017/10/13 0013 12:50.
 */

public class RaeSeekBar extends AppCompatSeekBar {

    private String[] mTickMarkTitles = new String[]{
            "A-",
            "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
            "A+"
    };
    private int[] mTextSize = new int[]{
            16, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50,16
    };

    private final Paint mTickMarkTitlePaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
    private float mTickMarkTitleTextSize = 18;
    private float mOffsetY = 40;
    private int mLineHeight = 0; // 刻度高度
    private int mThumbWidth;
    private final Rect mRect = new Rect();
    private int mThumbHeight;

    public RaeSeekBar(Context context) {
        super(context);
        init();
    }

    public RaeSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RaeSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    protected void init() {
        mTickMarkTitleTextSize = getSize(mTickMarkTitleTextSize);
        mOffsetY = getSize(mOffsetY);
        mLineHeight = getSize(mLineHeight);
        mTickMarkTitlePaint.setTextAlign(Paint.Align.CENTER);
        mTickMarkTitlePaint.setColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int max = mTextSize.length - 1;
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        int h2 = height / 2;

//        final int saveCount = canvas.save();
//        canvas.translate(getPaddingLeft() - getThumbOffset(), getPaddingTop() + h2 - mThumbHeight / 2);
//        getThumb().draw(canvas);
//        canvas.restoreToCount(saveCount);

        // 画刻度背景
        mRect.left = getPaddingLeft();
        mRect.right = width - getPaddingRight();
        mRect.top = h2 - getSize(1);
        mRect.bottom = mRect.top + getSize(1.5f);
        canvas.drawRect(mRect, mTickMarkTitlePaint);
        int cw = mRect.right - mRect.left; // 总画线的长度 = 右边坐标 - 左边坐标
        for (int i = 0; i <= max; i++) {
            // 每个间隔的大小
            int thumbPos = getPaddingLeft() + (cw * i / max);
            // 画分割线
            mRect.top = h2 - mLineHeight / 2;
            mRect.bottom = h2 + mLineHeight / 2;
            mRect.left = thumbPos;
            mRect.right = thumbPos + getSize(1.5f);
            canvas.drawRect(mRect, mTickMarkTitlePaint);

            // 画刻度文本
            String title = mTickMarkTitles[i % mTickMarkTitles.length];
            mTickMarkTitlePaint.getTextBounds(title, 0, title.length(), mRect);
            mTickMarkTitlePaint.setTextSize(getSize(mTextSize[i]));
            canvas.drawText(title, thumbPos, getSize(mTextSize[mTextSize.length - 1]), mTickMarkTitlePaint);
        }
    }

    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mThumbWidth = getThumb().getIntrinsicWidth();
        mThumbHeight = getThumb().getIntrinsicHeight();
        // 加上字体大小
        int wm = MeasureSpec.getMode(widthMeasureSpec);
        int hm = MeasureSpec.getMode(heightMeasureSpec);
        int w = getMeasuredWidth();
        int h = getMeasuredHeight();
        h += getSize(mTextSize[mTextSize.length - 1]); // 最大的字体
        h += mOffsetY;
        // 保存
        setMeasuredDimension(MeasureSpec.makeMeasureSpec(w, wm), MeasureSpec.makeMeasureSpec(h, hm));

    }

    protected int getSize(float size) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, size, getResources().getDisplayMetrics());
    }

    public int getRawTextSize(int progress) {
        int percent = progress % 100;
        int size=0;
        if (percent >= 0 && percent < 5)
            size = 10;
        if (percent >= 5 && percent < 10) {
            size = mTextSize[1];
        }
        if (percent >= 10 && percent < 15) {
            size = mTextSize[2];
        }
        if (percent >= 15 && percent < 20) {
            size = mTextSize[3];
        }
        if (percent >= 20 && percent < 25) {
            size = mTextSize[4];
        }
        if (percent >= 20 && percent < 25) {
            size = mTextSize[5];
        }
        if (percent >= 25 && percent < 30) {
            size = mTextSize[6];
        }
        if (percent >= 30 && percent < 35) {
            size = mTextSize[7];
        }
        if (percent >= 35 && percent < 40) {
            size = mTextSize[8];
        }
        if (percent >= 40 && percent < 45) {
            size = mTextSize[9];
        }
        if (percent >= 45 && percent < 50) {
            size = mTextSize[10];
        }
        if (percent >= 50 && percent < 55) {
            size = mTextSize[11];
        }
        if (percent >= 55 && percent < 60) {
            size = mTextSize[12];
        }
        if (percent >= 60 && percent < 65) {
            size = mTextSize[13];
        }
        if (percent >= 65 && percent < 70) {
            size = mTextSize[14];
        }
        if (percent >= 70 && percent < 75) {
            size = mTextSize[15];
        }
        if (percent >= 75 && percent < 80) {
            size = mTextSize[16];
        }
        if (percent >= 80 && percent < 85) {
            size = mTextSize[17];
        }
        if (percent >= 85 && percent < 90) {
            size = mTextSize[18];
        }
        if (percent >= 90 && percent < 95) {
            size = mTextSize[19];
        }
        if (percent >= 95 ||progress==100) {
            size = 52;
        }
        return size;
    }

    public int getTextSize(int progress) {
        return getSize(getRawTextSize(progress));
    }

    public void setTextSize(int size) {
        for (int i = 0; i < mTextSize.length; i++) {
            int textSize = getSize(mTextSize[i]);
            if (textSize == size) {
                setProgress(i);
                break;
            }
        }
    }

}
