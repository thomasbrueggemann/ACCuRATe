package com.koushikdutta.async.http;

import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.AsyncHttpRequestBody;
import com.koushikdutta.async.parser.StringParser;

public class StringBody implements AsyncHttpRequestBody<String> {
   public static final String CONTENT_TYPE = "text/plain";
   byte[] mBodyBytes;
   String string;

   public StringBody() {
   }

   public StringBody(String var1) {
      this();
      this.string = var1;
   }

   public String get() {
      return this.toString();
   }

   public String getContentType() {
      return "text/plain";
   }

   public int length() {
      if(this.mBodyBytes == null) {
         this.mBodyBytes = this.string.getBytes();
      }

      return this.mBodyBytes.length;
   }

   public void parse(DataEmitter var1, final CompletedCallback var2) {
      (new StringParser()).parse(var1).setCallback(new FutureCallback() {
         public void onCompleted(Exception var1, String var2x) {
            StringBody.this.string = var2x;
            var2.onCompleted(var1);
         }
      });
   }

   public boolean readFullyOnRequest() {
      return true;
   }

   public String toString() {
      return this.string;
   }

   public void write(AsyncHttpRequest var1, DataSink var2, CompletedCallback var3) {
      if(this.mBodyBytes == null) {
         this.mBodyBytes = this.string.getBytes();
      }

      Util.writeAll(var2, this.mBodyBytes, var3);
   }
}
