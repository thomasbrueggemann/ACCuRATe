package com.koushikdutta.async.http;

import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;

public interface AsyncHttpRequestBody<T> {
   T get();

   String getContentType();

   int length();

   void parse(DataEmitter var1, CompletedCallback var2);

   boolean readFullyOnRequest();

   void write(AsyncHttpRequest var1, DataSink var2, CompletedCallback var3);
}
