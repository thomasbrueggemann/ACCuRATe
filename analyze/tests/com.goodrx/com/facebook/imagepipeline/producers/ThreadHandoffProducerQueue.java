package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;

public class ThreadHandoffProducerQueue {
   private final Executor mExecutor;
   private boolean mQueueing = false;
   private final ArrayList<Runnable> mRunnableList;

   public ThreadHandoffProducerQueue(Executor var1) {
      this.mExecutor = (Executor)Preconditions.checkNotNull(var1);
      this.mRunnableList = new ArrayList();
   }

   private void execInQueue() {
      Iterator var1 = this.mRunnableList.iterator();

      while(var1.hasNext()) {
         Runnable var2 = (Runnable)var1.next();
         this.mExecutor.execute(var2);
      }

      this.mRunnableList.clear();
   }

   public void addToQueueOrExecute(Runnable var1) {
      synchronized(this){}

      try {
         if(this.mQueueing) {
            this.mRunnableList.add(var1);
         } else {
            this.mExecutor.execute(var1);
         }
      } finally {
         ;
      }

   }

   public boolean isQueueing() {
      synchronized(this){}

      boolean var2;
      try {
         var2 = this.mQueueing;
      } finally {
         ;
      }

      return var2;
   }

   public void remove(Runnable var1) {
      this.mRunnableList.remove(var1);
   }

   public void startQueueing() {
      synchronized(this){}

      try {
         this.mQueueing = true;
      } finally {
         ;
      }

   }

   public void stopQueuing() {
      synchronized(this){}

      try {
         this.mQueueing = false;
         this.execInQueue();
      } finally {
         ;
      }

   }
}
