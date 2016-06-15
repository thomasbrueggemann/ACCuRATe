package com.squareup.okhttp;

import com.squareup.okhttp.OkAuthenticator;
import com.squareup.okhttp.internal.Util;
import java.net.Proxy;
import java.net.UnknownHostException;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class Address {
   final OkAuthenticator authenticator;
   final HostnameVerifier hostnameVerifier;
   final Proxy proxy;
   final SSLSocketFactory sslSocketFactory;
   final List<String> transports;
   final String uriHost;
   final int uriPort;

   public Address(String var1, int var2, SSLSocketFactory var3, HostnameVerifier var4, OkAuthenticator var5, Proxy var6, List<String> var7) throws UnknownHostException {
      if(var1 == null) {
         throw new NullPointerException("uriHost == null");
      } else if(var2 <= 0) {
         throw new IllegalArgumentException("uriPort <= 0: " + var2);
      } else if(var5 == null) {
         throw new IllegalArgumentException("authenticator == null");
      } else if(var7 == null) {
         throw new IllegalArgumentException("transports == null");
      } else {
         this.proxy = var6;
         this.uriHost = var1;
         this.uriPort = var2;
         this.sslSocketFactory = var3;
         this.hostnameVerifier = var4;
         this.authenticator = var5;
         this.transports = Util.immutableList(var7);
      }
   }

   public boolean equals(Object var1) {
      boolean var2 = var1 instanceof Address;
      boolean var3 = false;
      if(var2) {
         Address var4 = (Address)var1;
         boolean var5 = Util.equal(this.proxy, var4.proxy);
         var3 = false;
         if(var5) {
            boolean var6 = this.uriHost.equals(var4.uriHost);
            var3 = false;
            if(var6) {
               int var7 = this.uriPort;
               int var8 = var4.uriPort;
               var3 = false;
               if(var7 == var8) {
                  boolean var9 = Util.equal(this.sslSocketFactory, var4.sslSocketFactory);
                  var3 = false;
                  if(var9) {
                     boolean var10 = Util.equal(this.hostnameVerifier, var4.hostnameVerifier);
                     var3 = false;
                     if(var10) {
                        boolean var11 = Util.equal(this.authenticator, var4.authenticator);
                        var3 = false;
                        if(var11) {
                           boolean var12 = Util.equal(this.transports, var4.transports);
                           var3 = false;
                           if(var12) {
                              var3 = true;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return var3;
   }

   public OkAuthenticator getAuthenticator() {
      return this.authenticator;
   }

   public HostnameVerifier getHostnameVerifier() {
      return this.hostnameVerifier;
   }

   public Proxy getProxy() {
      return this.proxy;
   }

   public SSLSocketFactory getSslSocketFactory() {
      return this.sslSocketFactory;
   }

   public List<String> getTransports() {
      return this.transports;
   }

   public String getUriHost() {
      return this.uriHost;
   }

   public int getUriPort() {
      return this.uriPort;
   }

   public int hashCode() {
      int var1 = 31 * (31 * (527 + this.uriHost.hashCode()) + this.uriPort);
      int var2;
      if(this.sslSocketFactory != null) {
         var2 = this.sslSocketFactory.hashCode();
      } else {
         var2 = 0;
      }

      int var3 = 31 * (var1 + var2);
      int var4;
      if(this.hostnameVerifier != null) {
         var4 = this.hostnameVerifier.hashCode();
      } else {
         var4 = 0;
      }

      int var5 = 31 * (var3 + var4);
      int var6;
      if(this.authenticator != null) {
         var6 = this.authenticator.hashCode();
      } else {
         var6 = 0;
      }

      int var7 = 31 * (var5 + var6);
      Proxy var8 = this.proxy;
      int var9 = 0;
      if(var8 != null) {
         var9 = this.proxy.hashCode();
      }

      return 31 * (var7 + var9) + this.transports.hashCode();
   }
}
