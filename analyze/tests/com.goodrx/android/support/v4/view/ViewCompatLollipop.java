package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v4.view.WindowInsetsCompatApi21;
import android.view.View;
import android.view.WindowInsets;

class ViewCompatLollipop {
   public static WindowInsetsCompat dispatchApplyWindowInsets(View var0, WindowInsetsCompat var1) {
      if(var1 instanceof WindowInsetsCompatApi21) {
         WindowInsets var2 = ((WindowInsetsCompatApi21)var1).unwrap();
         WindowInsets var3 = var0.dispatchApplyWindowInsets(var2);
         if(var3 != var2) {
            var1 = new WindowInsetsCompatApi21(var3);
         }
      }

      return (WindowInsetsCompat)var1;
   }

   public static boolean dispatchNestedFling(View var0, float var1, float var2, boolean var3) {
      return var0.dispatchNestedFling(var1, var2, var3);
   }

   public static boolean dispatchNestedPreFling(View var0, float var1, float var2) {
      return var0.dispatchNestedPreFling(var1, var2);
   }

   public static boolean dispatchNestedPreScroll(View var0, int var1, int var2, int[] var3, int[] var4) {
      return var0.dispatchNestedPreScroll(var1, var2, var3, var4);
   }

   public static boolean dispatchNestedScroll(View var0, int var1, int var2, int var3, int var4, int[] var5) {
      return var0.dispatchNestedScroll(var1, var2, var3, var4, var5);
   }

   static ColorStateList getBackgroundTintList(View var0) {
      return var0.getBackgroundTintList();
   }

   static Mode getBackgroundTintMode(View var0) {
      return var0.getBackgroundTintMode();
   }

   public static float getElevation(View var0) {
      return var0.getElevation();
   }

   public static String getTransitionName(View var0) {
      return var0.getTransitionName();
   }

   public static float getTranslationZ(View var0) {
      return var0.getTranslationZ();
   }

   public static float getZ(View var0) {
      return var0.getZ();
   }

   public static boolean hasNestedScrollingParent(View var0) {
      return var0.hasNestedScrollingParent();
   }

   public static boolean isImportantForAccessibility(View var0) {
      return var0.isImportantForAccessibility();
   }

   public static boolean isNestedScrollingEnabled(View var0) {
      return var0.isNestedScrollingEnabled();
   }

   public static WindowInsetsCompat onApplyWindowInsets(View var0, WindowInsetsCompat var1) {
      if(var1 instanceof WindowInsetsCompatApi21) {
         WindowInsets var2 = ((WindowInsetsCompatApi21)var1).unwrap();
         WindowInsets var3 = var0.onApplyWindowInsets(var2);
         if(var3 != var2) {
            var1 = new WindowInsetsCompatApi21(var3);
         }
      }

      return (WindowInsetsCompat)var1;
   }

   public static void requestApplyInsets(View var0) {
      var0.requestApplyInsets();
   }

   static void setBackgroundTintList(View var0, ColorStateList var1) {
      var0.setBackgroundTintList(var1);
   }

   static void setBackgroundTintMode(View var0, Mode var1) {
      var0.setBackgroundTintMode(var1);
   }

   public static void setElevation(View var0, float var1) {
      var0.setElevation(var1);
   }

   public static void setNestedScrollingEnabled(View var0, boolean var1) {
      var0.setNestedScrollingEnabled(var1);
   }

   public static void setOnApplyWindowInsetsListener(View var0, final OnApplyWindowInsetsListener var1) {
      if(var1 == null) {
         var0.setOnApplyWindowInsetsListener((android.view.View.OnApplyWindowInsetsListener)null);
      } else {
         var0.setOnApplyWindowInsetsListener(new android.view.View.OnApplyWindowInsetsListener() {
            public WindowInsets onApplyWindowInsets(View var1x, WindowInsets var2) {
               WindowInsetsCompatApi21 var3 = new WindowInsetsCompatApi21(var2);
               return ((WindowInsetsCompatApi21)var1.onApplyWindowInsets(var1x, var3)).unwrap();
            }
         });
      }
   }

   public static void setTransitionName(View var0, String var1) {
      var0.setTransitionName(var1);
   }

   public static void setTranslationZ(View var0, float var1) {
      var0.setTranslationZ(var1);
   }

   public static boolean startNestedScroll(View var0, int var1) {
      return var0.startNestedScroll(var1);
   }

   public static void stopNestedScroll(View var0) {
      var0.stopNestedScroll();
   }
}
