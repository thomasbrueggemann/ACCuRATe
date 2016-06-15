package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.RouteDatabase;
import com.squareup.okhttp.internal.Dns;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.net.Proxy.Type;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public final class RouteSelector {
   private static final int TLS_MODE_COMPATIBLE = 0;
   private static final int TLS_MODE_MODERN = 1;
   private static final int TLS_MODE_NULL = -1;
   private final Address address;
   private final Dns dns;
   private boolean hasNextProxy;
   private InetSocketAddress lastInetSocketAddress;
   private Proxy lastProxy;
   private int nextSocketAddressIndex;
   private int nextTlsMode = -1;
   private final ConnectionPool pool;
   private final List<Route> postponedRoutes;
   private final ProxySelector proxySelector;
   private Iterator<Proxy> proxySelectorProxies;
   private final RouteDatabase routeDatabase;
   private InetAddress[] socketAddresses;
   private int socketPort;
   private final URI uri;
   private Proxy userSpecifiedProxy;

   public RouteSelector(Address var1, URI var2, ProxySelector var3, ConnectionPool var4, Dns var5, RouteDatabase var6) {
      this.address = var1;
      this.uri = var2;
      this.proxySelector = var3;
      this.pool = var4;
      this.dns = var5;
      this.routeDatabase = var6;
      this.postponedRoutes = new LinkedList();
      this.resetNextProxy(var2, var1.getProxy());
   }

   private boolean hasNextInetSocketAddress() {
      return this.socketAddresses != null;
   }

   private boolean hasNextPostponed() {
      return !this.postponedRoutes.isEmpty();
   }

   private boolean hasNextProxy() {
      return this.hasNextProxy;
   }

   private boolean hasNextTlsMode() {
      return this.nextTlsMode != -1;
   }

   private InetSocketAddress nextInetSocketAddress() throws UnknownHostException {
      InetAddress[] var1 = this.socketAddresses;
      int var2 = this.nextSocketAddressIndex;
      this.nextSocketAddressIndex = var2 + 1;
      InetSocketAddress var3 = new InetSocketAddress(var1[var2], this.socketPort);
      if(this.nextSocketAddressIndex == this.socketAddresses.length) {
         this.socketAddresses = null;
         this.nextSocketAddressIndex = 0;
      }

      return var3;
   }

   private Route nextPostponed() {
      return (Route)this.postponedRoutes.remove(0);
   }

   private Proxy nextProxy() {
      if(this.userSpecifiedProxy != null) {
         this.hasNextProxy = false;
         return this.userSpecifiedProxy;
      } else {
         if(this.proxySelectorProxies != null) {
            while(this.proxySelectorProxies.hasNext()) {
               Proxy var1 = (Proxy)this.proxySelectorProxies.next();
               if(var1.type() != Type.DIRECT) {
                  return var1;
               }
            }
         }

         this.hasNextProxy = false;
         return Proxy.NO_PROXY;
      }
   }

   private int nextTlsMode() {
      if(this.nextTlsMode == 1) {
         this.nextTlsMode = 0;
         return 1;
      } else if(this.nextTlsMode == 0) {
         this.nextTlsMode = -1;
         return 0;
      } else {
         throw new AssertionError();
      }
   }

   private void resetNextInetSocketAddress(Proxy var1) throws UnknownHostException {
      this.socketAddresses = null;
      String var4;
      if(var1.type() == Type.DIRECT) {
         var4 = this.uri.getHost();
         this.socketPort = Util.getEffectivePort(this.uri);
      } else {
         SocketAddress var2 = var1.address();
         if(!(var2 instanceof InetSocketAddress)) {
            throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + var2.getClass());
         }

         InetSocketAddress var3 = (InetSocketAddress)var2;
         var4 = var3.getHostName();
         this.socketPort = var3.getPort();
      }

      this.socketAddresses = this.dns.getAllByName(var4);
      this.nextSocketAddressIndex = 0;
   }

   private void resetNextProxy(URI var1, Proxy var2) {
      this.hasNextProxy = true;
      if(var2 != null) {
         this.userSpecifiedProxy = var2;
      } else {
         List var3 = this.proxySelector.select(var1);
         if(var3 != null) {
            this.proxySelectorProxies = var3.iterator();
            return;
         }
      }

   }

   private void resetNextTlsMode() {
      byte var1;
      if(this.address.getSslSocketFactory() != null) {
         var1 = 1;
      } else {
         var1 = 0;
      }

      this.nextTlsMode = var1;
   }

   public void connectFailed(Connection var1, IOException var2) {
      Route var3 = var1.getRoute();
      if(var3.getProxy().type() != Type.DIRECT && this.proxySelector != null) {
         this.proxySelector.connectFailed(this.uri, var3.getProxy().address(), var2);
      }

      this.routeDatabase.failed(var3, var2);
   }

   public boolean hasNext() {
      return this.hasNextTlsMode() || this.hasNextInetSocketAddress() || this.hasNextProxy() || this.hasNextPostponed();
   }

   public Connection next(String var1) throws IOException {
      byte var2 = 1;

      while(true) {
         Connection var3 = this.pool.get(this.address);
         if(var3 == null) {
            if(!this.hasNextTlsMode()) {
               if(!this.hasNextInetSocketAddress()) {
                  if(!this.hasNextProxy()) {
                     if(!this.hasNextPostponed()) {
                        throw new NoSuchElementException();
                     }

                     return new Connection(this.nextPostponed());
                  }

                  this.lastProxy = this.nextProxy();
                  this.resetNextInetSocketAddress(this.lastProxy);
               }

               this.lastInetSocketAddress = this.nextInetSocketAddress();
               this.resetNextTlsMode();
            }

            if(this.nextTlsMode() != var2) {
               var2 = 0;
            }

            Route var4 = new Route(this.address, this.lastProxy, this.lastInetSocketAddress, (boolean)var2);
            if(this.routeDatabase.shouldPostpone(var4)) {
               this.postponedRoutes.add(var4);
               return this.next(var1);
            }

            return new Connection(var4);
         }

         if(var1.equals("GET") || var3.isReadable()) {
            return var3;
         }

         var3.close();
      }
   }
}
