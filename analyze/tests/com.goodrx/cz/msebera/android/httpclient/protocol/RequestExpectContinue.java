package cz.msebera.android.httpclient.protocol;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpVersion;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;

public class RequestExpectContinue implements HttpRequestInterceptor {
   private final boolean activeByDefault;

   @Deprecated
   public RequestExpectContinue() {
      this(false);
   }

   public RequestExpectContinue(boolean var1) {
      this.activeByDefault = var1;
   }

   public void process(HttpRequest var1, HttpContext var2) throws HttpException, IOException {
      Args.notNull(var1, "HTTP request");
      if(!var1.containsHeader("Expect") && var1 instanceof HttpEntityEnclosingRequest) {
         ProtocolVersion var4 = var1.getRequestLine().getProtocolVersion();
         HttpEntity var5 = ((HttpEntityEnclosingRequest)var1).getEntity();
         if(var5 != null && var5.getContentLength() != 0L && !var4.lessEquals(HttpVersion.HTTP_1_0) && var1.getParams().getBooleanParameter("http.protocol.expect-continue", this.activeByDefault)) {
            var1.addHeader("Expect", "100-continue");
         }
      }

   }
}
