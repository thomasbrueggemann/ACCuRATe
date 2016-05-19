package com.newrelic.agent.android.util;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.util.NamedThreadFactory;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class UiBackgroundListener implements ComponentCallbacks2 {
   protected final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("UiBackgroundListener"));

   public void onConfigurationChanged(Configuration var1) {
   }

   public void onLowMemory() {
   }

   public void onTrimMemory(int var1) {
      switch(var1) {
      case 20:
         Runnable var2 = new Runnable() {
            public void run() {
               ApplicationStateMonitor.getInstance().uiHidden();
            }
         };
         this.executor.submit(var2);
         return;
      default:
      }
   }
}
