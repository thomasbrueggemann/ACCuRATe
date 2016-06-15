package com.squareup.okhttp.internal;

import java.net.InetAddress;
import java.net.UnknownHostException;

public interface Dns {
   Dns DEFAULT = new Dns() {
      public InetAddress[] getAllByName(String var1) throws UnknownHostException {
         return InetAddress.getAllByName(var1);
      }
   };

   InetAddress[] getAllByName(String var1) throws UnknownHostException;
}
