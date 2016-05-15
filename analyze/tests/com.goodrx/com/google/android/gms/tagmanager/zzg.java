package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.tagmanager.zzak;
import com.google.android.gms.tagmanager.zzbg;
import com.google.android.gms.tagmanager.zzdf;
import java.util.Map;

class zzg extends zzak {
   // $FF: renamed from: ID java.lang.String
   private static final String field_59;
   private final Context mContext;

   static {
      field_59 = com.google.android.gms.internal.zzad.zzbu.toString();
   }

   public zzg(Context var1) {
      super(field_59, new String[0]);
      this.mContext = var1;
   }

   public boolean zzFW() {
      return true;
   }

   public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> var1) {
      try {
         PackageManager var3 = this.mContext.getPackageManager();
         com.google.android.gms.internal.zzag.zza var4 = zzdf.zzR(var3.getApplicationLabel(var3.getApplicationInfo(this.mContext.getPackageName(), 0)).toString());
         return var4;
      } catch (NameNotFoundException var5) {
         zzbg.zzb("App name is not found.", var5);
         return zzdf.zzHF();
      }
   }
}
