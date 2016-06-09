package com.koushikdutta.async.future;

public interface FutureCallback<T> {
   void onCompleted(Exception var1, T var2);
}
