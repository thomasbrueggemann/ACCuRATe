package com.google.android.gms.common.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public abstract class ResultTransform<R extends Result, S extends Result> {
   @NonNull
   public Status onFailure(@NonNull Status var1) {
      return var1;
   }

   @Nullable
   @WorkerThread
   public abstract PendingResult<S> onSuccess(@NonNull R var1);
}
