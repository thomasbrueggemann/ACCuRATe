package com.koushikdutta.async.http;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.AsyncHttpRequestBody;
import com.koushikdutta.async.http.Multimap;
import java.util.List;
import org.apache.http.NameValuePair;

public class UrlEncodedFormBody implements AsyncHttpRequestBody<Multimap> {
   public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
   private byte[] mBodyBytes;
   private Multimap mParameters;

   public UrlEncodedFormBody() {
   }

   public UrlEncodedFormBody(Multimap var1) {
      this.mParameters = var1;
   }

   public UrlEncodedFormBody(List<NameValuePair> var1) {
      this.mParameters = new Multimap(var1);
   }

   private void buildData() {
      // $FF: Couldn't be decompiled
   }

   public Multimap get() {
      return this.mParameters;
   }

   public String getContentType() {
      return "application/x-www-form-urlencoded";
   }

   public int length() {
      if(this.mBodyBytes == null) {
         this.buildData();
      }

      return this.mBodyBytes.length;
   }

   public void parse(DataEmitter var1, final CompletedCallback var2) {
      final ByteBufferList var3 = new ByteBufferList();
      var1.setDataCallback(new DataCallback() {
         public void onDataAvailable(DataEmitter var1, ByteBufferList var2) {
            var2.get(var3);
         }
      });
      var1.setEndCallback(new CompletedCallback() {
         public void onCompleted(Exception var1) {
            if(var1 != null) {
               var2.onCompleted(var1);
            } else {
               try {
                  UrlEncodedFormBody.this.mParameters = Multimap.parseQuery(var3.readString());
                  var2.onCompleted((Exception)null);
               } catch (Exception var3x) {
                  var2.onCompleted(var3x);
               }
            }
         }
      });
   }

   public boolean readFullyOnRequest() {
      return true;
   }

   public void write(AsyncHttpRequest var1, DataSink var2, CompletedCallback var3) {
      if(this.mBodyBytes == null) {
         this.buildData();
      }

      Util.writeAll(var2, this.mBodyBytes, var3);
   }
}
