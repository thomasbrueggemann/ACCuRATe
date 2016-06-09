package com.facebook.imagepipeline.request;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.nativecode.Bitmaps;
import com.facebook.imagepipeline.request.Postprocessor;
import javax.annotation.Nullable;

public abstract class BasePostprocessor implements Postprocessor {
   public String getName() {
      return "Unknown postprocessor";
   }

   @Nullable
   public CacheKey getPostprocessorCacheKey() {
      return null;
   }

   public CloseableReference<Bitmap> process(Bitmap var1, PlatformBitmapFactory var2) {
      CloseableReference var3 = var2.createBitmap(var1.getWidth(), var1.getHeight(), var1.getConfig());

      CloseableReference var5;
      try {
         this.process((Bitmap)var3.get(), var1);
         var5 = CloseableReference.cloneOrNull(var3);
      } finally {
         CloseableReference.closeSafely(var3);
      }

      return var5;
   }

   public void process(Bitmap var1) {
   }

   public void process(Bitmap var1, Bitmap var2) {
      Bitmaps.copyBitmap(var1, var2);
      this.process(var1);
   }
}
