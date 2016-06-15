package android.support.v4.view;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.GravityCompatJellybeanMr1;
import android.view.Gravity;

public class GravityCompat {
   public static final int END = 8388613;
   static final GravityCompat.GravityCompatImpl IMPL;
   public static final int RELATIVE_HORIZONTAL_GRAVITY_MASK = 8388615;
   public static final int RELATIVE_LAYOUT_DIRECTION = 8388608;
   public static final int START = 8388611;

   static {
      if(VERSION.SDK_INT >= 17) {
         IMPL = new GravityCompat.GravityCompatImplJellybeanMr1();
      } else {
         IMPL = new GravityCompat.GravityCompatImplBase();
      }
   }

   public static void apply(int var0, int var1, int var2, Rect var3, int var4, int var5, Rect var6, int var7) {
      IMPL.apply(var0, var1, var2, var3, var4, var5, var6, var7);
   }

   public static void apply(int var0, int var1, int var2, Rect var3, Rect var4, int var5) {
      IMPL.apply(var0, var1, var2, var3, var4, var5);
   }

   public static void applyDisplay(int var0, Rect var1, Rect var2, int var3) {
      IMPL.applyDisplay(var0, var1, var2, var3);
   }

   public static int getAbsoluteGravity(int var0, int var1) {
      return IMPL.getAbsoluteGravity(var0, var1);
   }

   interface GravityCompatImpl {
      void apply(int var1, int var2, int var3, Rect var4, int var5, int var6, Rect var7, int var8);

      void apply(int var1, int var2, int var3, Rect var4, Rect var5, int var6);

      void applyDisplay(int var1, Rect var2, Rect var3, int var4);

      int getAbsoluteGravity(int var1, int var2);
   }

   static class GravityCompatImplBase implements GravityCompat.GravityCompatImpl {
      public void apply(int var1, int var2, int var3, Rect var4, int var5, int var6, Rect var7, int var8) {
         Gravity.apply(var1, var2, var3, var4, var5, var6, var7);
      }

      public void apply(int var1, int var2, int var3, Rect var4, Rect var5, int var6) {
         Gravity.apply(var1, var2, var3, var4, var5);
      }

      public void applyDisplay(int var1, Rect var2, Rect var3, int var4) {
         Gravity.applyDisplay(var1, var2, var3);
      }

      public int getAbsoluteGravity(int var1, int var2) {
         return -8388609 & var1;
      }
   }

   static class GravityCompatImplJellybeanMr1 implements GravityCompat.GravityCompatImpl {
      public void apply(int var1, int var2, int var3, Rect var4, int var5, int var6, Rect var7, int var8) {
         GravityCompatJellybeanMr1.apply(var1, var2, var3, var4, var5, var6, var7, var8);
      }

      public void apply(int var1, int var2, int var3, Rect var4, Rect var5, int var6) {
         GravityCompatJellybeanMr1.apply(var1, var2, var3, var4, var5, var6);
      }

      public void applyDisplay(int var1, Rect var2, Rect var3, int var4) {
         GravityCompatJellybeanMr1.applyDisplay(var1, var2, var3, var4);
      }

      public int getAbsoluteGravity(int var1, int var2) {
         return GravityCompatJellybeanMr1.getAbsoluteGravity(var1, var2);
      }
   }
}
