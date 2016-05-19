package com.facebook.imagepipeline.core;

import com.facebook.imagepipeline.core.ExecutorSupplier;
import com.facebook.imagepipeline.core.PriorityThreadFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DefaultExecutorSupplier implements ExecutorSupplier {
   private static final int NUM_IO_BOUND_THREADS = 2;
   private static final int NUM_LIGHTWEIGHT_BACKGROUND_THREADS = 1;
   private final Executor mBackgroundExecutor;
   private final Executor mDecodeExecutor;
   private final Executor mIoBoundExecutor;
   private final Executor mLightWeightBackgroundExecutor;

   public DefaultExecutorSupplier(int var1) {
      PriorityThreadFactory var2 = new PriorityThreadFactory(10);
      this.mIoBoundExecutor = Executors.newFixedThreadPool(2);
      this.mDecodeExecutor = Executors.newFixedThreadPool(var1, var2);
      this.mBackgroundExecutor = Executors.newFixedThreadPool(var1, var2);
      this.mLightWeightBackgroundExecutor = Executors.newFixedThreadPool(1, var2);
   }

   public Executor forBackgroundTasks() {
      return this.mBackgroundExecutor;
   }

   public Executor forDecode() {
      return this.mDecodeExecutor;
   }

   public Executor forLightweightBackgroundTasks() {
      return this.mLightWeightBackgroundExecutor;
   }

   public Executor forLocalStorageRead() {
      return this.mIoBoundExecutor;
   }

   public Executor forLocalStorageWrite() {
      return this.mIoBoundExecutor;
   }
}
