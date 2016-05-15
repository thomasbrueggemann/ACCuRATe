package com.facebook.imagepipeline.nativecode;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.soloader.SoLoaderShim;
import com.facebook.imageutils.BitmapUtil;

@DoNotStrip
public class Bitmaps {
   static {
      SoLoaderShim.loadLibrary("bitmaps");
   }

   public static void copyBitmap(Bitmap var0, Bitmap var1) {
      boolean var2 = true;
      boolean var3;
      if(var1.getConfig() == var0.getConfig()) {
         var3 = var2;
      } else {
         var3 = false;
      }

      Preconditions.checkArgument(var3);
      Preconditions.checkArgument(var0.isMutable());
      boolean var4;
      if(var0.getWidth() == var1.getWidth()) {
         var4 = var2;
      } else {
         var4 = false;
      }

      Preconditions.checkArgument(var4);
      if(var0.getHeight() != var1.getHeight()) {
         var2 = false;
      }

      Preconditions.checkArgument(var2);
      nativeCopyBitmap(var0, var0.getRowBytes(), var1, var1.getRowBytes(), var0.getHeight());
   }

   @DoNotStrip
   private static native void nativeCopyBitmap(Bitmap var0, int var1, Bitmap var2, int var3, int var4);

   @DoNotStrip
   private static native void nativePinBitmap(Bitmap var0);

   public static void pinBitmap(Bitmap var0) {
      Preconditions.checkNotNull(var0);
      nativePinBitmap(var0);
   }

   @TargetApi(19)
   public static void reconfigureBitmap(Bitmap var0, int var1, int var2, Config var3) {
      boolean var4;
      if(var0.getAllocationByteCount() >= var1 * var2 * BitmapUtil.getPixelSizeForBitmapConfig(var3)) {
         var4 = true;
      } else {
         var4 = false;
      }

      Preconditions.checkArgument(var4);
      var0.reconfigure(var1, var2, var3);
   }
}
