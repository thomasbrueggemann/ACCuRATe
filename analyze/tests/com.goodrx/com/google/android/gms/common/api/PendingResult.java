package com.google.android.gms.common.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.TimeUnit;

public abstract class PendingResult<R extends Result> {
   public abstract void setResultCallback(@NonNull ResultCallback<? super R> var1);

   public abstract void setResultCallback(@NonNull ResultCallback<? super R> var1, long var2, @NonNull TimeUnit var4);

   @Nullable
   public Integer zzpa() {
      throw new UnsupportedOperationException();
   }

   public interface zza {
      void zzu(Status var1);
   }
}
