package com.facebook.imagepipeline.datasource;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.image.CloseableImage;
import java.util.List;

public abstract class BaseListBitmapDataSubscriber extends BaseDataSubscriber<List<CloseableReference<CloseableImage>>> {
   public void onNewResultImpl(DataSource<List<CloseableReference<CloseableImage>>> param1) {
      // $FF: Couldn't be decompiled
   }

   protected abstract void onNewResultListImpl(List<Bitmap> var1);
}
