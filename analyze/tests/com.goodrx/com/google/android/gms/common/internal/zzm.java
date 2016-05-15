package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Handler.Callback;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

final class zzm extends zzl implements Callback {
   private final Handler mHandler;
   private final HashMap<zzm.zza, zzm.zzb> zzalZ = new HashMap();
   private final com.google.android.gms.common.stats.zzb zzama;
   private final long zzamb;
   private final Context zzsa;

   zzm(Context var1) {
      this.zzsa = var1.getApplicationContext();
      this.mHandler = new Handler(var1.getMainLooper(), this);
      this.zzama = com.google.android.gms.common.stats.zzb.zzrP();
      this.zzamb = 5000L;
   }

   // $FF: synthetic method
   static HashMap zza(zzm var0) {
      return var0.zzalZ;
   }

   private boolean zza(zzm.zza param1, ServiceConnection param2, String param3) {
      // $FF: Couldn't be decompiled
   }

   private void zzb(zzm.zza param1, ServiceConnection param2, String param3) {
      // $FF: Couldn't be decompiled
   }

   public boolean handleMessage(Message param1) {
      // $FF: Couldn't be decompiled
   }

   public boolean zza(String var1, ServiceConnection var2, String var3) {
      return this.zza(new zzm.zza(var1), var2, var3);
   }

   public void zzb(String var1, ServiceConnection var2, String var3) {
      this.zzb(new zzm.zza(var1), var2, var3);
   }

   private static final class zza {
      private final String zzSU;
      private final ComponentName zzamc;

      public zza(String var1) {
         this.zzSU = zzx.zzcM(var1);
         this.zzamc = null;
      }

      public boolean equals(Object var1) {
         if(this != var1) {
            if(!(var1 instanceof zzm.zza)) {
               return false;
            }

            zzm.zza var2 = (zzm.zza)var1;
            if(!zzw.equal(this.zzSU, var2.zzSU) || !zzw.equal(this.zzamc, var2.zzamc)) {
               return false;
            }
         }

         return true;
      }

      public int hashCode() {
         Object[] var1 = new Object[]{this.zzSU, this.zzamc};
         return zzw.hashCode(var1);
      }

      public String toString() {
         return this.zzSU == null?this.zzamc.flattenToString():this.zzSU;
      }

      public Intent zzqS() {
         return this.zzSU != null?(new Intent(this.zzSU)).setPackage("com.google.android.gms"):(new Intent()).setComponent(this.zzamc);
      }
   }

   private final class zzb {
      private int mState;
      private IBinder zzakD;
      private ComponentName zzamc;
      private final zzm.zza zzamd;
      private final Set<ServiceConnection> zzame;
      private boolean zzamf;
      private final zzm.zza zzamg;

      public zzb(zzm.zza var2) {
         this.zzamg = var2;
         this.zzamd = new zzm.zza();
         this.zzame = new HashSet();
         this.mState = 2;
      }

      // $FF: synthetic method
      static int zza(zzm.zzb var0, int var1) {
         var0.mState = var1;
         return var1;
      }

      // $FF: synthetic method
      static ComponentName zza(zzm.zzb var0, ComponentName var1) {
         var0.zzamc = var1;
         return var1;
      }

      // $FF: synthetic method
      static IBinder zza(zzm.zzb var0, IBinder var1) {
         var0.zzakD = var1;
         return var1;
      }

      // $FF: synthetic method
      static zzm.zza zza(zzm.zzb var0) {
         return var0.zzamg;
      }

      // $FF: synthetic method
      static Set zzb(zzm.zzb var0) {
         return var0.zzame;
      }

      public IBinder getBinder() {
         return this.zzakD;
      }

      public ComponentName getComponentName() {
         return this.zzamc;
      }

      public int getState() {
         return this.mState;
      }

      public boolean isBound() {
         return this.zzamf;
      }

      public void zza(ServiceConnection var1, String var2) {
         zzm.this.zzama.zza(zzm.this.zzsa, var1, var2, this.zzamg.zzqS());
         this.zzame.add(var1);
      }

      public boolean zza(ServiceConnection var1) {
         return this.zzame.contains(var1);
      }

      public void zzb(ServiceConnection var1, String var2) {
         zzm.this.zzama.zzb(zzm.this.zzsa, var1);
         this.zzame.remove(var1);
      }

      @TargetApi(14)
      public void zzcH(String var1) {
         this.mState = 3;
         this.zzamf = zzm.this.zzama.zza(zzm.this.zzsa, var1, (Intent)this.zzamg.zzqS(), (ServiceConnection)this.zzamd, 129);
         if(!this.zzamf) {
            this.mState = 2;

            try {
               zzm.this.zzama.zza(zzm.this.zzsa, this.zzamd);
            } catch (IllegalArgumentException var3) {
               return;
            }
         }

      }

      public void zzcI(String var1) {
         zzm.this.zzama.zza(zzm.this.zzsa, this.zzamd);
         this.zzamf = false;
         this.mState = 2;
      }

      public boolean zzqT() {
         return this.zzame.isEmpty();
      }
   }

   public class zza implements ServiceConnection {
      public void onServiceConnected(ComponentName param1, IBinder param2) {
         // $FF: Couldn't be decompiled
      }

      public void onServiceDisconnected(ComponentName param1) {
         // $FF: Couldn't be decompiled
      }
   }
}
