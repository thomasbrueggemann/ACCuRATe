package cz.msebera.android.httpclient.params;

import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;

@Deprecated
public final class HttpConnectionParams {
   public static int getConnectionTimeout(HttpParams var0) {
      Args.notNull(var0, "HTTP parameters");
      return var0.getIntParameter("http.connection.timeout", 0);
   }

   public static int getLinger(HttpParams var0) {
      Args.notNull(var0, "HTTP parameters");
      return var0.getIntParameter("http.socket.linger", -1);
   }

   public static boolean getSoReuseaddr(HttpParams var0) {
      Args.notNull(var0, "HTTP parameters");
      return var0.getBooleanParameter("http.socket.reuseaddr", false);
   }

   public static int getSoTimeout(HttpParams var0) {
      Args.notNull(var0, "HTTP parameters");
      return var0.getIntParameter("http.socket.timeout", 0);
   }

   public static boolean getTcpNoDelay(HttpParams var0) {
      Args.notNull(var0, "HTTP parameters");
      return var0.getBooleanParameter("http.tcp.nodelay", true);
   }

   public static boolean isStaleCheckingEnabled(HttpParams var0) {
      Args.notNull(var0, "HTTP parameters");
      return var0.getBooleanParameter("http.connection.stalecheck", true);
   }

   public static void setConnectionTimeout(HttpParams var0, int var1) {
      Args.notNull(var0, "HTTP parameters");
      var0.setIntParameter("http.connection.timeout", var1);
   }

   public static void setSoTimeout(HttpParams var0, int var1) {
      Args.notNull(var0, "HTTP parameters");
      var0.setIntParameter("http.socket.timeout", var1);
   }

   public static void setSocketBufferSize(HttpParams var0, int var1) {
      Args.notNull(var0, "HTTP parameters");
      var0.setIntParameter("http.socket.buffer-size", var1);
   }

   public static void setTcpNoDelay(HttpParams var0, boolean var1) {
      Args.notNull(var0, "HTTP parameters");
      var0.setBooleanParameter("http.tcp.nodelay", var1);
   }
}
