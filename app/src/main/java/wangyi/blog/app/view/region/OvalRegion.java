package wangyi.blog.app.view.region;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by WangYi
 *
 * @Date : 2018/7/5
 * @Desc : 椭圆高亮区域
 */
public class OvalRegion extends RectRegion {
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeParcelable(this.rectF, flags);
    }

    public OvalRegion(RectF rectF) {
        super(rectF);
    }

    private OvalRegion(Parcel in) {
        super(in);
        this.rectF = in.readParcelable(RectF.class.getClassLoader());
    }

    public static final Parcelable.Creator<OvalRegion> CREATOR =
            new Parcelable.Creator<OvalRegion>() {
                @Override
                public OvalRegion createFromParcel(Parcel source) {
                    return new OvalRegion(source);
                }

                @Override
                public OvalRegion[] newArray(int size) {
                    return new OvalRegion[size];
                }
            };
}
