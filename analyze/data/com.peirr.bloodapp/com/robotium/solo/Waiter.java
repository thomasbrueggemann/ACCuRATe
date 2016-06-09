package com.robotium.solo;

import android.app.Activity;
import android.app.Fragment;
import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;
import com.robotium.solo.ActivityUtils;
import com.robotium.solo.Condition;
import com.robotium.solo.RobotiumUtils;
import com.robotium.solo.Scroller;
import com.robotium.solo.Searcher;
import com.robotium.solo.Sleeper;
import com.robotium.solo.Timeout;
import com.robotium.solo.ViewFetcher;
import com.robotium.solo.WebElement;
import com.robotium.solo.class_0;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import junit.framework.Assert;

class Waiter {
   private final int MINISLEEP = 20;
   private final ActivityUtils activityUtils;
   private final Scroller scroller;
   private final Searcher searcher;
   private final Sleeper sleeper;
   private final ViewFetcher viewFetcher;

   public Waiter(ActivityUtils var1, ViewFetcher var2, Searcher var3, Scroller var4, Sleeper var5) {
      this.activityUtils = var1;
      this.viewFetcher = var2;
      this.searcher = var3;
      this.scroller = var4;
      this.sleeper = var5;
   }

   private void destroy(Process var1, BufferedReader var2) {
      var1.destroy();

      try {
         var2.close();
      } catch (IOException var4) {
         var4.printStackTrace();
      }
   }

   private Fragment getFragment(String param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private StringBuilder getLog(StringBuilder param1) {
      // $FF: Couldn't be decompiled
   }

   private android.support.v4.app.Fragment getSupportFragment(String param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   public void clearLog() {
      try {
         Runtime.getRuntime().exec("logcat -c");
      } catch (IOException var2) {
         var2.printStackTrace();
      }
   }

   public boolean waitForActivity(Class<? extends Activity> var1) {
      return this.waitForActivity(var1, Timeout.getSmallTimeout());
   }

   public boolean waitForActivity(Class<? extends Activity> var1, int var2) {
      Activity var3 = this.activityUtils.getCurrentActivity(false, false);
      long var4 = SystemClock.uptimeMillis() + (long)var2;

      boolean var7;
      while(true) {
         long var8;
         int var6 = (var8 = SystemClock.uptimeMillis() - var4) == 0L?0:(var8 < 0L?-1:1);
         var7 = false;
         if(var6 >= 0) {
            break;
         }

         if(var3 != null && var3.getClass().equals(var1)) {
            var7 = true;
            break;
         }

         this.sleeper.sleep(20);
         var3 = this.activityUtils.getCurrentActivity(false, false);
      }

      return var7;
   }

   public boolean waitForActivity(String var1) {
      return this.waitForActivity(var1, Timeout.getSmallTimeout());
   }

   public boolean waitForActivity(String var1, int var2) {
      Activity var3 = this.activityUtils.getCurrentActivity(false, false);

      for(long var4 = SystemClock.uptimeMillis() + (long)var2; SystemClock.uptimeMillis() < var4; var3 = this.activityUtils.getCurrentActivity(false, false)) {
         if(var3 != null && var3.getClass().getSimpleName().equals(var1) || this.activityUtils.getCurrentActivityName().contains(var1)) {
            return true;
         }

         this.sleeper.sleep(20);
      }

      return false;
   }

   public <T extends View> T waitForAndGetView(int var1, Class<T> var2) {
      long var3 = SystemClock.uptimeMillis() + (long)Timeout.getSmallTimeout();

      while(SystemClock.uptimeMillis() <= var3 && !this.waitForView(var2, var1, true, true)) {
         ;
      }

      int var5 = this.searcher.getNumberOfUniqueViews();
      ArrayList var6 = RobotiumUtils.removeInvisibleViews(this.viewFetcher.getCurrentViews(var2, true));
      if(var6.size() < var5) {
         int var10 = var1 - (var5 - var6.size());
         if(var10 >= 0) {
            var1 = var10;
         }
      }

      View var9;
      try {
         var9 = (View)var6.get(var1);
      } catch (IndexOutOfBoundsException var11) {
         int var8 = var1 + 1;
         if(var8 > 1) {
            Assert.fail(var8 + " " + var2.getSimpleName() + "s" + " are not found!");
            var9 = null;
         } else {
            Assert.fail(var2.getSimpleName() + " is not found!");
            var9 = null;
         }
      }

      return var9;
   }

   public boolean waitForCondition(Condition var1, int var2) {
      long var3 = SystemClock.uptimeMillis() + (long)var2;

      do {
         boolean var5;
         if(SystemClock.uptimeMillis() > var3) {
            var5 = true;
         } else {
            var5 = false;
         }

         if(var5) {
            return false;
         }

         this.sleeper.sleep();
      } while(!var1.isSatisfied());

      return true;
   }

   public boolean waitForFragment(String var1, int var2, int var3) {
      long var4 = SystemClock.uptimeMillis() + (long)var3;

      do {
         if(SystemClock.uptimeMillis() > var4) {
            return false;
         }

         if(this.getSupportFragment(var1, var2) != null) {
            return true;
         }
      } while(this.getFragment(var1, var2) == null);

      return true;
   }

   public boolean waitForLogMessage(String var1, int var2) {
      StringBuilder var3 = new StringBuilder();
      long var4 = SystemClock.uptimeMillis() + (long)var2;

      while(SystemClock.uptimeMillis() <= var4) {
         if(this.getLog(var3).lastIndexOf(var1) != -1) {
            return true;
         }

         this.sleeper.sleep();
      }

      return false;
   }

   public <T extends TextView> T waitForText(Class<T> var1, String var2, int var3, long var4, boolean var6) {
      return this.waitForText(var1, var2, var3, var4, var6, false, true);
   }

   public <T extends TextView> T waitForText(Class<T> var1, String var2, int var3, long var4, boolean var6, boolean var7, boolean var8) {
      long var9 = var4 + SystemClock.uptimeMillis();

      TextView var12;
      do {
         boolean var11;
         if(SystemClock.uptimeMillis() > var9) {
            var11 = true;
         } else {
            var11 = false;
         }

         if(var11) {
            return null;
         }

         this.sleeper.sleep();
         if(!var8) {
            var4 = 0L;
         }

         var12 = this.searcher.searchFor(var1, var2, var3, var4, var6, var7);
      } while(var12 == null);

      return var12;
   }

   public TextView waitForText(String var1) {
      return this.waitForText(var1, 0, (long)Timeout.getLargeTimeout(), true);
   }

   public TextView waitForText(String var1, int var2, long var3) {
      return this.waitForText(var1, var2, var3, true);
   }

   public TextView waitForText(String var1, int var2, long var3, boolean var5) {
      return this.waitForText(TextView.class, var1, var2, var3, var5, false, true);
   }

   public TextView waitForText(String var1, int var2, long var3, boolean var5, boolean var6, boolean var7) {
      return this.waitForText(TextView.class, var1, var2, var3, var5, var6, var7);
   }

   public View waitForView(int var1, int var2, int var3) {
      if(var3 == 0) {
         var3 = Timeout.getSmallTimeout();
      }

      return this.waitForView(var1, var2, var3, false);
   }

   public View waitForView(int var1, int var2, int var3, boolean var4) {
      HashSet var5 = new HashSet();
      long var6 = SystemClock.uptimeMillis() + (long)var3;

      while(SystemClock.uptimeMillis() <= var6) {
         this.sleeper.sleep();
         Iterator var8 = this.viewFetcher.getAllViews(false).iterator();

         while(var8.hasNext()) {
            View var10 = (View)var8.next();
            if(Integer.valueOf(var10.getId()).equals(Integer.valueOf(var1))) {
               var5.add(var10);
               if(var5.size() > var2) {
                  return var10;
               }
            }
         }

         if(var4) {
            this.scroller.scrollDown();
         }
      }

      return null;
   }

   public View waitForView(View var1, int var2) {
      return this.waitForView(var1, var2, true, true);
   }

   public View waitForView(View var1, int var2, boolean var3, boolean var4) {
      long var5 = SystemClock.uptimeMillis() + (long)var2;
      int var7 = 0;
      if(var1 == null) {
         return null;
      } else {
         label39:
         do {
            for(; SystemClock.uptimeMillis() < var5; this.sleeper.sleep()) {
               boolean var8 = this.searcher.searchFor(var1);
               if(var4 && var8 && !var1.isShown()) {
                  this.sleeper.sleepMini();
                  ++var7;
                  View var10 = this.viewFetcher.getIdenticalView(var1);
                  if(var10 != null && !var1.equals(var10)) {
                     var1 = var10;
                  }
                  continue label39;
               }

               if(var8) {
                  return var1;
               }

               if(var3) {
                  this.scroller.scrollDown();
               }
            }

            return var1;
         } while(var7 <= 5);

         return var1;
      }
   }

   public boolean waitForView(View var1) {
      return this.waitForView(var1, Timeout.getLargeTimeout(), true, true) != null;
   }

   public <T extends View> boolean waitForView(Class<T> var1, int var2, int var3, boolean var4) {
      HashSet var5 = new HashSet();
      long var6 = SystemClock.uptimeMillis() + (long)var3;

      while(SystemClock.uptimeMillis() < var6) {
         this.sleeper.sleep();
         if(this.searcher.searchFor(var5, var1, var2)) {
            return true;
         }

         if(var4) {
            this.scroller.scrollDown();
         }
      }

      return false;
   }

   public <T extends View> boolean waitForView(Class<T> var1, int var2, boolean var3, boolean var4) {
      HashSet var5 = new HashSet();

      boolean var7;
      while(true) {
         if(var3) {
            this.sleeper.sleep();
         }

         if(this.searcher.searchFor(var5, var1, var2)) {
            var7 = true;
            break;
         }

         if(var4) {
            boolean var6 = this.scroller.scrollDown();
            var7 = false;
            if(!var6) {
               break;
            }
         }

         if(!var4) {
            return false;
         }
      }

      return var7;
   }

   public <T extends View> boolean waitForViews(boolean var1, Class... var2) {
      long var3 = SystemClock.uptimeMillis() + (long)Timeout.getSmallTimeout();

      while(true) {
         long var9;
         int var5 = (var9 = SystemClock.uptimeMillis() - var3) == 0L?0:(var9 < 0L?-1:1);
         boolean var6 = false;
         if(var5 >= 0) {
            return var6;
         }

         int var7 = var2.length;

         for(int var8 = 0; var8 < var7; ++var8) {
            if(this.waitForView((Class)var2[var8], 0, false, false)) {
               var6 = true;
               return var6;
            }
         }

         if(var1) {
            this.scroller.scroll(0);
         } else {
            this.scroller.scrollDown();
         }

         this.sleeper.sleep();
      }
   }

   public WebElement waitForWebElement(class_0 var1, int var2, int var3, boolean var4) {
      long var5 = SystemClock.uptimeMillis() + (long)var3;

      WebElement var8;
      while(true) {
         boolean var7;
         if(SystemClock.uptimeMillis() > var5) {
            var7 = true;
         } else {
            var7 = false;
         }

         if(var7) {
            this.searcher.logMatchesFound(var1.getValue());
            var8 = null;
            break;
         }

         this.sleeper.sleep();
         var8 = this.searcher.searchForWebElement(var1, var2);
         if(var8 != null) {
            break;
         }

         if(var4) {
            this.scroller.scrollDown();
         }
      }

      return var8;
   }
}
