package com.koushikdutta.async.http.callback;

import com.koushikdutta.async.callback.ResultCallback;
import com.koushikdutta.async.http.AsyncHttpResponse;

public interface RequestCallback<T> extends ResultCallback<AsyncHttpResponse, T> {
   void onConnect(AsyncHttpResponse var1);

   void onProgress(AsyncHttpResponse var1, int var2, int var3);
}
