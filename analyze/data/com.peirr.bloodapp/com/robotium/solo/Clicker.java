package com.robotium.solo;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.TextView;
import com.robotium.solo.ActivityUtils;
import com.robotium.solo.DialogUtils;
import com.robotium.solo.RobotiumUtils;
import com.robotium.solo.Sender;
import com.robotium.solo.Sleeper;
import com.robotium.solo.Timeout;
import com.robotium.solo.ViewFetcher;
import com.robotium.solo.Waiter;
import com.robotium.solo.WebElement;
import com.robotium.solo.WebUtils;
import com.robotium.solo.class_0;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import junit.framework.Assert;

class Clicker {
   private final String LOG_TAG = "Robotium";
   private final int MINI_WAIT = 200;
   private final int WAIT_TIME = 1500;
   private final ActivityUtils activityUtils;
   private final DialogUtils dialogUtils;
   private final Instrumentation inst;
   private final Sender sender;
   private final Sleeper sleeper;
   private final ViewFetcher viewFetcher;
   private final Waiter waiter;
   private final WebUtils webUtils;

   public Clicker(ActivityUtils var1, ViewFetcher var2, Sender var3, Instrumentation var4, Sleeper var5, Waiter var6, WebUtils var7, DialogUtils var8) {
      this.activityUtils = var1;
      this.viewFetcher = var2;
      this.sender = var3;
      this.inst = var4;
      this.sleeper = var5;
      this.waiter = var6;
      this.webUtils = var7;
      this.dialogUtils = var8;
   }

   private float[] getClickCoordinates(View var1) {
      this.sleeper.sleep(200);
      int[] var2 = new int[2];
      float[] var3 = new float[2];
      var1.getLocationOnScreen(var2);
      int var4 = var1.getWidth();
      int var5 = var1.getHeight();
      float var6 = (float)var2[0] + (float)var4 / 2.0F;
      float var7 = (float)var2[1] + (float)var5 / 2.0F;
      var3[0] = var6;
      var3[1] = var7;
      return var3;
   }

   private View getViewOnListLine(AbsListView var1, int var2, int var3) {
      long var4 = SystemClock.uptimeMillis() + (long)Timeout.getSmallTimeout();

      View var6;
      for(var6 = var1.getChildAt(var3); var6 == null; var6 = var1.getChildAt(var3)) {
         boolean var7;
         if(SystemClock.uptimeMillis() > var4) {
            var7 = true;
         } else {
            var7 = false;
         }

         if(var7) {
            Assert.fail("View is null and can therefore not be clicked!");
         }

         this.sleeper.sleep();
         var1 = (AbsListView)this.viewFetcher.getIdenticalView(var1);
         if(var1 == null) {
            var1 = (AbsListView)this.waiter.waitForAndGetView(var2, AbsListView.class);
         }
      }

      return var6;
   }

   private void openMenu() {
      this.sleeper.sleepMini();
      if(!this.dialogUtils.waitForDialogToOpen(200L, false)) {
         try {
            this.sender.sendKeyCode(82);
            this.dialogUtils.waitForDialogToOpen(1500L, true);
         } catch (SecurityException var2) {
            Assert.fail("Can not open the menu!");
            return;
         }
      }

   }

   public ArrayList<TextView> clickInList(int var1) {
      return this.clickInList(var1, 0, false, 0);
   }

   public ArrayList<TextView> clickInList(int var1, int var2, boolean var3, int var4) {
      long var5 = SystemClock.uptimeMillis() + (long)Timeout.getSmallTimeout();
      int var7 = var1 - 1;
      if(var7 < 0) {
         var7 = 0;
      }

      ArrayList var8 = new ArrayList();
      AbsListView var9 = (AbsListView)this.waiter.waitForAndGetView(var2, AbsListView.class);
      if(var9 == null) {
         Assert.fail("ListView is null!");
      }

      for(; var7 > var9.getChildCount(); this.sleeper.sleep()) {
         boolean var11;
         if(SystemClock.uptimeMillis() > var5) {
            var11 = true;
         } else {
            var11 = false;
         }

         if(var11) {
            int var12 = var9.getChildCount();
            Assert.fail("Can not click on line number " + var1 + " as there are only " + var12 + " lines available");
         }
      }

      View var10 = this.getViewOnListLine(var9, var2, var7);
      if(var10 != null) {
         var8 = RobotiumUtils.removeInvisibleViews(this.viewFetcher.getViews(var10, true));
         this.clickOnScreen(var10, var3, var4);
      }

      return RobotiumUtils.filterViews(TextView.class, var8);
   }

   public void clickLongOnScreen(float param1, float param2, int param3, View param4) {
      // $FF: Couldn't be decompiled
   }

   public void clickLongOnTextAndPress(String var1, int var2) {
      this.clickOnText(var1, true, 0, true, 0);
      this.dialogUtils.waitForDialogToOpen((long)Timeout.getSmallTimeout(), true);

      try {
         this.inst.sendKeyDownUpSync(20);
      } catch (SecurityException var6) {
         Assert.fail("Can not press the context menu!");
      }

      for(int var5 = 0; var5 < var2; ++var5) {
         this.sleeper.sleepMini();
         this.inst.sendKeyDownUpSync(20);
      }

      this.inst.sendKeyDownUpSync(66);
   }

   public <T extends View> void clickOn(Class<T> var1, int var2) {
      this.clickOnScreen(this.waiter.waitForAndGetView(var2, var1));
   }

   public <T extends TextView> void clickOn(Class<T> var1, String var2) {
      TextView var3 = this.waiter.waitForText(var1, var2, 0, (long)Timeout.getSmallTimeout(), true, true, false);
      if(var3 != null) {
         this.clickOnScreen(var3);
      } else {
         Iterator var4 = RobotiumUtils.removeInvisibleViews(this.viewFetcher.getCurrentViews(var1, true)).iterator();

         while(var4.hasNext()) {
            TextView var5 = (TextView)var4.next();
            Log.d("Robotium", "\'" + var2 + "\' not found. Have found: \'" + var5.getText() + "\'");
         }

         Assert.fail(var1.getSimpleName() + " with text: \'" + var2 + "\' is not found!");
      }
   }

   public void clickOnActionBarHomeButton() {
      Activity var1 = this.activityUtils.getCurrentActivity();

      MenuItem var4;
      try {
         Class var7 = Class.forName("com.android.internal.view.menu.ActionMenuItem");
         Class[] var8 = new Class[]{Context.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, CharSequence.class};
         Constructor var9 = var7.getConstructor(var8);
         Object[] var10 = new Object[]{var1, Integer.valueOf(0), Integer.valueOf(16908332), Integer.valueOf(0), Integer.valueOf(0), ""};
         var4 = (MenuItem)var9.newInstance(var10);
      } catch (Exception var12) {
         Log.d("Robotium", "Can not find methods to invoke Home button!");
         var4 = null;
      }

      if(var4 != null) {
         try {
            var1.getWindow().getCallback().onMenuItemSelected(0, var4);
         } catch (Exception var11) {
            return;
         }
      }

   }

   public void clickOnActionBarItem(int var1) {
      this.sleeper.sleep();
      this.inst.invokeMenuActionSync(this.activityUtils.getCurrentActivity(), var1, 0);
   }

   public void clickOnMenuItem(String var1) {
      this.openMenu();
      this.clickOnText(var1, false, 1, true, 0);
   }

   public void clickOnMenuItem(String var1, boolean var2) {
      this.sleeper.sleepMini();
      int[] var3 = new int[2];
      if(!this.dialogUtils.waitForDialogToOpen(200L, false)) {
         try {
            this.sender.sendKeyCode(82);
            this.dialogUtils.waitForDialogToOpen(1500L, true);
         } catch (SecurityException var12) {
            Assert.fail("Can not open the menu!");
         }
      }

      boolean var4;
      if(this.waiter.waitForText(var1, 1, 1500L, true) != null) {
         var4 = true;
      } else {
         var4 = false;
      }

      TextView var5 = null;
      if(var2) {
         int var6 = this.viewFetcher.getCurrentViews(TextView.class, true).size();
         var5 = null;
         if(var6 > 5) {
            var5 = null;
            if(!var4) {
               Iterator var7 = this.viewFetcher.getCurrentViews(TextView.class, true).iterator();

               label36:
               while(true) {
                  TextView var8;
                  int var9;
                  int var10;
                  do {
                     if(!var7.hasNext()) {
                        break label36;
                     }

                     var8 = (TextView)var7.next();
                     var9 = var3[0];
                     var10 = var3[1];
                     var8.getLocationOnScreen(var3);
                  } while(var3[0] <= var9 && var3[1] <= var10);

                  var5 = var8;
               }
            }
         }
      }

      if(var5 != null) {
         this.clickOnScreen(var5);
      }

      this.clickOnText(var1, false, 1, true, 0);
   }

   public void clickOnScreen(float var1, float var2, View var3) {
      boolean var4 = false;
      int var5 = 0;
      SecurityException var6 = null;

      while(!var4 && var5 < 10) {
         long var9 = SystemClock.uptimeMillis();
         long var11 = SystemClock.uptimeMillis();
         MotionEvent var13 = MotionEvent.obtain(var9, var11, 0, var1, var2, 0);
         MotionEvent var14 = MotionEvent.obtain(var9, var11, 1, var1, var2, 0);

         try {
            this.inst.sendPointerSync(var13);
            this.inst.sendPointerSync(var14);
         } catch (SecurityException var18) {
            var6 = var18;
            this.dialogUtils.hideSoftKeyboard((EditText)null, false, true);
            this.sleeper.sleep(200);
            ++var5;
            View var16 = this.viewFetcher.getIdenticalView(var3);
            if(var16 != null) {
               float[] var17 = this.getClickCoordinates(var16);
               var1 = var17[0];
               var2 = var17[1];
            }
            continue;
         }

         var4 = true;
      }

      if(!var4) {
         StringBuilder var7 = (new StringBuilder()).append("Click at (").append(var1).append(", ").append(var2).append(") can not be completed! (");
         String var8;
         if(var6 != null) {
            var8 = var6.getClass().getName() + ": " + var6.getMessage();
         } else {
            var8 = "null";
         }

         Assert.fail(var7.append(var8).append(")").toString());
      }

   }

   public void clickOnScreen(View var1) {
      this.clickOnScreen(var1, false, 0);
   }

   public void clickOnScreen(View var1, boolean var2, int var3) {
      if(var1 == null) {
         Assert.fail("View is null and can therefore not be clicked!");
      }

      float[] var4 = this.getClickCoordinates(var1);
      float var5 = var4[0];
      float var6 = var4[1];
      if(var5 == 0.0F || var6 == 0.0F) {
         this.sleeper.sleepMini();

         label25: {
            View var9;
            try {
               var9 = this.viewFetcher.getIdenticalView(var1);
            } catch (Exception var10) {
               break label25;
            }

            var1 = var9;
         }

         if(var1 != null) {
            float[] var8 = this.getClickCoordinates(var1);
            var5 = var8[0];
            var6 = var8[1];
         }
      }

      if(var2) {
         this.clickLongOnScreen(var5, var6, var3, var1);
      } else {
         this.clickOnScreen(var5, var6, var1);
      }
   }

   public void clickOnText(String var1, boolean var2, int var3, boolean var4, int var5) {
      TextView var6 = this.waiter.waitForText(var1, var3, (long)Timeout.getSmallTimeout(), var4, true, false);
      if(var6 != null) {
         this.clickOnScreen(var6, var2, var5);
      } else if(var3 > 1) {
         Assert.fail(var3 + " matches of text string: \'" + var1 + "\' are not found!");
      } else {
         ArrayList var7 = RobotiumUtils.removeInvisibleViews(this.viewFetcher.getCurrentViews(TextView.class, true));
         var7.addAll(this.webUtils.getTextViewsFromWebView());
         Iterator var9 = var7.iterator();

         while(var9.hasNext()) {
            TextView var10 = (TextView)var9.next();
            Log.d("Robotium", "\'" + var1 + "\' not found. Have found: \'" + var10.getText() + "\'");
         }

         Assert.fail("Text string: \'" + var1 + "\' is not found!");
      }
   }

   public void clickOnWebElement(class_0 var1, int var2, boolean var3, boolean var4) {
      if(var4) {
         if(this.waiter.waitForWebElement(var1, var2, Timeout.getSmallTimeout(), false) == null) {
            Assert.fail("WebElement with " + this.webUtils.splitNameByUpperCase(var1.getClass().getSimpleName()) + ": \'" + var1.getValue() + "\' is not found!");
         }

         this.webUtils.executeJavaScript(var1, true);
      } else {
         WebElement var5 = this.waiter.waitForWebElement(var1, var2, Timeout.getSmallTimeout(), var3);
         if(var5 == null) {
            if(var2 > 1) {
               Assert.fail(var2 + " WebElements with " + this.webUtils.splitNameByUpperCase(var1.getClass().getSimpleName()) + ": \'" + var1.getValue() + "\' are not found!");
            } else {
               Assert.fail("WebElement with " + this.webUtils.splitNameByUpperCase(var1.getClass().getSimpleName()) + ": \'" + var1.getValue() + "\' is not found!");
            }
         }

         this.clickOnScreen((float)var5.getLocationX(), (float)var5.getLocationY(), (View)null);
      }
   }
}
