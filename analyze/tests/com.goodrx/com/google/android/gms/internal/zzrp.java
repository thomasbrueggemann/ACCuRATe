package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.zzlz;
import com.google.android.gms.internal.zzne;
import com.google.android.gms.internal.zzni;
import com.google.android.gms.internal.zznj;

public class zzrp {
   private static boolean DEBUG = false;
   private static String TAG = "WakeLock";
   private static String zzbhl = "*gcore*:";
   private final Context mContext;
   private final String zzanQ;
   private final WakeLock zzbhm;
   private WorkSource zzbhn;
   private final int zzbho;
   private final String zzbhp;
   private boolean zzbhq;
   private int zzbhr;
   private int zzbhs;

   public zzrp(Context var1, int var2, String var3) {
      String var4;
      if(var1 == null) {
         var4 = null;
      } else {
         var4 = var1.getPackageName();
      }

      this(var1, var2, var3, (String)null, var4);
   }

   @SuppressLint({"UnwrappedWakeLock"})
   public zzrp(Context var1, int var2, String var3, String var4, String var5) {
      this.zzbhq = true;
      com.google.android.gms.common.internal.zzx.zzh(var3, "Wake lock name can NOT be empty");
      this.zzbho = var2;
      this.zzbhp = var4;
      this.mContext = var1.getApplicationContext();
      if(!zzni.zzcV(var5) && "com.google.android.gms" != var5) {
         this.zzanQ = zzbhl + var3;
      } else {
         this.zzanQ = var3;
      }

      this.zzbhm = ((PowerManager)var1.getSystemService("power")).newWakeLock(var2, var3);
      if(zznj.zzaA(this.mContext)) {
         if(zzni.zzcV(var5)) {
            if(com.google.android.gms.common.internal.zzd.zzakE && zzlz.isInitialized()) {
               Log.e(TAG, "callingPackage is not supposed to be empty for wakelock " + this.zzanQ + "!", new IllegalArgumentException());
               var5 = "com.google.android.gms";
            } else {
               var5 = var1.getPackageName();
            }
         }

         this.zzbhn = zznj.zzl(var1, var5);
         this.zzc(this.zzbhn);
      }

   }

   private void zzfJ(String param1) {
      // $FF: Couldn't be decompiled
   }

   private boolean zzfK(String var1) {
      return !TextUtils.isEmpty(var1) && !var1.equals(this.zzbhp);
   }

   private void zzj(String param1, long param2) {
      // $FF: Couldn't be decompiled
   }

   private String zzn(String var1, boolean var2) {
      return this.zzbhq?(var2?var1:this.zzbhp):this.zzbhp;
   }

   public void acquire(long var1) {
      if(!zzne.zzsg() && this.zzbhq) {
         Log.wtf(TAG, "Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: " + this.zzanQ);
      }

      this.zzj((String)null, var1);
      this.zzbhm.acquire(var1);
   }

   public boolean isHeld() {
      return this.zzbhm.isHeld();
   }

   public void release() {
      this.zzfJ((String)null);
      this.zzbhm.release();
   }

   public void setReferenceCounted(boolean var1) {
      this.zzbhm.setReferenceCounted(var1);
      this.zzbhq = var1;
   }

   public void zzc(WorkSource var1) {
      if(zznj.zzaA(this.mContext) && var1 != null) {
         if(this.zzbhn != null) {
            this.zzbhn.add(var1);
         } else {
            this.zzbhn = var1;
         }

         this.zzbhm.setWorkSource(this.zzbhn);
      }

   }
}
