package com.google.android.gms.tagmanager;

import android.util.Log;
import com.google.android.gms.tagmanager.zzbh;

public class zzy implements zzbh {
   private int zzRB = 5;

   // $FF: renamed from: e (java.lang.String) void
   public void method_19(String var1) {
      if(this.zzRB <= 6) {
         Log.e("GoogleTagManager", var1);
      }

   }

   public void setLogLevel(int var1) {
      this.zzRB = var1;
   }

   // $FF: renamed from: v (java.lang.String) void
   public void method_20(String var1) {
      if(this.zzRB <= 2) {
         Log.v("GoogleTagManager", var1);
      }

   }

   public void zzaI(String var1) {
      if(this.zzRB <= 3) {
         Log.d("GoogleTagManager", var1);
      }

   }

   public void zzaJ(String var1) {
      if(this.zzRB <= 4) {
         Log.i("GoogleTagManager", var1);
      }

   }

   public void zzaK(String var1) {
      if(this.zzRB <= 5) {
         Log.w("GoogleTagManager", var1);
      }

   }

   public void zzb(String var1, Throwable var2) {
      if(this.zzRB <= 6) {
         Log.e("GoogleTagManager", var1, var2);
      }

   }

   public void zzd(String var1, Throwable var2) {
      if(this.zzRB <= 5) {
         Log.w("GoogleTagManager", var1, var2);
      }

   }
}
