package com.goodrx.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.goodrx.widget.BaseActivityWithPasscode;

public class SearchActivity extends BaseActivityWithPasscode {
   public static void launch(Activity var0) {
      var0.startActivity(new Intent(var0, SearchActivity.class));
      var0.overridePendingTransition(2131034136, 2131034136);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130968639);
   }
}
