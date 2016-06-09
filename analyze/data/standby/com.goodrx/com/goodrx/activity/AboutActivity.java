package com.goodrx.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.webkit.WebView;
import com.goodrx.widget.BaseActivityWithPasscode;
import com.goodrx.widget.VideoEnabledWebChromeClient;
import com.goodrx.widget.VideoEnabledWebView;

public class AboutActivity extends BaseActivityWithPasscode {
   private VideoEnabledWebView webView;

   public static void launch(Activity var0) {
      var0.startActivity(new Intent(var0, AboutActivity.class));
      var0.overridePendingTransition(2131034132, 2131034138);
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.enableScreenViewTracking(2131427822);
      this.setContentView(2130968601);
      this.webView = (VideoEnabledWebView)this.findViewById(2131886235);
      VideoEnabledWebChromeClient var2 = new VideoEnabledWebChromeClient(this.findViewById(2131886234), (ViewGroup)this.findViewById(2131886236), LayoutInflater.from(this).inflate(2130968779, (ViewGroup)null), this.webView) {
         public void onProgressChanged(WebView var1, int var2) {
         }
      };
      var2.setOnToggledFullscreen(new VideoEnabledWebChromeClient.ToggledFullscreenCallback() {
         public void toggledFullscreen(boolean var1) {
            if(var1) {
               AboutActivity.this.getSupportActionBar().hide();
               LayoutParams var3 = AboutActivity.this.getWindow().getAttributes();
               var3.flags |= 1024;
               var3.flags |= 128;
               AboutActivity.this.getWindow().setAttributes(var3);
               if(VERSION.SDK_INT >= 14) {
                  AboutActivity.this.getWindow().getDecorView().setSystemUiVisibility(1);
               }
            } else {
               AboutActivity.this.getSupportActionBar().show();
               LayoutParams var2 = AboutActivity.this.getWindow().getAttributes();
               var2.flags &= -1025;
               var2.flags &= -129;
               AboutActivity.this.getWindow().setAttributes(var2);
               if(VERSION.SDK_INT >= 14) {
                  AboutActivity.this.getWindow().getDecorView().setSystemUiVisibility(0);
                  return;
               }
            }

         }
      });
      this.webView.setWebChromeClient(var2);
   }

   public void onResume() {
      super.onResume();
      this.webView.loadDataWithBaseURL((String)null, "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\n<html>\n    <head>\n        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n            <meta http-equiv=\"Content-Style-Type\" content=\"text/css\">\n                <title></title>\n                <meta name=\"Generator\" content=\"Cocoa HTML Writer\">\n                    <meta name=\"CocoaVersion\" content=\"1187.39\">\n                        <style>h3, p, li { font-family: arial; } p {padding: 5px 10px; } ul, li {margin:0px 10px 0 15px; padding:0px; } h3 {padding: 5px 10px;} hv{ display:inline; background-color:#ffffc4}\n                            </style>\n                        <style type=\"text/css\">\n                            p.p3 {margin: 12.0px 0.0px 12.0px 0.0px; font: 15.0px arial;}\n                            p.p4 {margin: 0.0px 0.0px 0.0px 0.0px; font: 14.0px arial;}\n                            p.p6 {margin: 0.0px 0.0px 12.0px 0.0px; font: 15.0px arial; color: #0000ee}\n                            </style>\n                        \n    </head>\n    <body>\n<iframe id=\'playerId\' type=\'text/html\' width=\'100%\' src=\'http://www.youtube.com/embed/9qkXs768JKY?enablejsapi=1&rel=0\' frameborder=\'0\' allowfullscreen> </iframe>        <h3>We believe that all Americans deserve affordable and convenient prescription drugs.</h3><p>That should be easy, right?</p><p>Well, for a whole bunch of really complicated reasons, prescription drugs are too expensive. Up to <strong>45% of Americans</strong> have trouble paying for the prescriptions they require. 26% of Americans actually don\'t fill prescriptions because they simply can\'t afford it.</p><p>Most consumers don\'t know that:</p><ol><li>Prices for prescription drugs vary widely from drugstore to drugstore</li><li>Your insurance co-pay may not be the best way to save money on prescriptions</li><li>The price of drugs has been decreasing, but you\'re paying more</li><li>Your doctor doesn\'t know how much your drugs cost</li></ol><p>Enter GoodRx.</p><p>Our goal is to provide you, the health consumer, with convenient, affordable prescription drugs.</p><p>We\'re starting by providing you with information you\'ve never had before. We\'re building the same kind of tools that you use to get invoice prices for cars or TV\'s and bringing them to prescription drugs.</p><p>We\'ve built a service that features:</p><ul><li>Over 1 million prices for more than 6,000 drugs at every major US pharmacy chain and many local stores</li><li>Prices from all major US pharmacy chains and online pharmacies</li><li>Information on manufacturer discount cards (free coupons provided by pharmaceutical manufacturers that can save you $500 or more)</li><li>Information on ways to save with coupons, price-matching, pharmacy discount plans and more</li><li>Alert so you can be aware when drug prices change (and they do all the time)</li><br/><br/>\n    </body>\n</html>\n\n", "text/html", "utf-8", (String)null);
   }

   public void onStop() {
      super.onStop();
      this.webView.loadDataWithBaseURL((String)null, "", "text/html", "utf-8", (String)null);
   }
}
