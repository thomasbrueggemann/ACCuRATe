package com.newrelic.agent.android.stats;

public class TicToc {
   private long endTime;
   private long startTime;
   private TicToc.State state;

   public void tic() {
      this.state = TicToc.State.STARTED;
      this.startTime = System.currentTimeMillis();
   }

   public long toc() {
      this.endTime = System.currentTimeMillis();
      if(this.state == TicToc.State.STARTED) {
         this.state = TicToc.State.STOPPED;
         return this.endTime - this.startTime;
      } else {
         return -1L;
      }
   }

   private static enum State {
      STARTED,
      STOPPED;

      static {
         TicToc.State[] var0 = new TicToc.State[]{STOPPED, STARTED};
      }
   }
}
