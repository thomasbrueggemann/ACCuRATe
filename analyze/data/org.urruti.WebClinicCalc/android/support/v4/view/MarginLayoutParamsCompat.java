package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.view.MarginLayoutParamsCompatJellybeanMr1;
import android.view.ViewGroup.MarginLayoutParams;

public class MarginLayoutParamsCompat {
   static final MarginLayoutParamsCompat.MarginLayoutParamsCompatImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 17) {
         IMPL = new MarginLayoutParamsCompat.MarginLayoutParamsCompatImplJbMr1();
      } else {
         IMPL = new MarginLayoutParamsCompat.MarginLayoutParamsCompatImplBase();
      }
   }

   public static int getLayoutDirection(MarginLayoutParams var0) {
      return IMPL.getLayoutDirection(var0);
   }

   public static int getMarginEnd(MarginLayoutParams var0) {
      return IMPL.getMarginEnd(var0);
   }

   public static int getMarginStart(MarginLayoutParams var0) {
      return IMPL.getMarginStart(var0);
   }

   public static boolean isMarginRelative(MarginLayoutParams var0) {
      return IMPL.isMarginRelative(var0);
   }

   public static void resolveLayoutDirection(MarginLayoutParams var0, int var1) {
      IMPL.resolveLayoutDirection(var0, var1);
   }

   public static void setLayoutDirection(MarginLayoutParams var0, int var1) {
      IMPL.setLayoutDirection(var0, var1);
   }

   public static void setMarginEnd(MarginLayoutParams var0, int var1) {
      IMPL.setMarginEnd(var0, var1);
   }

   public static void setMarginStart(MarginLayoutParams var0, int var1) {
      IMPL.setMarginStart(var0, var1);
   }

   interface MarginLayoutParamsCompatImpl {
      int getLayoutDirection(MarginLayoutParams var1);

      int getMarginEnd(MarginLayoutParams var1);

      int getMarginStart(MarginLayoutParams var1);

      boolean isMarginRelative(MarginLayoutParams var1);

      void resolveLayoutDirection(MarginLayoutParams var1, int var2);

      void setLayoutDirection(MarginLayoutParams var1, int var2);

      void setMarginEnd(MarginLayoutParams var1, int var2);

      void setMarginStart(MarginLayoutParams var1, int var2);
   }

   static class MarginLayoutParamsCompatImplBase implements MarginLayoutParamsCompat.MarginLayoutParamsCompatImpl {
      public int getLayoutDirection(MarginLayoutParams var1) {
         return 0;
      }

      public int getMarginEnd(MarginLayoutParams var1) {
         return var1.rightMargin;
      }

      public int getMarginStart(MarginLayoutParams var1) {
         return var1.leftMargin;
      }

      public boolean isMarginRelative(MarginLayoutParams var1) {
         return false;
      }

      public void resolveLayoutDirection(MarginLayoutParams var1, int var2) {
      }

      public void setLayoutDirection(MarginLayoutParams var1, int var2) {
      }

      public void setMarginEnd(MarginLayoutParams var1, int var2) {
         var1.rightMargin = var2;
      }

      public void setMarginStart(MarginLayoutParams var1, int var2) {
         var1.leftMargin = var2;
      }
   }

   static class MarginLayoutParamsCompatImplJbMr1 implements MarginLayoutParamsCompat.MarginLayoutParamsCompatImpl {
      public int getLayoutDirection(MarginLayoutParams var1) {
         return MarginLayoutParamsCompatJellybeanMr1.getLayoutDirection(var1);
      }

      public int getMarginEnd(MarginLayoutParams var1) {
         return MarginLayoutParamsCompatJellybeanMr1.getMarginEnd(var1);
      }

      public int getMarginStart(MarginLayoutParams var1) {
         return MarginLayoutParamsCompatJellybeanMr1.getMarginStart(var1);
      }

      public boolean isMarginRelative(MarginLayoutParams var1) {
         return MarginLayoutParamsCompatJellybeanMr1.isMarginRelative(var1);
      }

      public void resolveLayoutDirection(MarginLayoutParams var1, int var2) {
         MarginLayoutParamsCompatJellybeanMr1.resolveLayoutDirection(var1, var2);
      }

      public void setLayoutDirection(MarginLayoutParams var1, int var2) {
         MarginLayoutParamsCompatJellybeanMr1.setLayoutDirection(var1, var2);
      }

      public void setMarginEnd(MarginLayoutParams var1, int var2) {
         MarginLayoutParamsCompatJellybeanMr1.setMarginEnd(var1, var2);
      }

      public void setMarginStart(MarginLayoutParams var1, int var2) {
         MarginLayoutParamsCompatJellybeanMr1.setMarginStart(var1, var2);
      }
   }
}
