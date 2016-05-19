package com.facebook.imagepipeline.producers;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.producers.LocalFetchProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.concurrent.Executor;

public class LocalAssetFetchProducer extends LocalFetchProducer {
   @VisibleForTesting
   static final String PRODUCER_NAME = "LocalAssetFetchProducer";
   private final AssetManager mAssetManager;

   public LocalAssetFetchProducer(Executor var1, PooledByteBufferFactory var2, AssetManager var3, boolean var4) {
      super(var1, var2, var4);
      this.mAssetManager = var3;
   }

   private static String getAssetName(ImageRequest var0) {
      return var0.getSourceUri().getPath().substring(1);
   }

   private int getLength(ImageRequest var1) {
      AssetFileDescriptor var2 = null;
      boolean var16 = false;

      int var6;
      long var8;
      label85: {
         try {
            var16 = true;
            var2 = this.mAssetManager.openFd(getAssetName(var1));
            var8 = var2.getLength();
            var16 = false;
            break label85;
         } catch (IOException var20) {
            var16 = false;
         } finally {
            if(var16) {
               if(var2 != null) {
                  try {
                     var2.close();
                  } catch (IOException var17) {
                     ;
                  }
               }

            }
         }

         var6 = -1;
         if(var2 != null) {
            try {
               var2.close();
               return var6;
            } catch (IOException var18) {
               return var6;
            }
         }

         return var6;
      }

      var6 = (int)var8;
      if(var2 != null) {
         try {
            var2.close();
         } catch (IOException var19) {
            return var6;
         }
      }

      return var6;
   }

   protected EncodedImage getEncodedImage(ImageRequest var1) throws IOException {
      return this.getEncodedImage(this.mAssetManager.open(getAssetName(var1), 2), this.getLength(var1));
   }

   protected String getProducerName() {
      return "LocalAssetFetchProducer";
   }
}
