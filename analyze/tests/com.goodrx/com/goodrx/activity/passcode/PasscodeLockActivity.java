package com.goodrx.activity.passcode;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.goodrx.utils.PasscodeManager;
import com.goodrx.widget.Passcode.PasscodeInputFinishListener;
import com.goodrx.widget.Passcode.PasscodeView;
import java.util.List;
import org.joda.time.DateTime;

public class PasscodeLockActivity extends AppCompatActivity {
   private View disabledLayout;
   private int failCounter;

   // $FF: synthetic method
   static int access$008(PasscodeLockActivity var0) {
      int var1 = var0.failCounter;
      var0.failCounter = var1 + 1;
      return var1;
   }

   public static void launch(Activity var0) {
      var0.startActivity(new Intent(var0, PasscodeLockActivity.class));
   }

   @TargetApi(21)
   private void setStatusBarBackground(int var1) {
      if(VERSION.SDK_INT >= 21) {
         Window var2 = this.getWindow();
         var2.addFlags(Integer.MIN_VALUE);
         var2.setStatusBarColor(var1);
      }

   }

   private void showDisableLayout(boolean var1) {
      if(var1) {
         this.disabledLayout.setVisibility(0);
         this.setStatusBarBackground(ContextCompat.getColor(this, 2131755008));
      } else {
         this.disabledLayout.setVisibility(8);
         this.setStatusBarBackground(ContextCompat.getColor(this, 2131755009));
      }
   }

   private void updateDisableTimer(final long var1) {
      this.updateTimeDisplay(var1);
      (new CountDownTimer(var1, var4) {
         public void onFinish() {
            PasscodeLockActivity.this.showDisableLayout(false);
         }

         public void onTick(long var1) {
            PasscodeLockActivity.this.updateTimeDisplay(var1);
         }
      }).start();
   }

   private void updateTimeDisplay(long var1) {
      int var3 = (int)Math.ceil((double)var1 / 60000.0D);
      int var4 = (int)Math.ceil((double)var1 / 3600000.0D);
      String var9;
      if(var3 > 60) {
         String var10 = this.getString(2131427997);
         Object[] var11 = new Object[1];
         Resources var12 = this.getResources();
         Object[] var13 = new Object[]{Integer.valueOf(var4)};
         var11[0] = var12.getQuantityString(2131361813, var4, var13);
         var9 = String.format(var10, var11);
      } else {
         String var5 = this.getString(2131427997);
         Object[] var6 = new Object[1];
         Resources var7 = this.getResources();
         Object[] var8 = new Object[]{Integer.valueOf(var3)};
         var6[0] = var7.getQuantityString(2131361817, var3, var8);
         var9 = String.format(var5, var6);
      }

      ((TextView)this.findViewById(2131886306)).setText(var9);
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
      this.setContentView(2130968626);
      this.setSupportActionBar((Toolbar)this.findViewById(2131886238));
      ActionBar var2 = this.getSupportActionBar();
      var2.setDisplayShowTitleEnabled(false);
      var2.setDisplayHomeAsUpEnabled(false);
      var2.setDisplayShowHomeEnabled(false);
      var2.setDisplayShowCustomEnabled(true);
      var2.setCustomView(View.inflate(this, 2130968771, (ViewGroup)null));
      this.disabledLayout = this.findViewById(2131886305);
      final PasscodeView var3 = (PasscodeView)this.findViewById(2131886304);
      var3.setOnInputFinishListener(new PasscodeInputFinishListener() {
         public void onInputFinish(List<Integer> var1) {
            if(PasscodeManager.getInstance().isValidPasscode(PasscodeLockActivity.this, var1)) {
               PasscodeLockActivity.this.setResult(-1);
               PasscodeLockActivity.this.failCounter = 0;
               PasscodeLockActivity.this.finish();
            } else {
               var3.shake();
               PasscodeLockActivity.access$008(PasscodeLockActivity.this);
               long var3x = (new DateTime()).getMillis();
               if(PasscodeLockActivity.this.failCounter >= 5) {
                  long var5 = var3x;
                  if(PasscodeLockActivity.this.failCounter == 5) {
                     var5 = var3x + 60000L;
                  } else if(PasscodeLockActivity.this.failCounter == 7) {
                     var5 = var3x + 300000L;
                  } else if(PasscodeLockActivity.this.failCounter == 9) {
                     var5 = var3x + 1800000L;
                  } else if(PasscodeLockActivity.this.failCounter == 11) {
                     var5 = var3x + 3600000L;
                  } else if(PasscodeLockActivity.this.failCounter >= 13) {
                     var5 = var3x + 14400000L;
                  }

                  if(var5 > var3x) {
                     PasscodeLockActivity.this.showDisableLayout(true);
                     PasscodeManager.getInstance().setNextAvailableTime(PasscodeLockActivity.this, var5);
                     PasscodeLockActivity.this.updateDisableTimer(var5 - var3x);
                     return;
                  }
               }
            }

         }
      });
   }

   protected void onPause() {
      super.onPause();
      PasscodeManager.getInstance().setFailCounter(this, this.failCounter);
   }

   protected void onResume() {
      super.onResume();
      this.failCounter = PasscodeManager.getInstance().getFailCounter(this);
      long var1 = (new DateTime()).getMillis();
      long var3 = PasscodeManager.getInstance().getNextAvailableTime(this) - var1;
      if(var3 < 1000L) {
         this.showDisableLayout(false);
      } else {
         this.showDisableLayout(true);
         this.updateDisableTimer(var3);
      }
   }
}
