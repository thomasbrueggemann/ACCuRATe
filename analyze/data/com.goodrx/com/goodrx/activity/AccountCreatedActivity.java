package com.goodrx.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.goodrx.activity.main.MainActivity;
import com.goodrx.utils.MyRxUtils;
import com.goodrx.widget.BaseActivityWithPasscode;

public class AccountCreatedActivity extends BaseActivityWithPasscode {
   private void openMainActivity() {
      Intent var1 = new Intent(this, MainActivity.class);
      MyRxUtils.setRxUpdateFlag(this);
      var1.setFlags(67108864);
      this.startActivity(var1);
      this.finish();
   }

   public void onContinueClicked(View var1) {
      this.openMainActivity();
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.enableScreenViewTracking(2131427823);
      this.setContentView(2130968602);
      this.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
   }
}
