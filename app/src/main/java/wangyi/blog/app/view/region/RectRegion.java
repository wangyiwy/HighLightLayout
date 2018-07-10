package wangyi.blog.app.view.region;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by WangYi
 *
 * @Date : 2018/7/5
 * @Desc : 矩形高亮区域
 */
public class RectRegion implements Parcelable {
    public RectF rectF;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.rectF, flags);
    }

    public RectRegion(RectF rectF) {
        this.rectF = rectF;
    }

    RectRegion(Parcel in) {
        this.rectF = in.readParcelable(RectF.class.getClassLoader());
    }

    public static final Creator<RectRegion> CREATOR = new Creator<RectRegion>() {
        @Override
        public RectRegion createFromParcel(Parcel in) {
            return new RectRegion(in);
        }

        @Override
        public RectRegion[] newArray(int size) {
            return new RectRegion[size];
        }
    };
}
