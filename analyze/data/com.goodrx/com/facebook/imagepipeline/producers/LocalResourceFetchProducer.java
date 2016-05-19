package com.facebook.imagepipeline.producers;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.producers.LocalFetchProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.util.concurrent.Executor;

public class LocalResourceFetchProducer extends LocalFetchProducer {
   @VisibleForTesting
   static final String PRODUCER_NAME = "LocalResourceFetchProducer";
   private final Resources mResources;

   public LocalResourceFetchProducer(Executor var1, PooledByteBufferFactory var2, Resources var3, boolean var4) {
      super(var1, var2, var4);
      this.mResources = var3;
   }

   private int getLength(ImageRequest var1) {
      AssetFileDescriptor var2 = null;
      boolean var16 = false;

      int var6;
      long var8;
      label85: {
         try {
            var16 = true;
            var2 = this.mResources.openRawResourceFd(getResourceId(var1));
            var8 = var2.getLength();
            var16 = false;
            break label85;
         } catch (NotFoundException var20) {
            var16 = false;
         } finally {
            if(var16) {
               if(var2 != null) {
                  try {
                     var2.close();
                  } catch (IOException var18) {
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
            } catch (IOException var17) {
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

   private static int getResourceId(ImageRequest var0) {
      return Integer.parseInt(var0.getSourceUri().getPath().substring(1));
   }

   protected EncodedImage getEncodedImage(ImageRequest var1) throws IOException {
      return this.getEncodedImage(this.mResources.openRawResource(getResourceId(var1)), this.getLength(var1));
   }

   protected String getProducerName() {
      return "LocalResourceFetchProducer";
   }
}
