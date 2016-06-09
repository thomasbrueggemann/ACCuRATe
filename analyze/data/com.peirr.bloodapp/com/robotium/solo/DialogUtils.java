package com.robotium.solo;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.robotium.solo.ActivityUtils;
import com.robotium.solo.Sleeper;
import com.robotium.solo.ViewFetcher;

class DialogUtils {
   private static final int TIMEOUT_DIALOG_TO_CLOSE = 1000;
   private final int MINISLEEP = 200;
   private final ActivityUtils activityUtils;
   private final Sleeper sleeper;
   private final ViewFetcher viewFetcher;

   public DialogUtils(ActivityUtils var1, ViewFetcher var2, Sleeper var3) {
      this.activityUtils = var1;
      this.viewFetcher = var2;
      this.sleeper = var3;
   }

   private boolean isDialog(Activity var1, View var2) {
      if(var2 != null && var2.isShown()) {
         Context var3 = null;
         if(var2 != null) {
            var3 = var2.getContext();
         }

         if(var3 instanceof ContextThemeWrapper) {
            var3 = ((ContextThemeWrapper)var3).getBaseContext();
         }

         Context var4 = var1.getBaseContext();
         if((var1.equals(var3) || var4.equals(var3)) && var2 != var1.getWindow().getDecorView()) {
            return true;
         }
      }

      return false;
   }

   private boolean isDialogOpen() {
      Activity var1 = this.activityUtils.getCurrentActivity(false);
      View[] var2 = this.viewFetcher.getWindowDecorViews();
      if(!this.isDialog(var1, this.viewFetcher.getRecentDecorView(var2))) {
         int var3 = var2.length;
         int var4 = 0;

         while(true) {
            if(var4 >= var3) {
               return false;
            }

            if(this.isDialog(var1, var2[var4])) {
               break;
            }

            ++var4;
         }
      }

      return true;
   }

   public void hideSoftKeyboard(EditText var1, boolean var2, boolean var3) {
      Activity var4 = this.activityUtils.getCurrentActivity(var2);
      InputMethodManager var5 = (InputMethodManager)var4.getSystemService("input_method");
      if(var1 != null) {
         var5.hideSoftInputFromWindow(var1.getWindowToken(), 0);
      } else {
         Object var6 = var4.getCurrentFocus();
         if(!(var6 instanceof EditText)) {
            EditText var8 = (EditText)this.viewFetcher.getFreshestView(this.viewFetcher.getCurrentViews(EditText.class, true));
            if(var8 != null) {
               var6 = var8;
            }
         }

         if(var6 != null) {
            var5.hideSoftInputFromWindow(((View)var6).getWindowToken(), 0);
         }

         if(var3) {
            this.sleeper.sleep();
            return;
         }
      }

   }

   public boolean waitForDialogToClose(long var1) {
      this.waitForDialogToOpen(1000L, false);
      long var4 = var1 + SystemClock.uptimeMillis();

      boolean var7;
      while(true) {
         long var8;
         int var6 = (var8 = SystemClock.uptimeMillis() - var4) == 0L?0:(var8 < 0L?-1:1);
         var7 = false;
         if(var6 >= 0) {
            break;
         }

         if(!this.isDialogOpen()) {
            var7 = true;
            break;
         }

         this.sleeper.sleep(200);
      }

      return var7;
   }

   public boolean waitForDialogToOpen(long var1, boolean var3) {
      long var4 = var1 + SystemClock.uptimeMillis();
      boolean var6 = this.isDialogOpen();
      if(var3) {
         this.sleeper.sleep();
      }

      if(var6) {
         return true;
      } else {
         while(SystemClock.uptimeMillis() < var4) {
            if(this.isDialogOpen()) {
               return true;
            }

            this.sleeper.sleepMini();
         }

         return false;
      }
   }
}
