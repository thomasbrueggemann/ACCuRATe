package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.conn.ConnectionKeepAliveStrategy;
import cz.msebera.android.httpclient.message.BasicHeaderElementIterator;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;

public class DefaultConnectionKeepAliveStrategy implements ConnectionKeepAliveStrategy {
   public static final DefaultConnectionKeepAliveStrategy INSTANCE = new DefaultConnectionKeepAliveStrategy();

   public long getKeepAliveDuration(HttpResponse var1, HttpContext var2) {
      Args.notNull(var1, "HTTP response");
      BasicHeaderElementIterator var4 = new BasicHeaderElementIterator(var1.headerIterator("Keep-Alive"));

      while(true) {
         String var6;
         String var7;
         do {
            do {
               if(!var4.hasNext()) {
                  return -1L;
               }

               HeaderElement var5 = var4.nextElement();
               var6 = var5.getName();
               var7 = var5.getValue();
            } while(var7 == null);
         } while(!var6.equalsIgnoreCase("timeout"));

         try {
            long var9 = Long.parseLong(var7);
            return var9 * 1000L;
         } catch (NumberFormatException var11) {
            ;
         }
      }
   }
}
