package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.producers.LocalFetchProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;

public class LocalFileFetchProducer extends LocalFetchProducer {
   @VisibleForTesting
   static final String PRODUCER_NAME = "LocalFileFetchProducer";

   public LocalFileFetchProducer(Executor var1, PooledByteBufferFactory var2, boolean var3) {
      super(var1, var2, var3);
   }

   protected EncodedImage getEncodedImage(ImageRequest var1) throws IOException {
      return this.getEncodedImage(new FileInputStream(var1.getSourceFile().toString()), (int)var1.getSourceFile().length());
   }

   protected String getProducerName() {
      return "LocalFileFetchProducer";
   }
}
