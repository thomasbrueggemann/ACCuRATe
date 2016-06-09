package com.facebook.imagepipeline.producers;

import java.util.Map;
import javax.annotation.Nullable;

public interface ProducerListener {
   void onProducerEvent(String var1, String var2, String var3);

   void onProducerFinishWithCancellation(String var1, String var2, @Nullable Map<String, String> var3);

   void onProducerFinishWithFailure(String var1, String var2, Throwable var3, @Nullable Map<String, String> var4);

   void onProducerFinishWithSuccess(String var1, String var2, @Nullable Map<String, String> var3);

   void onProducerStart(String var1, String var2);

   boolean requiresExtraMap(String var1);
}
