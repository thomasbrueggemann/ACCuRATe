package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.MainThread;
import android.support.annotation.WorkerThread;
import com.google.android.gms.measurement.internal.zzp;
import com.google.android.gms.measurement.internal.zzw;

class zzr extends BroadcastReceiver {
   static final String zzSZ = zzr.class.getName();
   private boolean zzTa;
   private boolean zzTb;
   private final zzw zzaTV;

   zzr(zzw var1) {
      com.google.android.gms.common.internal.zzx.zzz(var1);
      this.zzaTV = var1;
   }

   private Context getContext() {
      return this.zzaTV.getContext();
   }

   private zzp zzAo() {
      return this.zzaTV.zzAo();
   }

   @WorkerThread
   public boolean isRegistered() {
      this.zzaTV.zzjk();
      return this.zzTa;
   }

   @MainThread
   public void onReceive(Context var1, Intent var2) {
      this.zzaTV.zzjv();
      String var3 = var2.getAction();
      this.zzAo().zzCK().zzj("NetworkBroadcastReceiver received action", var3);
      if("android.net.conn.CONNECTIVITY_CHANGE".equals(var3)) {
         final boolean var4 = this.zzaTV.zzCW().zzlB();
         if(this.zzTb != var4) {
            this.zzTb = var4;
            this.zzaTV.zzCn().zzg(new Runnable() {
               public void run() {
                  zzr.this.zzaTV.zzJ(var4);
               }
            });
         }

      } else {
         this.zzAo().zzCF().zzj("NetworkBroadcastReceiver received unknown action", var3);
      }
   }

   @WorkerThread
   public void unregister() {
      this.zzaTV.zzjv();
      this.zzaTV.zzjk();
      if(this.isRegistered()) {
         this.zzAo().zzCK().zzfg("Unregistering connectivity change receiver");
         this.zzTa = false;
         this.zzTb = false;
         Context var1 = this.getContext();

         try {
            var1.unregisterReceiver(this);
         } catch (IllegalArgumentException var3) {
            this.zzAo().zzCE().zzj("Failed to unregister the network broadcast receiver", var3);
         }
      }
   }

   @WorkerThread
   public void zzly() {
      this.zzaTV.zzjv();
      this.zzaTV.zzjk();
      if(!this.zzTa) {
         this.getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
         this.zzTb = this.zzaTV.zzCW().zzlB();
         this.zzAo().zzCK().zzj("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzTb));
         this.zzTa = true;
      }
   }
}
