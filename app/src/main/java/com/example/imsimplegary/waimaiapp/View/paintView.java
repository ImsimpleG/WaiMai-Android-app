package com.example.imsimplegary.waimaiapp.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/**
 * Created by IMSIMPLEGARY on 2018/11/12.
 */

public class paintView extends View {
    Paint paint1 = new Paint();

    public paintView(Context context) {
        super(context);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint1.setAntiAlias(true);
        paint1.setColor(Color.parseColor("#ffd161"));
        paint1.setStrokeWidth(3);
        paint1.setStyle(Paint.Style.FILL);
        RectF oval = new RectF(0,0,1080,200);
        canvas.drawArc(oval,0,90,true,paint1);
        canvas.drawArc(oval,90,90,true,paint1);
        canvas.drawRect(0,0,1080,100,paint1);


    }
}
