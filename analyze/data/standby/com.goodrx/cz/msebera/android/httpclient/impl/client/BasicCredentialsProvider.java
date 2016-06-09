package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.auth.AuthScope;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.client.CredentialsProvider;
import cz.msebera.android.httpclient.util.Args;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BasicCredentialsProvider implements CredentialsProvider {
   private final ConcurrentHashMap<AuthScope, Credentials> credMap = new ConcurrentHashMap();

   private static Credentials matchCredentials(Map<AuthScope, Credentials> var0, AuthScope var1) {
      Credentials var2 = (Credentials)var0.get(var1);
      if(var2 == null) {
         int var3 = -1;
         AuthScope var4 = null;
         Iterator var5 = var0.keySet().iterator();

         while(var5.hasNext()) {
            AuthScope var6 = (AuthScope)var5.next();
            int var7 = var1.match(var6);
            if(var7 > var3) {
               var3 = var7;
               var4 = var6;
            }
         }

         if(var4 != null) {
            var2 = (Credentials)var0.get(var4);
         }
      }

      return var2;
   }

   public Credentials getCredentials(AuthScope var1) {
      Args.notNull(var1, "Authentication scope");
      return matchCredentials(this.credMap, var1);
   }

   public String toString() {
      return this.credMap.toString();
   }
}
