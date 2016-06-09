package com.google.android.gms.analytics.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzb;
import com.google.android.gms.analytics.internal.zzf;

class zzag extends BroadcastReceiver {
   static final String zzSZ = zzag.class.getName();
   private final zzf zzQj;
   private boolean zzTa;
   private boolean zzTb;

   zzag(zzf var1) {
      com.google.android.gms.common.internal.zzx.zzz(var1);
      this.zzQj = var1;
   }

   private Context getContext() {
      return this.zzQj.getContext();
   }

   private zzb zziH() {
      return this.zzQj.zziH();
   }

   private zzaf zzjm() {
      return this.zzQj.zzjm();
   }

   private void zzlz() {
      this.zzjm();
      this.zziH();
   }

   public boolean isConnected() {
      if(!this.zzTa) {
         this.zzQj.zzjm().zzbg("Connectivity unknown. Receiver not registered");
      }

      return this.zzTb;
   }

   public boolean isRegistered() {
      return this.zzTa;
   }

   public void onReceive(Context var1, Intent var2) {
      this.zzlz();
      String var3 = var2.getAction();
      this.zzQj.zzjm().zza("NetworkBroadcastReceiver received action", var3);
      if("android.net.conn.CONNECTIVITY_CHANGE".equals(var3)) {
         boolean var4 = this.zzlB();
         if(this.zzTb != var4) {
            this.zzTb = var4;
            this.zziH().zzJ(var4);
         }
      } else {
         if(!"com.google.analytics.RADIO_POWERED".equals(var3)) {
            this.zzQj.zzjm().zzd("NetworkBroadcastReceiver received unknown action", var3);
            return;
         }

         if(!var2.hasExtra(zzSZ)) {
            this.zziH().zzjg();
            return;
         }
      }

   }

   public void unregister() {
      if(this.isRegistered()) {
         this.zzQj.zzjm().zzbd("Unregistering connectivity change receiver");
         this.zzTa = false;
         this.zzTb = false;
         Context var1 = this.getContext();

         try {
            var1.unregisterReceiver(this);
         } catch (IllegalArgumentException var3) {
            this.zzjm().zze("Failed to unregister the network broadcast receiver", var3);
         }
      }
   }

   public void zzlA() {
      if(VERSION.SDK_INT > 10) {
         Context var1 = this.getContext();
         Intent var2 = new Intent("com.google.analytics.RADIO_POWERED");
         var2.addCategory(var1.getPackageName());
         var2.putExtra(zzSZ, true);
         var1.sendOrderedBroadcast(var2, (String)null);
      }
   }

   protected boolean zzlB() {
      // $FF: Couldn't be decompiled
   }

   public void zzly() {
      this.zzlz();
      if(!this.zzTa) {
         Context var1 = this.getContext();
         var1.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
         IntentFilter var3 = new IntentFilter("com.google.analytics.RADIO_POWERED");
         var3.addCategory(var1.getPackageName());
         var1.registerReceiver(this, var3);
         this.zzTb = this.zzlB();
         this.zzQj.zzjm().zza("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzTb));
         this.zzTa = true;
      }
   }
}
