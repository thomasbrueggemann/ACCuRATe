package cz.msebera.android.httpclient.impl;

import cz.msebera.android.httpclient.ConnectionReuseStrategy;
import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.TokenIterator;
import cz.msebera.android.httpclient.message.BasicTokenIterator;
import cz.msebera.android.httpclient.protocol.HttpContext;

public class DefaultConnectionReuseStrategy implements ConnectionReuseStrategy {
   public static final DefaultConnectionReuseStrategy INSTANCE = new DefaultConnectionReuseStrategy();

   private boolean canResponseHaveBody(HttpResponse var1) {
      int var2 = var1.getStatusLine().getStatusCode();
      return var2 >= 200 && var2 != 204 && var2 != 304 && var2 != 205;
   }

   protected TokenIterator createTokenIterator(HeaderIterator var1) {
      return new BasicTokenIterator(var1);
   }

   public boolean keepAlive(HttpResponse param1, HttpContext param2) {
      // $FF: Couldn't be decompiled
   }
}
