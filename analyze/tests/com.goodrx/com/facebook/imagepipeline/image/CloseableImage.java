package com.facebook.imagepipeline.image;

import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import java.io.Closeable;

public abstract class CloseableImage implements ImageInfo, Closeable {
   private static final String TAG = "CloseableImage";

   public abstract void close();

   protected void finalize() throws Throwable {
      if(!this.isClosed()) {
         Object[] var1 = new Object[]{this.getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this))};
         FLog.method_439("CloseableImage", "finalize: %s %x still open.", var1);

         try {
            this.close();
         } finally {
            super.finalize();
         }

      }
   }

   public QualityInfo getQualityInfo() {
      return ImmutableQualityInfo.FULL_QUALITY;
   }

   public abstract int getSizeInBytes();

   public abstract boolean isClosed();

   public boolean isStateful() {
      return false;
   }
}
