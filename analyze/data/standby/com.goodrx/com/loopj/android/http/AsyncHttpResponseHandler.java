package com.loopj.android.http;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.LogInterface;
import com.loopj.android.http.ResponseHandlerInterface;
import com.loopj.android.http.Utils;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.client.HttpResponseException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.URI;

public abstract class AsyncHttpResponseHandler implements ResponseHandlerInterface {
   protected static final int BUFFER_SIZE = 4096;
   protected static final int CANCEL_MESSAGE = 6;
   public static final String DEFAULT_CHARSET = "UTF-8";
   protected static final int FAILURE_MESSAGE = 1;
   protected static final int FINISH_MESSAGE = 3;
   private static final String LOG_TAG = "AsyncHttpRH";
   protected static final int PROGRESS_MESSAGE = 4;
   protected static final int RETRY_MESSAGE = 5;
   protected static final int START_MESSAGE = 2;
   protected static final int SUCCESS_MESSAGE = 0;
   public static final String UTF8_BOM = "\ufeff";
   private WeakReference<Object> TAG;
   private Handler handler;
   private Looper looper;
   private Header[] requestHeaders;
   private URI requestURI;
   private String responseCharset;
   private boolean usePoolThread;
   private boolean useSynchronousMode;

   public AsyncHttpResponseHandler() {
      this((Looper)null);
   }

   public AsyncHttpResponseHandler(Looper var1) {
      this.responseCharset = "UTF-8";
      this.requestURI = null;
      this.requestHeaders = null;
      this.looper = null;
      this.TAG = new WeakReference((Object)null);
      if(var1 == null) {
         var1 = Looper.myLooper();
      }

      this.looper = var1;
      this.setUseSynchronousMode(false);
      this.setUsePoolThread(false);
   }

   public AsyncHttpResponseHandler(boolean var1) {
      this.responseCharset = "UTF-8";
      this.requestURI = null;
      this.requestHeaders = null;
      this.looper = null;
      this.TAG = new WeakReference((Object)null);
      this.setUsePoolThread(var1);
      if(!this.getUsePoolThread()) {
         this.looper = Looper.myLooper();
         this.setUseSynchronousMode(false);
      }

   }

   public String getCharset() {
      return this.responseCharset == null?"UTF-8":this.responseCharset;
   }

   public Header[] getRequestHeaders() {
      return this.requestHeaders;
   }

   public URI getRequestURI() {
      return this.requestURI;
   }

   byte[] getResponseData(HttpEntity param1) throws IOException {
      // $FF: Couldn't be decompiled
   }

   public Object getTag() {
      return this.TAG.get();
   }

   public boolean getUsePoolThread() {
      return this.usePoolThread;
   }

   public boolean getUseSynchronousMode() {
      return this.useSynchronousMode;
   }

   protected void handleMessage(Message param1) {
      // $FF: Couldn't be decompiled
   }

   protected Message obtainMessage(int var1, Object var2) {
      return Message.obtain(this.handler, var1, var2);
   }

   public void onCancel() {
      AsyncHttpClient.log.method_1("AsyncHttpRH", "Request got cancelled");
   }

   public abstract void onFailure(int var1, Header[] var2, byte[] var3, Throwable var4);

   public void onFinish() {
   }

   public void onPostProcessResponse(ResponseHandlerInterface var1, HttpResponse var2) {
   }

   public void onPreProcessResponse(ResponseHandlerInterface var1, HttpResponse var2) {
   }

   public void onProgress(long var1, long var3) {
      LogInterface var5 = AsyncHttpClient.log;
      Object[] var6 = new Object[]{Long.valueOf(var1), Long.valueOf(var3), null};
      double var7;
      if(var3 > 0L) {
         var7 = 100.0D * (1.0D * (double)var1 / (double)var3);
      } else {
         var7 = -1.0D;
      }

      var6[2] = Double.valueOf(var7);
      var5.method_6("AsyncHttpRH", String.format("Progress %d from %d (%2.0f%%)", var6));
   }

   public void onRetry(int var1) {
      LogInterface var2 = AsyncHttpClient.log;
      Object[] var3 = new Object[]{Integer.valueOf(var1)};
      var2.method_1("AsyncHttpRH", String.format("Request retry no. %d", var3));
   }

   public void onStart() {
   }

   public abstract void onSuccess(int var1, Header[] var2, byte[] var3);

   public void onUserException(Throwable var1) {
      AsyncHttpClient.log.method_4("AsyncHttpRH", "User-space exception detected!", var1);
      throw new RuntimeException(var1);
   }

   protected void postRunnable(Runnable var1) {
      if(var1 != null) {
         if(!this.getUseSynchronousMode() && this.handler != null) {
            this.handler.post(var1);
            return;
         }

         var1.run();
      }

   }

   public final void sendCancelMessage() {
      this.sendMessage(this.obtainMessage(6, (Object)null));
   }

   public final void sendFailureMessage(int var1, Header[] var2, byte[] var3, Throwable var4) {
      Object[] var5 = new Object[]{Integer.valueOf(var1), var2, var3, var4};
      this.sendMessage(this.obtainMessage(1, var5));
   }

   public final void sendFinishMessage() {
      this.sendMessage(this.obtainMessage(3, (Object)null));
   }

   protected void sendMessage(Message var1) {
      if(!this.getUseSynchronousMode() && this.handler != null) {
         if(!Thread.currentThread().isInterrupted()) {
            boolean var2;
            if(this.handler != null) {
               var2 = true;
            } else {
               var2 = false;
            }

            Utils.asserts(var2, "handler should not be null!");
            this.handler.sendMessage(var1);
            return;
         }
      } else {
         this.handleMessage(var1);
      }

   }

   public final void sendProgressMessage(long var1, long var3) {
      Object[] var5 = new Object[]{Long.valueOf(var1), Long.valueOf(var3)};
      this.sendMessage(this.obtainMessage(4, var5));
   }

   public void sendResponseMessage(HttpResponse var1) throws IOException {
      if(!Thread.currentThread().isInterrupted()) {
         StatusLine var2 = var1.getStatusLine();
         byte[] var3 = this.getResponseData(var1.getEntity());
         if(!Thread.currentThread().isInterrupted()) {
            if(var2.getStatusCode() < 300) {
               this.sendSuccessMessage(var2.getStatusCode(), var1.getAllHeaders(), var3);
               return;
            }

            this.sendFailureMessage(var2.getStatusCode(), var1.getAllHeaders(), var3, new HttpResponseException(var2.getStatusCode(), var2.getReasonPhrase()));
         }
      }

   }

   public final void sendRetryMessage(int var1) {
      Object[] var2 = new Object[]{Integer.valueOf(var1)};
      this.sendMessage(this.obtainMessage(5, var2));
   }

   public final void sendStartMessage() {
      this.sendMessage(this.obtainMessage(2, (Object)null));
   }

   public final void sendSuccessMessage(int var1, Header[] var2, byte[] var3) {
      Object[] var4 = new Object[]{Integer.valueOf(var1), var2, var3};
      this.sendMessage(this.obtainMessage(0, var4));
   }

   public void setCharset(String var1) {
      this.responseCharset = var1;
   }

   public void setRequestHeaders(Header[] var1) {
      this.requestHeaders = var1;
   }

   public void setRequestURI(URI var1) {
      this.requestURI = var1;
   }

   public void setTag(Object var1) {
      this.TAG = new WeakReference(var1);
   }

   public void setUsePoolThread(boolean var1) {
      if(var1) {
         this.looper = null;
         this.handler = null;
      }

      this.usePoolThread = var1;
   }

   public void setUseSynchronousMode(boolean var1) {
      if(!var1 && this.looper == null) {
         var1 = true;
         AsyncHttpClient.log.method_7("AsyncHttpRH", "Current thread has not called Looper.prepare(). Forcing synchronous mode.");
      }

      if(!var1 && this.handler == null) {
         this.handler = new AsyncHttpResponseHandler.ResponderHandler(this, this.looper);
      } else if(var1 && this.handler != null) {
         this.handler = null;
      }

      this.useSynchronousMode = var1;
   }

   private static class ResponderHandler extends Handler {
      private final AsyncHttpResponseHandler mResponder;

      ResponderHandler(AsyncHttpResponseHandler var1, Looper var2) {
         super(var2);
         this.mResponder = var1;
      }

      public void handleMessage(Message var1) {
         this.mResponder.handleMessage(var1);
      }
   }
}
