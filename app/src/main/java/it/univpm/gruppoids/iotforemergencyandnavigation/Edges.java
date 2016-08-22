package it.univpm.gruppoids.iotforemergencyandnavigation;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceView;

public class Edges extends SurfaceView{


    public Edges(Context context) {
        super(context);
    }

    /*@Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.colorAccent));
        paint.setStrokeWidth(2f);
        canvas.drawLine(100, 100, 500, 500, paint);
    }*/

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.colorAccent));
        paint.setStrokeWidth(2f);
        canvas.drawLine(100, 100, 500, 500, paint);
    }
}
