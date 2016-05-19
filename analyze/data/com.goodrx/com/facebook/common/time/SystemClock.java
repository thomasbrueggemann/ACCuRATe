package com.facebook.common.time;

import com.facebook.common.time.Clock;

public class SystemClock implements Clock {
   private static final SystemClock INSTANCE = new SystemClock();

   public static SystemClock get() {
      return INSTANCE;
   }

   public long now() {
      return System.currentTimeMillis();
   }
}
