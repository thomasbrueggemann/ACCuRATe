package com.robotium.solo;

import android.app.Instrumentation;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ScrollView;
import com.robotium.solo.ActivityUtils;
import com.robotium.solo.RobotiumUtils;
import com.robotium.solo.Sleeper;
import com.robotium.solo.Solo;
import com.robotium.solo.ViewFetcher;
import java.util.ArrayList;
import junit.framework.Assert;

class Scroller {
   public static final int DOWN = 0;
   // $FF: renamed from: UP int
   public static final int field_6 = 1;
   private final ActivityUtils activityUtils;
   private boolean canScroll = false;
   private final Solo.Config config;
   private final Instrumentation inst;
   private final Sleeper sleeper;
   private final ViewFetcher viewFetcher;

   public Scroller(Solo.Config var1, Instrumentation var2, ActivityUtils var3, ViewFetcher var4, Sleeper var5) {
      this.config = var1;
      this.inst = var2;
      this.activityUtils = var3;
      this.viewFetcher = var4;
      this.sleeper = var5;
   }

   private boolean scrollScrollView(final ScrollView var1, int var2) {
      if(var1 != null) {
         int var3 = -1 + var1.getHeight();
         final int var4 = -1;
         if(var2 == 0) {
            var4 = var3;
         } else if(var2 == 1) {
            var4 = -var3;
         }

         int var5 = var1.getScrollY();
         this.inst.runOnMainSync(new Runnable() {
            public void run() {
               var1.scrollBy(0, var4);
            }
         });
         if(var5 != var1.getScrollY()) {
            return true;
         }
      }

      return false;
   }

   private void scrollScrollViewAllTheWay(ScrollView var1, int var2) {
      while(this.scrollScrollView(var1, var2)) {
         ;
      }

   }

   public void drag(float var1, float var2, float var3, float var4, int var5) {
      long var6 = SystemClock.uptimeMillis();
      long var8 = SystemClock.uptimeMillis();
      float var10 = (var4 - var3) / (float)var5;
      float var11 = (var2 - var1) / (float)var5;
      MotionEvent var12 = MotionEvent.obtain(var6, var8, 0, var1, var3, 0);

      try {
         this.inst.sendPointerSync(var12);
      } catch (SecurityException var23) {
         ;
      }

      int var14 = 0;
      float var15 = var1;

      for(float var16 = var3; var14 < var5; ++var14) {
         var16 += var10;
         var15 += var11;
         MotionEvent var19 = MotionEvent.obtain(var6, SystemClock.uptimeMillis(), 2, var15, var16, 0);

         try {
            this.inst.sendPointerSync(var19);
         } catch (SecurityException var22) {
            ;
         }
      }

      MotionEvent var17 = MotionEvent.obtain(var6, SystemClock.uptimeMillis(), 1, var2, var4, 0);

      try {
         this.inst.sendPointerSync(var17);
      } catch (SecurityException var21) {
         ;
      }
   }

   public boolean scroll(int var1) {
      return this.scroll(var1, false);
   }

   public boolean scroll(int var1, boolean var2) {
      ArrayList var3 = RobotiumUtils.removeInvisibleViews(this.viewFetcher.getAllViews(true));
      ArrayList var4 = RobotiumUtils.filterViewsToSet(new Class[]{ListView.class, ScrollView.class, GridView.class, WebView.class}, var3);
      View var5 = this.viewFetcher.getFreshestView(var4);
      if(var5 != null) {
         if(var5 instanceof AbsListView) {
            return this.scrollList((AbsListView)var5, var1, var2);
         }

         if(var5 instanceof ScrollView) {
            if(var2) {
               this.scrollScrollViewAllTheWay((ScrollView)var5, var1);
               return false;
            }

            return this.scrollScrollView((ScrollView)var5, var1);
         }

         if(var5 instanceof WebView) {
            return this.scrollWebView((WebView)var5, var1, var2);
         }
      }

      return false;
   }

   public boolean scrollDown() {
      return !this.config.shouldScroll?false:this.scroll(0);
   }

   public <T extends AbsListView> boolean scrollList(T var1, int var2, boolean var3) {
      if(var1 != null) {
         if(var2 == 0) {
            int var7 = var1.getCount();
            int var8 = var1.getLastVisiblePosition();
            if(var3) {
               this.scrollListToLine(var1, var7 - 1);
               return false;
            }

            if(var8 >= var7 - 1) {
               if(var8 > 0) {
                  this.scrollListToLine(var1, var8);
                  return false;
               }

               return false;
            }

            int var9 = var1.getFirstVisiblePosition();
            if(var9 != var8) {
               this.scrollListToLine(var1, var8);
            } else {
               this.scrollListToLine(var1, var9 + 1);
            }
         } else if(var2 == 1) {
            int var4 = var1.getFirstVisiblePosition();
            if(var3 || var4 < 2) {
               this.scrollListToLine(var1, 0);
               return false;
            }

            int var5 = var1.getLastVisiblePosition();
            int var6 = var4 - (var5 - var4);
            if(var6 == var5) {
               --var6;
            }

            if(var6 < 0) {
               var6 = 0;
            }

            this.scrollListToLine(var1, var6);
         }

         this.sleeper.sleep();
         return true;
      } else {
         return false;
      }
   }

   public <T extends AbsListView> void scrollListToLine(final T var1, int var2) {
      if(var1 == null) {
         Assert.fail("AbsListView is null!");
      }

      final int var3;
      if(var1 instanceof GridView) {
         var3 = var2 + 1;
      } else {
         var3 = var2;
      }

      this.inst.runOnMainSync(new Runnable() {
         public void run() {
            var1.setSelection(var3);
         }
      });
   }

   public void scrollToSide(Scroller.Side var1, float var2, int var3) {
      int var4 = this.activityUtils.getCurrentActivity().getWindowManager().getDefaultDisplay().getHeight();
      float var5 = var2 * (float)this.activityUtils.getCurrentActivity(false).getWindowManager().getDefaultDisplay().getWidth();
      float var6 = (float)var4 / 2.0F;
      if(var1 == Scroller.Side.LEFT) {
         this.drag(70.0F, var5, var6, var6, var3);
      } else if(var1 == Scroller.Side.RIGHT) {
         this.drag(var5, 0.0F, var6, var6, var3);
         return;
      }

   }

   public void scrollViewToSide(View var1, Scroller.Side var2, float var3, int var4) {
      int[] var5 = new int[2];
      var1.getLocationOnScreen(var5);
      int var6 = var1.getHeight();
      int var7 = var1.getWidth();
      float var8 = (float)var5[0] + var3 * (float)var7;
      float var9 = (float)var5[1] + (float)var6 / 2.0F;
      if(var2 == Scroller.Side.LEFT) {
         this.drag((float)var5[0], var8, var9, var9, var4);
      } else if(var2 == Scroller.Side.RIGHT) {
         this.drag(var8, (float)var5[0], var9, var9, var4);
         return;
      }

   }

   public boolean scrollWebView(final WebView var1, int var2, final boolean var3) {
      if(var2 == 0) {
         this.inst.runOnMainSync(new Runnable() {
            public void run() {
               Scroller.this.canScroll = var1.pageDown(var3);
            }
         });
      }

      if(var2 == 1) {
         this.inst.runOnMainSync(new Runnable() {
            public void run() {
               Scroller.this.canScroll = var1.pageUp(var3);
            }
         });
      }

      return this.canScroll;
   }

   public static enum Side {
      LEFT,
      RIGHT;

      static {
         Scroller.Side[] var0 = new Scroller.Side[]{LEFT, RIGHT};
      }
   }
}
