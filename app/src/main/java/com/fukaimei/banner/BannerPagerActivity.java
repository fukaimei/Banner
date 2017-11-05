package com.fukaimei.banner;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

import com.fukaimei.banner.util.DisplayUtil;
import com.fukaimei.banner.widget.BannerPager;

public class BannerPagerActivity extends AppCompatActivity implements BannerPager.BannerClickListener {
    private static final String TAG = "BannerPagerActivity";

    private TextView tv_pager;
    private BannerPager mBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_pager);
        tv_pager = (TextView) findViewById(R.id.tv_pager);

        mBanner = (BannerPager) findViewById(R.id.banner_pager);
        LayoutParams params = (LayoutParams) mBanner.getLayoutParams();
        params.height = (int) (DisplayUtil.getSreenWidth(this) * 250f / 640f);
        mBanner.setLayoutParams(params);

        ArrayList<Integer> bannerArray = new ArrayList<Integer>();
        bannerArray.add(Integer.valueOf(R.drawable.banner_1));
        bannerArray.add(Integer.valueOf(R.drawable.banner_2));
        bannerArray.add(Integer.valueOf(R.drawable.banner_3));
        bannerArray.add(Integer.valueOf(R.drawable.banner_4));
        bannerArray.add(Integer.valueOf(R.drawable.banner_5));
        mBanner.setImage(bannerArray);
        mBanner.setOnBannerListener(this);
        mBanner.start();
    }

    @Override
    public void onBannerClick(int position) {
        String desc = String.format("您点击了第%d张图片", position + 1);
        tv_pager.setText(desc);
    }

}
