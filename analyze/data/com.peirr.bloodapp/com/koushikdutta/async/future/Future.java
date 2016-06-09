package com.koushikdutta.async.future;

import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.future.FutureCallback;

public interface Future<T> extends Cancellable, java.util.concurrent.Future<T> {
   Future<T> setCallback(FutureCallback<T> var1);
}
