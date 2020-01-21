package com.nix.testmobiads;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ads.mobitechadslib.MobiAdBanner;
import com.ads.mobitechadslib.MobitechAds;

public class MainActivity extends AppCompatActivity {

    //Init banner ads-----
    private MobiAdBanner bannerAd,bannerAd2,bannerAd3;
    private String applicationId="562024";
    private String category="5";
    private TextView txtCategory;
    private String[] listItems = {"News","Entertainment","Sport","Business","Games","Education"};
    private WebView webview;
    //............
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //banner .....get banner ads
        bannerAd = findViewById(R.id.bannerAd);
        bannerAd2 = findViewById(R.id.bannerAd2);
        bannerAd3 = findViewById(R.id.bannerAd3);
        txtCategory = findViewById(R.id.txtcategory);

        Button btnRefresh = findViewById(R.id.btnRefresh);
        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reloadAds();
            }
        });
        /*
        * Load Ads*/

        showAlert();

        Button btnCategory = findViewById(R.id.btnCategory);
        btnCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert();
            }
        });


        MobiAdBanner mobiAdBanner = new MobiAdBanner(this);
        mobiAdBanner.getBannerAds(this,applicationId,category);


    }
    private void showAlert(){
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        mBuilder.setTitle("Choose a Category");
        mBuilder.setCancelable(false);
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                txtCategory.setText(listItems[i]+" Category");
                dialogInterface.dismiss();
                category = String.valueOf(i+1);
                loadBannerAds();
                loadIntertistialAds();
            }
        });

        AlertDialog mDialog = mBuilder.create();
        mDialog.show();
    }

    //...fetch banner
    private void loadBannerAds(){
        bannerAd.getBannerAds(this,applicationId,
                category);
        bannerAd2.getBannerAds(this,applicationId,
                category);
        bannerAd3.getBannerAds(this,applicationId,
                category,
                1);
        Toast.makeText(this,"Loading ads Please wait ... ",Toast.LENGTH_LONG).show();
    }

    //optional method to fetch ads
    private void loadIntertistialAds(){
        MobitechAds.getIntertistialAd(
                MainActivity.this,applicationId,
                category);
    }

    public void reloadAds(){
        loadBannerAds();
        loadIntertistialAds();
        Toast.makeText(this,"Reloading ... ",Toast.LENGTH_LONG).show();

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MobitechAds.getIntertistialAd(
                MainActivity.this,applicationId,
                category);
    }
}
