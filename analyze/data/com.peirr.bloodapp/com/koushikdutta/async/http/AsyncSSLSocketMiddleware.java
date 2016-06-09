package com.koushikdutta.async.http;

import com.koushikdutta.async.AsyncSSLSocketWrapper;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.callback.ConnectCallback;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.AsyncSocketMiddleware;
import java.net.URI;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class AsyncSSLSocketMiddleware extends AsyncSocketMiddleware {
   HostnameVerifier hostnameVerifier;
   SSLContext sslContext;
   TrustManager[] trustManagers;

   public AsyncSSLSocketMiddleware(AsyncHttpClient var1) {
      super(var1, "https", 443);
   }

   public void setHostnameVerifier(HostnameVerifier var1) {
      this.hostnameVerifier = var1;
   }

   public void setSSLContext(SSLContext var1) {
      this.sslContext = var1;
   }

   public void setTrustManagers(TrustManager[] var1) {
      this.trustManagers = var1;
   }

   protected ConnectCallback wrapCallback(final ConnectCallback var1, final URI var2, final int var3) {
      return new ConnectCallback() {
         public void onConnectCompleted(Exception var1x, AsyncSocket var2x) {
            if(var1x == null) {
               var1.onConnectCompleted(var1x, new AsyncSSLSocketWrapper(var2x, var2.getHost(), var3, AsyncSSLSocketMiddleware.this.sslContext, AsyncSSLSocketMiddleware.this.trustManagers, AsyncSSLSocketMiddleware.this.hostnameVerifier, true));
            } else {
               var1.onConnectCompleted(var1x, var2x);
            }
         }
      };
   }
}
