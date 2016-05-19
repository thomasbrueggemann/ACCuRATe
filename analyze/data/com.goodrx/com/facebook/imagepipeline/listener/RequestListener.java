package com.facebook.imagepipeline.listener;

import com.facebook.imagepipeline.producers.ProducerListener;
import com.facebook.imagepipeline.request.ImageRequest;

public interface RequestListener extends ProducerListener {
   void onRequestCancellation(String var1);

   void onRequestFailure(ImageRequest var1, String var2, Throwable var3, boolean var4);

   void onRequestStart(ImageRequest var1, Object var2, String var3, boolean var4);

   void onRequestSuccess(ImageRequest var1, String var2, boolean var3);
}
