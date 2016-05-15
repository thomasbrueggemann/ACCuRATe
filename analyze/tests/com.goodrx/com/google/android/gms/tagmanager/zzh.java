package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.tagmanager.zzak;
import com.google.android.gms.tagmanager.zzbg;
import com.google.android.gms.tagmanager.zzdf;
import java.util.Map;

class zzh extends zzak {
   // $FF: renamed from: ID java.lang.String
   private static final String field_58;
   private final Context mContext;

   static {
      field_58 = com.google.android.gms.internal.zzad.zzbv.toString();
   }

   public zzh(Context var1) {
      super(field_58, new String[0]);
      this.mContext = var1;
   }

   public boolean zzFW() {
      return true;
   }

   public com.google.android.gms.internal.zzag.zza zzP(Map<String, com.google.android.gms.internal.zzag.zza> var1) {
      try {
         com.google.android.gms.internal.zzag.zza var3 = zzdf.zzR(Integer.valueOf(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode));
         return var3;
      } catch (NameNotFoundException var4) {
         zzbg.method_353("Package name " + this.mContext.getPackageName() + " not found. " + var4.getMessage());
         return zzdf.zzHF();
      }
   }
}
