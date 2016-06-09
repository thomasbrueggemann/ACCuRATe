package com.koushikdutta.async.http.callback;

import com.koushikdutta.async.http.AsyncHttpResponse;

public interface HttpConnectCallback {
   void onConnectCompleted(Exception var1, AsyncHttpResponse var2);
}
