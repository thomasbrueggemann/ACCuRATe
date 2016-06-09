package com.koushikdutta.async.http;

import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.AsyncHttpRequestBody;
import com.koushikdutta.async.parser.JSONObjectParser;
import org.json.JSONObject;

public class JSONObjectBody implements AsyncHttpRequestBody<JSONObject> {
   public static final String CONTENT_TYPE = "application/json";
   JSONObject json;
   byte[] mBodyBytes;

   public JSONObjectBody() {
   }

   public JSONObjectBody(JSONObject var1) {
      this();
      this.json = var1;
   }

   public JSONObject get() {
      return this.json;
   }

   public String getContentType() {
      return "application/json";
   }

   public int length() {
      this.mBodyBytes = this.json.toString().getBytes();
      return this.mBodyBytes.length;
   }

   public void parse(DataEmitter var1, final CompletedCallback var2) {
      (new JSONObjectParser()).parse(var1).setCallback(new FutureCallback() {
         public void onCompleted(Exception var1, JSONObject var2x) {
            JSONObjectBody.this.json = var2x;
            var2.onCompleted(var1);
         }
      });
   }

   public boolean readFullyOnRequest() {
      return true;
   }

   public void write(AsyncHttpRequest var1, DataSink var2, CompletedCallback var3) {
      Util.writeAll(var2, this.mBodyBytes, var3);
   }
}
