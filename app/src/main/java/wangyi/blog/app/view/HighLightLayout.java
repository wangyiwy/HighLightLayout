package wangyi.blog.app.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import wangyi.blog.app.view.region.CircleRegion;
import wangyi.blog.app.view.region.OvalRegion;
import wangyi.blog.app.view.region.RectRegion;
import wangyi.blog.app.view.region.RoundRectRegion;

/**
 * Created by WangYi
 *
 * @Date : 2018/6/28
 * @Desc : 实现高亮引导
 */
public class HighLightLayout extends FrameLayout {
    private Paint mPaint;
    private Path mPath = new Path();
    private List<RectRegion> mRegions;

    public HighLightLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(0xAA000000);

        setWillNotDraw(false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPath.reset();
        mPath.addRect(0, 0, getWidth(), getHeight(), Path.Direction.CCW);
        for (RectRegion region : mRegions) {
            RectF rectF = region.rectF;
            if (region instanceof RoundRectRegion) {
                RoundRectRegion roundRectRegion = (RoundRectRegion) region;
                mPath.addRoundRect(rectF, roundRectRegion.rx, roundRectRegion.ry, Path.Direction.CW);
            } else if (region instanceof CircleRegion) {
                CircleRegion circleRegion = (CircleRegion) region;
                float cX = (rectF.right + rectF.left) / 2;
                float cY = (rectF.bottom + rectF.top) / 2;
                mPath.addCircle(cX, cY, circleRegion.radius, Path.Direction.CW);
            } else if (region instanceof OvalRegion) {
                mPath.addOval(rectF, Path.Direction.CW);
            } else {
                mPath.addRect(rectF, Path.Direction.CW);
            }
        }
        canvas.drawPath(mPath, mPaint);
    }

    public void setRegion(@NonNull RectRegion region) {
        if (mRegions == null) {
            mRegions = new ArrayList<>();
        } else {
            mRegions.clear();
        }
        mRegions.add(region);
        invalidate();
    }

    public void setRegions(@NonNull List<RectRegion> regions) {
        mRegions = regions;
        invalidate();
    }

    @Override
    public void setBackgroundColor(int color) {
        mPaint.setColor(color);
    }
}
