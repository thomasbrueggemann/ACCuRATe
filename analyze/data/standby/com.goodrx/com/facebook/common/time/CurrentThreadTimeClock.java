package com.facebook.common.time;

import com.facebook.common.time.Clock;

public class CurrentThreadTimeClock implements Clock {
   public long now() {
      return android.os.SystemClock.currentThreadTimeMillis();
   }
}
