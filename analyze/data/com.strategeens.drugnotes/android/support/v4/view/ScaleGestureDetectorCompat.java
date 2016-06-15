package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.view.ScaleGestureDetectorCompatKitKat;

public class ScaleGestureDetectorCompat {
   static final ScaleGestureDetectorCompat.ScaleGestureDetectorImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 19) {
         IMPL = new ScaleGestureDetectorCompat.ScaleGestureDetectorCompatKitKatImpl();
      } else {
         IMPL = new ScaleGestureDetectorCompat.BaseScaleGestureDetectorImpl();
      }
   }

   public static boolean isQuickScaleEnabled(Object var0) {
      return IMPL.isQuickScaleEnabled(var0);
   }

   public static void setQuickScaleEnabled(Object var0, boolean var1) {
      IMPL.setQuickScaleEnabled(var0, var1);
   }

   private static class BaseScaleGestureDetectorImpl implements ScaleGestureDetectorCompat.ScaleGestureDetectorImpl {
      private BaseScaleGestureDetectorImpl() {
      }

      // $FF: synthetic method
      BaseScaleGestureDetectorImpl(Object var1) {
         this();
      }

      public boolean isQuickScaleEnabled(Object var1) {
         return false;
      }

      public void setQuickScaleEnabled(Object var1, boolean var2) {
      }
   }

   private static class ScaleGestureDetectorCompatKitKatImpl implements ScaleGestureDetectorCompat.ScaleGestureDetectorImpl {
      private ScaleGestureDetectorCompatKitKatImpl() {
      }

      // $FF: synthetic method
      ScaleGestureDetectorCompatKitKatImpl(Object var1) {
         this();
      }

      public boolean isQuickScaleEnabled(Object var1) {
         return ScaleGestureDetectorCompatKitKat.isQuickScaleEnabled(var1);
      }

      public void setQuickScaleEnabled(Object var1, boolean var2) {
         ScaleGestureDetectorCompatKitKat.setQuickScaleEnabled(var1, var2);
      }
   }

   interface ScaleGestureDetectorImpl {
      boolean isQuickScaleEnabled(Object var1);

      void setQuickScaleEnabled(Object var1, boolean var2);
   }
}
