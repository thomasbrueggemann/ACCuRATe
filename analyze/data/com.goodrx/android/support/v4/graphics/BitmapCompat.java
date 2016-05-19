package android.support.v4.graphics;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.support.v4.graphics.BitmapCompatHoneycombMr1;
import android.support.v4.graphics.BitmapCompatJellybeanMR2;
import android.support.v4.graphics.BitmapCompatKitKat;

public final class BitmapCompat {
   static final BitmapCompat.BitmapImpl IMPL;

   static {
      int var0 = VERSION.SDK_INT;
      if(var0 >= 19) {
         IMPL = new BitmapCompat.KitKatBitmapCompatImpl();
      } else if(var0 >= 18) {
         IMPL = new BitmapCompat.JbMr2BitmapCompatImpl();
      } else if(var0 >= 12) {
         IMPL = new BitmapCompat.HcMr1BitmapCompatImpl();
      } else {
         IMPL = new BitmapCompat.BaseBitmapImpl();
      }
   }

   public static int getAllocationByteCount(Bitmap var0) {
      return IMPL.getAllocationByteCount(var0);
   }

   public static boolean hasMipMap(Bitmap var0) {
      return IMPL.hasMipMap(var0);
   }

   public static void setHasMipMap(Bitmap var0, boolean var1) {
      IMPL.setHasMipMap(var0, var1);
   }

   static class BaseBitmapImpl implements BitmapCompat.BitmapImpl {
      public int getAllocationByteCount(Bitmap var1) {
         return var1.getRowBytes() * var1.getHeight();
      }

      public boolean hasMipMap(Bitmap var1) {
         return false;
      }

      public void setHasMipMap(Bitmap var1, boolean var2) {
      }
   }

   interface BitmapImpl {
      int getAllocationByteCount(Bitmap var1);

      boolean hasMipMap(Bitmap var1);

      void setHasMipMap(Bitmap var1, boolean var2);
   }

   static class HcMr1BitmapCompatImpl extends BitmapCompat.BaseBitmapImpl {
      public int getAllocationByteCount(Bitmap var1) {
         return BitmapCompatHoneycombMr1.getAllocationByteCount(var1);
      }
   }

   static class JbMr2BitmapCompatImpl extends BitmapCompat.HcMr1BitmapCompatImpl {
      public boolean hasMipMap(Bitmap var1) {
         return BitmapCompatJellybeanMR2.hasMipMap(var1);
      }

      public void setHasMipMap(Bitmap var1, boolean var2) {
         BitmapCompatJellybeanMR2.setHasMipMap(var1, var2);
      }
   }

   static class KitKatBitmapCompatImpl extends BitmapCompat.JbMr2BitmapCompatImpl {
      public int getAllocationByteCount(Bitmap var1) {
         return BitmapCompatKitKat.getAllocationByteCount(var1);
      }
   }
}
