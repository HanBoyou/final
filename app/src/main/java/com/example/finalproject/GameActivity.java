package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Chronometer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class GameActivity extends AppCompatActivity {

//    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Game(this));

//
//        ConstraintLayout ball = findViewById(R.id.ball);
//        Ball ball1 = new Ball(this);
//        ball.addView(ball1);
//
      Chronometer chronometer = findViewById(R.id.);
      chronometer.start();
//
//

    }

    public class Game extends SurfaceView implements SurfaceHolder.Callback, Runnable {

        private int screenW;
        private int screenH;
        private SurfaceHolder mHolder;
        private Canvas mCanvas;
        private Thread t;
        private boolean isRunning;
        private List<RectF> mObstacles = new ArrayList<>();
        private int[] obstacleColors = new int[] {Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.RED, Color.YELLOW, Color.GRAY};
        private Paint mObstaclePaint;
        private Paint mPlayerPaint;
        private int difficulty;
        private float cx = 50;
        private float cy = 50;
        private int radius = 20;
        private Chronometer chronometer = findViewById(R.id.ch);
        private int seconds =
                Integer.parseInt(chronometer.getText().toString().split(":")[0]) * 60
                + Integer.parseInt(chronometer.getText().toString().split(":")[1]);
        private Thread th;


        public Game(Context context) {
            this(context, null);
        }
        public Game(Context context, AttributeSet attrs) {
            super(context, attrs);
            mHolder = getHolder();
            mHolder.addCallback(this);
            setFocusable(true);
            setFocusableInTouchMode(true);
            this.setKeepScreenOn(true);
            Intent intent = getIntent();
            if (intent != null && intent.hasExtra("difficulty")) {
                difficulty = intent.getIntExtra("difficulty", R.id.radioButtonEasy);
            } else difficulty = R.id.radioButtonEasy;
        }



        @Override
        public void run() {
            while (isRunning) {
                long start = System.currentTimeMillis();
//                spawnObstacles();
//                moveObstacles();
//                deleteObstacles();
                draw();
                long end = System.currentTimeMillis();
                try {
                    if (end - start < 10) {
                        Thread.sleep(10 - (end - start));
                    } // refresh
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void moveObstacles() {

        }
        private void deleteObstacles() {
            for (RectF r : mObstacles) {
                if (r.top >= screenH) {
                    mObstacles.remove(r);
                }
            }
        }
        private void spawnObstacles() {

        }

        public class Spawner extends Thread implements Runnable {
            float leftLimit = 0;
            float rightLimit = screenW;
            float widthRange = screenW / 5;
            float minHeight = screenH / 5;
            float maxHeight = screenH;
            float heightRange = screenH / 3 * 2;
            int maxInterval = 1000 - seconds * difficulty;
            int intervalRange = maxInterval / 2;
            int number = 1 + seconds / 2;
            @Override
            public void run() {
                try {
                    Thread.sleep(maxInterval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < number; i++) {
                    mObstacles.add(randomRectF());
                }
            }
            private RectF randomRectF() {
                Random random = new Random(1000);
                RectF r = new RectF();
                int left = random.nextInt((int) (rightLimit - widthRange));
                int bottom = random.nextInt((int) (maxHeight - heightRange));
                int right = random.nextInt((int) (left + widthRange));
                int top = random.nextInt((int) (bottom + heightRange));
                r.set(left, top, right, bottom);
                return r;
            }
        }

        private void draw() {
            try {
                mCanvas = mHolder.lockCanvas();
                if (mCanvas != null) {
                    mCanvas.drawColor(Color.WHITE);             //START DRAW
//                    drawObstacle();
                    revise();
                    mCanvas.drawCircle(cx, cy, radius, mPlayerPaint);
                }
            } catch (Exception e) {
            } finally {
                if (mCanvas != null)
                    mHolder.unlockCanvasAndPost(mCanvas);
            }
        }

        private void drawObstacle() {
            //draw all obstacles in mObstacles
            for (RectF rectF : mObstacles) {
                int colorIndex = (int) (Math.random() * obstacleColors.length) - 1;
                mObstaclePaint.setStyle(Paint.Style.FILL);
                mObstaclePaint.setColor(obstacleColors[colorIndex]);
                mCanvas.drawRect(rectF, mObstaclePaint);
                mObstaclePaint.setStyle(Paint.Style.STROKE);
                mObstaclePaint.setColor(Color.BLACK);
                mCanvas.drawRect(rectF, mObstaclePaint);

            }
        }

        private void revise() {
            if (cx <= radius) {
                cx = radius;
            } else if (cx >= (screenW - radius)) {
                cx = screenW - radius;
            }
            if (cy <= radius) {
                cy = radius;
            } else if (cy >= (screenH - radius)) {
                cy = screenH - radius;
            }
        }

        @Override
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            isRunning = true;
            t = new Thread(this);
            screenW = getWidth();
            screenH = getHeight();
            mPlayerPaint = new Paint();
            mPlayerPaint.setAntiAlias(true);
            mPlayerPaint.setColor(Color.BLACK);
            t.start();
//            th.start();
        }

        @Override
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            isRunning = false;
        }
//        public boolean onTouchEvent(MotionEvent event) {
//
//            float currentX = event.getX();
//            float currentY = event.getY();
//            if (event.getAction() == MotionEvent.ACTION_MOVE) {
//                cx += (event.getX() - currentX);
//                cy += (event.getY() - currentY);
//            }
//            System.out.println("cx " + cx);
//            System.out.println("currentX" + currentX);
//            System.out.println("getX " + event.getX());
//            return true;
//        }

        float currentX;
        float currentY;
        @Override
        public boolean onTouchEvent(MotionEvent event) {

            if (event.getAction() == MotionEvent.ACTION_MOVE) {
                System.out.println(event.getHistorySize());
                if (event.getHistorySize() < 1) {
                    return true;
                }
                currentX = event.getHistoricalX(0);
                currentY = event.getHistoricalY(0);

                cx += (event.getX() - currentX);
                cy += (event.getY() - currentY);
            }

            return true;
        }
    }



}
