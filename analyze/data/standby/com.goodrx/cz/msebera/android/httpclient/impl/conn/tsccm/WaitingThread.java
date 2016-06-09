package cz.msebera.android.httpclient.impl.conn.tsccm;

import cz.msebera.android.httpclient.impl.conn.tsccm.RouteSpecificPool;
import cz.msebera.android.httpclient.util.Args;
import java.util.Date;
import java.util.concurrent.locks.Condition;

@Deprecated
public class WaitingThread {
   private boolean aborted;
   private final Condition cond;
   private final RouteSpecificPool pool;
   private Thread waiter;

   public WaitingThread(Condition var1, RouteSpecificPool var2) {
      Args.notNull(var1, "Condition");
      this.cond = var1;
      this.pool = var2;
   }

   public boolean await(Date param1) throws InterruptedException {
      // $FF: Couldn't be decompiled
   }

   public void interrupt() {
      this.aborted = true;
      this.cond.signalAll();
   }

   public void wakeup() {
      if(this.waiter == null) {
         throw new IllegalStateException("Nobody waiting on this object.");
      } else {
         this.cond.signalAll();
      }
   }
}
