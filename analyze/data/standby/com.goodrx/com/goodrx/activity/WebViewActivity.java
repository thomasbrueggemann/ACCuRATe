package com.goodrx.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.webkit.WebView;
import com.goodrx.widget.BaseActivityWithPasscode;

public class WebViewActivity extends BaseActivityWithPasscode {
   public static void launch(Activity var0, String var1, String var2) {
      Intent var3 = new Intent(var0, WebViewActivity.class);
      var3.putExtra("title", var1);
      var3.putExtra("content", var2);
      var0.startActivity(var3);
      var0.overridePendingTransition(2131034132, 2131034138);
   }

   protected void loadContent(String var1) {
      ((WebView)this.findViewById(2131886256)).loadDataWithBaseURL((String)null, var1, "text/html", "utf-8", (String)null);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130968647);
      Bundle var2 = this.getIntent().getExtras();
      String var3 = var2.getString("title");
      String var4 = var2.getString("content");
      ActionBar var5 = this.getSupportActionBar();
      var5.setDisplayHomeAsUpEnabled(true);
      var5.setHomeAsUpIndicator(2130837662);
      var5.setDisplayShowCustomEnabled(true);
      var5.setTitle(var3);
      this.loadContent(var4);
   }
}
