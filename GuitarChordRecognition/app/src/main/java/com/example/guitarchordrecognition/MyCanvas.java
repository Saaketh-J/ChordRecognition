package com.example.guitarchordrecognition;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class MyCanvas extends View {
    public MyCanvas(Context context){
        super(context);
        Paint paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }


}
