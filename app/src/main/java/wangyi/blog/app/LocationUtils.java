package wangyi.blog.app;

import android.graphics.RectF;
import android.view.View;

/**
 * Created by WangYi
 *
 * @Date : 2018/7/4
 * @Desc :
 */
public class LocationUtils {

    public static RectF getViewLocation(View view) {
        int[] location = new int[2];
        view.getLocationInWindow(location);
        RectF rectF = new RectF();

        rectF.left = location[0];
        rectF.top = location[1];
        rectF.right = rectF.left + view.getWidth();
        rectF.bottom = rectF.top + view.getHeight();
        return rectF;
    }

    public static void expandRectF(RectF rectF, int offset) {
        rectF.left -= offset;
        rectF.top -= offset;
        rectF.right += offset;
        rectF.bottom += offset;
    }
}
