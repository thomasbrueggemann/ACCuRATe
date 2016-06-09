package com.parse;

import bolts.Task;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

class ParseExecutors {
   private static final Object SCHEDULED_EXECUTOR_LOCK = new Object();
   private static ScheduledExecutorService scheduledExecutor;

   // $FF: renamed from: io () java.util.concurrent.Executor
   static Executor method_369() {
      return Task.BACKGROUND_EXECUTOR;
   }

   static Executor main() {
      return Task.UI_THREAD_EXECUTOR;
   }

   static ScheduledExecutorService scheduled() {
      // $FF: Couldn't be decompiled
   }
}
