package android.support.v4.graphics.drawable;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompatHoneycomb;

public class DrawableCompat {
   static final DrawableCompat.DrawableImpl IMPL;

   static {
      if(VERSION.SDK_INT >= 11) {
         IMPL = new DrawableCompat.HoneycombDrawableImpl();
      } else {
         IMPL = new DrawableCompat.BaseDrawableImpl();
      }
   }

   public static void jumpToCurrentState(Drawable var0) {
      IMPL.jumpToCurrentState(var0);
   }

   static class BaseDrawableImpl implements DrawableCompat.DrawableImpl {
      public void jumpToCurrentState(Drawable var1) {
      }
   }

   interface DrawableImpl {
      void jumpToCurrentState(Drawable var1);
   }

   static class HoneycombDrawableImpl implements DrawableCompat.DrawableImpl {
      public void jumpToCurrentState(Drawable var1) {
         DrawableCompatHoneycomb.jumpToCurrentState(var1);
      }
   }
}
