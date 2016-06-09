package com.koushikdutta.ion;

import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.libcore.RawHeaders;
import com.koushikdutta.ion.Ion;

public interface Loader {
   Future<DataEmitter> load(Ion var1, AsyncHttpRequest var2, FutureCallback<Loader.LoaderEmitter> var3);

   public static class LoaderEmitter {
      public static final int LOADED_FROM_CACHE = 1;
      public static final int LOADED_FROM_CONDITIONAL_CACHE = 2;
      public static final int LOADED_FROM_MEMORY = 0;
      public static final int LOADED_FROM_NETWORK = 3;
      DataEmitter emitter;
      RawHeaders headers;
      int length;
      int loadedFrom;
      AsyncHttpRequest request;

      public LoaderEmitter(DataEmitter var1, int var2, int var3, RawHeaders var4, AsyncHttpRequest var5) {
         this.length = var2;
         this.emitter = var1;
         this.loadedFrom = var3;
         this.headers = var4;
         this.request = var5;
      }

      public DataEmitter getDataEmitter() {
         return this.emitter;
      }

      public RawHeaders getHeaders() {
         return this.headers;
      }

      public AsyncHttpRequest getRequest() {
         return this.request;
      }

      public int length() {
         return this.length;
      }

      public int loadedFrom() {
         return this.loadedFrom;
      }
   }
}
