package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.util.VersionInfo;

public class HttpClientBuilder {
   static final String DEFAULT_USER_AGENT;
   private int maxConnPerRoute = 0;
   private int maxConnTotal = 0;

   static {
      VersionInfo var0 = VersionInfo.loadVersionInfo("cz.msebera.android.httpclient.client", HttpClientBuilder.class.getClassLoader());
      String var1;
      if(var0 != null) {
         var1 = var0.getRelease();
      } else {
         var1 = "UNAVAILABLE";
      }

      DEFAULT_USER_AGENT = "Apache-HttpClient/" + var1 + " (java 1.5)";
   }
}
