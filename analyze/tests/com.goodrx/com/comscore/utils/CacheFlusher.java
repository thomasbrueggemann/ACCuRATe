package com.comscore.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.comscore.analytics.Core;
import com.comscore.utils.CSLog;

public class CacheFlusher implements Runnable {
   // $FF: renamed from: a com.comscore.analytics.Core
   protected Core field_508;
   // $FF: renamed from: b android.os.Handler
   protected Handler field_509;
   // $FF: renamed from: c boolean
   protected boolean field_510;
   // $FF: renamed from: d long
   protected long field_511 = -1L;

   public CacheFlusher(Core var1) {
      this.field_508 = var1;
   }

   // $FF: renamed from: a () void
   protected void method_441() {
      if(this.field_508.getStorage().has("plannedFlushTime").booleanValue()) {
         try {
            this.field_511 = Long.parseLong(this.field_508.getStorage().get("plannedFlushTime"), 10);
         } catch (Exception var2) {
            return;
         }
      }

   }

   // $FF: renamed from: a (long) void
   protected void method_442(long var1) {
      this.field_511 = var1;
      this.field_508.getStorage().set("plannedFlushTime", Long.toString(var1, 10));
   }

   // $FF: renamed from: b () void
   protected void method_443() {
      if(this.field_511 < 0L) {
         this.method_442(SystemClock.uptimeMillis() + 1000L * this.field_508.getCacheFlushingInterval());
      }

      this.field_509.postAtTime(this, this.field_511);
   }

   // $FF: renamed from: c () void
   protected void method_444() {
      // $FF: Couldn't be decompiled
   }

   // $FF: renamed from: d () void
   protected void method_445() {
      HandlerThread var1 = new HandlerThread("CacheFlusher");
      var1.start();
      this.field_509 = new Handler(var1.getLooper());
      this.method_441();
   }

   // $FF: renamed from: e () void
   protected void method_446() {
      if(this.field_509 != null) {
         this.field_509.getLooper().quit();
         this.field_509 = null;
      }

   }

   public void run() {
      synchronized(this){}

      try {
         CSLog.method_372(this, "run(): Flushing the cache");
         this.field_508.flush(false);
         this.method_442(-1L);
         this.method_443();
      } finally {
         ;
      }

   }

   public void start() {
      synchronized(this){}

      try {
         CSLog.method_372(this, "start()");
         this.field_510 = true;
         if(this.field_509 == null && this.field_508.getCacheFlushingInterval() > 0L && this.field_508.getCustomerC2() != null) {
            this.method_445();
            this.method_443();
         }
      } finally {
         ;
      }

   }

   public void stop() {
      synchronized(this){}

      try {
         CSLog.method_372(this, "stop()");
         this.field_510 = false;
         this.method_446();
      } finally {
         ;
      }

   }

   public void update() {
      synchronized(this){}

      try {
         if(this.field_508.getCacheFlushingInterval() > 0L && this.field_508.getCustomerC2() != null) {
            if(this.field_509 == null && this.field_510) {
               this.method_442(-1L);
               this.start();
            } else if(this.field_509 != null) {
               this.method_444();
            }
         } else {
            this.method_442(-1L);
            this.method_446();
         }
      } finally {
         ;
      }

   }
}
