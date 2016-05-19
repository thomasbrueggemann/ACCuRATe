package cz.msebera.android.httpclient.impl.conn.tsccm;

import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.ConnectionPoolTimeoutException;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.conn.params.ConnManagerParams;
import cz.msebera.android.httpclient.conn.params.ConnPerRoute;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.conn.tsccm.AbstractConnPool;
import cz.msebera.android.httpclient.impl.conn.tsccm.BasicPoolEntry;
import cz.msebera.android.httpclient.impl.conn.tsccm.PoolEntryRequest;
import cz.msebera.android.httpclient.impl.conn.tsccm.RouteSpecificPool;
import cz.msebera.android.httpclient.impl.conn.tsccm.WaitingThread;
import cz.msebera.android.httpclient.impl.conn.tsccm.WaitingThreadAborter;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.util.Args;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

@Deprecated
public class ConnPoolByRoute extends AbstractConnPool {
   protected final ConnPerRoute connPerRoute;
   private final long connTTL;
   private final TimeUnit connTTLTimeUnit;
   protected final Queue<BasicPoolEntry> freeConnections;
   protected final Set<BasicPoolEntry> leasedConnections;
   public HttpClientAndroidLog log;
   protected volatile int maxTotalConnections;
   protected volatile int numConnections;
   protected final ClientConnectionOperator operator;
   private final Lock poolLock;
   protected final Map<HttpRoute, RouteSpecificPool> routeToPool;
   protected volatile boolean shutdown;
   protected final Queue<WaitingThread> waitingThreads;

   public ConnPoolByRoute(ClientConnectionOperator var1, ConnPerRoute var2, int var3) {
      this(var1, var2, var3, -1L, TimeUnit.MILLISECONDS);
   }

   public ConnPoolByRoute(ClientConnectionOperator var1, ConnPerRoute var2, int var3, long var4, TimeUnit var6) {
      this.log = new HttpClientAndroidLog(this.getClass());
      Args.notNull(var1, "Connection operator");
      Args.notNull(var2, "Connections per route");
      this.poolLock = super.poolLock;
      this.leasedConnections = super.leasedConnections;
      this.operator = var1;
      this.connPerRoute = var2;
      this.maxTotalConnections = var3;
      this.freeConnections = this.createFreeConnQueue();
      this.waitingThreads = this.createWaitingThreadQueue();
      this.routeToPool = this.createRouteToPoolMap();
      this.connTTL = var4;
      this.connTTLTimeUnit = var6;
   }

   @Deprecated
   public ConnPoolByRoute(ClientConnectionOperator var1, HttpParams var2) {
      this(var1, ConnManagerParams.getMaxConnectionsPerRoute(var2), ConnManagerParams.getMaxTotalConnections(var2));
   }

   private void closeConnection(BasicPoolEntry var1) {
      OperatedClientConnection var2 = var1.getConnection();
      if(var2 != null) {
         try {
            var2.close();
         } catch (IOException var4) {
            this.log.debug("I/O error closing connection", var4);
            return;
         }
      }

   }

   protected BasicPoolEntry createEntry(RouteSpecificPool var1, ClientConnectionOperator var2) {
      if(this.log.isDebugEnabled()) {
         this.log.debug("Creating new connection [" + var1.getRoute() + "]");
      }

      BasicPoolEntry var3 = new BasicPoolEntry(var2, var1.getRoute(), this.connTTL, this.connTTLTimeUnit);
      this.poolLock.lock();

      try {
         var1.createdEntry(var3);
         ++this.numConnections;
         this.leasedConnections.add(var3);
      } finally {
         this.poolLock.unlock();
      }

      return var3;
   }

   protected Queue<BasicPoolEntry> createFreeConnQueue() {
      return new LinkedList();
   }

   protected Map<HttpRoute, RouteSpecificPool> createRouteToPoolMap() {
      return new HashMap();
   }

   protected Queue<WaitingThread> createWaitingThreadQueue() {
      return new LinkedList();
   }

   protected void deleteEntry(BasicPoolEntry var1) {
      HttpRoute var2 = var1.getPlannedRoute();
      if(this.log.isDebugEnabled()) {
         this.log.debug("Deleting connection [" + var2 + "][" + var1.getState() + "]");
      }

      this.poolLock.lock();

      try {
         this.closeConnection(var1);
         RouteSpecificPool var4 = this.getRoutePool(var2, true);
         var4.deleteEntry(var1);
         this.numConnections += -1;
         if(var4.isUnused()) {
            this.routeToPool.remove(var2);
         }
      } finally {
         this.poolLock.unlock();
      }

   }

   protected void deleteLeastUsedEntry() {
      // $FF: Couldn't be decompiled
   }

   public void freeEntry(BasicPoolEntry param1, boolean param2, long param3, TimeUnit param5) {
      // $FF: Couldn't be decompiled
   }

   protected BasicPoolEntry getEntryBlocking(HttpRoute param1, Object param2, long param3, TimeUnit param5, WaitingThreadAborter param6) throws ConnectionPoolTimeoutException, InterruptedException {
      // $FF: Couldn't be decompiled
   }

   protected BasicPoolEntry getFreeEntry(RouteSpecificPool param1, Object param2) {
      // $FF: Couldn't be decompiled
   }

   protected RouteSpecificPool getRoutePool(HttpRoute param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   protected RouteSpecificPool newRouteSpecificPool(HttpRoute var1) {
      return new RouteSpecificPool(var1, this.connPerRoute);
   }

   protected WaitingThread newWaitingThread(Condition var1, RouteSpecificPool var2) {
      return new WaitingThread(var1, var2);
   }

   protected void notifyWaitingThread(RouteSpecificPool param1) {
      // $FF: Couldn't be decompiled
   }

   public PoolEntryRequest requestPoolEntry(final HttpRoute var1, final Object var2) {
      return new PoolEntryRequest() {
         // $FF: synthetic field
         final WaitingThreadAborter val$aborter;

         {
            this.val$aborter = var2x;
         }

         public BasicPoolEntry getPoolEntry(long var1x, TimeUnit var3) throws InterruptedException, ConnectionPoolTimeoutException {
            return ConnPoolByRoute.this.getEntryBlocking(var1, var2, var1x, var3, this.val$aborter);
         }
      };
   }

   public void shutdown() {
      // $FF: Couldn't be decompiled
   }
}
