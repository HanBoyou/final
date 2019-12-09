package com.example.finalproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Chronometer;

import java.util.Random;
import java.util.Timer;
import java.util.jar.Attributes;

public class Ball extends View {
//    private Ball_x;
//    private Ball_y;
//    private final int step = 3;
//    private boolean up, down, left, right;
//    private boolean alive = true;

    public float currentX = 100;
    public float currentY = 200;

    // draw pen
    Paint p = new Paint();

    public Ball(Context context, AttributeSet set) {
        super(context, set);
    }
    public Ball(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        Random random = new Random(1000);

        canvas.drawColor(Color.WHITE);
        //set the color

        p.setColor(Color.BLACK);
        canvas.drawCircle(currentX, currentY, 30, p);
        p.setColor(Color.WHITE);
        canvas.drawCircle(currentX - 10, currentY - 10, 5, p);
        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.BLACK);
        canvas.drawRect(300, 600, 500, 800, p);
        for (int i = 0; i < 5; i++) {
            int a = random.nextInt(1000);
            int b = random.nextInt(2000);
            p.setStyle(Paint.Style.FILL);
            p.setColor(Color.BLUE);
            canvas.drawCircle(a,b,50,p);
//            this.invalidate();
//            Timer timer = new Timer();
//            timer.schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    p.setStyle(Paint.Style.FILL);
//                    p.setColor(Color.WHITE);
//                    canvas.drawCircle(a,b,50,p);
//                }
//            },1000);

//            try {
//                Thread.sleep(300);
//            } catch(InterruptedException ie) {
//                System.out.println("error");
//            }
//            p.setStyle(Paint.Style.FILL);
//            p.setColor(Color.WHITE);
//            canvas.drawCircle(a,b,50,p);

        }
//        try {
//            Thread.sleep(5000);
//        } catch(InterruptedException ie) {
//            System.out.println("error");
//        }




    }

    public boolean onTouchEvent(MotionEvent event) {
        this.currentX = event.getX();
        this.currentY = event.getY();
        this.invalidate();
        if (currentX > 200 && currentX < 500 && currentY > 600 && currentY < 800){

            System.exit(0);
        }
        return true;
    }
    public void timeCount(Chronometer chronometer) {
        String time = chronometer.getText().toString();
        System.out.println(time);
    }


}
