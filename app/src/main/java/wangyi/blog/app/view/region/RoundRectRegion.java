package wangyi.blog.app.view.region;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by WangYi
 *
 * @Date : 2018/7/5
 * @Desc : 圆角矩形高亮区域
 */
public class RoundRectRegion extends RectRegion {
    public float rx, ry;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeFloat(this.rx);
        dest.writeFloat(this.ry);
        dest.writeParcelable(this.rectF, flags);
    }

    public RoundRectRegion(RectF rectF, float rx, float ry) {
        super(rectF);
        this.rx = rx;
        this.ry = ry;
    }

    private RoundRectRegion(Parcel in) {
        super(in);
        this.rx = in.readFloat();
        this.ry = in.readFloat();
        this.rectF = in.readParcelable(RectF.class.getClassLoader());
    }

    public static final Parcelable.Creator<RoundRectRegion> CREATOR =
            new Parcelable.Creator<RoundRectRegion>() {
                @Override
                public RoundRectRegion createFromParcel(Parcel source) {
                    return new RoundRectRegion(source);
                }

                @Override
                public RoundRectRegion[] newArray(int size) {
                    return new RoundRectRegion[size];
                }
            };
}
