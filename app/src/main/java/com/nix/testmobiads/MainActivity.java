package com.nix.testmobiads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ads.mobitechadslib.MobiAdBanner;
import com.ads.mobitechadslib.MobitechAds;

public class MainActivity extends AppCompatActivity {

    //Init banner ads-----
    private MobiAdBanner bannerAd,bannerAd2,bannerAd3;
    //............
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //banner .....get banner ads
        bannerAd = findViewById(R.id.bannerAd);
        bannerAd2 = findViewById(R.id.bannerAd2);
        bannerAd3 = findViewById(R.id.bannerAd3);

        Button btnRefresh = findViewById(R.id.btnRefresh);
        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reloadAds();
            }
        });
        /*
        * Load Ads*/
        loadBannerAds();
        loadIntertistialAds();



    }

    //...fetch banner
    private void loadBannerAds(){
        bannerAd.getBannerAds(this,
                "1");
        bannerAd2.getBannerAds(this,
                "2");
        bannerAd3.getBannerAds(this,
                "1",
                1);
    }

    //optional method to fetch ads
    private void loadIntertistialAds(){
        MobitechAds.getIntertistialAd(
                MainActivity.this,
                "1");
    }

    public void reloadAds(){
        loadBannerAds();
        loadIntertistialAds();
    }
}
