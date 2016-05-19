package com.loopj.android.http;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RangeFileAsyncHttpResponseHandler;
import com.loopj.android.http.ResponseHandlerInterface;
import com.loopj.android.http.Utils;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.client.methods.CloseableHttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.impl.client.AbstractHttpClient;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.atomic.AtomicBoolean;

public class AsyncHttpRequest implements Runnable {
   private boolean cancelIsNotified;
   private final AbstractHttpClient client;
   private final HttpContext context;
   private int executionCount;
   private final AtomicBoolean isCancelled = new AtomicBoolean();
   private volatile boolean isFinished;
   private boolean isRequestPreProcessed;
   private final HttpUriRequest request;
   private final ResponseHandlerInterface responseHandler;

   public AsyncHttpRequest(AbstractHttpClient var1, HttpContext var2, HttpUriRequest var3, ResponseHandlerInterface var4) {
      this.client = (AbstractHttpClient)Utils.notNull(var1, "client");
      this.context = (HttpContext)Utils.notNull(var2, "context");
      this.request = (HttpUriRequest)Utils.notNull(var3, "request");
      this.responseHandler = (ResponseHandlerInterface)Utils.notNull(var4, "responseHandler");
   }

   private void makeRequest() throws IOException {
      if(!this.isCancelled()) {
         if(this.request.getURI().getScheme() == null) {
            throw new MalformedURLException("No valid URI scheme was provided");
         }

         if(this.responseHandler instanceof RangeFileAsyncHttpResponseHandler) {
            ((RangeFileAsyncHttpResponseHandler)this.responseHandler).updateRequestHeaders(this.request);
         }

         CloseableHttpResponse var1 = this.client.execute(this.request, this.context);
         if(!this.isCancelled()) {
            this.responseHandler.onPreProcessResponse(this.responseHandler, var1);
            if(!this.isCancelled()) {
               this.responseHandler.sendResponseMessage(var1);
               if(!this.isCancelled()) {
                  this.responseHandler.onPostProcessResponse(this.responseHandler, var1);
                  return;
               }
            }
         }
      }

   }

   private void makeRequestWithRetries() throws IOException {
      // $FF: Couldn't be decompiled
   }

   private void sendCancelNotification() {
      synchronized(this){}

      try {
         if(!this.isFinished && this.isCancelled.get() && !this.cancelIsNotified) {
            this.cancelIsNotified = true;
            this.responseHandler.sendCancelMessage();
         }
      } finally {
         ;
      }

   }

   public boolean isCancelled() {
      boolean var1 = this.isCancelled.get();
      if(var1) {
         this.sendCancelNotification();
      }

      return var1;
   }

   public boolean isDone() {
      return this.isCancelled() || this.isFinished;
   }

   public void onPostProcessRequest(AsyncHttpRequest var1) {
   }

   public void onPreProcessRequest(AsyncHttpRequest var1) {
   }

   public void run() {
      if(!this.isCancelled()) {
         if(!this.isRequestPreProcessed) {
            this.isRequestPreProcessed = true;
            this.onPreProcessRequest(this);
         }

         if(!this.isCancelled()) {
            this.responseHandler.sendStartMessage();
            if(!this.isCancelled()) {
               try {
                  this.makeRequestWithRetries();
               } catch (IOException var2) {
                  if(!this.isCancelled()) {
                     this.responseHandler.sendFailureMessage(0, (Header[])null, (byte[])null, var2);
                  } else {
                     AsyncHttpClient.log.method_4("AsyncHttpRequest", "makeRequestWithRetries returned error", var2);
                  }
               }

               if(!this.isCancelled()) {
                  this.responseHandler.sendFinishMessage();
                  if(!this.isCancelled()) {
                     this.onPostProcessRequest(this);
                     this.isFinished = true;
                     return;
                  }
               }
            }
         }
      }

   }
}
