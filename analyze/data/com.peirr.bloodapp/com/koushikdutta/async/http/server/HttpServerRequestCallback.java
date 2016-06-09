package com.koushikdutta.async.http.server;

import com.koushikdutta.async.http.server.AsyncHttpServerRequest;
import com.koushikdutta.async.http.server.AsyncHttpServerResponse;

public interface HttpServerRequestCallback {
   void onRequest(AsyncHttpServerRequest var1, AsyncHttpServerResponse var2);
}
