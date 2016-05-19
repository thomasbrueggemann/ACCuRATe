package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpClientConnection;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.ClientConnectionRequest;
import cz.msebera.android.httpclient.conn.ManagedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.conn.DefaultClientConnectionOperator;
import cz.msebera.android.httpclient.impl.conn.HttpPoolEntry;
import cz.msebera.android.httpclient.impl.conn.ManagedClientConnectionImpl;
import cz.msebera.android.httpclient.impl.conn.SchemeRegistryFactory;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Deprecated
public class BasicClientConnectionManager implements ClientConnectionManager {
   private static final AtomicLong COUNTER = new AtomicLong();
   private ManagedClientConnectionImpl conn;
   private final ClientConnectionOperator connOperator;
   public HttpClientAndroidLog log;
   private HttpPoolEntry poolEntry;
   private final SchemeRegistry schemeRegistry;
   private volatile boolean shutdown;

   public BasicClientConnectionManager() {
      this(SchemeRegistryFactory.createDefault());
   }

   public BasicClientConnectionManager(SchemeRegistry var1) {
      this.log = new HttpClientAndroidLog(this.getClass());
      Args.notNull(var1, "Scheme registry");
      this.schemeRegistry = var1;
      this.connOperator = this.createConnectionOperator(var1);
   }

   private void assertNotShutdown() {
      boolean var1;
      if(!this.shutdown) {
         var1 = true;
      } else {
         var1 = false;
      }

      Asserts.check(var1, "Connection manager has been shut down");
   }

   private void shutdownConnection(HttpClientConnection var1) {
      try {
         var1.shutdown();
      } catch (IOException var3) {
         if(this.log.isDebugEnabled()) {
            this.log.debug("I/O exception shutting down connection", var3);
            return;
         }
      }

   }

   protected ClientConnectionOperator createConnectionOperator(SchemeRegistry var1) {
      return new DefaultClientConnectionOperator(var1);
   }

   protected void finalize() throws Throwable {
      try {
         this.shutdown();
      } finally {
         super.finalize();
      }

   }

   ManagedClientConnection getConnection(HttpRoute param1, Object param2) {
      // $FF: Couldn't be decompiled
   }

   public SchemeRegistry getSchemeRegistry() {
      return this.schemeRegistry;
   }

   public void releaseConnection(ManagedClientConnection param1, long param2, TimeUnit param4) {
      // $FF: Couldn't be decompiled
   }

   public final ClientConnectionRequest requestConnection(final HttpRoute var1, final Object var2) {
      return new ClientConnectionRequest() {
         public ManagedClientConnection getConnection(long var1x, TimeUnit var3) {
            return BasicClientConnectionManager.this.getConnection(var1, var2);
         }
      };
   }

   public void shutdown() {
      // $FF: Couldn't be decompiled
   }
}
