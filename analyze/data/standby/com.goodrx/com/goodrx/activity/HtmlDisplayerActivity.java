package com.goodrx.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.goodrx.WebViewFragment;
import com.goodrx.widget.BaseActivityWithPasscode;

public class HtmlDisplayerActivity extends BaseActivityWithPasscode {
   public static void launch(Activity var0, String var1, String var2, boolean var3) {
      Intent var4 = new Intent(var0, HtmlDisplayerActivity.class);
      var4.putExtra("title", var1);
      var4.putExtra("url", var2);
      var4.putExtra("js_enabled", var3);
      var0.startActivity(var4);
      var0.overridePendingTransition(2131034132, 2131034138);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130968614);
      Intent var2 = this.getIntent();
      String var3 = var2.getStringExtra("title");
      String var4 = var2.getStringExtra("url");
      boolean var5 = var2.getBooleanExtra("js_enabled", false);
      this.getSupportActionBar().setTitle(var3);
      WebViewFragment var6 = WebViewFragment.newInstance(var4, var5);
      this.getSupportFragmentManager().beginTransaction().replace(2131886271, var6).commitAllowingStateLoss();
   }
}
