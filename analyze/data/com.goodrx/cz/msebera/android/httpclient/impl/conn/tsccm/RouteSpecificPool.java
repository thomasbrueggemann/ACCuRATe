package cz.msebera.android.httpclient.impl.conn.tsccm;

import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.conn.params.ConnPerRoute;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import cz.msebera.android.httpclient.impl.conn.tsccm.BasicPoolEntry;
import cz.msebera.android.httpclient.impl.conn.tsccm.WaitingThread;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import cz.msebera.android.httpclient.util.LangUtils;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

@Deprecated
public class RouteSpecificPool {
   protected final ConnPerRoute connPerRoute;
   protected final LinkedList<BasicPoolEntry> freeEntries;
   public HttpClientAndroidLog log = new HttpClientAndroidLog(this.getClass());
   protected final int maxEntries;
   protected int numEntries;
   protected final HttpRoute route;
   protected final Queue<WaitingThread> waitingThreads;

   public RouteSpecificPool(HttpRoute var1, ConnPerRoute var2) {
      this.route = var1;
      this.connPerRoute = var2;
      this.maxEntries = var2.getMaxForRoute(var1);
      this.freeEntries = new LinkedList();
      this.waitingThreads = new LinkedList();
      this.numEntries = 0;
   }

   public BasicPoolEntry allocEntry(Object var1) {
      if(!this.freeEntries.isEmpty()) {
         ListIterator var5 = this.freeEntries.listIterator(this.freeEntries.size());

         while(var5.hasPrevious()) {
            BasicPoolEntry var6 = (BasicPoolEntry)var5.previous();
            if(var6.getState() == null || LangUtils.equals(var1, var6.getState())) {
               var5.remove();
               return var6;
            }
         }
      }

      if(this.getCapacity() == 0 && !this.freeEntries.isEmpty()) {
         BasicPoolEntry var2 = (BasicPoolEntry)this.freeEntries.remove();
         var2.shutdownEntry();
         OperatedClientConnection var3 = var2.getConnection();

         try {
            var3.close();
            return var2;
         } catch (IOException var7) {
            this.log.debug("I/O error closing connection", var7);
            return var2;
         }
      } else {
         return null;
      }
   }

   public void createdEntry(BasicPoolEntry var1) {
      Args.check(this.route.equals(var1.getPlannedRoute()), "Entry not planned for this pool");
      ++this.numEntries;
   }

   public boolean deleteEntry(BasicPoolEntry var1) {
      boolean var2 = this.freeEntries.remove(var1);
      if(var2) {
         this.numEntries += -1;
      }

      return var2;
   }

   public void dropEntry() {
      boolean var1;
      if(this.numEntries > 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      Asserts.check(var1, "There is no entry that could be dropped");
      this.numEntries += -1;
   }

   public void freeEntry(BasicPoolEntry var1) {
      if(this.numEntries < 1) {
         throw new IllegalStateException("No entry created for this pool. " + this.route);
      } else if(this.numEntries <= this.freeEntries.size()) {
         throw new IllegalStateException("No entry allocated from this pool. " + this.route);
      } else {
         this.freeEntries.add(var1);
      }
   }

   public int getCapacity() {
      return this.connPerRoute.getMaxForRoute(this.route) - this.numEntries;
   }

   public final int getMaxEntries() {
      return this.maxEntries;
   }

   public final HttpRoute getRoute() {
      return this.route;
   }

   public boolean hasThread() {
      return !this.waitingThreads.isEmpty();
   }

   public boolean isUnused() {
      return this.numEntries < 1 && this.waitingThreads.isEmpty();
   }

   public WaitingThread nextThread() {
      return (WaitingThread)this.waitingThreads.peek();
   }

   public void queueThread(WaitingThread var1) {
      Args.notNull(var1, "Waiting thread");
      this.waitingThreads.add(var1);
   }

   public void removeThread(WaitingThread var1) {
      if(var1 != null) {
         this.waitingThreads.remove(var1);
      }
   }
}
