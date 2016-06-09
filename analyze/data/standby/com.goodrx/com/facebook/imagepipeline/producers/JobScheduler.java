package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

public class JobScheduler {
   static final String QUEUE_TIME_KEY = "queueTime";
   private final Runnable mDoJobRunnable;
   @VisibleForTesting
   @GuardedBy("this")
   EncodedImage mEncodedImage;
   private final Executor mExecutor;
   @VisibleForTesting
   @GuardedBy("this")
   boolean mIsLast;
   private final JobScheduler.JobRunnable mJobRunnable;
   @VisibleForTesting
   @GuardedBy("this")
   long mJobStartTime;
   @VisibleForTesting
   @GuardedBy("this")
   JobScheduler.JobState mJobState;
   @VisibleForTesting
   @GuardedBy("this")
   long mJobSubmitTime;
   private final int mMinimumJobIntervalMs;
   private final Runnable mSubmitJobRunnable;

   public JobScheduler(Executor var1, JobScheduler.JobRunnable var2, int var3) {
      this.mExecutor = var1;
      this.mJobRunnable = var2;
      this.mMinimumJobIntervalMs = var3;
      this.mDoJobRunnable = new Runnable() {
         public void run() {
            JobScheduler.this.doJob();
         }
      };
      this.mSubmitJobRunnable = new Runnable() {
         public void run() {
            JobScheduler.this.submitJob();
         }
      };
      this.mEncodedImage = null;
      this.mIsLast = false;
      this.mJobState = JobScheduler.JobState.IDLE;
      this.mJobSubmitTime = 0L;
      this.mJobStartTime = 0L;
   }

   private void doJob() {
      // $FF: Couldn't be decompiled
   }

   private void enqueueJob(long var1) {
      if(var1 > 0L) {
         JobScheduler.JobStartExecutorSupplier.get().schedule(this.mSubmitJobRunnable, var1, TimeUnit.MILLISECONDS);
      } else {
         this.mSubmitJobRunnable.run();
      }
   }

   private void onJobFinished() {
      // $FF: Couldn't be decompiled
   }

   private static boolean shouldProcess(EncodedImage var0, boolean var1) {
      return var1 || EncodedImage.isValid(var0);
   }

   private void submitJob() {
      this.mExecutor.execute(this.mDoJobRunnable);
   }

   public void clearJob() {
      // $FF: Couldn't be decompiled
   }

   public long getQueuedTime() {
      synchronized(this){}
      boolean var9 = false;

      long var2;
      long var4;
      try {
         var9 = true;
         var2 = this.mJobStartTime;
         var4 = this.mJobSubmitTime;
         var9 = false;
      } finally {
         if(var9) {
            ;
         }
      }

      long var6 = var2 - var4;
      return var6;
   }

   public boolean scheduleJob() {
      // $FF: Couldn't be decompiled
   }

   public boolean updateJob(EncodedImage param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   public interface JobRunnable {
      void run(EncodedImage var1, boolean var2);
   }

   @VisibleForTesting
   static class JobStartExecutorSupplier {
      private static ScheduledExecutorService sJobStarterExecutor;

      static ScheduledExecutorService get() {
         if(sJobStarterExecutor == null) {
            sJobStarterExecutor = Executors.newSingleThreadScheduledExecutor();
         }

         return sJobStarterExecutor;
      }
   }

   @VisibleForTesting
   static enum JobState {
      IDLE,
      QUEUED,
      RUNNING,
      RUNNING_AND_PENDING;

      static {
         JobScheduler.JobState[] var0 = new JobScheduler.JobState[]{IDLE, QUEUED, RUNNING, RUNNING_AND_PENDING};
      }
   }
}
