package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import javax.annotation.Nullable;

public abstract class BaseBitmapDataSubscriber extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
   protected abstract void onNewResultImpl(@Nullable Bitmap var1);

   public void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> var1) {
      if(var1.isFinished()) {
         CloseableReference var2 = (CloseableReference)var1.getResult();
         Bitmap var3 = null;
         if(var2 != null) {
            boolean var5 = var2.get() instanceof CloseableBitmap;
            var3 = null;
            if(var5) {
               var3 = ((CloseableBitmap)var2.get()).getUnderlyingBitmap();
            }
         }

         try {
            this.onNewResultImpl(var3);
         } finally {
            CloseableReference.closeSafely(var2);
         }

      }
   }
}
