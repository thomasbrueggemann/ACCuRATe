package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.ProtocolException;
import cz.msebera.android.httpclient.client.CircularRedirectException;
import cz.msebera.android.httpclient.client.RedirectStrategy;
import cz.msebera.android.httpclient.client.config.RequestConfig;
import cz.msebera.android.httpclient.client.methods.HttpGet;
import cz.msebera.android.httpclient.client.methods.HttpHead;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.client.methods.RequestBuilder;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.client.utils.URIUtils;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.client.RedirectLocations;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.net.URI;
import java.net.URISyntaxException;

public class DefaultRedirectStrategy implements RedirectStrategy {
   public static final DefaultRedirectStrategy INSTANCE = new DefaultRedirectStrategy();
   private static final String[] REDIRECT_METHODS = new String[]{"GET", "HEAD"};
   public HttpClientAndroidLog log = new HttpClientAndroidLog(this.getClass());

   protected URI createLocationURI(String param1) throws ProtocolException {
      // $FF: Couldn't be decompiled
   }

   public URI getLocationURI(HttpRequest var1, HttpResponse var2, HttpContext var3) throws ProtocolException {
      Args.notNull(var1, "HTTP request");
      Args.notNull(var2, "HTTP response");
      Args.notNull(var3, "HTTP context");
      HttpClientContext var7 = HttpClientContext.adapt(var3);
      Header var8 = var2.getFirstHeader("location");
      if(var8 == null) {
         throw new ProtocolException("Received redirect response " + var2.getStatusLine() + " but no location header");
      } else {
         String var9 = var8.getValue();
         if(this.log.isDebugEnabled()) {
            this.log.debug("Redirect requested to location \'" + var9 + "\'");
         }

         RequestConfig var10 = var7.getRequestConfig();
         URI var11 = this.createLocationURI(var9);

         label38: {
            URI var15;
            try {
               if(var11.isAbsolute()) {
                  break label38;
               }

               if(!var10.isRelativeRedirectsAllowed()) {
                  throw new ProtocolException("Relative redirect location \'" + var11 + "\' not allowed");
               }

               HttpHost var14 = var7.getTargetHost();
               Asserts.notNull(var14, "Target host");
               var15 = URIUtils.resolve(URIUtils.rewriteURI(new URI(var1.getRequestLine().getUri()), var14, false), var11);
            } catch (URISyntaxException var16) {
               throw new ProtocolException(var16.getMessage(), var16);
            }

            var11 = var15;
         }

         RedirectLocations var13 = (RedirectLocations)var7.getAttribute("http.protocol.redirect-locations");
         if(var13 == null) {
            var13 = new RedirectLocations();
            var3.setAttribute("http.protocol.redirect-locations", var13);
         }

         if(!var10.isCircularRedirectsAllowed() && var13.contains(var11)) {
            throw new CircularRedirectException("Circular redirect to \'" + var11 + "\'");
         } else {
            var13.add(var11);
            return var11;
         }
      }
   }

   public HttpUriRequest getRedirect(HttpRequest var1, HttpResponse var2, HttpContext var3) throws ProtocolException {
      URI var4 = this.getLocationURI(var1, var2, var3);
      String var5 = var1.getRequestLine().getMethod();
      return (HttpUriRequest)(var5.equalsIgnoreCase("HEAD")?new HttpHead(var4):(var5.equalsIgnoreCase("GET")?new HttpGet(var4):(var2.getStatusLine().getStatusCode() == 307?RequestBuilder.copy(var1).setUri(var4).build():new HttpGet(var4))));
   }

   protected boolean isRedirectable(String var1) {
      String[] var2 = REDIRECT_METHODS;
      int var3 = var2.length;
      int var4 = 0;

      boolean var5;
      while(true) {
         var5 = false;
         if(var4 >= var3) {
            break;
         }

         if(var2[var4].equalsIgnoreCase(var1)) {
            var5 = true;
            break;
         }

         ++var4;
      }

      return var5;
   }

   public boolean isRedirected(HttpRequest var1, HttpResponse var2, HttpContext var3) throws ProtocolException {
      boolean var4 = true;
      Args.notNull(var1, "HTTP request");
      Args.notNull(var2, "HTTP response");
      int var7 = var2.getStatusLine().getStatusCode();
      String var8 = var1.getRequestLine().getMethod();
      Header var9 = var2.getFirstHeader("location");
      switch(var7) {
      case 301:
      case 307:
         return this.isRedirectable(var8);
      case 302:
         if(!this.isRedirectable(var8) || var9 == null) {
            return false;
         }
      case 303:
         break;
      case 304:
      case 305:
      case 306:
      default:
         var4 = false;
      }

      return var4;
   }
}
