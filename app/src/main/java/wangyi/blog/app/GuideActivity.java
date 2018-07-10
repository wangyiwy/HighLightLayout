package wangyi.blog.app;

import android.os.Bundle;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import wangyi.blog.app.view.HighLightLayout;
import wangyi.blog.app.view.region.RectRegion;

public class GuideActivity extends AppCompatActivity {
    public static final String EXTRA_REGION_LIST = "extra_region_list";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        ArrayList<RectRegion> regions = getIntent().getParcelableArrayListExtra(EXTRA_REGION_LIST);
        HighLightLayout highLightLayout = findViewById(R.id.highLightLayout);
        highLightLayout.setRegions(regions);
    }
}
