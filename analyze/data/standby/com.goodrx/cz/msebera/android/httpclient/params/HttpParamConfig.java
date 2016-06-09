package cz.msebera.android.httpclient.params;

import cz.msebera.android.httpclient.config.MessageConstraints;
import cz.msebera.android.httpclient.params.HttpParams;

@Deprecated
public final class HttpParamConfig {
   public static MessageConstraints getMessageConstraints(HttpParams var0) {
      return MessageConstraints.custom().setMaxHeaderCount(var0.getIntParameter("http.connection.max-header-count", -1)).setMaxLineLength(var0.getIntParameter("http.connection.max-line-length", -1)).build();
   }
}
