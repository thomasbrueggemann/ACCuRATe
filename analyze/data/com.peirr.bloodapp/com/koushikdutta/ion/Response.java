package com.koushikdutta.ion;

import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.libcore.RawHeaders;

public class Response<T> {
   RawHeaders headers;
   AsyncHttpRequest request;
   T result;

   public RawHeaders getHeaders() {
      return this.headers;
   }

   public AsyncHttpRequest getRequest() {
      return this.request;
   }

   public T getResult() {
      return this.result;
   }
}
