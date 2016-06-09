package com.comscore.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.comscore.analytics.Core;
import com.comscore.utils.CSLog;
import com.comscore.utils.Connectivity;
import com.comscore.utils.TransmissionMode;
import com.comscore.utils.Utils;
import com.comscore.utils.class_20;
import java.util.HashSet;

public class ConnectivityChangeReceiver extends BroadcastReceiver {
   // $FF: renamed from: a boolean
   protected boolean field_108 = false;
   // $FF: renamed from: b boolean
   protected boolean field_109 = false;
   // $FF: renamed from: c long
   protected long field_110 = -1L;
   // $FF: renamed from: d java.util.HashSet
   protected HashSet<String> field_111 = null;
   // $FF: renamed from: e java.lang.Runnable
   private Runnable field_112 = null;
   // $FF: renamed from: f com.comscore.analytics.Core
   private final Core field_113;

   public ConnectivityChangeReceiver(Core var1) {
      this.field_113 = var1;
      this.field_111 = new HashSet();
   }

   // $FF: renamed from: a () void
   protected void method_64() {
      if(this.field_113.isEnabled()) {
         CSLog.method_372(this, "onConnectedWifi()");
         this.method_67(this.method_69(this.field_113.getAppContext()));
         if(this.field_113.getOfflineTransmissionMode() != TransmissionMode.NEVER && this.field_113.getOfflineTransmissionMode() != TransmissionMode.DISABLED && !this.field_108) {
            this.field_108 = true;
            this.method_68(false);
            return;
         }
      }

   }

   // $FF: renamed from: a (long) void
   protected void method_65(long var1) {
      if(this.field_113.isEnabled()) {
         this.field_112 = new class_20(this);
         this.field_113.getTaskExecutor().execute(this.field_112, var1);
      }
   }

   // $FF: renamed from: a (android.content.Context) void
   protected void method_66(Context var1) {
      if(this.field_113.isEnabled()) {
         CSLog.method_372(this, "onConnectedMobile()");
         this.method_67("|||cs_3g|||");
         if((this.field_113.getOfflineTransmissionMode() == TransmissionMode.DEFAULT || this.field_113.getOfflineTransmissionMode() == TransmissionMode.PIGGYBACK && Connectivity.isDataConnected(var1)) && !this.field_108) {
            this.field_108 = true;
            this.method_68(false);
            return;
         }
      }

   }

   // $FF: renamed from: a (java.lang.String) void
   protected void method_67(String var1) {
      if(this.field_113.isEnabled() && Utils.isNotEmpty(var1) && this.field_111 != null && !this.field_111.contains(var1)) {
         if(this.field_111.size() != 0) {
            this.method_73();
         }

         this.field_111.add(var1);
      }
   }

   // $FF: renamed from: a (boolean) void
   protected void method_68(boolean var1) {
      if(this.field_113.isEnabled()) {
         if(this.field_109) {
            this.method_72();
            if(this.field_110 < SystemClock.uptimeMillis() || this.field_110 < 0L || !var1) {
               this.field_110 = 30000L + SystemClock.uptimeMillis();
            }

            this.method_65(this.field_110 - SystemClock.uptimeMillis());
            CSLog.method_372(this, "scheduleFlushTask(): Flushing in " + (this.field_110 - SystemClock.uptimeMillis()));
            return;
         }

         if(this.field_110 < 0L) {
            this.field_110 = 30000L + SystemClock.uptimeMillis();
            return;
         }
      }

   }

   // $FF: renamed from: b (android.content.Context) java.lang.String
   protected String method_69(Context var1) {
      return Connectivity.getCurrentSSID(var1);
   }

   // $FF: renamed from: b () void
   protected void method_70() {
      if(this.field_113.isEnabled()) {
         CSLog.method_372(this, "onDisconnected()");
         this.method_72();
         this.field_108 = false;
         this.field_110 = -1L;
      }
   }

   // $FF: renamed from: b (boolean) void
   protected void method_71(boolean var1) {
      synchronized(this){}

      try {
         CSLog.method_372(this, "flushing");
         this.field_113.flush(var1);
         this.field_110 = -1L;
      } finally {
         ;
      }

   }

   // $FF: renamed from: c () void
   protected void method_72() {
      if(this.field_112 != null) {
         CSLog.method_372(this, "cancelFlushTask()");
         this.field_113.getTaskExecutor().removeEnqueuedTask(this.field_112);
         this.field_112 = null;
      }

   }

   // $FF: renamed from: d () void
   protected void method_73() {
      if(this.field_113.isEnabled()) {
         this.field_113.getKeepAlive().reset(3000L);
      }
   }

   public void onReceive(Context var1, Intent var2) {
      synchronized(this){}

      try {
         if(var2.getExtras() != null) {
            if(Connectivity.isConnectedWiFi(var1)) {
               this.method_64();
            } else if(Connectivity.isConnectedMobile(var1)) {
               this.method_66(var1);
            } else {
               this.method_70();
            }
         }
      } finally {
         ;
      }

   }

   public void start() {
      // $FF: Couldn't be decompiled
   }

   public void stop() {
      synchronized(this){}

      try {
         this.field_109 = false;
         this.method_72();
      } finally {
         ;
      }

   }
}
