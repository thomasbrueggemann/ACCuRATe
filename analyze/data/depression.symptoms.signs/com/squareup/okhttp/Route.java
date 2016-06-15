package com.squareup.okhttp;

import com.squareup.okhttp.Address;
import java.net.InetSocketAddress;
import java.net.Proxy;

public class Route {
   final Address address;
   final InetSocketAddress inetSocketAddress;
   final boolean modernTls;
   final Proxy proxy;

   public Route(Address var1, Proxy var2, InetSocketAddress var3, boolean var4) {
      if(var1 == null) {
         throw new NullPointerException("address == null");
      } else if(var2 == null) {
         throw new NullPointerException("proxy == null");
      } else if(var3 == null) {
         throw new NullPointerException("inetSocketAddress == null");
      } else {
         this.address = var1;
         this.proxy = var2;
         this.inetSocketAddress = var3;
         this.modernTls = var4;
      }
   }

   public boolean equals(Object var1) {
      boolean var2 = var1 instanceof Route;
      boolean var3 = false;
      if(var2) {
         Route var4 = (Route)var1;
         boolean var5 = this.address.equals(var4.address);
         var3 = false;
         if(var5) {
            boolean var6 = this.proxy.equals(var4.proxy);
            var3 = false;
            if(var6) {
               boolean var7 = this.inetSocketAddress.equals(var4.inetSocketAddress);
               var3 = false;
               if(var7) {
                  boolean var8 = this.modernTls;
                  boolean var9 = var4.modernTls;
                  var3 = false;
                  if(var8 == var9) {
                     var3 = true;
                  }
               }
            }
         }
      }

      return var3;
   }

   Route flipTlsMode() {
      Address var1 = this.address;
      Proxy var2 = this.proxy;
      InetSocketAddress var3 = this.inetSocketAddress;
      boolean var4;
      if(!this.modernTls) {
         var4 = true;
      } else {
         var4 = false;
      }

      return new Route(var1, var2, var3, var4);
   }

   public Address getAddress() {
      return this.address;
   }

   public Proxy getProxy() {
      return this.proxy;
   }

   public InetSocketAddress getSocketAddress() {
      return this.inetSocketAddress;
   }

   public int hashCode() {
      int var1 = 31 * (31 * (527 + this.address.hashCode()) + this.proxy.hashCode()) + this.inetSocketAddress.hashCode();
      int var2;
      if(this.modernTls) {
         var2 = var1 * 31;
      } else {
         var2 = 0;
      }

      return var1 + var2;
   }

   public boolean isModernTls() {
      return this.modernTls;
   }
}
