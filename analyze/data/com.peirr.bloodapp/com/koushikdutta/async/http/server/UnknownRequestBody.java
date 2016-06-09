package com.koushikdutta.async.http.server;

import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.NullDataCallback;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.AsyncHttpRequestBody;

public class UnknownRequestBody implements AsyncHttpRequestBody<Void> {
   // $FF: synthetic field
   static final boolean $assertionsDisabled;
   private String mContentType;

   static {
      boolean var0;
      if(!UnknownRequestBody.class.desiredAssertionStatus()) {
         var0 = true;
      } else {
         var0 = false;
      }

      $assertionsDisabled = var0;
   }

   public UnknownRequestBody(String var1) {
      this.mContentType = var1;
   }

   public Void get() {
      return null;
   }

   public String getContentType() {
      return this.mContentType;
   }

   public int length() {
      return -1;
   }

   public void parse(DataEmitter var1, CompletedCallback var2) {
      var1.setEndCallback(var2);
      var1.setDataCallback(new NullDataCallback());
   }

   public boolean readFullyOnRequest() {
      return false;
   }

   public void write(AsyncHttpRequest var1, DataSink var2, CompletedCallback var3) {
      if(!$assertionsDisabled) {
         throw new AssertionError();
      }
   }
}
