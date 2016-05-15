package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzmt;
import com.google.android.gms.tagmanager.zzbg;
import java.io.IOException;

public class zza {
   private static zza zzbhA;
   private static Object zzbhz = new Object();
   private volatile boolean mClosed;
   private final Context mContext;
   private final Thread zzLM;
   private volatile AdvertisingIdClient.Info zzPW;
   private volatile long zzbht;
   private volatile long zzbhu;
   private volatile long zzbhv;
   private volatile long zzbhw;
   private final Object zzbhx;
   private zza.zza zzbhy;
   private final zzmq zzqW;

   private zza(Context var1) {
      this(var1, (zza.zza)null, zzmt.zzsc());
   }

   public zza(Context var1, zza.zza var2, zzmq var3) {
      this.zzbht = 900000L;
      this.zzbhu = 30000L;
      this.mClosed = false;
      this.zzbhx = new Object();
      this.zzbhy = new zza.zza() {
         public AdvertisingIdClient.Info zzFV() {
            try {
               AdvertisingIdClient.Info var6 = AdvertisingIdClient.getAdvertisingIdInfo(zza.this.mContext);
               return var6;
            } catch (IllegalStateException var7) {
               zzbg.zzd("IllegalStateException getting Advertising Id Info", var7);
               return null;
            } catch (GooglePlayServicesRepairableException var8) {
               zzbg.zzd("GooglePlayServicesRepairableException getting Advertising Id Info", var8);
               return null;
            } catch (IOException var9) {
               zzbg.zzd("IOException getting Ad Id Info", var9);
               return null;
            } catch (GooglePlayServicesNotAvailableException var10) {
               zzbg.zzd("GooglePlayServicesNotAvailableException getting Advertising Id Info", var10);
               return null;
            } catch (Exception var11) {
               zzbg.zzd("Unknown exception. Could not get the Advertising Id Info.", var11);
               return null;
            }
         }
      };
      this.zzqW = var3;
      if(var1 != null) {
         this.mContext = var1.getApplicationContext();
      } else {
         this.mContext = var1;
      }

      if(var2 != null) {
         this.zzbhy = var2;
      }

      this.zzbhv = this.zzqW.currentTimeMillis();
      this.zzLM = new Thread(new Runnable() {
         public void run() {
            zza.this.zzFU();
         }
      });
   }

   private void zzFR() {
      // $FF: Couldn't be decompiled
   }

   private void zzFS() {
      // $FF: Couldn't be decompiled
   }

   private void zzFT() {
      if(this.zzqW.currentTimeMillis() - this.zzbhw > 3600000L) {
         this.zzPW = null;
      }

   }

   private void zzFU() {
      // $FF: Couldn't be decompiled
   }

   public static zza zzaW(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public boolean isLimitAdTrackingEnabled() {
      if(this.zzPW == null) {
         this.zzFR();
      } else {
         this.zzFS();
      }

      this.zzFT();
      return this.zzPW == null?true:this.zzPW.isLimitAdTrackingEnabled();
   }

   public void start() {
      this.zzLM.start();
   }

   public String zzFQ() {
      if(this.zzPW == null) {
         this.zzFR();
      } else {
         this.zzFS();
      }

      this.zzFT();
      return this.zzPW == null?null:this.zzPW.getId();
   }

   public interface zza {
      AdvertisingIdClient.Info zzFV();
   }
}
