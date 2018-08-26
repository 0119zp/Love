package com.zpan.love.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class LoveView extends SurfaceView implements Runnable {

    private boolean mLoop = true;
    private SurfaceHolder mSurfaceHolder = null;
    private int miCount = 0;

    public LoveView(Context context) {
        super(context);
        initView();
    }

    public LoveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public LoveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public LoveView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
    }

    private void initView() {
        setFocusable(true);
        setKeepScreenOn(true);
        mSurfaceHolder = getHolder();
        mSurfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                new Thread(LoveView.this).start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                mLoop = false;
            }
        });
    }

    @Override
    public void run() {
        DrawLoveView();
        while (mLoop) {
            try {
                Thread.sleep(1000);
                synchronized (mSurfaceHolder) {
                    DrawLoveView();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void DrawLoveView() {
        Canvas canvas = mSurfaceHolder.lockCanvas();
        try {
            if (mSurfaceHolder == null || canvas == null) {
                return;
            }
            if (miCount < 100) {
                miCount++;
            } else {
                miCount = 0;
            }
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            // 设置画布颜色
            canvas.drawARGB(50, 0, 0, 0);

            switch (miCount % 6) {
                case 0:
                    paint.setColor(Color.parseColor("#FF0000"));
                    break;
                case 1:
                    paint.setColor(Color.parseColor("#F56B08"));
                    break;
                case 2:
                    paint.setColor(Color.parseColor("#F7EB06"));
                    break;
                case 3:
                    paint.setColor(Color.parseColor("#14F504"));
                    break;
                case 4:
                    paint.setColor(Color.parseColor("#EE08F2"));
                    break;
                case 5:
                    paint.setColor(Color.parseColor("#F70425"));
                    break;
            }
            int i, j;
            double x, y, r;

            for (i = 0; i <= 180; i++) {
                for (j = 0; j <= 180; j++) {
                    r = Math.PI / 45 * i * (1 - Math.sin(Math.PI / 45 * j)) * 20;
                    x = r * Math.cos(Math.PI / 45 * j) * Math.sin(Math.PI / 45 * i) + 320 / 2;
                    y = -r * Math.sin(Math.PI / 45 * j) + 400 / 4;
                    canvas.drawPoint((float) x + 200, (float) y, paint);
                }
            }

            paint.setTextSize(80);
            paint.setTypeface(Typeface.DEFAULT_BOLD);
            canvas.drawText("Love You Forever", 60, 700, paint);

            mSurfaceHolder.unlockCanvasAndPost(canvas);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
