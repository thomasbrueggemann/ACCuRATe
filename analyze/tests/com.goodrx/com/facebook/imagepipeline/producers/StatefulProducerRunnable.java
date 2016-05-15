package com.facebook.imagepipeline.producers;

import com.facebook.common.executors.StatefulRunnable;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.ProducerListener;
import java.util.Map;

public abstract class StatefulProducerRunnable<T> extends StatefulRunnable<T> {
   private final Consumer<T> mConsumer;
   private final ProducerListener mProducerListener;
   private final String mProducerName;
   private final String mRequestId;

   public StatefulProducerRunnable(Consumer<T> var1, ProducerListener var2, String var3, String var4) {
      this.mConsumer = var1;
      this.mProducerListener = var2;
      this.mProducerName = var3;
      this.mRequestId = var4;
      this.mProducerListener.onProducerStart(this.mRequestId, this.mProducerName);
   }

   protected abstract void disposeResult(T var1);

   protected Map<String, String> getExtraMapOnCancellation() {
      return null;
   }

   protected Map<String, String> getExtraMapOnFailure(Exception var1) {
      return null;
   }

   protected Map<String, String> getExtraMapOnSuccess(T var1) {
      return null;
   }

   protected void onCancellation() {
      ProducerListener var1 = this.mProducerListener;
      String var2 = this.mRequestId;
      String var3 = this.mProducerName;
      Map var4;
      if(this.mProducerListener.requiresExtraMap(this.mRequestId)) {
         var4 = this.getExtraMapOnCancellation();
      } else {
         var4 = null;
      }

      var1.onProducerFinishWithCancellation(var2, var3, var4);
      this.mConsumer.onCancellation();
   }

   protected void onFailure(Exception var1) {
      ProducerListener var2 = this.mProducerListener;
      String var3 = this.mRequestId;
      String var4 = this.mProducerName;
      Map var5;
      if(this.mProducerListener.requiresExtraMap(this.mRequestId)) {
         var5 = this.getExtraMapOnFailure(var1);
      } else {
         var5 = null;
      }

      var2.onProducerFinishWithFailure(var3, var4, var1, var5);
      this.mConsumer.onFailure(var1);
   }

   protected void onSuccess(T var1) {
      ProducerListener var2 = this.mProducerListener;
      String var3 = this.mRequestId;
      String var4 = this.mProducerName;
      Map var5;
      if(this.mProducerListener.requiresExtraMap(this.mRequestId)) {
         var5 = this.getExtraMapOnSuccess(var1);
      } else {
         var5 = null;
      }

      var2.onProducerFinishWithSuccess(var3, var4, var5);
      this.mConsumer.onNewResult(var1, true);
   }
}
