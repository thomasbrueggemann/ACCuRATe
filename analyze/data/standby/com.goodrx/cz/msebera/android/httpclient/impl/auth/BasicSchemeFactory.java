package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthSchemeFactory;
import cz.msebera.android.httpclient.auth.AuthSchemeProvider;
import cz.msebera.android.httpclient.impl.auth.BasicScheme;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.nio.charset.Charset;

public class BasicSchemeFactory implements AuthSchemeFactory, AuthSchemeProvider {
   private final Charset charset;

   public BasicSchemeFactory() {
      this((Charset)null);
   }

   public BasicSchemeFactory(Charset var1) {
      this.charset = var1;
   }

   public AuthScheme create(HttpContext var1) {
      return new BasicScheme(this.charset);
   }

   public AuthScheme newInstance(HttpParams var1) {
      return new BasicScheme();
   }
}
