package com.facebook.imagepipeline.producers;

public interface Consumer<T> {
   void onCancellation();

   void onFailure(Throwable var1);

   void onNewResult(T var1, boolean var2);

   void onProgressUpdate(float var1);
}
