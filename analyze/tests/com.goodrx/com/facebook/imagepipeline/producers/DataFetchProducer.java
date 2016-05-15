package com.facebook.imagepipeline.producers;

import android.net.Uri;
import android.util.Base64;
import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.producers.LocalFetchProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class DataFetchProducer extends LocalFetchProducer {
   private static final String PRODUCER_NAME = "DataFetchProducer";

   public DataFetchProducer(PooledByteBufferFactory var1, boolean var2) {
      super(CallerThreadExecutor.getInstance(), var1, var2);
   }

   @VisibleForTesting
   static byte[] getData(String var0) {
      Preconditions.checkArgument(var0.substring(0, 5).equals("data:"));
      int var1 = var0.indexOf(44);
      String var2 = var0.substring(var1 + 1, var0.length());
      return isBase64(var0.substring(0, var1))?Base64.decode(var2, 0):Uri.decode(var2).getBytes();
   }

   @VisibleForTesting
   static boolean isBase64(String var0) {
      if(!var0.contains(";")) {
         return false;
      } else {
         String[] var1 = var0.split(";");
         return var1[-1 + var1.length].equals("base64");
      }
   }

   protected EncodedImage getEncodedImage(ImageRequest var1) throws IOException {
      byte[] var2 = getData(var1.getSourceUri().toString());
      return this.getByteBufferBackedEncodedImage(new ByteArrayInputStream(var2), var2.length);
   }

   protected String getProducerName() {
      return "DataFetchProducer";
   }
}
