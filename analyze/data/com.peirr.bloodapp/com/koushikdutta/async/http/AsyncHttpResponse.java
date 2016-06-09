package com.koushikdutta.async.http;

import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.libcore.ResponseHeaders;

public interface AsyncHttpResponse extends AsyncSocket {
   AsyncSocket detachSocket();

   void end();

   CompletedCallback getEndCallback();

   ResponseHeaders getHeaders();

   AsyncHttpRequest getRequest();

   void setEndCallback(CompletedCallback var1);
}
