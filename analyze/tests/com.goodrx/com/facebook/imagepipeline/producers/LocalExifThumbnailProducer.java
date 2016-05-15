package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.media.ExifInterface;
import android.net.Uri;
import android.util.Pair;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.memory.PooledByteBufferInputStream;
import com.facebook.imagepipeline.producers.BaseProducerContextCallbacks;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.StatefulProducerRunnable;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.imageutils.JfifUtil;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.Executor;

public class LocalExifThumbnailProducer implements Producer<EncodedImage> {
   @VisibleForTesting
   static final String CREATED_THUMBNAIL = "createdThumbnail";
   @VisibleForTesting
   static final String PRODUCER_NAME = "LocalExifThumbnailProducer";
   private final ContentResolver mContentResolver;
   private final Executor mExecutor;
   private final PooledByteBufferFactory mPooledByteBufferFactory;

   public LocalExifThumbnailProducer(Executor var1, PooledByteBufferFactory var2, ContentResolver var3) {
      this.mExecutor = var1;
      this.mPooledByteBufferFactory = var2;
      this.mContentResolver = var3;
   }

   private EncodedImage buildEncodedImage(PooledByteBuffer var1, ExifInterface var2) {
      int var3 = -1;
      Pair var4 = BitmapUtil.decodeDimensions((InputStream)(new PooledByteBufferInputStream(var1)));
      int var5 = this.getRotationAngle(var2);
      int var6;
      if(var4 != null) {
         var6 = ((Integer)var4.first).intValue();
      } else {
         var6 = var3;
      }

      if(var4 != null) {
         var3 = ((Integer)var4.second).intValue();
      }

      EncodedImage var7 = new EncodedImage(CloseableReference.method_306(var1));
      var7.setImageFormat(ImageFormat.JPEG);
      var7.setRotationAngle(var5);
      var7.setWidth(var6);
      var7.setHeight(var3);
      return var7;
   }

   private String getRealPathFromUri(Uri param1) {
      // $FF: Couldn't be decompiled
   }

   private int getRotationAngle(ExifInterface var1) {
      return JfifUtil.getAutoRotateAngleFromOrientation(Integer.parseInt(var1.getAttribute("Orientation")));
   }

   @VisibleForTesting
   boolean canReadAsFile(String var1) throws IOException {
      if(var1 != null) {
         File var2 = new File(var1);
         if(var2.exists() && var2.canRead()) {
            return true;
         }
      }

      return false;
   }

   @VisibleForTesting
   ExifInterface getExifInterface(Uri var1) throws IOException {
      String var2 = this.getRealPathFromUri(var1);
      return this.canReadAsFile(var2)?new ExifInterface(var2):null;
   }

   public void produceResults(final Consumer<EncodedImage> var1, ProducerContext var2) {
      final StatefulProducerRunnable var3 = new StatefulProducerRunnable(var1, var2.getListener(), "LocalExifThumbnailProducer", var2.getId()) {
         // $FF: synthetic field
         final ImageRequest val$imageRequest;

         {
            this.val$imageRequest = var6;
         }

         protected void disposeResult(EncodedImage var1) {
            EncodedImage.closeSafely(var1);
         }

         protected Map<String, String> getExtraMapOnSuccess(EncodedImage var1) {
            boolean var2;
            if(var1 != null) {
               var2 = true;
            } else {
               var2 = false;
            }

            return ImmutableMap.method_205("createdThumbnail", Boolean.toString(var2));
         }

         protected EncodedImage getResult() throws Exception {
            Uri var1 = this.val$imageRequest.getSourceUri();
            ExifInterface var2 = LocalExifThumbnailProducer.this.getExifInterface(var1);
            if(var2 != null && var2.hasThumbnail()) {
               byte[] var3 = var2.getThumbnail();
               PooledByteBuffer var4 = LocalExifThumbnailProducer.this.mPooledByteBufferFactory.newByteBuffer(var3);
               return LocalExifThumbnailProducer.this.buildEncodedImage(var4, var2);
            } else {
               return null;
            }
         }
      };
      var2.addCallbacks(new BaseProducerContextCallbacks() {
         public void onCancellationRequested() {
            var3.cancel();
         }
      });
      this.mExecutor.execute(var3);
   }
}
