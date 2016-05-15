package android.support.v4.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

class ViewParentCompatLollipop {
   private static final String TAG = "ViewParentCompat";

   public static boolean onNestedFling(ViewParent var0, View var1, float var2, float var3, boolean var4) {
      try {
         boolean var7 = var0.onNestedFling(var1, var2, var3, var4);
         return var7;
      } catch (AbstractMethodError var8) {
         Log.e("ViewParentCompat", "ViewParent " + var0 + " does not implement interface " + "method onNestedFling", var8);
         return false;
      }
   }

   public static boolean onNestedPreFling(ViewParent var0, View var1, float var2, float var3) {
      try {
         boolean var6 = var0.onNestedPreFling(var1, var2, var3);
         return var6;
      } catch (AbstractMethodError var7) {
         Log.e("ViewParentCompat", "ViewParent " + var0 + " does not implement interface " + "method onNestedPreFling", var7);
         return false;
      }
   }

   public static void onNestedPreScroll(ViewParent var0, View var1, int var2, int var3, int[] var4) {
      try {
         var0.onNestedPreScroll(var1, var2, var3, var4);
      } catch (AbstractMethodError var6) {
         Log.e("ViewParentCompat", "ViewParent " + var0 + " does not implement interface " + "method onNestedPreScroll", var6);
      }
   }

   public static void onNestedScroll(ViewParent var0, View var1, int var2, int var3, int var4, int var5) {
      try {
         var0.onNestedScroll(var1, var2, var3, var4, var5);
      } catch (AbstractMethodError var7) {
         Log.e("ViewParentCompat", "ViewParent " + var0 + " does not implement interface " + "method onNestedScroll", var7);
      }
   }

   public static void onNestedScrollAccepted(ViewParent var0, View var1, View var2, int var3) {
      try {
         var0.onNestedScrollAccepted(var1, var2, var3);
      } catch (AbstractMethodError var5) {
         Log.e("ViewParentCompat", "ViewParent " + var0 + " does not implement interface " + "method onNestedScrollAccepted", var5);
      }
   }

   public static boolean onStartNestedScroll(ViewParent var0, View var1, View var2, int var3) {
      try {
         boolean var6 = var0.onStartNestedScroll(var1, var2, var3);
         return var6;
      } catch (AbstractMethodError var7) {
         Log.e("ViewParentCompat", "ViewParent " + var0 + " does not implement interface " + "method onStartNestedScroll", var7);
         return false;
      }
   }

   public static void onStopNestedScroll(ViewParent var0, View var1) {
      try {
         var0.onStopNestedScroll(var1);
      } catch (AbstractMethodError var3) {
         Log.e("ViewParentCompat", "ViewParent " + var0 + " does not implement interface " + "method onStopNestedScroll", var3);
      }
   }
}
