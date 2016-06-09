package cz.msebera.android.httpclient.impl.conn.tsccm;

import cz.msebera.android.httpclient.impl.conn.tsccm.WaitingThread;

@Deprecated
public class WaitingThreadAborter {
   private boolean aborted;
   private WaitingThread waitingThread;

   public void setWaitingThread(WaitingThread var1) {
      this.waitingThread = var1;
      if(this.aborted) {
         var1.interrupt();
      }

   }
}
