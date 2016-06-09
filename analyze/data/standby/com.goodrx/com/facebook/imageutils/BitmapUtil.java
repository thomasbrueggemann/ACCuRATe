package com.facebook.imageutils;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.support.v4.util.Pools;
import android.util.Pair;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

public final class BitmapUtil {
   public static final int ALPHA_8_BYTES_PER_PIXEL = 1;
   public static final int ARGB_4444_BYTES_PER_PIXEL = 2;
   public static final int ARGB_8888_BYTES_PER_PIXEL = 4;
   private static final Pools.SynchronizedPool<ByteBuffer> DECODE_BUFFERS = new Pools.SynchronizedPool(12);
   private static final int DECODE_BUFFER_SIZE = 16384;
   public static final float MAX_BITMAP_SIZE = 2048.0F;
   private static final int POOL_SIZE = 12;
   public static final int RGB_565_BYTES_PER_PIXEL = 2;

   @Nullable
   public static Pair<Integer, Integer> decodeDimensions(InputStream param0) {
      // $FF: Couldn't be decompiled
   }

   @Nullable
   public static Pair<Integer, Integer> decodeDimensions(byte[] var0) {
      return decodeDimensions((InputStream)(new ByteArrayInputStream(var0)));
   }

   public static int getPixelSizeForBitmapConfig(Config var0) {
      byte var1 = 2;
      switch(null.$SwitchMap$android$graphics$Bitmap$Config[var0.ordinal()]) {
      case 1:
         var1 = 4;
      case 3:
      case 4:
         return var1;
      case 2:
         return 1;
      default:
         throw new UnsupportedOperationException("The provided Bitmap.Config is not supported");
      }
   }

   public static int getSizeInByteForBitmap(int var0, int var1, Config var2) {
      return var0 * var1 * getPixelSizeForBitmapConfig(var2);
   }

   @SuppressLint({"NewApi"})
   public static int getSizeInBytes(@Nullable Bitmap var0) {
      if(var0 == null) {
         return 0;
      } else {
         if(VERSION.SDK_INT > 19) {
            try {
               int var2 = var0.getAllocationByteCount();
               return var2;
            } catch (NullPointerException var3) {
               ;
            }
         }

         return VERSION.SDK_INT >= 12?var0.getByteCount():var0.getWidth() * var0.getRowBytes();
      }
   }
}
