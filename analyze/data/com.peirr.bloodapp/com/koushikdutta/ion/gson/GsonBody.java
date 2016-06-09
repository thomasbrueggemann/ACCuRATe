package com.koushikdutta.ion.gson;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.AsyncHttpRequestBody;
import com.koushikdutta.ion.gson.GsonParser;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;

public class GsonBody<T extends JsonElement> implements AsyncHttpRequestBody<T> {
   public static final String CONTENT_TYPE = "application/json";
   Gson gson;
   T json;
   byte[] mBodyBytes;

   public GsonBody(Gson var1, T var2) {
      this.json = var2;
      this.gson = var1;
   }

   public T get() {
      return this.json;
   }

   public String getContentType() {
      return "application/json";
   }

   public int length() {
      if(this.mBodyBytes == null) {
         this.mBodyBytes = this.json.toString().getBytes();
      }

      return this.mBodyBytes.length;
   }

   public void parse(DataEmitter var1, final CompletedCallback var2) {
      (new GsonParser()).parse(var1).setCallback(new FutureCallback() {
         public void onCompleted(Exception var1, T var2x) {
            GsonBody.this.json = var2x;
            var2.onCompleted(var1);
         }
      });
   }

   public boolean readFullyOnRequest() {
      return true;
   }

   public void write(AsyncHttpRequest var1, DataSink var2, CompletedCallback var3) {
      if(this.mBodyBytes == null) {
         ByteArrayOutputStream var4 = new ByteArrayOutputStream();
         OutputStreamWriter var5 = new OutputStreamWriter(var4);
         this.gson.toJson((JsonElement)this.json, (Appendable)var5);
         this.mBodyBytes = var4.toByteArray();
      }

      Util.writeAll(var2, this.mBodyBytes, var3);
   }
}
