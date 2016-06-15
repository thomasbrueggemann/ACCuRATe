package com.google.android.gms.common.api;

import com.google.android.gms.common.api.BatchResultToken;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_347;
import java.util.concurrent.TimeUnit;

public final class BatchResult implements Result {
   // $FF: renamed from: Dz com.google.android.gms.common.api.PendingResult[]
   private final PendingResult<?>[] field_3412;
   // $FF: renamed from: yw com.google.android.gms.common.api.Status
   private final Status field_3413;

   BatchResult(Status var1, PendingResult<?>[] var2) {
      this.field_3413 = var1;
      this.field_3412 = var2;
   }

   public Status getStatus() {
      return this.field_3413;
   }

   public <R extends Result> R take(BatchResultToken<R> var1) {
      boolean var2;
      if(var1.mId < this.field_3412.length) {
         var2 = true;
      } else {
         var2 = false;
      }

      class_347.method_2168(var2, "The result token does not belong to this batch");
      return this.field_3412[var1.mId].await(0L, TimeUnit.MILLISECONDS);
   }
}
