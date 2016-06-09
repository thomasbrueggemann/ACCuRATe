package com.loopj.android.http;

import cz.msebera.android.httpclient.client.methods.HttpEntityEnclosingRequestBase;
import java.net.URI;

public final class HttpGet extends HttpEntityEnclosingRequestBase {
   public HttpGet() {
   }

   public HttpGet(String var1) {
      this.setURI(URI.create(var1));
   }

   public String getMethod() {
      return "GET";
   }
}
