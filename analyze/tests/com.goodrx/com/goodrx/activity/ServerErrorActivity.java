package com.goodrx.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.goodrx.widget.BaseActivityWithPasscode;
import java.util.regex.Pattern;

public class ServerErrorActivity extends BaseActivityWithPasscode {
   public static void launch(Activity var0, int var1, String var2) {
      Intent var3 = new Intent(var0, ServerErrorActivity.class);
      var3.setFlags(536870912);
      var3.putExtra("status_code", var1);
      var3.putExtra("url", var2);
      var0.startActivityForResult(var3, 4);
   }

   public void onBackPressed() {
      Intent var1 = new Intent("android.intent.action.MAIN");
      var1.addCategory("android.intent.category.HOME");
      var1.setFlags(268435456);
      this.startActivity(var1);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.enableScreenViewTracking(2131427866);
      this.setContentView(2130968640);
      ActionBar var2 = this.getSupportActionBar();
      var2.setDisplayShowTitleEnabled(false);
      var2.setDisplayHomeAsUpEnabled(false);
      var2.setDisplayShowHomeEnabled(false);
      var2.setDisplayShowCustomEnabled(true);
      var2.setCustomView(View.inflate(this, 2130968771, (ViewGroup)null));
      ((Button)this.findViewById(2131886348)).setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            ServerErrorActivity.this.finish();
         }
      });
      int var3 = this.getIntent().getIntExtra("status_code", 0);
      ((TextView)this.findViewById(2131886347)).setText(String.valueOf(var3));
      String var4 = this.getIntent().getStringExtra("url");
      if(var4 != null) {
         String var5 = Pattern.compile("token=.*&token_id=.*&?").matcher(var4).replaceFirst("token=***&token_id=***&");
         String var6 = Pattern.compile("password=.*&?").matcher(var5).replaceFirst("password=***").replace("https://www.goodrx.com/mobile-api/", "");
         ((TextView)this.findViewById(2131886349)).setText(var6);
      }

   }
}
