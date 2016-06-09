package com.robotium.solo;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import com.robotium.solo.ActivityUtils;
import com.robotium.solo.Waiter;
import junit.framework.Assert;

class Asserter {
   private final ActivityUtils activityUtils;
   private final Waiter waiter;

   public Asserter(ActivityUtils var1, Waiter var2) {
      this.activityUtils = var1;
      this.waiter = var2;
   }

   public void assertCurrentActivity(String var1, Class<? extends Activity> var2) {
      if(var2 == null) {
         Assert.fail("The specified Activity is null!");
      }

      if(!this.waiter.waitForActivity(var2)) {
         Assert.assertEquals(var1, var2.getName(), this.activityUtils.getCurrentActivity().getClass().getName());
      }

   }

   public void assertCurrentActivity(String var1, Class<? extends Activity> var2, boolean var3) {
      boolean var4 = false;
      this.assertCurrentActivity(var1, var2);
      Activity var5 = this.activityUtils.getCurrentActivity(false);

      for(int var6 = 0; var6 < -1 + this.activityUtils.getAllOpenedActivities().size(); ++var6) {
         if(((Activity)this.activityUtils.getAllOpenedActivities().get(var6)).toString().equals(var5.toString())) {
            var4 = true;
         }
      }

      Assert.assertNotSame(var1, Boolean.valueOf(var3), Boolean.valueOf(var4));
   }

   public void assertCurrentActivity(String var1, String var2) {
      if(!this.waiter.waitForActivity(var2)) {
         Assert.assertEquals(var1, var2, this.activityUtils.getCurrentActivity().getClass().getSimpleName());
      }

   }

   public void assertCurrentActivity(String var1, String var2, boolean var3) {
      this.assertCurrentActivity(var1, var2);
      this.assertCurrentActivity(var1, this.activityUtils.getCurrentActivity().getClass(), var3);
   }

   public void assertMemoryNotLow() {
      MemoryInfo var1 = new MemoryInfo();
      ((ActivityManager)this.activityUtils.getCurrentActivity().getSystemService("activity")).getMemoryInfo(var1);
      Assert.assertFalse("Low memory available: " + var1.availMem + " bytes!", var1.lowMemory);
   }
}
