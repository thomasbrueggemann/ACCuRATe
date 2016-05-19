package com.facebook.imagepipeline.producers;

import android.os.Build.VERSION;
import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.producers.BaseProducerContextCallbacks;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.ProducerListener;
import com.facebook.imagepipeline.producers.StatefulProducerRunnable;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

public abstract class LocalFetchProducer implements Producer<EncodedImage> {
   private final boolean mDecodeFileDescriptorEnabledForKitKat;
   private final Executor mExecutor;
   private final PooledByteBufferFactory mPooledByteBufferFactory;

   protected LocalFetchProducer(Executor var1, PooledByteBufferFactory var2, boolean var3) {
      this.mExecutor = var1;
      this.mPooledByteBufferFactory = var2;
      boolean var4;
      if(var3 && VERSION.SDK_INT == 19) {
         var4 = true;
      } else {
         var4 = false;
      }

      this.mDecodeFileDescriptorEnabledForKitKat = var4;
   }

   protected EncodedImage getByteBufferBackedEncodedImage(InputStream param1, int param2) throws IOException {
      // $FF: Couldn't be decompiled
   }

   protected abstract EncodedImage getEncodedImage(ImageRequest var1) throws IOException;

   protected EncodedImage getEncodedImage(InputStream var1, int var2) throws IOException {
      Runtime var3 = Runtime.getRuntime();
      long var4 = var3.maxMemory();
      long var6 = Math.min(var4 - (var3.totalMemory() - var3.freeMemory()), 8388608L);
      return this.mDecodeFileDescriptorEnabledForKitKat && var1 instanceof FileInputStream && var4 >= 64L * var6?this.getInputStreamBackedEncodedImage(new File(var1.toString()), var2):this.getByteBufferBackedEncodedImage(var1, var2);
   }

   protected EncodedImage getInputStreamBackedEncodedImage(final File var1, int var2) throws IOException {
      return new EncodedImage(new Supplier() {
         public FileInputStream get() {
            try {
               FileInputStream var1x = new FileInputStream(var1);
               return var1x;
            } catch (IOException var3) {
               throw new RuntimeException(var3);
            }
         }
      }, var2);
   }

   protected abstract String getProducerName();

   public void produceResults(final Consumer<EncodedImage> var1, ProducerContext var2) {
      final ProducerListener var3 = var2.getListener();
      final String var4 = var2.getId();
      final ImageRequest var5 = var2.getImageRequest();
      final StatefulProducerRunnable var6 = new StatefulProducerRunnable(var1, var3, this.getProducerName(), var4) {
         protected void disposeResult(EncodedImage var1) {
            EncodedImage.closeSafely(var1);
         }

         protected EncodedImage getResult() throws Exception {
            EncodedImage var1 = LocalFetchProducer.this.getEncodedImage(var5);
            if(var1 == null) {
               return null;
            } else {
               var1.parseMetaData();
               return var1;
            }
         }
      };
      var2.addCallbacks(new BaseProducerContextCallbacks() {
         public void onCancellationRequested() {
            var6.cancel();
         }
      });
      this.mExecutor.execute(var6);
   }
}
