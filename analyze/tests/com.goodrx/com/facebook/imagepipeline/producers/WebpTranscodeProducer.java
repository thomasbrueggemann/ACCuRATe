package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.util.TriState;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.memory.PooledByteBufferOutputStream;
import com.facebook.imagepipeline.nativecode.WebpTranscoderFactory;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.DelegatingConsumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.StatefulProducerRunnable;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class WebpTranscodeProducer implements Producer<EncodedImage> {
   private static final int DEFAULT_JPEG_QUALITY = 80;
   private static final String PRODUCER_NAME = "WebpTranscodeProducer";
   private final Executor mExecutor;
   private final Producer<EncodedImage> mInputProducer;
   private final PooledByteBufferFactory mPooledByteBufferFactory;

   public WebpTranscodeProducer(Executor var1, PooledByteBufferFactory var2, Producer<EncodedImage> var3) {
      this.mExecutor = (Executor)Preconditions.checkNotNull(var1);
      this.mPooledByteBufferFactory = (PooledByteBufferFactory)Preconditions.checkNotNull(var2);
      this.mInputProducer = (Producer)Preconditions.checkNotNull(var3);
   }

   // $FF: synthetic method
   static PooledByteBufferFactory access$200(WebpTranscodeProducer var0) {
      return var0.mPooledByteBufferFactory;
   }

   // $FF: synthetic method
   static void access$300(EncodedImage var0, PooledByteBufferOutputStream var1) throws Exception {
      doTranscode(var0, var1);
   }

   private static void doTranscode(EncodedImage var0, PooledByteBufferOutputStream var1) throws Exception {
      InputStream var2 = var0.getInputStream();
      ImageFormat var3 = ImageFormatChecker.getImageFormat_WrapIOException(var2);
      switch(null.$SwitchMap$com$facebook$imageformat$ImageFormat[var3.ordinal()]) {
      case 1:
      case 3:
         WebpTranscoderFactory.getWebpTranscoder().transcodeWebpToJpeg(var2, var1, 80);
         return;
      case 2:
      case 4:
         WebpTranscoderFactory.getWebpTranscoder().transcodeWebpToPng(var2, var1);
         return;
      default:
         throw new IllegalArgumentException("Wrong image format");
      }
   }

   private static TriState shouldTranscode(EncodedImage var0) {
      Preconditions.checkNotNull(var0);
      ImageFormat var2 = ImageFormatChecker.getImageFormat_WrapIOException(var0.getInputStream());
      switch(null.$SwitchMap$com$facebook$imageformat$ImageFormat[var2.ordinal()]) {
      case 1:
      case 2:
      case 3:
      case 4:
         boolean var3;
         if(!WebpTranscoderFactory.getWebpTranscoder().isWebpNativelySupported(var2)) {
            var3 = true;
         } else {
            var3 = false;
         }

         return TriState.valueOf(var3);
      case 5:
         return TriState.UNSET;
      default:
         return TriState.field_223;
      }
   }

   private void transcodeLastResult(EncodedImage var1, final Consumer<EncodedImage> var2, ProducerContext var3) {
      Preconditions.checkNotNull(var1);
      final EncodedImage var5 = EncodedImage.cloneOrNull(var1);
      StatefulProducerRunnable var6 = new StatefulProducerRunnable(var2, var3.getListener(), "WebpTranscodeProducer", var3.getId()) {
         protected void disposeResult(EncodedImage var1) {
            EncodedImage.closeSafely(var1);
         }

         protected EncodedImage getResult() throws Exception {
            // $FF: Couldn't be decompiled
         }

         protected void onCancellation() {
            EncodedImage.closeSafely(var5);
            super.onCancellation();
         }

         protected void onFailure(Exception var1) {
            EncodedImage.closeSafely(var5);
            super.onFailure(var1);
         }

         protected void onSuccess(EncodedImage var1) {
            EncodedImage.closeSafely(var5);
            super.onSuccess(var1);
         }
      };
      this.mExecutor.execute(var6);
   }

   public void produceResults(Consumer<EncodedImage> var1, ProducerContext var2) {
      this.mInputProducer.produceResults(new WebpTranscodeProducer.WebpTranscodeConsumer(var1, var2), var2);
   }

   private class WebpTranscodeConsumer extends DelegatingConsumer<EncodedImage, EncodedImage> {
      private final ProducerContext mContext;
      private TriState mShouldTranscodeWhenFinished;

      public WebpTranscodeConsumer(Consumer<EncodedImage> var1, ProducerContext var2) {
         super(var2);
         this.mContext = var3;
         this.mShouldTranscodeWhenFinished = TriState.UNSET;
      }

      protected void onNewResultImpl(@Nullable EncodedImage var1, boolean var2) {
         if(this.mShouldTranscodeWhenFinished == TriState.UNSET && var1 != null) {
            this.mShouldTranscodeWhenFinished = WebpTranscodeProducer.shouldTranscode(var1);
         }

         if(this.mShouldTranscodeWhenFinished == TriState.field_223) {
            this.getConsumer().onNewResult(var1, var2);
         } else if(var2) {
            if(this.mShouldTranscodeWhenFinished == TriState.YES && var1 != null) {
               WebpTranscodeProducer.this.transcodeLastResult(var1, this.getConsumer(), this.mContext);
               return;
            }

            this.getConsumer().onNewResult(var1, var2);
            return;
         }

      }
   }
}
