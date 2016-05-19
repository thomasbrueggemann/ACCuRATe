package com.newrelic.agent.android.instrumentation;

import com.newrelic.agent.android.instrumentation.HttpURLConnectionExtension;
import com.newrelic.agent.android.instrumentation.HttpsURLConnectionExtension;
import com.newrelic.agent.android.instrumentation.WrapReturn;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;

public class OkHttpInstrumentation {
   private static final AgentLog log = AgentLogManager.getAgentLog();

   @WrapReturn(
      className = "com/squareup/okhttp/OkHttpClient",
      methodDesc = "(Ljava/net/URL;)Ljava/net/HttpURLConnection;",
      methodName = "open"
   )
   public static HttpURLConnection open(HttpURLConnection var0) {
      return (HttpURLConnection)(var0 instanceof HttpsURLConnection?new HttpsURLConnectionExtension((HttpsURLConnection)var0):(var0 != null?new HttpURLConnectionExtension(var0):null));
   }

   @WrapReturn(
      className = "com/squareup/okhttp/OkHttpClient",
      methodDesc = "(Ljava/net/URL;Ljava/net/Proxy)Ljava/net/HttpURLConnection;",
      methodName = "open"
   )
   public static HttpURLConnection openWithProxy(HttpURLConnection var0) {
      return (HttpURLConnection)(var0 instanceof HttpsURLConnection?new HttpsURLConnectionExtension((HttpsURLConnection)var0):(var0 != null?new HttpURLConnectionExtension(var0):null));
   }

   @WrapReturn(
      className = "com/squareup/okhttp/OkUrlFactory",
      methodDesc = "(Ljava/net/URL;)Ljava/net/HttpURLConnection;",
      methodName = "open"
   )
   public static HttpURLConnection urlFactoryOpen(HttpURLConnection var0) {
      log.debug("OkHttpInstrumentation - wrapping return of call to OkUrlFactory.open...");
      return (HttpURLConnection)(var0 instanceof HttpsURLConnection?new HttpsURLConnectionExtension((HttpsURLConnection)var0):(var0 != null?new HttpURLConnectionExtension(var0):null));
   }
}
