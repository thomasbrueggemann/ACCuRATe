package com.comscore.applications;

import android.util.Log;
import com.comscore.analytics.Core;
import com.comscore.applications.EventType;
import com.comscore.utils.OfflineMeasurementsCache;
import com.comscore.utils.Storage;
import java.util.HashMap;

public class KeepAlive implements Runnable {
   // $FF: renamed from: a long
   protected final long field_400;
   // $FF: renamed from: b long
   protected long field_401 = -1L;
   // $FF: renamed from: c long
   protected long field_402;
   // $FF: renamed from: d com.comscore.analytics.Core
   private Core field_403;
   // $FF: renamed from: e boolean
   private boolean field_404 = false;
   // $FF: renamed from: f boolean
   private boolean field_405 = false;

   public KeepAlive(Core var1, long var2) {
      this.field_400 = var2;
      this.field_402 = this.field_400;
      this.field_403 = var1;
   }

   // $FF: renamed from: a (com.comscore.utils.Storage) long
   private long method_304(Storage var1) {
      long var2 = 0L;
      String var4 = var1.get("lastMeasurementProcessedTimestamp");
      if(var4 != null && var4.length() > 0) {
         long var6;
         try {
            var6 = Long.parseLong(var4);
         } catch (Exception var8) {
            return var2;
         }

         var2 = var6;
      }

      return var2;
   }

   // $FF: renamed from: a () void
   protected void method_305() {
      if(this.field_403.isEnabled()) {
         this.field_403.getTaskExecutor().execute(this, this.field_401 - System.currentTimeMillis(), true, this.field_400);
         this.field_405 = true;
      }
   }

   public void cancel() {
      Log.d("KeepAlive", "cancel()");
      this.field_403.getTaskExecutor().removeEnqueuedTask(this);
      this.field_405 = false;
   }

   public void processKeepAlive(boolean var1) {
      if(this.field_403.isEnabled() && this.field_403.isKeepAliveEnabled()) {
         OfflineMeasurementsCache var2 = this.field_403.getOfflineCache();
         long var3 = this.method_304(this.field_403.getStorage());
         long var5 = System.currentTimeMillis() - var3;
         Log.d("KeepAlive", "processKeepAlive(" + var1 + ") timeSinceLastTransmission=" + (System.currentTimeMillis() - var5) + " currentTimeout=" + this.field_402);
         if(var3 != 0L && var5 > this.field_402 - 1000L) {
            Log.d("KeepAlive", "Sending Keep-alive");
            if(!var1) {
               this.field_403.notify(EventType.KEEPALIVE, new HashMap(), true);
            } else {
               var2.saveApplicationMeasurement(EventType.KEEPALIVE, (HashMap)null, true);
            }

            this.field_403.getStorage().set("lastMeasurementProcessedTimestamp", String.valueOf(System.currentTimeMillis()));
            return;
         }
      }

   }

   public void reset() {
      this.reset(this.field_400);
   }

   public void reset(long var1) {
      if(this.field_403.isEnabled()) {
         this.cancel();
         Log.d("KeepAlive", "reset:" + var1);
         this.field_401 = var1 + System.currentTimeMillis();
         this.field_402 = var1;
         if(this.field_404) {
            this.start(0);
            return;
         }
      }

   }

   public void run() {
      if(this.field_403.isEnabled() && this.field_405) {
         Log.d("KeepAlive", "run()");
         this.sendKeepAlive();
      }
   }

   public void sendKeepAlive() {
      this.processKeepAlive(false);
   }

   public void start(int var1) {
      if(this.field_403.isEnabled()) {
         this.cancel();
         this.field_404 = true;
         Log.d("KeepAlive", "start(" + var1 + ")");
         if(this.field_403.isKeepAliveEnabled()) {
            long var3 = System.currentTimeMillis();
            if(this.field_401 < var3) {
               this.field_401 = var3 + (long)var1;
            }

            this.method_305();
            return;
         }
      }

   }

   public void stop() {
      Log.d("KeepAlive", "stop");
      this.field_404 = false;
      this.cancel();
      this.processKeepAlive(true);
   }
}
