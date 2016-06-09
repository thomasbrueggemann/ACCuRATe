package com.koushikdutta.ion.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.AsyncHttpRequestBody;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;

public class PojoBody<T> implements AsyncHttpRequestBody<T> {
   public static final String CONTENT_TYPE = "application/json";
   byte[] bodyBytes;
   Gson gson;
   T pojo;
   Type type;

   public PojoBody(Gson var1, T var2, TypeToken<T> var3) {
      this.pojo = var2;
      if(var3 != null) {
         this.type = var3.getType();
      }

      this.gson = var1;
   }

   public T get() {
      return this.pojo;
   }

   byte[] getBodyBytes() {
      if(this.bodyBytes != null) {
         return this.bodyBytes;
      } else {
         ByteArrayOutputStream var1 = new ByteArrayOutputStream();
         OutputStreamWriter var2 = new OutputStreamWriter(var1);
         if(this.type == null) {
            this.gson.toJson((Object)this.pojo, (Appendable)var2);
         } else {
            this.gson.toJson(this.pojo, this.type, (Appendable)var2);
         }

         try {
            var2.flush();
            var1.flush();
         } catch (Exception var4) {
            ;
         }

         this.bodyBytes = var1.toByteArray();
         return this.bodyBytes;
      }
   }

   public String getContentType() {
      return "application/json";
   }

   public int length() {
      return this.getBodyBytes().length;
   }

   public void parse(DataEmitter var1, CompletedCallback var2) {
   }

   public boolean readFullyOnRequest() {
      return true;
   }

   public void write(AsyncHttpRequest var1, DataSink var2, CompletedCallback var3) {
      Util.writeAll(var2, this.getBodyBytes(), var3);
   }
}
