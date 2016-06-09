package com.goodrx.activity.passcode;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import com.goodrx.utils.PasscodeManager;
import com.goodrx.widget.BaseActivity;

@SuppressLint({"NewApi"})
public class SystemLockActivity extends BaseActivity {
   private KeyguardManager mKeyguardManager;

   public static void launch(Activity var0) {
      var0.startActivity(new Intent(var0, SystemLockActivity.class));
   }

   private void showAuthenticationScreen() {
      Intent var1 = this.mKeyguardManager.createConfirmDeviceCredentialIntent(this.getString(2131427604), (CharSequence)null);
      if(var1 != null) {
         this.startActivityForResult(var1, 22);
      }

   }

   protected void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      if(var1 == 22 && var2 == -1) {
         PasscodeManager.getInstance().refreshTimeStamp(this);
         this.finish();
      }

   }

   public void onBackPressed() {
      super.onBackPressed();
      Intent var1 = new Intent("android.intent.action.MAIN");
      var1.addCategory("android.intent.category.HOME");
      var1.setFlags(268435456);
      this.startActivity(var1);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.shouldOverrideBackAnimation(false);
      this.setContentView(2130968646);
      this.setSupportActionBar((Toolbar)this.findViewById(2131886238));
      ActionBar var2 = this.getSupportActionBar();
      var2.setDisplayShowTitleEnabled(false);
      var2.setDisplayHomeAsUpEnabled(false);
      var2.setDisplayShowHomeEnabled(false);
      var2.setDisplayShowCustomEnabled(true);
      var2.setCustomView(View.inflate(this, 2130968771, (ViewGroup)null));
      this.mKeyguardManager = (KeyguardManager)this.getSystemService("keyguard");
      if(!this.mKeyguardManager.isKeyguardSecure()) {
         PasscodeManager.getInstance().setPassCodeFeatureEnabled(this, false);
         this.finish();
      } else {
         this.showAuthenticationScreen();
      }
   }

   public void tryAgainClicked(View var1) {
      this.showAuthenticationScreen();
   }
}
