package com.parse;

import com.parse.http.ParseHttpResponse;
import com.parse.http.ParseNetworkInterceptor;
import java.io.IOException;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;

class ParseDecompressInterceptor implements ParseNetworkInterceptor {
   private static final String CONTENT_ENCODING_HEADER = "Content-Encoding";
   private static final String CONTENT_LENGTH_HEADER = "Content-Length";
   private static final String GZIP_ENCODING = "gzip";

   public ParseHttpResponse intercept(ParseNetworkInterceptor.Chain var1) throws IOException {
      ParseHttpResponse var2 = var1.proceed(var1.getRequest());
      if("gzip".equalsIgnoreCase(var2.getHeader("Content-Encoding"))) {
         HashMap var3 = new HashMap(var2.getAllHeaders());
         var3.remove("Content-Encoding");
         var3.put("Content-Length", "-1");
         var2 = (new ParseHttpResponse.Builder(var2)).setTotalSize(-1L).setHeaders(var3).setContent(new GZIPInputStream(var2.getContent())).build();
      }

      return var2;
   }
}
