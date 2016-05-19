package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.internal.zzy;

class zzs implements Logger {
   private boolean zzPk;
   private int zzRB = 2;

   public void error(String var1) {
   }

   public int getLogLevel() {
      return this.zzRB;
   }

   public void info(String var1) {
   }

   public void setLogLevel(int var1) {
      this.zzRB = var1;
      if(!this.zzPk) {
         Log.i((String)zzy.zzRL.get(), "Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag." + (String)zzy.zzRL.get() + " DEBUG");
         this.zzPk = true;
      }

   }

   public void verbose(String var1) {
   }

   public void warn(String var1) {
   }
}
