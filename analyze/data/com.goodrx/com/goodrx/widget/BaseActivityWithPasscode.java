package com.goodrx.widget;

import android.app.KeyguardManager;
import android.os.Bundle;
import android.os.Build.VERSION;
import com.goodrx.activity.passcode.PasscodeLockActivity;
import com.goodrx.activity.passcode.SystemLockActivity;
import com.goodrx.utils.PasscodeManager;
import com.goodrx.widget.BaseActivity;

public class BaseActivityWithPasscode extends BaseActivity {
   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
   }

   protected void onPause() {
      super.onPause();
      PasscodeManager.getInstance().setActive(this, false);
   }

   protected void onResume() {
      super.onResume();
      if(PasscodeManager.getInstance().shouldLockScreen(this)) {
         if(VERSION.SDK_INT >= 23) {
            if(((KeyguardManager)this.getSystemService("keyguard")).isKeyguardSecure()) {
               SystemLockActivity.launch(this);
            } else if(PasscodeManager.getInstance().isLocalPasscodeAvailable(this)) {
               PasscodeLockActivity.launch(this);
            } else {
               PasscodeManager.getInstance().setPassCodeFeatureEnabled(this, false);
            }
         } else {
            PasscodeLockActivity.launch(this);
         }
      } else {
         PasscodeManager.getInstance().setActive(this, true);
      }
   }
}
