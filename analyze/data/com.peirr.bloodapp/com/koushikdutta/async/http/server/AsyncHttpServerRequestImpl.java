package com.koushikdutta.async.http.server;

import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.FilteredDataEmitter;
import com.koushikdutta.async.LineEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.http.AsyncHttpRequestBody;
import com.koushikdutta.async.http.HttpUtil;
import com.koushikdutta.async.http.libcore.RawHeaders;
import com.koushikdutta.async.http.libcore.RequestHeaders;
import com.koushikdutta.async.http.server.AsyncHttpServerRequest;
import java.net.URI;
import java.util.regex.Matcher;

public abstract class AsyncHttpServerRequestImpl extends FilteredDataEmitter implements AsyncHttpServerRequest, CompletedCallback {
   AsyncHttpRequestBody mBody;
   LineEmitter.StringCallback mHeaderCallback = new LineEmitter.StringCallback() {
      public void onStringAvailable(String var1) {
         try {
            if(AsyncHttpServerRequestImpl.this.mRawHeaders.getStatusLine() == null) {
               AsyncHttpServerRequestImpl.this.mRawHeaders.setStatusLine(var1);
               if(!AsyncHttpServerRequestImpl.this.mRawHeaders.getStatusLine().contains("HTTP/")) {
                  AsyncHttpServerRequestImpl.this.onNotHttp();
                  AsyncHttpServerRequestImpl.this.mSocket.setDataCallback((DataCallback)null);
                  return;
               }
            } else {
               if(!"\r".equals(var1)) {
                  AsyncHttpServerRequestImpl.this.mRawHeaders.addLine(var1);
                  return;
               }

               DataEmitter var3 = HttpUtil.getBodyDecoder(AsyncHttpServerRequestImpl.this.mSocket, AsyncHttpServerRequestImpl.this.mRawHeaders, true);
               AsyncHttpServerRequestImpl.this.mBody = HttpUtil.getBody(var3, AsyncHttpServerRequestImpl.this.mReporter, AsyncHttpServerRequestImpl.this.mRawHeaders);
               AsyncHttpServerRequestImpl.this.mBody.parse(var3, AsyncHttpServerRequestImpl.this.mReporter);
               AsyncHttpServerRequestImpl.this.mHeaders = new RequestHeaders((URI)null, AsyncHttpServerRequestImpl.this.mRawHeaders);
               AsyncHttpServerRequestImpl.this.onHeadersReceived();
            }

         } catch (Exception var4) {
            AsyncHttpServerRequestImpl.this.onCompleted(var4);
         }
      }
   };
   private RequestHeaders mHeaders;
   Matcher mMatcher;
   private RawHeaders mRawHeaders = new RawHeaders();
   private CompletedCallback mReporter = new CompletedCallback() {
      public void onCompleted(Exception var1) {
         AsyncHttpServerRequestImpl.this.onCompleted(var1);
      }
   };
   AsyncSocket mSocket;
   String method;

   public AsyncHttpRequestBody getBody() {
      return this.mBody;
   }

   public DataCallback getDataCallback() {
      return this.mSocket.getDataCallback();
   }

   public RequestHeaders getHeaders() {
      return this.mHeaders;
   }

   public Matcher getMatcher() {
      return this.mMatcher;
   }

   public String getMethod() {
      return this.method;
   }

   RawHeaders getRawHeaders() {
      return this.mRawHeaders;
   }

   public AsyncSocket getSocket() {
      return this.mSocket;
   }

   public boolean isChunked() {
      return this.mSocket.isChunked();
   }

   public boolean isPaused() {
      return this.mSocket.isPaused();
   }

   public void onCompleted(Exception var1) {
      this.report(var1);
   }

   protected abstract void onHeadersReceived();

   protected void onNotHttp() {
      System.out.println("not http: " + this.mRawHeaders.getStatusLine());
      System.out.println("not http: " + this.mRawHeaders.getStatusLine().length());
   }

   public void pause() {
      this.mSocket.pause();
   }

   public void resume() {
      this.mSocket.resume();
   }

   public void setDataCallback(DataCallback var1) {
      this.mSocket.setDataCallback(var1);
   }

   void setSocket(AsyncSocket var1) {
      this.mSocket = var1;
      LineEmitter var2 = new LineEmitter();
      this.mSocket.setDataCallback(var2);
      var2.setLineCallback(this.mHeaderCallback);
   }
}
