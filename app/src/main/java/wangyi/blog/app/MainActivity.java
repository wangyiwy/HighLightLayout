package wangyi.blog.app;

import androidx.appcompat.app.AppCompatActivity;
import wangyi.blog.app.view.HighLightLayout;
import wangyi.blog.app.view.region.CircleRegion;
import wangyi.blog.app.view.region.OvalRegion;
import wangyi.blog.app.view.region.RectRegion;
import wangyi.blog.app.view.region.RoundRectRegion;

import android.content.Intent;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private View mButton1, mButton2, mButton3, mButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton1 = findViewById(R.id.btn1);
        mButton2 = findViewById(R.id.btn2);
        mButton3 = findViewById(R.id.btn3);
        mButton4 = findViewById(R.id.btn4);
    }

    public void onClick(View view) {
        ArrayList<RectRegion> regions = new ArrayList<>();

        //矩形高亮
        RectF rectF1 = LocationUtils.getViewLocation(mButton1);
        RectRegion region1 = new RectRegion(rectF1);
        regions.add(region1);
        //圆角矩形高亮
        RectF rectF2 = LocationUtils.getViewLocation(mButton2);
        RoundRectRegion region2 = new RoundRectRegion(rectF2, 10, 10);
        regions.add(region2);
        //圆形高亮
        RectF rectF3 = LocationUtils.getViewLocation(mButton3);
        float radius = (rectF3.right - rectF3.left) / 2 + 20;
        CircleRegion region3 = new CircleRegion(rectF3, radius);
        regions.add(region3);
        //椭圆高亮
        RectF rectF4 = LocationUtils.getViewLocation(mButton4);
        LocationUtils.expandRectF(rectF4, 40);
        OvalRegion region4 = new OvalRegion(rectF4);
        regions.add(region4);

        Intent intent = new Intent(this, GuideActivity.class);
        intent.putExtra(GuideActivity.EXTRA_REGION_LIST, regions);
        startActivity(intent);
    }

    public void onClick5(View view) {
        //获取view位置
        RectF rectF = LocationUtils.getViewLocation(view);
        //创建高亮区域
        OvalRegion region = new OvalRegion(rectF);
        //获取DecorView
        FrameLayout root = (FrameLayout) getWindow().getDecorView();
        HighLightLayout guideView = (HighLightLayout) LayoutInflater.from(this)
                .inflate(R.layout.activity_guide, null);
        guideView.setRegion(region);
        //将高亮引导添加到获取DecorView
        root.addView(guideView);
    }
}