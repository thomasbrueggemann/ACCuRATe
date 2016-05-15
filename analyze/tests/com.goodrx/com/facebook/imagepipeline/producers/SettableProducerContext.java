package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.producers.BaseProducerContext;
import com.facebook.imagepipeline.producers.ProducerListener;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class SettableProducerContext extends BaseProducerContext {
   public SettableProducerContext(ImageRequest var1, String var2, ProducerListener var3, Object var4, ImageRequest.RequestLevel var5, boolean var6, boolean var7, Priority var8) {
      super(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public void setIsIntermediateResultExpected(boolean var1) {
      BaseProducerContext.callOnIsIntermediateResultExpectedChanged(this.setIsIntermediateResultExpectedNoCallbacks(var1));
   }

   public void setIsPrefetch(boolean var1) {
      BaseProducerContext.callOnIsPrefetchChanged(this.setIsPrefetchNoCallbacks(var1));
   }

   public void setPriority(Priority var1) {
      BaseProducerContext.callOnPriorityChanged(this.setPriorityNoCallbacks(var1));
   }
}
