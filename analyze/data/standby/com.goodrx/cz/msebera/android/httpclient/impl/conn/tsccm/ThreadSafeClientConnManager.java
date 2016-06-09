package cz.msebera.android.httpclient.impl.conn.tsccm;

import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.ClientConnectionRequest;
import cz.msebera.android.httpclient.conn.ConnectionPoolTimeoutException;
import cz.msebera.android.httpclient.conn.ManagedClientConnection;
import cz.msebera.android.httpclient.conn.params.ConnPerRouteBean;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.conn.DefaultClientConnectionOperator;
import cz.msebera.android.httpclient.impl.conn.SchemeRegistryFactory;
import cz.msebera.android.httpclient.impl.conn.tsccm.AbstractConnPool;
import cz.msebera.android.httpclient.impl.conn.tsccm.BasicPoolEntry;
import cz.msebera.android.httpclient.impl.conn.tsccm.BasicPooledConnAdapter;
import cz.msebera.android.httpclient.impl.conn.tsccm.ConnPoolByRoute;
import cz.msebera.android.httpclient.impl.conn.tsccm.PoolEntryRequest;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import java.util.concurrent.TimeUnit;

@Deprecated
public class ThreadSafeClientConnManager implements ClientConnectionManager {
   protected final ClientConnectionOperator connOperator;
   protected final ConnPerRouteBean connPerRoute;
   protected final AbstractConnPool connectionPool;
   public HttpClientAndroidLog log;
   protected final ConnPoolByRoute pool;
   protected final SchemeRegistry schemeRegistry;

   public ThreadSafeClientConnManager() {
      this(SchemeRegistryFactory.createDefault());
   }

   public ThreadSafeClientConnManager(SchemeRegistry var1) {
      this(var1, -1L, TimeUnit.MILLISECONDS);
   }

   public ThreadSafeClientConnManager(SchemeRegistry var1, long var2, TimeUnit var4) {
      this(var1, var2, var4, new ConnPerRouteBean());
   }

   public ThreadSafeClientConnManager(SchemeRegistry var1, long var2, TimeUnit var4, ConnPerRouteBean var5) {
      Args.notNull(var1, "Scheme registry");
      this.log = new HttpClientAndroidLog(this.getClass());
      this.schemeRegistry = var1;
      this.connPerRoute = var5;
      this.connOperator = this.createConnectionOperator(var1);
      this.pool = this.createConnectionPool(var2, var4);
      this.connectionPool = this.pool;
   }

   @Deprecated
   public ThreadSafeClientConnManager(HttpParams var1, SchemeRegistry var2) {
      Args.notNull(var2, "Scheme registry");
      this.log = new HttpClientAndroidLog(this.getClass());
      this.schemeRegistry = var2;
      this.connPerRoute = new ConnPerRouteBean();
      this.connOperator = this.createConnectionOperator(var2);
      this.pool = (ConnPoolByRoute)this.createConnectionPool(var1);
      this.connectionPool = this.pool;
   }

   protected ClientConnectionOperator createConnectionOperator(SchemeRegistry var1) {
      return new DefaultClientConnectionOperator(var1);
   }

   @Deprecated
   protected AbstractConnPool createConnectionPool(HttpParams var1) {
      return new ConnPoolByRoute(this.connOperator, var1);
   }

   protected ConnPoolByRoute createConnectionPool(long var1, TimeUnit var3) {
      return new ConnPoolByRoute(this.connOperator, this.connPerRoute, 20, var1, var3);
   }

   protected void finalize() throws Throwable {
      try {
         this.shutdown();
      } finally {
         super.finalize();
      }

   }

   public SchemeRegistry getSchemeRegistry() {
      return this.schemeRegistry;
   }

   public void releaseConnection(ManagedClientConnection param1, long param2, TimeUnit param4) {
      // $FF: Couldn't be decompiled
   }

   public ClientConnectionRequest requestConnection(final HttpRoute var1, Object var2) {
      return new ClientConnectionRequest() {
         // $FF: synthetic field
         final PoolEntryRequest val$poolRequest;

         {
            this.val$poolRequest = var2;
         }

         public ManagedClientConnection getConnection(long var1x, TimeUnit var3) throws InterruptedException, ConnectionPoolTimeoutException {
            Args.notNull(var1, "Route");
            if(ThreadSafeClientConnManager.this.log.isDebugEnabled()) {
               ThreadSafeClientConnManager.this.log.debug("Get connection: " + var1 + ", timeout = " + var1x);
            }

            BasicPoolEntry var5 = this.val$poolRequest.getPoolEntry(var1x, var3);
            return new BasicPooledConnAdapter(ThreadSafeClientConnManager.this, var5);
         }
      };
   }

   public void shutdown() {
      this.log.debug("Shutting down");
      this.pool.shutdown();
   }
}
