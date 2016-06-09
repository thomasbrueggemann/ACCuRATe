package cz.msebera.android.httpclient.params;

import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.util.Args;

@Deprecated
public final class HttpProtocolParams {
   public static String getHttpElementCharset(HttpParams var0) {
      Args.notNull(var0, "HTTP parameters");
      String var2 = (String)var0.getParameter("http.protocol.element-charset");
      if(var2 == null) {
         var2 = HTTP.DEF_PROTOCOL_CHARSET.name();
      }

      return var2;
   }

   public static ProtocolVersion getVersion(HttpParams var0) {
      Args.notNull(var0, "HTTP parameters");
      Object var2 = var0.getParameter("http.protocol.version");
      return (ProtocolVersion)(var2 == null?HttpVersion.HTTP_1_1:(ProtocolVersion)var2);
   }

   public static void setContentCharset(HttpParams var0, String var1) {
      Args.notNull(var0, "HTTP parameters");
      var0.setParameter("http.protocol.content-charset", var1);
   }

   public static void setUserAgent(HttpParams var0, String var1) {
      Args.notNull(var0, "HTTP parameters");
      var0.setParameter("http.useragent", var1);
   }

   public static void setVersion(HttpParams var0, ProtocolVersion var1) {
      Args.notNull(var0, "HTTP parameters");
      var0.setParameter("http.protocol.version", var1);
   }
}
