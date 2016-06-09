package com.robotium.solo;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ScrollView;
import com.robotium.solo.ActivityUtils;
import com.robotium.solo.RobotiumUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

class ViewFetcher {
   private static Class<?> windowManager;
   private final ActivityUtils activityUtils;
   private String windowManagerString;

   static {
      // $FF: Couldn't be decompiled
   }

   public ViewFetcher(ActivityUtils var1) {
      this.activityUtils = var1;
      this.setWindowManagerString();
   }

   private void addChildren(ArrayList<View> var1, ViewGroup var2, boolean var3) {
      if(var2 != null) {
         for(int var4 = 0; var4 < var2.getChildCount(); ++var4) {
            View var5 = var2.getChildAt(var4);
            if(var3 && this.isViewSufficientlyShown(var5)) {
               var1.add(var5);
            } else if(!var3) {
               var1.add(var5);
            }

            if(var5 instanceof ViewGroup) {
               this.addChildren(var1, (ViewGroup)var5, var3);
            }
         }
      }

   }

   private boolean areViewsIdentical(View var1, View var2) {
      return var1.getId() == var2.getId() && var1.getClass().isAssignableFrom(var2.getClass()) && this.isSamePlacementInRespectiveTree(var1, var2)?(var1.getParent() != null && var1.getParent() instanceof View && var2.getParent() != null && var2.getParent() instanceof View?this.areViewsIdentical((View)var1.getParent(), (View)var2.getParent()):true):false;
   }

   private final View[] getNonDecorViews(View[] var1) {
      View[] var2 = null;
      if(var1 != null) {
         var2 = new View[var1.length];
         int var3 = 0;

         for(int var4 = 0; var4 < var1.length; ++var4) {
            View var5 = var1[var4];
            if(var5 != null && !var5.getClass().getName().equals("com.android.internal.policy.impl.PhoneWindow$DecorView")) {
               var2[var3] = var5;
               ++var3;
            }
         }
      }

      return var2;
   }

   private int getObjectPlacementNumber(View param1) {
      // $FF: Couldn't be decompiled
   }

   private final View getRecentContainer(View[] var1) {
      View var2 = null;
      long var3 = 0L;

      for(int var5 = 0; var5 < var1.length; ++var5) {
         View var6 = var1[var5];
         if(var6 != null && var6.isShown() && var6.hasWindowFocus() && var6.getDrawingTime() > var3) {
            var2 = var6;
            var3 = var6.getDrawingTime();
         }
      }

      return var2;
   }

   private boolean isSamePlacementInRespectiveTree(View var1, View var2) {
      return this.getObjectPlacementNumber(var1) == this.getObjectPlacementNumber(var2);
   }

   private void setWindowManagerString() {
      if(VERSION.SDK_INT >= 17) {
         this.windowManagerString = "sDefaultWindowManager";
      } else if(VERSION.SDK_INT >= 13) {
         this.windowManagerString = "sWindowManager";
      } else {
         this.windowManagerString = "mWindowManager";
      }
   }

   public ArrayList<View> getAllViews(boolean var1) {
      View[] var2 = this.getWindowDecorViews();
      ArrayList var3 = new ArrayList();
      View[] var4 = this.getNonDecorViews(var2);
      if(var4 != null) {
         for(int var8 = 0; var8 < var4.length; ++var8) {
            View var9 = var4[var8];

            try {
               this.addChildren(var3, (ViewGroup)var9, var1);
            } catch (Exception var12) {
               ;
            }

            if(var9 != null) {
               var3.add(var9);
            }
         }
      }

      if(var2 != null && var2.length > 0) {
         View var5 = this.getRecentDecorView(var2);

         try {
            this.addChildren(var3, (ViewGroup)var5, var1);
         } catch (Exception var11) {
            ;
         }

         if(var5 != null) {
            var3.add(var5);
         }
      }

      return var3;
   }

   public <T extends View> ArrayList<T> getCurrentViews(Class<T> var1, boolean var2) {
      return this.getCurrentViews(var1, var2, (View)null);
   }

   public <T extends View> ArrayList<T> getCurrentViews(Class<T> var1, boolean var2, View var3) {
      ArrayList var4 = new ArrayList();
      Iterator var5 = this.getViews(var3, true).iterator();

      while(true) {
         View var6;
         Class var7;
         do {
            do {
               if(!var5.hasNext()) {
                  return var4;
               }

               var6 = (View)var5.next();
            } while(var6 == null);

            var7 = var6.getClass();
         } while((!var2 || !var1.isAssignableFrom(var7)) && (var2 || var1 != var7));

         var4.add(var1.cast(var6));
      }
   }

   public final <T extends View> T getFreshestView(ArrayList<T> var1) {
      int[] var2 = new int[2];
      View var3 = null;
      long var4 = 0L;
      if(var1 == null) {
         return null;
      } else {
         Iterator var6 = var1.iterator();

         while(var6.hasNext()) {
            View var7 = (View)var6.next();
            var7.getLocationOnScreen(var2);
            if(var2[0] >= 0 && var7.getDrawingTime() > var4 && var7.getHeight() > 0) {
               var4 = var7.getDrawingTime();
               var3 = var7;
            }
         }

         return var3;
      }
   }

   public View getIdenticalView(View var1) {
      if(var1 != null) {
         Iterator var2 = RobotiumUtils.removeInvisibleViews(this.getCurrentViews(var1.getClass(), true)).iterator();

         while(var2.hasNext()) {
            View var3 = (View)var2.next();
            if(this.areViewsIdentical(var3, var1)) {
               return var3;
            }
         }
      }

      return null;
   }

   public final View getRecentDecorView(View[] var1) {
      if(var1 == null) {
         return null;
      } else {
         View[] var2 = new View[var1.length];
         int var3 = 0;

         for(int var4 = 0; var4 < var1.length; ++var4) {
            View var5 = var1[var4];
            if(var5 != null) {
               String var6 = var5.getClass().getName();
               if(var6.equals("com.android.internal.policy.impl.PhoneWindow$DecorView") || var6.equals("com.android.internal.policy.impl.MultiPhoneWindow$MultiPhoneDecorView")) {
                  var2[var3] = var5;
                  ++var3;
               }
            }
         }

         return this.getRecentContainer(var2);
      }
   }

   public float getScrollListWindowHeight(View var1) {
      int[] var2 = new int[2];
      View var3 = this.getScrollOrListParent(var1);
      float var4;
      if(var3 == null) {
         var4 = (float)this.activityUtils.getCurrentActivity(false).getWindowManager().getDefaultDisplay().getHeight();
      } else {
         var3.getLocationOnScreen(var2);
         var4 = (float)(var2[1] + var3.getHeight());
      }

      return var4;
   }

   public View getScrollOrListParent(View var1) {
      if(!(var1 instanceof AbsListView) && !(var1 instanceof ScrollView) && !(var1 instanceof WebView)) {
         View var3;
         try {
            var3 = this.getScrollOrListParent((View)var1.getParent());
         } catch (Exception var4) {
            return null;
         }

         var1 = var3;
      }

      return var1;
   }

   public View getTopParent(View var1) {
      ViewParent var2 = var1.getParent();
      if(var2 != null && var2 instanceof View) {
         var1 = this.getTopParent((View)var2);
      }

      return var1;
   }

   public ArrayList<View> getViews(View var1, boolean var2) {
      ArrayList var3 = new ArrayList();
      if(var1 == null) {
         var3 = this.getAllViews(var2);
      } else {
         var3.add(var1);
         if(var1 instanceof ViewGroup) {
            this.addChildren(var3, (ViewGroup)var1, var2);
            return var3;
         }
      }

      return var3;
   }

   public View[] getWindowDecorViews() {
      try {
         Field var2 = windowManager.getDeclaredField("mViews");
         Field var3 = windowManager.getDeclaredField(this.windowManagerString);
         var2.setAccessible(true);
         var3.setAccessible(true);
         Object var4 = var3.get((Object)null);
         if(VERSION.SDK_INT >= 19) {
            return (View[])((ArrayList)var2.get(var4)).toArray(new View[0]);
         } else {
            View[] var5 = (View[])((View[])var2.get(var4));
            return var5;
         }
      } catch (Exception var6) {
         var6.printStackTrace();
         return null;
      }
   }

   public final boolean isViewSufficientlyShown(View var1) {
      int[] var2 = new int[2];
      int[] var3 = new int[2];
      if(var1 != null) {
         float var4 = (float)var1.getHeight();
         View var5 = this.getScrollOrListParent(var1);
         var1.getLocationOnScreen(var2);
         if(var5 == null) {
            var3[1] = 0;
         } else {
            var5.getLocationOnScreen(var3);
         }

         if((float)var2[1] + var4 / 2.0F <= this.getScrollListWindowHeight(var1) && (float)var2[1] + var4 / 2.0F >= (float)var3[1]) {
            return true;
         }
      }

      return false;
   }
}
