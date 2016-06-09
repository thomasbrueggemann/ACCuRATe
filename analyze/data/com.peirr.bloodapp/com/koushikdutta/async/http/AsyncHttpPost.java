package com.koushikdutta.async.http;

import com.koushikdutta.async.http.AsyncHttpRequest;
import java.net.URI;

public class AsyncHttpPost extends AsyncHttpRequest {
   public static final String METHOD = "POST";

   public AsyncHttpPost(String var1) {
      this(URI.create(var1));
   }

   public AsyncHttpPost(URI var1) {
      super(var1, "POST");
   }
}
