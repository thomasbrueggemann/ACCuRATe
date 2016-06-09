package com.koushikdutta.async.callback;

public interface ResultCallback<S, T> {
   void onCompleted(Exception var1, S var2, T var3);
}
