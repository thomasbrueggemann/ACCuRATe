package com.facebook.imagepipeline.listener;

import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import javax.annotation.Nullable;

public class BaseRequestListener implements RequestListener {
   public void onProducerEvent(String var1, String var2, String var3) {
   }

   public void onProducerFinishWithCancellation(String var1, String var2, @Nullable Map<String, String> var3) {
   }

   public void onProducerFinishWithFailure(String var1, String var2, Throwable var3, @Nullable Map<String, String> var4) {
   }

   public void onProducerFinishWithSuccess(String var1, String var2, @Nullable Map<String, String> var3) {
   }

   public void onProducerStart(String var1, String var2) {
   }

   public void onRequestCancellation(String var1) {
   }

   public void onRequestFailure(ImageRequest var1, String var2, Throwable var3, boolean var4) {
   }

   public void onRequestStart(ImageRequest var1, Object var2, String var3, boolean var4) {
   }

   public void onRequestSuccess(ImageRequest var1, String var2, boolean var3) {
   }

   public boolean requiresExtraMap(String var1) {
      return false;
   }
}
