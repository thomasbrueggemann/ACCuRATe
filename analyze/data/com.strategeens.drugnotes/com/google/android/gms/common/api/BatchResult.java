package com.google.android.gms.common.api;

import com.google.android.gms.common.api.BatchResultToken;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.class_335;
import java.util.concurrent.TimeUnit;

public final class BatchResult implements Result {
   // $FF: renamed from: Eb com.google.android.gms.common.api.Status
   private final Status field_3510;
   // $FF: renamed from: JC com.google.android.gms.common.api.PendingResult[]
   private final PendingResult<?>[] field_3511;

   BatchResult(Status var1, PendingResult<?>[] var2) {
      this.field_3510 = var1;
      this.field_3511 = var2;
   }

   public Status getStatus() {
      return this.field_3510;
   }

   public <R extends Result> R take(BatchResultToken<R> var1) {
      boolean var2;
      if(var1.mId < this.field_3511.length) {
         var2 = true;
      } else {
         var2 = false;
      }

      class_335.method_2308(var2, "The result token does not belong to this batch");
      return this.field_3511[var1.mId].await(0L, TimeUnit.MILLISECONDS);
   }
}
