package com.hamzaus.ncp.Heart_Failure;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends ActionBarActivity {
   String aURL;
   private AdView mAdView;
   private InterstitialAd mInterstitial;
   int showtimes = 0;
   // $FF: renamed from: wv android.webkit.WebView
   WebView field_2911;

   public static void showmessage(String var0, Context var1) {
      (new Toast(var1)).cancel();
      Toast.makeText(var1, var0, 1).show();
   }

   public void onBackPressed() {
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130903064);
      this.field_2911 = (WebView)this.findViewById(2131230802);
      this.field_2911.setWebViewClient(new WebViewClient());
      this.field_2911.getSettings().setJavaScriptEnabled(true);
      this.field_2911.getSettings().setSupportZoom(true);
      this.field_2911.getSettings().setBuiltInZoomControls(true);
      this.aURL = "file:///android_asset/main.htm";
      this.mInterstitial = new InterstitialAd(this);
      this.mInterstitial.setAdUnitId(this.getResources().getString(2131099697));
      this.mInterstitial.loadAd((new AdRequest.Builder()).build());
      this.mAdView = (AdView)this.findViewById(2131230804);
      this.mAdView.setVisibility(8);
      this.mAdView.loadAd((new AdRequest.Builder()).build());
      this.field_2911.loadUrl(this.aURL);
      ((Button)this.findViewById(2131230801)).setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            if(MainActivity.this.mInterstitial.isLoaded() && MainActivity.this.showtimes < 3) {
               MainActivity.this.mInterstitial.show();
               MainActivity var2 = MainActivity.this;
               ++var2.showtimes;
            }

            if(MainActivity.this.showtimes < 3) {
               MainActivity.this.mInterstitial.loadAd((new AdRequest.Builder()).build());
            } else {
               MainActivity.this.mAdView.setVisibility(0);
            }

            MainActivity.this.field_2911.loadUrl(MainActivity.this.aURL);
         }
      });
      ((Button)this.findViewById(2131230803)).setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            MainActivity.this.finish();
         }
      });
   }

   public boolean onCreateOptionsMenu(Menu var1) {
      this.getMenuInflater().inflate(2131492864, var1);
      return true;
   }

   protected void onDestroy() {
      this.mAdView.destroy();
      super.onDestroy();
   }

   public boolean onOptionsItemSelected(MenuItem var1) {
      return var1.getItemId() == 2131230805?true:super.onOptionsItemSelected(var1);
   }

   protected void onPause() {
      this.mAdView.pause();
      super.onPause();
   }

   protected void onResume() {
      super.onResume();
      this.mAdView.resume();
   }
}
