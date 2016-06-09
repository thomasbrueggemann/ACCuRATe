package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.support.v4.util.Pools;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.streams.LimitedInputStream;
import com.facebook.common.streams.TailAppendingInputStream;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imageutils.BitmapUtil;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.annotation.concurrent.ThreadSafe;

@TargetApi(21)
@ThreadSafe
public class ArtDecoder implements PlatformDecoder {
   private static final int DECODE_BUFFER_SIZE = 16384;
   private static final byte[] EOI_TAIL = new byte[]{(byte)-1, (byte)-39};
   private final BitmapPool mBitmapPool;
   @VisibleForTesting
   final Pools.SynchronizedPool<ByteBuffer> mDecodeBuffers;

   public ArtDecoder(BitmapPool var1, int var2) {
      this.mBitmapPool = var1;
      this.mDecodeBuffers = new Pools.SynchronizedPool(var2);

      for(int var3 = 0; var3 < var2; ++var3) {
         this.mDecodeBuffers.release(ByteBuffer.allocate(16384));
      }

   }

   private CloseableReference<Bitmap> decodeStaticImageFromStream(InputStream var1, Options var2) {
      Preconditions.checkNotNull(var1);
      int var4 = BitmapUtil.getSizeInByteForBitmap(var2.outWidth, var2.outHeight, var2.inPreferredConfig);
      Bitmap var5 = (Bitmap)this.mBitmapPool.get(var4);
      if(var5 == null) {
         throw new NullPointerException("BitmapPool.get returned null");
      } else {
         var2.inBitmap = var5;
         ByteBuffer var6 = (ByteBuffer)this.mDecodeBuffers.acquire();
         if(var6 == null) {
            var6 = ByteBuffer.allocate(16384);
         }

         Bitmap var10;
         try {
            var2.inTempStorage = var6.array();
            var10 = BitmapFactoryInstrumentation.decodeStream(var1, (Rect)null, var2);
         } catch (RuntimeException var13) {
            this.mBitmapPool.release(var5);
            throw var13;
         } finally {
            this.mDecodeBuffers.release(var6);
         }

         if(var5 != var10) {
            this.mBitmapPool.release(var5);
            var10.recycle();
            throw new IllegalStateException();
         } else {
            return CloseableReference.method_307(var10, this.mBitmapPool);
         }
      }
   }

   private static Options getDecodeOptionsForStream(EncodedImage var0, Config var1) {
      Options var2 = new Options();
      var2.inSampleSize = var0.getSampleSize();
      var2.inJustDecodeBounds = true;
      BitmapFactoryInstrumentation.decodeStream(var0.getInputStream(), (Rect)null, var2);
      if(var2.outWidth != -1 && var2.outHeight != -1) {
         var2.inJustDecodeBounds = false;
         var2.inDither = true;
         var2.inPreferredConfig = var1;
         var2.inMutable = true;
         return var2;
      } else {
         throw new IllegalArgumentException();
      }
   }

   public CloseableReference<Bitmap> decodeFromEncodedImage(EncodedImage var1, Config var2) {
      Options var3 = getDecodeOptionsForStream(var1, var2);
      boolean var4;
      if(var3.inPreferredConfig != Config.ARGB_8888) {
         var4 = true;
      } else {
         var4 = false;
      }

      try {
         CloseableReference var6 = this.decodeStaticImageFromStream(var1.getInputStream(), var3);
         return var6;
      } catch (RuntimeException var7) {
         if(var4) {
            return this.decodeFromEncodedImage(var1, Config.ARGB_8888);
         } else {
            throw var7;
         }
      }
   }

   public CloseableReference<Bitmap> decodeJPEGFromEncodedImage(EncodedImage var1, Config var2, int var3) {
      boolean var4 = var1.isCompleteAt(var3);
      Options var5 = getDecodeOptionsForStream(var1, var2);
      InputStream var6 = var1.getInputStream();
      Preconditions.checkNotNull(var6);
      Object var8;
      if(var1.getSize() > var3) {
         var8 = new LimitedInputStream(var6, var3);
      } else {
         var8 = var6;
      }

      Object var9;
      if(!var4) {
         var9 = new TailAppendingInputStream((InputStream)var8, EOI_TAIL);
      } else {
         var9 = var8;
      }

      boolean var10;
      if(var5.inPreferredConfig != Config.ARGB_8888) {
         var10 = true;
      } else {
         var10 = false;
      }

      try {
         CloseableReference var12 = this.decodeStaticImageFromStream((InputStream)var9, var5);
         return var12;
      } catch (RuntimeException var13) {
         if(var10) {
            return this.decodeFromEncodedImage(var1, Config.ARGB_8888);
         } else {
            throw var13;
         }
      }
   }
}
