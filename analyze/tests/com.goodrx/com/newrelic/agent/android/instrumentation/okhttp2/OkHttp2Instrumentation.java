package com.newrelic.agent.android.instrumentation.okhttp2;

import com.newrelic.agent.android.instrumentation.HttpURLConnectionExtension;
import com.newrelic.agent.android.instrumentation.HttpsURLConnectionExtension;
import com.newrelic.agent.android.instrumentation.ReplaceCallSite;
import com.newrelic.agent.android.instrumentation.okhttp2.CallExtension;
import com.newrelic.agent.android.instrumentation.okhttp2.RequestBuilderExtension;
import com.newrelic.agent.android.instrumentation.okhttp2.ResponseBuilderExtension;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.OkUrlFactory;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Response.Builder;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class OkHttp2Instrumentation {
   private static final AgentLog log = AgentLogManager.getAgentLog();

   @ReplaceCallSite
   public static Builder body(Builder var0, ResponseBody var1) {
      return (new ResponseBuilderExtension(var0)).body(var1);
   }

   @ReplaceCallSite
   public static Request build(com.squareup.okhttp.Request.Builder var0) {
      return (new RequestBuilderExtension(var0)).build();
   }

   @ReplaceCallSite
   public static Builder newBuilder(Builder var0) {
      return new ResponseBuilderExtension(var0);
   }

   @ReplaceCallSite
   public static Call newCall(OkHttpClient var0, Request var1) {
      return new CallExtension(var0, var1, var0.newCall(var1));
   }

   @ReplaceCallSite
   public static HttpURLConnection open(OkUrlFactory var0, URL var1) {
      HttpURLConnection var2 = var0.open(var1);
      String var3 = var1.getProtocol();
      return (HttpURLConnection)(var3.equals("http")?new HttpURLConnectionExtension(var2):(var3.equals("https") && var2 instanceof HttpsURLConnection?new HttpsURLConnectionExtension((HttpsURLConnection)var2):new HttpURLConnectionExtension(var2)));
   }
}
