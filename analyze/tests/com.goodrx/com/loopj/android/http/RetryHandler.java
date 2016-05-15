package com.loopj.android.http;

import android.os.SystemClock;
import cz.msebera.android.httpclient.NoHttpResponseException;
import cz.msebera.android.httpclient.client.HttpRequestRetryHandler;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Iterator;
import javax.net.ssl.SSLException;

class RetryHandler implements HttpRequestRetryHandler {
   private static final HashSet<Class<?>> exceptionBlacklist = new HashSet();
   private static final HashSet<Class<?>> exceptionWhitelist = new HashSet();
   private final int maxRetries;
   private final int retrySleepTimeMS;

   static {
      exceptionWhitelist.add(NoHttpResponseException.class);
      exceptionWhitelist.add(UnknownHostException.class);
      exceptionWhitelist.add(SocketException.class);
      exceptionBlacklist.add(InterruptedIOException.class);
      exceptionBlacklist.add(SSLException.class);
   }

   public RetryHandler(int var1, int var2) {
      this.maxRetries = var1;
      this.retrySleepTimeMS = var2;
   }

   protected boolean isInList(HashSet<Class<?>> var1, Throwable var2) {
      Iterator var3 = var1.iterator();

      do {
         if(!var3.hasNext()) {
            return false;
         }
      } while(!((Class)var3.next()).isInstance(var2));

      return true;
   }

   public boolean retryRequest(IOException var1, int var2, HttpContext var3) {
      boolean var4 = true;
      Boolean var5 = (Boolean)var3.getAttribute("http.request_sent");
      boolean var6;
      if(var5 != null && var5.booleanValue()) {
         var6 = true;
      } else {
         var6 = false;
      }

      if(var2 > this.maxRetries) {
         var4 = false;
      } else if(this.isInList(exceptionWhitelist, var1)) {
         var4 = true;
      } else if(this.isInList(exceptionBlacklist, var1)) {
         var4 = false;
      } else if(!var6) {
         var4 = true;
      }

      if(var4 && (HttpUriRequest)var3.getAttribute("http.request") == null) {
         return false;
      } else {
         if(var4) {
            SystemClock.sleep((long)this.retrySleepTimeMS);
         } else {
            var1.printStackTrace();
         }

         return var4;
      }
   }
}
