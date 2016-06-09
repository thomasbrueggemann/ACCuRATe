package com.facebook.imagepipeline.producers;

import android.net.Uri;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.ProducerListener;

public class FetchState {
   private final Consumer<EncodedImage> mConsumer;
   private final ProducerContext mContext;
   private long mLastIntermediateResultTimeMs;

   public FetchState(Consumer<EncodedImage> var1, ProducerContext var2) {
      this.mConsumer = var1;
      this.mContext = var2;
      this.mLastIntermediateResultTimeMs = 0L;
   }

   public Consumer<EncodedImage> getConsumer() {
      return this.mConsumer;
   }

   public ProducerContext getContext() {
      return this.mContext;
   }

   public String getId() {
      return this.mContext.getId();
   }

   public long getLastIntermediateResultTimeMs() {
      return this.mLastIntermediateResultTimeMs;
   }

   public ProducerListener getListener() {
      return this.mContext.getListener();
   }

   public Uri getUri() {
      return this.mContext.getImageRequest().getSourceUri();
   }

   public void setLastIntermediateResultTimeMs(long var1) {
      this.mLastIntermediateResultTimeMs = var1;
   }
}
