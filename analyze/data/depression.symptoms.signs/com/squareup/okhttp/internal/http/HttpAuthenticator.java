package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.OkAuthenticator;
import com.squareup.okhttp.internal.http.HeaderParser;
import com.squareup.okhttp.internal.http.RawHeaders;
import java.io.IOException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.net.Authenticator.RequestorType;
import java.net.Proxy.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class HttpAuthenticator {
   public static final OkAuthenticator SYSTEM_DEFAULT = new OkAuthenticator() {
      private InetAddress getConnectToInetAddress(Proxy var1, URL var2) throws IOException {
         return var1 != null && var1.type() != Type.DIRECT?((InetSocketAddress)var1.address()).getAddress():InetAddress.getByName(var2.getHost());
      }

      public OkAuthenticator.Credential authenticate(Proxy var1, URL var2, List<OkAuthenticator.Challenge> var3) throws IOException {
         Iterator var4 = var3.iterator();

         while(var4.hasNext()) {
            OkAuthenticator.Challenge var5 = (OkAuthenticator.Challenge)var4.next();
            if("Basic".equalsIgnoreCase(var5.getScheme())) {
               PasswordAuthentication var6 = Authenticator.requestPasswordAuthentication(var2.getHost(), this.getConnectToInetAddress(var1, var2), var2.getPort(), var2.getProtocol(), var5.getRealm(), var5.getScheme(), var2, RequestorType.SERVER);
               if(var6 != null) {
                  return OkAuthenticator.Credential.basic(var6.getUserName(), new String(var6.getPassword()));
               }
            }
         }

         return null;
      }

      public OkAuthenticator.Credential authenticateProxy(Proxy var1, URL var2, List<OkAuthenticator.Challenge> var3) throws IOException {
         Iterator var4 = var3.iterator();

         while(var4.hasNext()) {
            OkAuthenticator.Challenge var5 = (OkAuthenticator.Challenge)var4.next();
            if("Basic".equalsIgnoreCase(var5.getScheme())) {
               InetSocketAddress var6 = (InetSocketAddress)var1.address();
               PasswordAuthentication var7 = Authenticator.requestPasswordAuthentication(var6.getHostName(), this.getConnectToInetAddress(var1, var2), var6.getPort(), var2.getProtocol(), var5.getRealm(), var5.getScheme(), var2, RequestorType.PROXY);
               if(var7 != null) {
                  return OkAuthenticator.Credential.basic(var7.getUserName(), new String(var7.getPassword()));
               }
            }
         }

         return null;
      }
   };

   private static List<OkAuthenticator.Challenge> parseChallenges(RawHeaders var0, String var1) {
      ArrayList var2 = new ArrayList();

      for(int var3 = 0; var3 < var0.length(); ++var3) {
         if(var1.equalsIgnoreCase(var0.getFieldName(var3))) {
            String var4 = var0.getValue(var3);
            int var5 = 0;

            while(var5 < var4.length()) {
               int var7 = HeaderParser.skipUntil(var4, var5, " ");
               String var8 = var4.substring(var5, var7).trim();
               int var9 = HeaderParser.skipWhitespace(var4, var7);
               if(!var4.regionMatches(true, var9, "realm=\"", 0, "realm=\"".length())) {
                  break;
               }

               int var10 = var9 + "realm=\"".length();
               int var11 = HeaderParser.skipUntil(var4, var10, "\"");
               String var12 = var4.substring(var10, var11);
               var5 = HeaderParser.skipWhitespace(var4, 1 + HeaderParser.skipUntil(var4, var11 + 1, ","));
               var2.add(new OkAuthenticator.Challenge(var8, var12));
            }
         }
      }

      return var2;
   }

   public static boolean processAuthHeader(OkAuthenticator var0, int var1, RawHeaders var2, RawHeaders var3, Proxy var4, URL var5) throws IOException {
      String var6;
      String var7;
      if(var1 == 401) {
         var6 = "WWW-Authenticate";
         var7 = "Authorization";
      } else {
         if(var1 != 407) {
            throw new IllegalArgumentException();
         }

         var6 = "Proxy-Authenticate";
         var7 = "Proxy-Authorization";
      }

      List var8 = parseChallenges(var2, var6);
      if(!var8.isEmpty()) {
         OkAuthenticator.Credential var9;
         if(var2.getResponseCode() == 407) {
            var9 = var0.authenticateProxy(var4, var5, var8);
         } else {
            var9 = var0.authenticate(var4, var5, var8);
         }

         if(var9 != null) {
            var3.set(var7, var9.getHeaderValue());
            return true;
         }
      }

      return false;
   }
}
