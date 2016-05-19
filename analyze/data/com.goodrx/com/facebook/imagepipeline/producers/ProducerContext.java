package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.producers.ProducerContextCallbacks;
import com.facebook.imagepipeline.producers.ProducerListener;
import com.facebook.imagepipeline.request.ImageRequest;

public interface ProducerContext {
   void addCallbacks(ProducerContextCallbacks var1);

   Object getCallerContext();

   String getId();

   ImageRequest getImageRequest();

   ProducerListener getListener();

   ImageRequest.RequestLevel getLowestPermittedRequestLevel();

   Priority getPriority();

   boolean isIntermediateResultExpected();

   boolean isPrefetch();
}
