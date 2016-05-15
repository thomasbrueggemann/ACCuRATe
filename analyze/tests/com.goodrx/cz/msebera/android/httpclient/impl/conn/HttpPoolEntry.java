package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.RouteTracker;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.pool.PoolEntry;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Deprecated
class HttpPoolEntry extends PoolEntry<HttpRoute, OperatedClientConnection> {
   public HttpClientAndroidLog log;
   private final RouteTracker tracker;

   public HttpPoolEntry(HttpClientAndroidLog var1, String var2, HttpRoute var3, OperatedClientConnection var4, long var5, TimeUnit var7) {
      super(var2, var3, var4, var5, var7);
      this.log = var1;
      this.tracker = new RouteTracker(var3);
   }

   public void close() {
      OperatedClientConnection var1 = (OperatedClientConnection)this.getConnection();

      try {
         var1.close();
      } catch (IOException var3) {
         this.log.debug("I/O error closing connection", var3);
      }
   }

   HttpRoute getEffectiveRoute() {
      return this.tracker.toRoute();
   }

   HttpRoute getPlannedRoute() {
      return (HttpRoute)this.getRoute();
   }

   RouteTracker getTracker() {
      return this.tracker;
   }

   public boolean isClosed() {
      return !((OperatedClientConnection)this.getConnection()).isOpen();
   }

   public boolean isExpired(long var1) {
      boolean var3 = super.isExpired(var1);
      if(var3 && this.log.isDebugEnabled()) {
         this.log.debug("Connection " + this + " expired @ " + new Date(this.getExpiry()));
      }

      return var3;
   }
}
