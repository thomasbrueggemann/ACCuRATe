package com.newrelic.agent.android.logging;

import android.util.Log;
import com.newrelic.agent.android.logging.AgentLog;

public class AndroidAgentLog implements AgentLog {
   private static final String TAG = "com.newrelic.agent.android";
   private int level = 3;

   public void debug(String var1) {
      if(this.level == 5) {
         Log.d("com.newrelic.agent.android", var1);
      }

   }

   public void error(String var1) {
      if(this.level >= 1) {
         Log.e("com.newrelic.agent.android", var1);
      }

   }

   public void error(String var1, Throwable var2) {
      if(this.level >= 1) {
         Log.e("com.newrelic.agent.android", var1, var2);
      }

   }

   public int getLevel() {
      return this.level;
   }

   public void info(String var1) {
      if(this.level >= 3) {
         Log.i("com.newrelic.agent.android", var1);
      }

   }

   public void setLevel(int var1) {
      if(var1 <= 5 && var1 >= 1) {
         this.level = var1;
      } else {
         throw new IllegalArgumentException("Log level is not between ERROR and DEBUG");
      }
   }

   public void verbose(String var1) {
      if(this.level >= 4) {
         Log.v("com.newrelic.agent.android", var1);
      }

   }

   public void warning(String var1) {
      if(this.level >= 2) {
         Log.w("com.newrelic.agent.android", var1);
      }

   }
}
