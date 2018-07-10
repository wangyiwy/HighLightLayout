package wangyi.blog.app.view.region;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by WangYi
 *
 * @Date : 2018/7/5
 * @Desc : 圆形高亮区域
 */
public class CircleRegion extends RectRegion {
    public float radius;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeFloat(this.radius);
        dest.writeParcelable(this.rectF, flags);
    }

    public CircleRegion(RectF rectF, float radius) {
        super(rectF);
        this.radius = radius;
    }

    private CircleRegion(Parcel in) {
        super(in);
        this.radius = in.readFloat();
        this.rectF = in.readParcelable(RectF.class.getClassLoader());
    }

    public static final Parcelable.Creator<CircleRegion> CREATOR =
            new Parcelable.Creator<CircleRegion>() {
                @Override
                public CircleRegion createFromParcel(Parcel source) {
                    return new CircleRegion(source);
                }

                @Override
                public CircleRegion[] newArray(int size) {
                    return new CircleRegion[size];
                }
            };
}
