package com.facebook.common.time;

import com.facebook.common.internal.DoNotStrip;
import com.facebook.common.time.MonotonicClock;

@DoNotStrip
public class RealtimeSinceBootClock implements MonotonicClock {
   private static final RealtimeSinceBootClock INSTANCE = new RealtimeSinceBootClock();

   @DoNotStrip
   public static RealtimeSinceBootClock get() {
      return INSTANCE;
   }

   public long now() {
      return android.os.SystemClock.elapsedRealtime();
   }
}
