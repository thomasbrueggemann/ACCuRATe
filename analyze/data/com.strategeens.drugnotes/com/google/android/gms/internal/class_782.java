package com.google.android.gms.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import java.util.concurrent.TimeUnit;

// $FF: renamed from: com.google.android.gms.internal.me
class class_782<T extends Result> implements PendingResult<T> {
   // $FF: renamed from: UU com.google.android.gms.common.api.Result
   private final T field_3439;

   class_782(T var1) {
      this.field_3439 = var1;
   }

   // $FF: renamed from: a (com.google.android.gms.common.api.PendingResult$a) void
   public void method_919(PendingResult.class_1650 var1) {
      var1.method_940(this.field_3439.getStatus());
   }

   public T await() {
      return this.field_3439;
   }

   public T await(long var1, TimeUnit var3) {
      return this.field_3439;
   }

   public void cancel() {
   }

   public boolean isCanceled() {
      return false;
   }

   public void setResultCallback(ResultCallback<T> var1) {
      var1.onResult(this.field_3439);
   }

   public void setResultCallback(ResultCallback<T> var1, long var2, TimeUnit var4) {
      var1.onResult(this.field_3439);
   }
}
