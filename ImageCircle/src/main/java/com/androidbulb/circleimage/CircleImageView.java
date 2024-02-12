package com.androidbulb.circleimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuffXfermode;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

public class CircleImageView extends AppCompatImageView {
    private Bitmap circularBitmap;

    public CircleImageView(Context context) {
        super(context);
    }

    public CircleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private Bitmap createCircularBitmap(Bitmap sourceBitmap) {
        Bitmap outputBitmap = Bitmap.createBitmap(sourceBitmap.getWidth(), sourceBitmap.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(outputBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, sourceBitmap.getWidth(), sourceBitmap.getHeight());
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-16776961);
        canvas.drawCircle((float)(sourceBitmap.getWidth() / 2), (float)(sourceBitmap.getHeight() / 2), (float)(sourceBitmap.getHeight() / 2), paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(sourceBitmap, rect, rect, paint);
        return outputBitmap;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        BitmapDrawable drawable = (BitmapDrawable) this.getDrawable();
        if (drawable != null) {
            if (this.getWidth() != 0 && this.getHeight() != 0) {
                Bitmap bitmap = drawable.getBitmap();
                int measuredWidth = this.getMeasuredWidth();
                int measuredHeight = this.getMeasuredHeight();
                if (bitmap != null) {
                    if (circularBitmap == null || measuredWidth != circularBitmap.getWidth() || measuredHeight != circularBitmap.getHeight()) {
                        circularBitmap = Bitmap.createScaledBitmap(bitmap, measuredWidth, measuredHeight, true);
                        circularBitmap = createCircularBitmap(circularBitmap);
                    }
                    canvas.drawBitmap(circularBitmap, 0.0F, 0.0F, null);
                }
            }
        }
    }
}
