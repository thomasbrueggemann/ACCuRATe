package com.google.android.gms.common.api;

import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
   public abstract void onFailure(@NonNull Status var1);

   public abstract void onSuccess(@NonNull R var1);
}
