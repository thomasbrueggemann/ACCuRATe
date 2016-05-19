package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseFactory;
import cz.msebera.android.httpclient.ReasonPhraseCatalog;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.impl.EnglishReasonPhraseCatalog;
import cz.msebera.android.httpclient.message.BasicHttpResponse;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.util.Locale;

public class DefaultHttpResponseFactory implements HttpResponseFactory {
   public static final DefaultHttpResponseFactory INSTANCE = new DefaultHttpResponseFactory();
   protected final ReasonPhraseCatalog reasonCatalog;

   public DefaultHttpResponseFactory() {
      this(EnglishReasonPhraseCatalog.INSTANCE);
   }

   public DefaultHttpResponseFactory(ReasonPhraseCatalog var1) {
      this.reasonCatalog = (ReasonPhraseCatalog)Args.notNull(var1, "Reason phrase catalog");
   }

   protected Locale determineLocale(HttpContext var1) {
      return Locale.getDefault();
   }

   public HttpResponse newHttpResponse(StatusLine var1, HttpContext var2) {
      Args.notNull(var1, "Status line");
      return new BasicHttpResponse(var1, this.reasonCatalog, this.determineLocale(var2));
   }
}
