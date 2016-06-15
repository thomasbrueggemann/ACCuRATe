package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompatHoneycomb;
import android.support.v4.graphics.drawable.DrawableCompatKitKat;

public class DrawableCompat {
   static final DrawableCompat.DrawableImpl IMPL;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 19) {
         IMPL = new DrawableCompat.KitKatDrawableImpl();
      } else if(var0 >= 11) {
         IMPL = new DrawableCompat.HoneycombDrawableImpl();
      } else {
         IMPL = new DrawableCompat.BaseDrawableImpl();
      }
   }

   public static boolean isAutoMirrored(Drawable var0) {
      return IMPL.isAutoMirrored(var0);
   }

   public static void jumpToCurrentState(Drawable var0) {
      IMPL.jumpToCurrentState(var0);
   }

   public static void setAutoMirrored(Drawable var0, boolean var1) {
      IMPL.setAutoMirrored(var0, var1);
   }

   static class BaseDrawableImpl implements DrawableCompat.DrawableImpl {
      public boolean isAutoMirrored(Drawable var1) {
         return false;
      }

      public void jumpToCurrentState(Drawable var1) {
      }

      public void setAutoMirrored(Drawable var1, boolean var2) {
      }
   }

   interface DrawableImpl {
      boolean isAutoMirrored(Drawable var1);

      void jumpToCurrentState(Drawable var1);

      void setAutoMirrored(Drawable var1, boolean var2);
   }

   static class HoneycombDrawableImpl extends DrawableCompat.BaseDrawableImpl {
      public void jumpToCurrentState(Drawable var1) {
         DrawableCompatHoneycomb.jumpToCurrentState(var1);
      }
   }

   static class KitKatDrawableImpl extends DrawableCompat.HoneycombDrawableImpl {
      public boolean isAutoMirrored(Drawable var1) {
         return DrawableCompatKitKat.isAutoMirrored(var1);
      }

      public void setAutoMirrored(Drawable var1, boolean var2) {
         DrawableCompatKitKat.setAutoMirrored(var1, var2);
      }
   }
}
