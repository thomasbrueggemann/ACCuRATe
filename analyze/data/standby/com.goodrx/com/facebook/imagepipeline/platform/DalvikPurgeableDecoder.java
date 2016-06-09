package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.common.TooManyBitmapsException;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapCounter;
import com.facebook.imagepipeline.memory.BitmapCounterProvider;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import com.facebook.imagepipeline.platform.PlatformDecoder;

abstract class DalvikPurgeableDecoder implements PlatformDecoder {
   protected static final byte[] EOI = new byte[]{(byte)-1, (byte)-39};
   private final BitmapCounter mUnpooledBitmapsCounter = BitmapCounterProvider.get();

   protected static boolean endsWithEOI(CloseableReference<PooledByteBuffer> var0, int var1) {
      PooledByteBuffer var2 = (PooledByteBuffer)var0.get();
      return var1 >= 2 && var2.read(var1 - 2) == -1 && var2.read(var1 - 1) == -39;
   }

   private static Options getBitmapFactoryOptions(int var0, Config var1) {
      Options var2 = new Options();
      var2.inDither = true;
      var2.inPreferredConfig = var1;
      var2.inPurgeable = true;
      var2.inInputShareable = true;
      var2.inSampleSize = var0;
      if(VERSION.SDK_INT >= 11) {
         var2.inMutable = true;
      }

      return var2;
   }

   abstract Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> var1, Options var2);

   public CloseableReference<Bitmap> decodeFromEncodedImage(EncodedImage var1, Config var2) {
      Options var3 = getBitmapFactoryOptions(var1.getSampleSize(), var2);
      CloseableReference var4 = var1.getByteBufferRef();
      Preconditions.checkNotNull(var4);

      CloseableReference var7;
      try {
         var7 = this.pinBitmap(this.decodeByteArrayAsPurgeable(var4, var3));
      } finally {
         CloseableReference.closeSafely(var4);
      }

      return var7;
   }

   abstract Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> var1, int var2, Options var3);

   public CloseableReference<Bitmap> decodeJPEGFromEncodedImage(EncodedImage var1, Config var2, int var3) {
      Options var4 = getBitmapFactoryOptions(var1.getSampleSize(), var2);
      CloseableReference var5 = var1.getByteBufferRef();
      Preconditions.checkNotNull(var5);

      CloseableReference var8;
      try {
         var8 = this.pinBitmap(this.decodeJPEGByteArrayAsPurgeable(var5, var3, var4));
      } finally {
         CloseableReference.closeSafely(var5);
      }

      return var8;
   }

   public CloseableReference<Bitmap> pinBitmap(Bitmap var1) {
      try {
         Bitmaps.pinBitmap(var1);
      } catch (Exception var3) {
         var1.recycle();
         throw Throwables.propagate(var3);
      }

      if(!this.mUnpooledBitmapsCounter.increase(var1)) {
         var1.recycle();
         throw new TooManyBitmapsException();
      } else {
         return CloseableReference.method_307(var1, this.mUnpooledBitmapsCounter.getReleaser());
      }
   }
}
