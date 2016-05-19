package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.client.RedirectHandler;
import cz.msebera.android.httpclient.client.RedirectStrategy;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.client.methods.HttpHead;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.net.URI;

@Deprecated
class DefaultRedirectStrategyAdaptor implements RedirectStrategy {
   private final RedirectHandler handler;

   public RedirectHandler getHandler() {
      return this.handler;
   }

   public HttpUriRequest getRedirect(HttpRequest var1, HttpResponse var2, HttpContext var3) throws ProtocolException {
      URI var4 = this.handler.getLocationURI(var2, var3);
      return (HttpUriRequest)(var1.getRequestLine().getMethod().equalsIgnoreCase("HEAD")?new HttpHead(var4):new HttpGet(var4));
   }

   public boolean isRedirected(HttpRequest var1, HttpResponse var2, HttpContext var3) throws ProtocolException {
      return this.handler.isRedirectRequested(var2, var3);
   }
}
