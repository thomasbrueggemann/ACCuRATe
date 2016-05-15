package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.client.HttpRequestRetryHandler;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import cz.msebera.android.httpclient.impl.client.RequestWrapper;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.net.ssl.SSLException;

public class DefaultHttpRequestRetryHandler implements HttpRequestRetryHandler {
   public static final DefaultHttpRequestRetryHandler INSTANCE = new DefaultHttpRequestRetryHandler();
   private final Set<Class<? extends IOException>> nonRetriableClasses;
   private final boolean requestSentRetryEnabled;
   private final int retryCount;

   public DefaultHttpRequestRetryHandler() {
      this(3, false);
   }

   public DefaultHttpRequestRetryHandler(int var1, boolean var2) {
      this(var1, var2, Arrays.asList(new Class[]{InterruptedIOException.class, UnknownHostException.class, ConnectException.class, SSLException.class}));
   }

   protected DefaultHttpRequestRetryHandler(int var1, boolean var2, Collection<Class<? extends IOException>> var3) {
      this.retryCount = var1;
      this.requestSentRetryEnabled = var2;
      this.nonRetriableClasses = new HashSet();
      Iterator var4 = var3.iterator();

      while(var4.hasNext()) {
         Class var5 = (Class)var4.next();
         this.nonRetriableClasses.add(var5);
      }

   }

   protected boolean handleAsIdempotent(HttpRequest var1) {
      return !(var1 instanceof HttpEntityEnclosingRequest);
   }

   @Deprecated
   protected boolean requestIsAborted(HttpRequest var1) {
      HttpRequest var2 = var1;
      if(var1 instanceof RequestWrapper) {
         var2 = ((RequestWrapper)var1).getOriginal();
      }

      return var2 instanceof HttpUriRequest && ((HttpUriRequest)var2).isAborted();
   }

   public boolean retryRequest(IOException var1, int var2, HttpContext var3) {
      Args.notNull(var1, "Exception parameter");
      Args.notNull(var3, "HTTP context");
      if(var2 <= this.retryCount && !this.nonRetriableClasses.contains(var1.getClass())) {
         Iterator var6 = this.nonRetriableClasses.iterator();

         while(var6.hasNext()) {
            if(((Class)var6.next()).isInstance(var1)) {
               return false;
            }
         }

         HttpClientContext var7 = HttpClientContext.adapt(var3);
         HttpRequest var8 = var7.getRequest();
         if(!this.requestIsAborted(var8)) {
            if(this.handleAsIdempotent(var8)) {
               return true;
            }

            if(!var7.isRequestSent() || this.requestSentRetryEnabled) {
               return true;
            }
         }
      }

      return false;
   }
}
