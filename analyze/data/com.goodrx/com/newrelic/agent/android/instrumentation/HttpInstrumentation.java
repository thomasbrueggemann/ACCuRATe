package com.newrelic.agent.android.instrumentation;

import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.instrumentation.HttpURLConnectionExtension;
import com.newrelic.agent.android.instrumentation.HttpsURLConnectionExtension;
import com.newrelic.agent.android.instrumentation.ReplaceCallSite;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.instrumentation.TransactionStateUtil;
import com.newrelic.agent.android.instrumentation.WrapReturn;
import com.newrelic.agent.android.instrumentation.httpclient.ResponseHandlerImpl;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

public final class HttpInstrumentation {
   // $FF: renamed from: _ (org.apache.http.HttpHost, org.apache.http.HttpRequest, com.newrelic.agent.android.instrumentation.TransactionState) org.apache.http.HttpRequest
   private static HttpRequest method_448(HttpHost var0, HttpRequest var1, TransactionState var2) {
      return TransactionStateUtil.inspectAndInstrument(var2, var0, var1);
   }

   // $FF: renamed from: _ (org.apache.http.HttpResponse, com.newrelic.agent.android.instrumentation.TransactionState) org.apache.http.HttpResponse
   private static HttpResponse method_449(HttpResponse var0, TransactionState var1) {
      return TransactionStateUtil.inspectAndInstrument(var1, var0);
   }

   // $FF: renamed from: _ (org.apache.http.client.ResponseHandler, com.newrelic.agent.android.instrumentation.TransactionState) org.apache.http.client.ResponseHandler
   private static <T> ResponseHandler<? extends T> method_450(ResponseHandler<? extends T> var0, TransactionState var1) {
      return ResponseHandlerImpl.wrap(var0, var1);
   }

   // $FF: renamed from: _ (org.apache.http.client.methods.HttpUriRequest, com.newrelic.agent.android.instrumentation.TransactionState) org.apache.http.client.methods.HttpUriRequest
   private static HttpUriRequest method_451(HttpUriRequest var0, TransactionState var1) {
      return TransactionStateUtil.inspectAndInstrument(var1, var0);
   }

   @ReplaceCallSite
   public static <T> T execute(HttpClient var0, HttpHost var1, HttpRequest var2, ResponseHandler<? extends T> var3) throws IOException, ClientProtocolException {
      TransactionState var4 = new TransactionState();

      try {
         Object var7 = var0.execute(var1, method_448(var1, var2, var4), method_450(var3, var4));
         return var7;
      } catch (ClientProtocolException var8) {
         httpClientError(var4, var8);
         throw var8;
      } catch (IOException var9) {
         httpClientError(var4, var9);
         throw var9;
      }
   }

   @ReplaceCallSite
   public static <T> T execute(HttpClient var0, HttpHost var1, HttpRequest var2, ResponseHandler<? extends T> var3, HttpContext var4) throws IOException, ClientProtocolException {
      TransactionState var5 = new TransactionState();

      try {
         Object var8 = var0.execute(var1, method_448(var1, var2, var5), method_450(var3, var5), var4);
         return var8;
      } catch (ClientProtocolException var9) {
         httpClientError(var5, var9);
         throw var9;
      } catch (IOException var10) {
         httpClientError(var5, var10);
         throw var10;
      }
   }

   @ReplaceCallSite
   public static <T> T execute(HttpClient var0, HttpUriRequest var1, ResponseHandler<? extends T> var2) throws IOException, ClientProtocolException {
      TransactionState var3 = new TransactionState();

      try {
         Object var6 = var0.execute(method_451(var1, var3), method_450(var2, var3));
         return var6;
      } catch (ClientProtocolException var7) {
         httpClientError(var3, var7);
         throw var7;
      } catch (IOException var8) {
         httpClientError(var3, var8);
         throw var8;
      }
   }

   @ReplaceCallSite
   public static <T> T execute(HttpClient var0, HttpUriRequest var1, ResponseHandler<? extends T> var2, HttpContext var3) throws IOException, ClientProtocolException {
      TransactionState var4 = new TransactionState();

      try {
         Object var7 = var0.execute(method_451(var1, var4), method_450(var2, var4), var3);
         return var7;
      } catch (ClientProtocolException var8) {
         httpClientError(var4, var8);
         throw var8;
      } catch (IOException var9) {
         httpClientError(var4, var9);
         throw var9;
      }
   }

   @ReplaceCallSite
   public static HttpResponse execute(HttpClient var0, HttpHost var1, HttpRequest var2) throws IOException {
      TransactionState var3 = new TransactionState();

      try {
         HttpResponse var5 = method_449(var0.execute(var1, method_448(var1, var2, var3)), var3);
         return var5;
      } catch (IOException var6) {
         httpClientError(var3, var6);
         throw var6;
      }
   }

   @ReplaceCallSite
   public static HttpResponse execute(HttpClient var0, HttpHost var1, HttpRequest var2, HttpContext var3) throws IOException {
      TransactionState var4 = new TransactionState();

      try {
         HttpResponse var6 = method_449(var0.execute(var1, method_448(var1, var2, var4), var3), var4);
         return var6;
      } catch (IOException var7) {
         httpClientError(var4, var7);
         throw var7;
      }
   }

   @ReplaceCallSite
   public static HttpResponse execute(HttpClient var0, HttpUriRequest var1) throws IOException {
      TransactionState var2 = new TransactionState();

      try {
         HttpResponse var4 = method_449(var0.execute(method_451(var1, var2)), var2);
         return var4;
      } catch (IOException var5) {
         httpClientError(var2, var5);
         throw var5;
      }
   }

   @ReplaceCallSite
   public static HttpResponse execute(HttpClient var0, HttpUriRequest var1, HttpContext var2) throws IOException {
      TransactionState var3 = new TransactionState();

      try {
         HttpResponse var5 = method_449(var0.execute(method_451(var1, var3), var2), var3);
         return var5;
      } catch (IOException var6) {
         httpClientError(var3, var6);
         throw var6;
      }
   }

   private static void httpClientError(TransactionState var0, Exception var1) {
      if(!var0.isComplete()) {
         TransactionStateUtil.setErrorCodeFromException(var0, var1);
         TransactionData var2 = var0.end();
         if(var2 != null) {
            TaskQueue.queue(new HttpTransactionMeasurement(var2.getUrl(), var2.getHttpMethod(), var2.getStatusCode(), var2.getErrorCode(), var2.getTimestamp(), (double)var2.getTime(), var2.getBytesSent(), var2.getBytesReceived(), var2.getAppData()));
         }
      }

   }

   @WrapReturn(
      className = "java/net/URL",
      methodDesc = "()Ljava/net/URLConnection;",
      methodName = "openConnection"
   )
   public static URLConnection openConnection(URLConnection var0) {
      if(var0 instanceof HttpsURLConnection) {
         var0 = new HttpsURLConnectionExtension((HttpsURLConnection)var0);
      } else if(var0 instanceof HttpURLConnection) {
         return new HttpURLConnectionExtension((HttpURLConnection)var0);
      }

      return (URLConnection)var0;
   }

   @WrapReturn(
      className = "java.net.URL",
      methodDesc = "(Ljava/net/Proxy;)Ljava/net/URLConnection;",
      methodName = "openConnection"
   )
   public static URLConnection openConnectionWithProxy(URLConnection var0) {
      if(var0 instanceof HttpsURLConnection) {
         var0 = new HttpsURLConnectionExtension((HttpsURLConnection)var0);
      } else if(var0 instanceof HttpURLConnection) {
         return new HttpURLConnectionExtension((HttpURLConnection)var0);
      }

      return (URLConnection)var0;
   }
}
