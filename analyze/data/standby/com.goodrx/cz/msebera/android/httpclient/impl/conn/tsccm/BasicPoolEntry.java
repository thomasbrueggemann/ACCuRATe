package cz.msebera.android.httpclient.impl.conn.tsccm;

import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.impl.conn.AbstractPoolEntry;
import cz.msebera.android.httpclient.util.Args;
import java.util.concurrent.TimeUnit;

@Deprecated
public class BasicPoolEntry extends AbstractPoolEntry {
   private final long created;
   private long expiry;
   private long updated;
   private final long validUntil;

   public BasicPoolEntry(ClientConnectionOperator var1, HttpRoute var2, long var3, TimeUnit var5) {
      super(var1, var2);
      Args.notNull(var2, "HTTP route");
      this.created = System.currentTimeMillis();
      if(var3 > 0L) {
         this.validUntil = this.created + var5.toMillis(var3);
      } else {
         this.validUntil = Long.MAX_VALUE;
      }

      this.expiry = this.validUntil;
   }

   protected final OperatedClientConnection getConnection() {
      return super.connection;
   }

   protected final HttpRoute getPlannedRoute() {
      return super.route;
   }

   public boolean isExpired(long var1) {
      return var1 >= this.expiry;
   }

   protected void shutdownEntry() {
      super.shutdownEntry();
   }

   public void updateExpiry(long var1, TimeUnit var3) {
      this.updated = System.currentTimeMillis();
      long var4;
      if(var1 > 0L) {
         var4 = this.updated + var3.toMillis(var1);
      } else {
         var4 = Long.MAX_VALUE;
      }

      this.expiry = Math.min(this.validUntil, var4);
   }
}
