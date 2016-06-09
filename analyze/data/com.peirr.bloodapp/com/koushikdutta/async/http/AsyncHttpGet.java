package com.koushikdutta.async.http;

import com.koushikdutta.async.http.AsyncHttpRequest;
import java.net.URI;

public class AsyncHttpGet extends AsyncHttpRequest {
   public static final String METHOD = "GET";

   public AsyncHttpGet(String var1) {
      super(URI.create(var1), "GET");
   }

   public AsyncHttpGet(URI var1) {
      super(var1, "GET");
   }
}
