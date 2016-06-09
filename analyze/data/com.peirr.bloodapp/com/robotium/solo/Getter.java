package com.robotium.solo;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.robotium.solo.ActivityUtils;
import com.robotium.solo.Timeout;
import com.robotium.solo.Waiter;
import junit.framework.Assert;

class Getter {
   private final int TIMEOUT = 1000;
   private final ActivityUtils activityUtils;
   private final Instrumentation instrumentation;
   private final Waiter waiter;

   public Getter(Instrumentation var1, ActivityUtils var2, Waiter var3) {
      this.instrumentation = var1;
      this.activityUtils = var2;
      this.waiter = var3;
   }

   public String getString(int var1) {
      return this.activityUtils.getCurrentActivity(false).getString(var1);
   }

   public String getString(String var1) {
      Context var2 = this.instrumentation.getTargetContext();
      String var3 = var2.getPackageName();
      int var4 = var2.getResources().getIdentifier(var1, "string", var3);
      if(var4 == 0) {
         var4 = var2.getResources().getIdentifier(var1, "string", "android");
      }

      return this.getString(var4);
   }

   public View getView(int var1, int var2) {
      return this.getView(var1, var2, 0);
   }

   public View getView(int var1, int var2, int var3) {
      Activity var4 = this.activityUtils.getCurrentActivity(false);
      View var5 = null;
      if(var2 < 1) {
         var2 = 0;
         var5 = var4.findViewById(var1);
      }

      return var5 != null?var5:this.waiter.waitForView(var1, var2, var3);
   }

   public <T extends View> T getView(Class<T> var1, int var2) {
      return this.waiter.waitForAndGetView(var2, var1);
   }

   public View getView(String var1, int var2) {
      Context var3 = this.instrumentation.getTargetContext();
      String var4 = var3.getPackageName();
      int var5 = var3.getResources().getIdentifier(var1, "id", var4);
      View var6 = null;
      if(var5 != 0) {
         var6 = this.getView(var5, var2, 1000);
      }

      if(var6 == null) {
         int var7 = var3.getResources().getIdentifier(var1, "id", "android");
         if(var7 != 0) {
            var6 = this.getView(var7, var2, 1000);
         }
      }

      return var6 != null?var6:this.getView(var5, var2);
   }

   public <T extends TextView> T getView(Class<T> var1, String var2, boolean var3) {
      TextView var4 = this.waiter.waitForText(var1, var2, 0, (long)Timeout.getSmallTimeout(), false, var3, false);
      if(var4 == null) {
         Assert.fail(var1.getSimpleName() + " with text: \'" + var2 + "\' is not found!");
      }

      return var4;
   }
}
